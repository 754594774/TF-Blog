// 注册
Vue.component('blog-link', {
    template: "<div class=\"panel panel-primary\">\n" +
    "    <div class=\"panel-heading\">\n" +
    "        <h3 class=\"panel-title\">友链</h3>\n" +
    "    </div>\n" +
    "    <ul class=\"list-group\">" +
    "        <li v-for=\"site in sites\" class=\"list-group-item\"><a v-bind:href=\"site.url\" target=\"_blank\">{{ site.title }}</a></li>" +
    "   </ul>" +
    "</div>",
    data: function () {
        return {
            sites:null
        };
    },
    created:function () {
        // 组件创建完后获取数据，
        // 此时 data 已经被 observed 了
        this.fetchData()
    },
    watch: {
        // 如果路由有变化，会再次执行该方法
        '$route': 'fetchData'
    },
    methods: {
        fetchData:function(){
            var vm = this;
            vm.sites = null;
            $.ajax({
                url : 'toLinkList',
                type : 'POST',
                success : function(data) {
                    vm.sites = data;
                },
                error : function() {
                    alert("error");
                }
            });
        }
    }
});


