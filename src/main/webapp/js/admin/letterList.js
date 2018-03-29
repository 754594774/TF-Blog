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
        scope.letter.viewStatus = 1;
        scope.$apply();//刷新数据

        var ids = $.map(row, function (row) {
            return row.id;
        });
        $('#myModal').modal('show');
        //更新信件状态
        $.ajax({
            url: '/changeViewStatus',
            type: 'POST',
            traditional:true,
            data:{ids:ids},
            success: function (data) {
                if(data.errNo == 0){
                    var $scope = $('div[ng-controller="headerCtrl"]').scope();
                    if($scope.unReadCount >0){
                        $scope.unReadCount -= 1;
                    }
                    $scope.$apply();//刷新数据
                    $table.bootstrapTable('updateRow', {
                        //index:0,
                        row:scope.letter
                    });
                }else {
                    toastr.error(data.errMsg);
                }
            },
            error: function () {
                toastr.error('更新信件状态失败');
            }
        });
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

