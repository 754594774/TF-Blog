// 注册
Vue.component('blog-notice', {
    template: "<div class=\"panel panel-primary\">\n" +
    "    <div class=\"panel-heading\">\n" +
    "        <h3 class=\"panel-title\">{{notice.title}}</h3>\n" +
    "    </div>\n" +
    "    <div class=\"panel-body\">\n" +
    "        {{notice.content}}\n" +
    "    </div>\n" +
    "</div>",
    data: function () {
        return {
            notice:null
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
            vm.notice = "";
            $.ajax({
                url : 'toNoticeDetail',
                type : 'POST',
                success : function(data) {
                    vm.notice = data;
                },
                error : function() {
                    alert("error");
                }
            });
        }
    }
});

