var $table = $('#table');
var $btnAdd = $('#btnAdd');
var $btnChange = $('#btnChange');
var $btnDel = $('#btnDel');
var $btnRefresh = $('#btnRefresh');
var $btnOk = $('#btnOk');
$(function () {
    $btnAdd.click(function () {
        //全局rootScope
        var $body = angular.element(document.body);   // 1
        var $rootScope = $body.scope().$root;         // 2
        $rootScope.article = null;
        $rootScope.$apply();
    });
    $btnChange.click(function (e) {
        var row = $table.bootstrapTable('getSelections');
        if(row.length != 1){
            toastr.warning('请选择一行！');
            return false;//阻止跳转
        }
        //全局rootScope
        var $body = angular.element(document.body);   // 1
        var $rootScope = $body.scope().$root;         // 2
        $rootScope.article = row[0];
        $rootScope.$apply();
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
        $.ajax({
            url: 'delArticle',
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
    });
});

