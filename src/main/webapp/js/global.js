$(document).ready(function () {
    //导航栏
    Vue.component('blog-header', {
        template:
        "<nav class=\"navbar navbar-inverse\" role=\"navigation\">\n" +
        "    <div class=\"container-fluid\">\n" +
        "        <div>\n" +
        "            <!--向左对齐-->\n" +
        "            <ul class=\"nav navbar-nav navbar-left\">\n" +
        "                <li class=\"active\"><a href=\"#\">首页</a></li>\n" +
        "                <li class=\"dropdown\">\n" +
        "                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n" +
        "                        传送门\n" +
        "                        <b class=\"caret\"></b>\n" +
        "                    </a>\n" +
        "                    <ul class=\"dropdown-menu\">\n" +
        "                        <li><a href=\"#\">文章</a></li>\n" +
        "                        <li><a href=\"#\">友链</a></li>\n" +
        "                    </ul>\n" +
        "                </li>\n" +
        "                <li><a href=\"#\">联系我</a></li>\n" +
        "            </ul>\n" +
        "            <!--向右对齐-->\n" +
        "            <ul class=\"nav navbar-nav navbar-right\">\n" +
        "                <li><a href=\"#\"><span class=\"glyphicon glyphicon-user\"></span> 注册</a></li>\n" +
        "                <li><a href=\"#\"><span class=\"glyphicon glyphicon-log-in\"></span> 登录</a></li>\n" +
        "            </ul>\n" +
        "            <form class=\"navbar-form navbar-right\">\n" +
        "                <input type=\"text\" class=\"form-control\" placeholder=\"Search...\">\n" +
        "            </form>\n" +
        "        </div>\n" +
        "     </div>\n" +
        "</nav>"
    })

    //页脚
    Vue.component('blog-footer', {
        template:
        "<footer>\n" +
        "    <p class=\"pull-right\"><a href=\"#\">Back to top</a></p>\n" +
        "    <p>&copy; 2016 Company, Inc. &middot; <a href=\"#\">Privacy</a> &middot; <a href=\"#\">Terms</a></p>\n" +
        "</footer>"
    })

    //公告
    Vue.component('blog-notice', {
        template:
        "<div class=\"panel panel-primary\">\n" +
        "    <div class=\"panel-heading\">\n" +
        "        <h3 class=\"panel-title\">{{title}}</h3>\n" +
        "    </div>\n" +
        "    <div class=\"panel-body\">\n" +
        "        {{content}}\n" +
        "    </div>\n" +
        "</div>",
        data: function () {
            return {
                title: '公告',
                content: '公告内容'
            }
        }
    })
    //右侧面板
    Vue.component('blog-panel', {
        props: ['todo'],
        template:
        "<div class=\"panel panel-primary\">\n" +
        "    <div class=\"panel-heading\">\n" +
        "        <h3 class=\"panel-title\">{{todo.title}}</h3>\n" +
        "    </div>\n" +
        "    <ul class=\"list-group\">\n" +
        "        <li v-for=\"item in todo.items\" class=\"list-group-item\"><a v-bind:href=\"item.url\">{{ item.text }}</a></li>\n" +
        "    </ul>\n" +
        "</div>"
    })


    //Vue.component('blog-panel', {
    //    props: ['todo'],
    //    template:
    //    "<div class=\"panel panel-primary\">\n" +
    //    "    <div class=\"panel-heading\">\n" +
    //    "        <h3 class=\"panel-title\">{{todo.title}}</h3>\n" +
    //    "    </div>\n" +
    //    "    <ul class=\"list-group\">\n" +
    //    "        <li v-for=\"item in todo.items\" class=\"list-group-item\"><router-link to=\"item.url\">{{ item.text }}</router-link></li>\n" +
    //    "    </ul>\n" +
    //    "</div>"
    //})


    //$.ajax({
    //    url : 'vueServlet',
    //    type : 'POST',
    //    data : {
    //        vue:"hello vue",
    //    },
    //    success : function(data) {
    //        alert("success");
    //    },
    //    error : function() {
    //        alert("error");
    //    }
    //});

});







