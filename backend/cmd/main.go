package main

import (
	"github.com/gin-gonic/gin"
	"io"
	"log"
	"os"
	"strconv"
)

var notifyChan chan struct{}

type Input struct {
	FileName   string `json:"file_name"`
	FileSize   string `json:"file_size"`
	BlockCount string `json:"block_count"`
}

func HeadersMiddleware() gin.HandlerFunc {
	return func(c *gin.Context) {
		c.Writer.Header().Set("Connection", "keep-alive")
		c.Next()
	}
}

// Combine 合并分片文件
func Combine(inputMeta Input) {
	// 等待通知
	var i int64
	blockCount, err := strconv.ParseInt(inputMeta.BlockCount, 10, 64)
	if err != nil {
		log.Println("数值转换发生错误！！")
	}
	for i = 0; i != blockCount; i++ {
		<-notifyChan
	}
	log.Println("开始合并文件")
	file, err := os.OpenFile(inputMeta.FileName, os.O_RDWR|os.O_APPEND|os.O_CREATE, 666)
	defer file.Close()
	if err != nil {
		log.Println("最终文件创建失败")
	}
	for i = 0; i != blockCount; i++ {
		blockFile, err := os.OpenFile(strconv.FormatInt(i, 10), os.O_RDWR, 666)
		if err != nil {
			log.Printf("没发现第 %d 块？发生错误 %s", i, err.Error())
			return
		}
		_, err = io.Copy(file, blockFile)
		if err != nil {
			log.Println("io Copy 发生错误：" + err.Error())
		}
		_ = blockFile.Close()
	}
	log.Println("写入成功")

}

func metadata(c *gin.Context) {
	var input Input
	err := c.Bind(&input)
	if err != nil {
		log.Println("metadata 绑定结构体 错误:" + err.Error())
		return
	}
	log.Printf("接收来自 %s 到 metadata 的请求，\nfile_name ：%s ,\n file_size : %s,\n block_count: %s\n",
		c.Request.Host,
		input.FileName,
		input.FileSize,
		input.BlockCount)

	go Combine(input)
	log.Println("启动 文件合成 Goroutine")
	c.JSON(200, gin.H{
		"message": "pong",
	})
}

func main() {
	notifyChan = make(chan struct{}, 1)

	r := gin.Default()
	r.POST("/file/upload/metadata", func(c *gin.Context) {
		var input Input
		err := c.Bind(&input)
		if err != nil {
			log.Println("metadata 绑定结构体 错误:" + err.Error())
			return
		}
		log.Printf("接收来自 %s 到 metadata 的请求，\nfile_name ：%s ,\n file_size : %s,\n block_count: %s\n",
			c.Request.Host,
			input.FileName,
			input.FileSize,
			input.BlockCount)

		go Combine(input)
		log.Println("启动 文件合成 Goroutine")
		// 返回
		c.JSON(200, gin.H{
			"message": "pong",
		})
	})
	r.POST("file/upload/data", HeadersMiddleware(), func(c *gin.Context) {
		order := c.PostForm("order")
		fileBlob, err := c.FormFile("data")

		if err != nil {
			log.Println("发生错误：" + err.Error())
			c.JSON(501, gin.H{})
			return
		}
		err = c.SaveUploadedFile(fileBlob, order)
		if err != nil {
			log.Println("发生错误：" + err.Error())
			c.JSON(502, gin.H{})
			return
		}
		log.Printf("接收到来自 %s 的 data, size 为：%d, order 为： %s", c.Request.Host, fileBlob.Size, order)
		notifyChan <- struct{}{}
		c.JSON(200, gin.H{
			"message": "Ping",
		})
	})

	err := r.Run(":5505")
	if err != nil {
		log.Fatal(err)
	}
}
