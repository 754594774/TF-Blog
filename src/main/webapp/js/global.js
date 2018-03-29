//bootstrap-table表格插件的过滤器
//显示信件的查阅状态
function letterStatusFormatter(viewStatus) {
    if(viewStatus == 0){
        viewStatus="未读";
    }else if(viewStatus == 1){
        viewStatus="已读";
    }else{
        viewStatus="未知状态";
    }
    return viewStatus;
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


