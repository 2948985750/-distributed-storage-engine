const navMenuLables = [
    {
        history: [
            {
                uploadFile:[],
                name_ZH: "上传文件"
            },
            {
                downloadFile:[],
                name_ZH: "下载文件"
            },
        ],
        name_ZH: "历史"
    },
    {
        helps: [
            {
                useHelps: [],
                name_ZH: "使用帮助"
            },
            {
                feedback: [],
                name_ZH: "反馈"
            },
        ],
        name_ZH: "帮助"
    },
];

const lables = (array) => {
    return array.map(item => {
        const [currentkey] = Object.keys(item).filter(key => {
            if(key !== "name_ZH")
                return key;
        })
        return currentkey;
    });
}
// 一级导航菜单标签
const firstLevel = lables(navMenuLables);
// 二级导航菜单标签
let secondLevel = [];
navMenuLables.forEach((item, idx) => {
    for(let key in item){
        if(key === firstLevel[idx]){
            secondLevel.push(lables(navMenuLables[idx][key]))
        }
    }
})


export {firstLevel, secondLevel}
