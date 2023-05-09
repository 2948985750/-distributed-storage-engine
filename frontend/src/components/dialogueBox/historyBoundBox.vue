<template>
  <div id="history-modal">
    <dialogue-box v-model:visible="visible">
      <template #content>
        <a-list
            class="demo-loadmore-list"
            item-layout="horizontal"
            :loading="initLoading"
            :data-source="fileData"
        >
          <template #renderItem="{ item }" >
            <a-list-item v-mouse-color>
              <template #actions>
                <close-outlined @click="deleteFile"/>
              </template>
              <a-list-item-meta>
                <template #description>
                  <span>{{fileInfo(item)}}</span>
                </template>
                <template #title>
                  <h4>{{item.uniCode}}</h4>
                </template>
              </a-list-item-meta>
            </a-list-item>
          </template>
        </a-list>
      </template>
      <template #title>
        <slot name="title"></slot>
      </template>
      <template #footer>
        <a-button shape="round" type="primary" size="large" @click="refresh">刷新</a-button>
      </template>
    </dialogue-box>
  </div>
</template>

<script setup>
import { CloseOutlined } from '@ant-design/icons-vue';
import dialogueBox from "./root/dialogueBox.vue";
import {provide, computed, inject, ref, watch, watchEffect} from "vue";

import { onMounted } from 'vue';
const modalClassName = ref("history-modal");
const initLoading = ref(true);
// const loading = ref(false);
const fileData = inject("fileData");

const visible = ref(false);

const emit = defineEmits(['visible'])
const props = defineProps({
  visible: Boolean,
  fileData: Array,
})
watch(visible, (newValue, oldValue) => {
  emit("visible", newValue);
});
watch(props, (newValue, oldValue) => {
  visible.value = newValue.visible;
},{
  immediate: true
})

watch(fileData, (newValue, oldValue) => {
  console.log(newValue)
  console.log(oldValue)
  initLoading.value = false;
})

const fileInfo = (item) => {
  let s = '';
  item.fileList.forEach((e, index) => {
    s += e.name;
    if(index !== item.fileList.length -1)
      s += '，';
  })
  return s;
}

const deleteFile = () => {
  console.log("删除文件");
}

const refresh = () => {
  console.log('刷新');
}

// 样式处理
provide("modalClassName", modalClassName);
</script>

<style lang="less">
  .history-modal{
    .ant-list{
    height: inherit;
    .ant-spin-container{
      height: 220px;
      overflow: auto;
      }
    .ant-list-item {
      padding: 3px;
      border-radius: 10px;
      // background-color: rgba(0, 111, 178, .5);
      margin-bottom: 1px;
      h4{
        margin-bottom: 0;
        }
      }
    }
  }
</style>
