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
        this.fetchData()
    },
    watch: {
        // 如果路由有变化，会再次执行该方法
        '$route': 'fetchData'
    },
    methods: {
        fetchData:function(){
            this.item = null;
            var resp = {};
            $.ajax({
                url : 'toArticleDetail',
                type : 'POST',
                async : false,
                data : {
                    articleId:this.$route.params.id
                },
                success : function(data) {
                    resp = data;
                },
                error : function() {
                    resp = data;
                }
            });
            this.item = resp;
        }
    }
})