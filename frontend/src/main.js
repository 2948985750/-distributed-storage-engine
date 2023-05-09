import { createApp } from 'vue'
import Antd from 'ant-design-vue';
import './style.css'
import Directive from "./utils/globalPlugin.js"
import App from './App.vue'
import 'ant-design-vue/dist/antd.css'

const app = createApp(App);
app.use(Antd)
app.use(Directive)
app.mount("#app")
