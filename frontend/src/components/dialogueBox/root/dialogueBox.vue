<template>
    <!-- 对话框 -->
    <div id="root-modal">
        <a-modal
            ref="modalRef"
            v-model:visible="visible"
            :wrap-style="{ overflow: 'hidden' }"
            @ok="handleOk"
            :mask="false"
            :maskClosable="false"
            :wrapClassName=comClassName
        >
            <div class="content">
                <slot name="content"></slot>
            </div>
            <template #title>
                <slot name="title"></slot>
            </template>
            <template #footer>
              <slot name="footer"></slot>
            </template>
        </a-modal>
    </div>
</template>

<script setup>
// 注意：ant-design-vue 的 a-modal 组件是 vue 的内置组件 teleport 构造而成的
import {computed, onMounted, ref, watch} from "vue";
import {inject} from "vue";

const modal = ref(null);
const visible = ref(false);
const className = inject("modalClassName");

const emit = defineEmits(['visible']);
const props = defineProps({
  visible: Boolean,
});
watch(visible, (newValue) => {
  emit("update:visible", newValue);
});
watch(props, (newValue) => {
  visible.value = newValue.visible;
},{
  immediate: true,
});

const handleOk = e => {
    console.log(e);
    visible.value = false;
};

onMounted(() => {
  console.log(modal.value);
})

//样式处理
const comClassName = computed(() => `root-modal ${className.value}`);
</script>

<style lang="less">
  .root-modal{
    .ant-modal{
      padding-bottom: 0 !important;
      border-radius: 15px;
      overflow: hidden;
      box-shadow: var(--box-shadow-style);
      .ant-modal-content{
        .ant-modal-header{
          border-bottom: none;
          text-align: center;
        }
        .ant-modal-body{
          padding: 0 24px;
          height: 220px;
          .content{
            height: inherit;
          }
        }
        .ant-modal-footer{
          border-top: none;
          text-align: center;
          .ant-btn{
            border: none;
          }
        }
      }
    }
  }
</style>
