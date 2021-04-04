var vm = new Vue({
    el: '#box', //确定根元素
    data: {
        keyword: '',
        list: [{
            name: "居家无忧家庭财产保险",
            src: "",
            intro: "全面守护爱家，每天仅需0.54元起"
        }, {
            name: "熊孩子·监护人责任险",
            src: "",
            intro: "保障全面，守护童真"
        }, {
            name: "伴你同行·交通工具意外险",
            src: "",
            intro: "一张保单两份保障，守护你和你爱的人"
        }, {
            name: "卡安心·家庭共享账户安全",
            src: "",
            intro: "一人投保，全家安心"
        }, {
            name: "安心养·宠物责任险",
            src: "",
            intro: "意外守护，养宠无忧"
        }, ],
        historyList: [] //历史搜索记录，存本地
    },
    methods: {
        get_search(){
           this.historyList.push(this.keyword);
        },
        jump_to(its){
         this.keyword = its;
        }
    },

    computed: { //设置计算属性
        fSearch() {
            if (this.keyword) {
                return this.list.filter((value) => { //过滤数组元素
                    return value.name.includes(this.keyword) || value.intro.includes(this.keyword); //如果包含字符返回true
                });
            } else {
                return this.list
            }
        }
    },

});