var $table = $('#table');
var $btnAdd = $('#btnAdd');
var $btnChange = $('#btnChange');
var $btnDel = $('#btnDel');
var $btnRefresh = $('#btnRefresh');
var $btnOk = $('#btnOk');
// 初始化验证
$('#noticeForm').validator({
    timely: 3,
    theme: 'yellow_top',
    fields: {
        'title': '标题:required',
        'content': '内容:required'
    },
    valid: function(form){

    }
});
$btnOk.click(function (e) {//点击确认按钮

    $('#noticeForm').isValid(function(){
        var scope = $(e.target).scope();
        if(!scope.notice.isActive){
            scope.notice.isActive = 0;//默认显示
        }
        if(scope.notice!=null && scope.notice.id !=null){//修改
            $table.bootstrapTable('updateRow', {
                //index:0,
               row:scope.catg
            });
        } else {
            $table.bootstrapTable('insertRow', {
                index: 0,
                row:scope.notice
            });
        }
        $('#myModal').modal('hide');

        //发送ajax请求
        $.ajax({
            url: 'addOrUpdateNotice',
            type: 'POST',
            data: {
                id: scope.notice.id,
                title:scope.notice.title,
                content:scope.notice.content,
                isActive:scope.notice.isActive
            },
            success: function (data) {
                if(data.errNo == 0){
                    toastr.success(data.errMsg);
                }else {
                    toastr.error(data.errMsg);
                    $table.bootstrapTable('refresh');
                }
            },
            error: function () {
                toastr.error('添加失败');
                $table.bootstrapTable('refresh');
            }
        });
    });
});
$btnAdd.click(function (e) {
    var scope = $(e.target).scope();
    scope.notice = null;
    scope.addOrChange = "添加";
    scope.$apply();//刷新数据;

});
$btnChange.click(function (e) {
    var row = $table.bootstrapTable('getSelections');
    if(row.length != 1){
        toastr.warning('请选择一行！');
        return;
    }
    var scope = $(e.target).scope();
    scope.addOrChange = "修改";
    scope.notice = row[0];
    scope.$apply();//刷新数据
    $('#myModal').modal('show');

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
        $.ajax({
            url: 'delNotice',
            type: 'POST',
            traditional:true,
            data:{ids:ids},
            success: function (data) {
                if(data.errNo == 0){
                    toastr.success(data.errMsg);
                }else {
                    toastr.error(data.errMsg);
                    $table.bootstrapTable('refresh');
                }
            },
            error: function () {
                toastr.error('删除失败');
                $table.bootstrapTable('refresh');
            }
        });
    };
});
$btnRefresh.click(function () {
    $table.bootstrapTable('refresh');
});


