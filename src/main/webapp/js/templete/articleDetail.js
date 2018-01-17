//1.定义模板
const articleDetail = Vue.extend({
    template:
    "<div class=\"panel panel-default\">\n" +
    "\t<div class=\"panel-body\">\n" +
    "\t\t<h2>{{item.title}}</h2>\n" +
    "\t\t<span class=\"text-muted\">{{item.gmtCreate| articleDateFilter}} by {{item.author}}</span>\n" +
    "\t\t<p>{{item.content}}</p>\n" +
    "  </div>\n" +
    "</div>",
    data: function () {
        return {
            item: null
        }
    },
    created:function () {
        // 组件创建完后获取数据，
        // 此时 data 已经被 observed 了
        this.fetchData(this)
    },
    watch: {
        // 如果路由有变化，会再次执行该方法
        '$route': 'fetchData'
    },
    methods: {
        fetchData:function(vm){
            vm.item = "";
            $.ajax({
                url : 'toArticleDetail',
                type : 'POST',
                data : {
                    articleId:this.$route.params.id
                },
                success : function(data) {
                    vm.item = data;
                },
                error : function() {
                   alert("error");
                }
            });
        }
    }
})