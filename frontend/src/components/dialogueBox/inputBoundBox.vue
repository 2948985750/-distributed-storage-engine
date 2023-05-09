<template>
  <div id="input-modal">
    <dialogue-box v-model:visible="visible">
    <template #content>
      <a-textarea
          v-model:value="value2"
          placeholder="在这里输入纯文本"
          :autoSize="{ minRows: 10, maxRows: 10 }"
      />
    </template>
    <template #title>
      <div>发送文本</div>
    </template>
    <template #footer>
      <a-button shape="round" type="primary" size="large">发送</a-button>
    </template>
  </dialogue-box>
  </div>
</template>

<script setup>
import dialogueBox from "./root/dialogueBox.vue";
import { ref, watch} from "vue";
const modalClassName = ref("input-modal");
const visible = ref(false);
const emit = defineEmits(['visible'])
const props = defineProps({
  visible: Boolean,
})
watch(visible, (newValue, oldValue) => {
  emit("visible", newValue);
});
watch(props, (newValue, oldValue) => {
  visible.value = newValue.visible;
},{
  immediate: true
})

</script>

<style lang="less">

</style>
