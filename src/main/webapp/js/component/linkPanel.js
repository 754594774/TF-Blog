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
        var result=getlinkData();
        return {
            sites:result
        };
    }
});

function getlinkData(){
    var resp = null;
    $.ajax({
        url : 'toLinkList',
        type : 'POST',
        async : false,
        success : function(data) {
            resp = $.parseJSON(data);
        },
        error : function() {
            resp = $.parseJSON(data);
        }
    });
    return resp;
}
