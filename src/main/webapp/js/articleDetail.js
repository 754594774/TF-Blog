/**
 * 文章详情和留言
 * Created by Administrator on 2018-02-28.
 */
// 初始化验证
$('#commentForm').validator({
    timely: 0,
    theme: 'yellow_top',
    fields: {
        'name': '姓名:required',
        'contactInfo': '联系方式:required',
        'msg':'内容:required'
    },
    valid: function(form){
        leaveMsg();
    }
});

function leaveMsg(){
    var name = $("#name").val().trim();
    var msg = $("#msg").val().trim();
    var articleId = $("#articleId").val();
    var contactInfo = $("#contactInfo").val();

    var innerHtml =
        "<li class=\"list0\"> <a class=\"close\" href=\"javascript:;\">X</a>\n" +
        "  <div class=\"head\"><img src=\"resources/images/foot.png\" alt=\"\"></div>\n" +
        "  <div class=\"content\">\n" +
        "    <p class=\"text\"><span class=\"name\">我：</span>" + msg + "</p>\n" +
        "    <div class=\"good\"><span class=\"date\">" + getTime() + "</span></div>\n" +
        "    <div class=\"people\" total=\"0\" style=\"display: none;\"></div>\n" +
        "    <div class=\"comment-list\">\n" +
        "    </div>" +
        "  </div>\n" +
        "</li>";

    $("#pn").prepend(innerHtml);

    $("#msg").val("");
    //发送ajax请求
    $.ajax({
        url: 'addComment',
        type: 'POST',
        data: {
            pid: 0,
            content:msg,
            memberName:name,
            contactInfo:contactInfo,
            articleId:articleId
        },
        success: function (data) {
            if(data.errNo == 0){
                //alert("ok");
            }else {
                swal("失败!", data.errMsg, "error")
            }
        },
        error: function () {
            swal("评论失败", "添加评论时出错了！", "error");
        }
    });
}

function getTime() {
    var t = new Date();
    var y = t.getFullYear();
    var m = t.getMonth() + 1;
    var d = t.getDate();
    var h = t.getHours();
    var mi = t.getMinutes();
    m = m < 10 ? "0" + m : m;
    d = d < 10 ? "0" + d : d;
    h = h < 10 ? "0" + h : h;
    mi = mi < 10 ? "0" + mi : mi;
    return y + "-" + m + "-" + d + "" + h + ":" + mi;
}