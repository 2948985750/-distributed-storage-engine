<template>
  <history-bound-box>
    <template #title>上传文件历史</template>
  </history-bound-box>
</template>

<script setup>
import HistoryBoundBox from "../../components/dialogueBox/historyBoundBox.vue";
import {onMounted, provide, readonly, ref} from "vue";

const fileList = [
  {
    fileList: [
      {
        name: "sysdiag-full-5.0.56.2-20210109.exe",
        mb: 17.89234161376953,
        size: 18761480,
      },
    ],
    uniCode: 99123,
  },
  {
    fileList: [
      {
        name: "VSCodeUserSetup-x64-1.58.0.exe",
        mb: 76.7958755493164,
        size: 80526312,
      },
    ],
    uniCode: 123456,
  },
  {
    fileList:[
      {
        name: "package.json",
        mb: 0.0005159378051757812,
        size: 541,
      },
      {
        name: "sysdiag-full-5.0.56.2-20210109.exe",
        mb: 17.89234161376953,
        size: 18761480,
      },
      {
        name: "VSCodeUserSetup-x64-1.58.0.exe",
        mb: 76.7958755493164,
        size: 80526312,
      },
      {
        name: "WeChatSetup.exe",
        mb: 115.03307342529297,
        size: 120620920,
      }
    ],
    uniCode: 912304,
  },
  {
    fileList: [
      {
        name: "WeChatSetup.exe",
        mb: 115.03307342529297,
        size: 120620920,
      }
    ],
    uniCode: 654321,
  },
];
let mock = [
  [
      {
          "key": {
              "file_name": "前端开发工程师_杨海_正式.doc",
              "file_size": "35980",
              "block_count": "1"
          },
          "value": [
              {}
          ]
      },
      {
          "key": {
              "file_name": "营业员_杨海_正式.doc",
              "file_size": "33164",
              "block_count": "1"
          },
          "value": [
              {}
          ]
      }
  ],
  
]
const mockData = ref([
  {
    fileList: [
      {
        name: "测试.exe",
      },
    ],
    uniCode: 111111,
  }]
);
// 实现单项数据流
provide("fileData", readonly(mockData));
onMounted(() =>{
  setTimeout(() => {
    mockData.value = fileList;
  }, 3000);
})

</script>

<style lang="less" >

</style>
