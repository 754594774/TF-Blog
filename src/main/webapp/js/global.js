//提示框配置
//需要在html里引用toastr的插件
$(function () {
    //弹出提示框
    toastr.options = {
        closeButton: false,//是否显示关闭按钮（提示框右上角关闭按钮）
        debug: false,//是否为调试
        progressBar: true,//是否显示进度条（设置关闭的超时时间进度条）
        positionClass: "toast-top-right",//消息框在页面显示的位置
        onclick: null,//点击消息框自定义事件
        showDuration: "300",//显示动作时间
        hideDuration: "1000",//隐藏动作时间
        timeOut: "5000",//自动关闭超时时间
        extendedTimeOut: "1000",
        showEasing: "swing",
        hideEasing: "linear",
        showMethod: "fadeIn",//显示的方式，和jquery相同
        hideMethod: "fadeOut"//隐藏的方式，和jquery相同
    };
});

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
