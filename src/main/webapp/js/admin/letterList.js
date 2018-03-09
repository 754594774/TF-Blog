var $table = $('#table');
var $btnLook = $('#btnLook');
var $btnDel = $('#btnDel');
var $btnRefresh = $('#btnRefresh');
$(function () {
    $btnLook.click(function (e) {
        var row = $table.bootstrapTable('getSelections');
        if(row.length != 1){
            toastr.warning('请选择一行！');
            return;
        }
        var scope = $(e.target).scope();
        scope.letter = row[0];
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
                url: 'delLetter',
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
});

