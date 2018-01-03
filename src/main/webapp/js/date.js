//日期时间的各式过滤器，将时间戳类型转为时间类型
Vue.filter('yyyy-MM-dd HH:mm:ss', function (value) {
    if (!value) return '';
    return getMyDate(value);
})
Vue.filter('yyyyMMdd', function (value) {
    return getMyDateYMD(value);
})

function getMyDate(str){
    var oDate = new Date(str),
        oYear = oDate.getFullYear(),
        oMonth = oDate.getMonth()+1,
        oDay = oDate.getDate(),
        oHour = oDate.getHours(),
        oMin = oDate.getMinutes(),
        oSen = oDate.getSeconds(),
        oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) +' '+ getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen);//最后拼接时间
    return oTime;
};

function getMyDateYMD(str){
    var oDate = new Date(str),
        oYear = oDate.getFullYear(),
        oMonth = oDate.getMonth()+1,
        oDay = oDate.getDate(),
        oHour = oDate.getHours(),
        oMin = oDate.getMinutes(),
        oSen = oDate.getSeconds(),
        oTime = oYear +'年'+ getzf(oMonth) +'月'+ getzf(oDay)+ '日';//最后拼接时间
    return oTime;
}

//补0操作
function getzf(num){
    if(parseInt(num) < 10){
        num = '0'+num;
    }
    return num;
}