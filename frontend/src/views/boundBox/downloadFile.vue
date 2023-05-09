<template>
  <history-bound-box>
    <template #title>下载文件历史</template>
    <template #content>
      <p>文件</p>
    </template>
  </history-bound-box>
</template>

<script setup>
import HistoryBoundBox from "../../components/dialogueBox/historyBoundBox.vue";
import {onMounted, provide, ref} from "vue";

const mockData = ref([
  {
    fileList: [
      {
        name: "测试.exe",
      },
    ],
    uniCode: 111111,
  }
  ]
);
provide("fileData", mockData);
onMounted(() =>{
  setTimeout(() => {
    mockData.value = [];
  }, 1000);
})
</script>

<style lang="" scoped>

</style>
