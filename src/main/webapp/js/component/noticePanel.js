// 注册
Vue.component('blog-notice', {
    template: "<div class=\"panel panel-primary\">\n" +
    "    <div class=\"panel-heading\">\n" +
    "        <h3 class=\"panel-title\">{{title}}</h3>\n" +
    "    </div>\n" +
    "    <div class=\"panel-body\">\n" +
    "        {{content}}\n" +
    "    </div>\n" +
    "</div>",
    data: function () {
        return getNoticeData();
    }
});

function getNoticeData(){
    var resp = null;
    $.ajax({
        url : 'toNoticeDetail',
        type : 'POST',
        async : false,
        success : function(data) {
            resp = data;
        },
        error : function() {
            resp = data;
        }
    });
    return resp;
}
