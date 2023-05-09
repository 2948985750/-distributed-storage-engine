<template>
    <div id="menu">
        <!-- 目录 -->
        <div class="board" v-if="active" @click.stop="onClick" ref="board">
            <unordered-list-outlined style="fontSize: 3vw; color: black;"/>
        </div>
        <!-- 导航菜单栏 -->
        <div class="nav-menu" v-else ref="nav">
            <div>
                <a-menu
                    v-model:selectedKeys="selectedKeys"
                    style="width: 15vw"
                    mode="inline"
                    :open-keys="openKeys"
                    @openChange="onOpenChange"
                >
                    <a-sub-menu :key="firstLevel[0]">
                        <template #icon>
                            <history-outlined />
                        </template>
                        <template #title>历史</template>
                        <a-menu-item :key="secondLevel[0][0]">发送文件</a-menu-item>
                        <a-menu-item :key="secondLevel[0][1]">下载文件</a-menu-item>
                    </a-sub-menu>
                    <a-sub-menu :key="firstLevel[1]">
                        <template #icon>
                            <question-circle-outlined />
                        </template>
                        <template #title>帮助</template>
                        <a-menu-item :key="secondLevel[1][0]">使用帮助</a-menu-item>
                        <a-menu-item :key="secondLevel[1][1]">反馈</a-menu-item>
                    </a-sub-menu>
                </a-menu>
            </div>
        </div>
    </div>
</template>

<script setup>
import { UnorderedListOutlined, HistoryOutlined, QuestionCircleOutlined } from '@ant-design/icons-vue';

import {ref, reactive, toRefs, onUpdated,computed, watch, watchEffect } from "vue";
import {firstLevel, secondLevel} from "./menu.init.js";
import HistoryBoundBox from "../../components/dialogueBox/historyBoundBox.vue";

// 判断导航菜单栏是否开启
let active = ref(true);
// 菜单面板
let board = ref(null);
// 导航菜单栏
let nav = ref(null);
// 向父组件传递当前点击的导航菜单栏的标签信息
let navClick = defineEmits(['labelClick']);

const onClick = () => {
    active.value = !active.value;
};

const navMenu = reactive({
    rootSubmenuKeys: firstLevel,
    openKeys: [],
    selectedKeys: [],
});

let { rootSubmenuKeys, openKeys, selectedKeys } = toRefs(navMenu);

const onOpenChange = (item) => {
    const latestOpenKey = item.find(key => navMenu.openKeys.indexOf(key) === -1);
    if (navMenu.rootSubmenuKeys.indexOf(latestOpenKey) === -1) {
        navMenu.openKeys = openKeys.value;
    }
    else {
        navMenu.openKeys = latestOpenKey ? [latestOpenKey] : [];
    }
};

// 导航菜单， 点击页面空白处
const doAreaClick = (e) => {
    const { target } = e;
    // 如果当前的点击区域不在导航菜单栏，则不触发onClick事件
    if(!nav.value.contains(target)){
      onClick()
    } else {
      navClick('labelClick', active.value || selectedKeys.value)
    }
}

onUpdated(() => {
    if(active.value === false && nav.value){
        // console.log("nav=", nav.value)
        window.addEventListener("click", doAreaClick);
    }
    if(active.value === true && board.value){
        // console.log("board=", board.value)
        window.removeEventListener("click", doAreaClick);
        // 清空selectedKeys, openKeys
        selectedKeys.value = [];
        openKeys.value = [];
    }
})


</script>

<style lang="less" scoped>
    #menu{
        width: 100%;
        height: 100%;
        .board{
            position: fixed;
            left: 10px;
            top: 10px;
            width: 20px;
            height: 20px;
        }
        .nav-menu{
            position: fixed;
            left: 10px;
            top: 10px;
            border-radius: 15px;
            overflow: hidden;
            box-shadow: var(--box-shadow-style);
        }
    }
</style>
