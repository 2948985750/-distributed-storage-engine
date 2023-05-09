// vue的插件功能
// 介绍；https://cn.vuejs.org/guide/reusability/plugins.html#introduction

export default function(app){
    // 自定义指令
    app.directive("focus", {
        mounted(el){
            el.focus();
        }
    }),
    app.directive("mouse-color", {
        creted(el, bindings){
            bindings.mouseColor = "skybule";
            if(bindings.value){
                bindings.mouseColor = bindings.value;
            }
        },
        mounted(el, bindings){
            el.addEventListener("mouseover", () => el.style.backgroundColor = "skyblue")
            el.addEventListener("mouseout", () => el.style.backgroundColor = "transparent")
        },
    })
}