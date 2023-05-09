<template>
  <top-menu @labelClick="onLabel"></top-menu>
  <uploader></uploader>
  <component
      :is="curBound"
      v-model:visible="labelState">
  </component>
</template>

<script setup>
import topMenu from "../../views/menu/menu.vue";
import uploader from "../../views/uploader.vue";

import useBoundBox from "./useBoundBox.js";
import {ref, watchEffect, watch, shallowRef} from "vue";

const currentLabel = ref([]);
const labelState = ref(null);
const curBound = shallowRef(null);
const { BoundTags } = useBoundBox();

const onLabel = (val) => {
  currentLabel.value = val;
  labelState.value = Boolean(val.length);
}

watch( currentLabel , (newValue) => {
  curBound.value = BoundTags[currentLabel.value];
}, {
  immediate: true,
});

// watchEffect(() => {
//   console.log("currentLabel=", currentLabel.value);
//   console.log("labelStatue=", labelState.value);
// },{
//   flush: "post",
// });

</script>

<style scoped>

</style>
