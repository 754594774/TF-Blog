//是否显示通知
function noticeStatusFormatter(isActive) {
    if(isActive == 1){
        return '<span class="label label-danger">不显示</span>';
    }else {
        return '<span class="label label-success">已显示</span>';
    }
}
//是否允许评论文章
function allowCommentFormatter(allowComment) {
    if(allowComment == 1){
        return '<span class="label label-danger">已禁止</span>';
    }else {
        return '<span class="label label-default">未禁止</span>';
    }
}
//显示文章置顶状态
function stickFormatter(stick) {
    if(stick == 1){
        return '<span class="label label-danger">已置顶</span>';
    }else {
        return '<span class="label label-default">未置顶</span>';
    }
}
//bootstrap-table表格插件的过滤器
//显示信件的查阅状态
function letterStatusFormatter(viewStatus) {
    if(viewStatus == 1){
        return '<span class="label label-default">已读</span>';
    }else {
        return '<span class="label label-info">未读</span>';
    }
}

//bootstrap-table表格插件的过滤器
// 日期时间的过滤
//传入时间戳,转为特定格式的字符串
//默认格式  "yyyy-MM-dd hh:mm:ss"
function formatDateTime (gmt) { //author: meizz
    var date = new Date(gmt);
    var fmt = "yyyy-MM-dd hh:mm:ss";
    var o = {
        "M+": date.getMonth() + 1, //月份
        "d+": date.getDate(), //日
        "h+": date.getHours(), //小时
        "m+": date.getMinutes(), //分
        "s+": date.getSeconds(), //秒
        "q+": Math.floor((date.getMonth() + 3) / 3), //季度
        "S": date.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;

}
//bootstrap-table表格插件的过滤器
// 显示序号
function indexFormatter(value, row, index) {
    return index;
}


