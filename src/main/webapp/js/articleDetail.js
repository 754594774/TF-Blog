/**
 * Created by Administrator on 2018-02-28.
 */
function leaveMsg(){
    var name = $("#name").val().trim();
    var msg = $("#msg").val().trim();
    var articleId = $("#articleId").val();
    if(name=="" || name == null || name == undefined){
        alert("请输入姓名");
        return;
    }
    if(msg=="" || msg == null || msg == undefined){
        alert("请输入留言信息");
        return;
    }
    var innerHtml =
        "<li class=\"list0\"> <a class=\"close\" href=\"javascript:;\">X</a>\n" +
        "  <div class=\"head\"><img src=\"../resources/images/foot.png\" alt=\"\"></div>\n" +
        "  <div class=\"content\">\n" +
        "    <p class=\"text\"><span class=\"name\">我：</span>" + msg + "</p>\n" +
        "    <div class=\"good\"><span class=\"date\">" + getTime() + "</span><a class=\"dzan\" href=\"javascript:;\">赞</a></div>\n" +
        "    <div class=\"people\" total=\"0\" style=\"display: none;\"></div>\n" +
        "    <div class=\"comment-list\">\n" +
        "    </div>" +
        "  </div>\n" +
        "</li>";

    $("#pn").prepend(innerHtml);

    $("#name").val("");
    $("#msg").val("");
    //发送ajax请求
    $.ajax({
        url: 'addComment',
        type: 'POST',
        data: {
            pid: 0,
            content:msg,
            memberName:name,
            articleId:articleId
        },
        success: function (data) {
            if(data.errNo == 0){
                //alert("ok");
            }else {
                alert("系统错误");
            }
        },
        error: function () {
            alert("添加失败");
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