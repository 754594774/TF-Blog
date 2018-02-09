var $table = $('#table');
var $btnAdd = $('#btnAdd');
var $btnChange = $('#btnChange');
var $btnDel = $('#btnDel');
var $btnRefresh = $('#btnRefresh');
var $btnOk = $('#btnOk');
$(function () {
    $btnAdd.click(function (e) {
        var scope = $(e.target).scope();
        scope.article = null;
        scope.addOrChange = "添加";
        scope.$apply();//刷新数据;

    });
    $btnChange.click(function (e) {
        var row = $table.bootstrapTable('getSelections');
        console.log(row);
        if(row.length != 1){
            toastr.warning('请选择一行！');
            return false;//阻止跳转
        }
        //var scope = $(e.target).scope();
        //scope.addOrChange = "修改";
        //scope.article = row[0];
        //scope.$apply();//刷新数据
    });
    $btnDel.click(function () {
        var row = $table.bootstrapTable('getSelections');
        if(row.length <= 0){
            return;
        };
        if(confirm("真的要删除吗?")){
            var ids = $.map($table.bootstrapTable('getSelections'), function (row) {
                return row.id;
            });
            $table.bootstrapTable('remove', {
                field: 'id',
                values: ids
            });
        };
        //$.ajax({
        //    url: 'delArticle',
        //    type: 'POST',
        //    traditional:true,
        //    data:{ids:ids},
        //    success: function (data) {
        //        if(data.errNo == 0){
        //            toastr.success(data.errMsg);
        //        }else {
        //            toastr.error(data.errMsg);
        //            $table.bootstrapTable('refresh');
        //        }
        //    },
        //    error: function () {
        //        toastr.error('删除失败');
        //        $table.bootstrapTable('refresh');
        //    }
        //});
    });
    $btnRefresh.click(function () {
        $table.bootstrapTable('refresh');
    });
    $btnOk.click(function (e) {//点击确认按钮
        var scope = $(e.target).scope();
        if(scope.article!=null && scope.article.id !=null){//修改
            $table.bootstrapTable('updateRow', {
                //index:0,
                row:scope.article
            });
        } else {
            $table.bootstrapTable('insertRow', {
                index: 0,
                row:scope.article
            });
        }
        $('#myModal').modal('hide');

        //发送ajax请求
        //$.ajax({
        //    url: 'addOrUpdateArticle',
        //    type: 'POST',
        //    data: {
        //        //id: scope.catg.id,
        //        //name:scope.catg.name,
        //        //description:scope.catg.description
        //    },
        //    success: function (data) {
        //        if(data.errNo == 0){
        //            toastr.success(data.errMsg);
        //        }else {
        //            toastr.error(data.errMsg);
        //            $table.bootstrapTable('refresh');
        //        }
        //    },
        //    error: function () {
        //        toastr.error('添加失败');
        //        $table.bootstrapTable('refresh');
        //    }
        //});
    });
});

//日期时间的过滤
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
//显示序号
function indexFormatter(value, row, index) {
    return index;
}