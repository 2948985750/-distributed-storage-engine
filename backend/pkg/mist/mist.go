package mist

import (
	"crypto/rand"
	"math/big"
	"strconv"
	"sync/atomic"
)

const _saltBit = uint(8)                     // 随机因子二进制位数
const _saltShift = uint(8)                   // 随机因子移位数
const _increaseShift = _saltBit + _saltShift // 自增数移位数

type Mist struct {
	increase atomic.Int64 // 自增数
}

// NewMist 初始化 Mist 结构体
func NewMist() *Mist {
	mist := Mist{increase: atomic.Int64{}}
	mist.increase.Store(1)
	return &mist
}

// Generate 生成唯一编号
func (c *Mist) Generate() int64 {
	// 获取随机因子数值 ｜ 使用真随机函数提高性能
	randA, _ := rand.Int(rand.Reader, big.NewInt(255))
	randB, _ := rand.Int(rand.Reader, big.NewInt(255))
	saltA, saltB := randA.Int64(), randB.Int64()
	c.increase.Add(1)
	// 通过位运算实现自动占位
	mist := (c.increase.Load() << _increaseShift) | (saltA << _saltShift) | saltB
	return mist
}

func (c *Mist) GenerateString() string {
	return strconv.FormatInt(c.Generate(), 10)
}
