var $table = $('#table');
var $btnAdd = $('#btnAdd');
var $btnChange = $('#btnChange');
var $btnDel = $('#btnDel');
var $btnRefresh = $('#btnRefresh');
var $btnOk = $('#btnOk');
$(function () {
    // 初始化验证
    $('#userForm').validator({
        timely: 3,
        theme: 'yellow_top',
        fields: {
            'userName': '用户名:required',
            'passWord': '密码:required'
        }
    });
    $btnAdd.click(function (e) {
        var scope = $(e.target).scope();
        scope.user = null;
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
        scope.user = row[0];
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
                url: 'delUser',
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
    $btnOk.click(function (e) {//点击确认按钮
        $('#linkForm').isValid(function(){
            var scope = $(e.target).scope();
            if(scope.user!=null && scope.user.id !=null){//修改
                $table.bootstrapTable('updateRow', {
                    //index:0,
                    row:scope.user
                });
            } else {
                $table.bootstrapTable('insertRow', {
                    index: 0,
                    row:scope.user
                });
            }
            $('#myModal').modal('hide');

            //发送ajax请求
            $.ajax({
                url: 'addOrUpdateUser',
                type: 'POST',
                data: {
                    id:scope.user.id,
                    userName: scope.user.userName,
                    passWord:scope.user.passWord
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
});

