/**
 * 联系我
 * Created by Administrator on 2018-03-09.
 */
// 初始化验证
$('#letterForm').validator({
    timely:3,
    theme:'yellow_top',
    fields: {
        'uname': '姓名:required',
        'contactWay': '联系方式:required',
        'content':'内容:required'
    },
    valid: function(form){
        var uname = $("#uname").val();
        var contactWay = $("#contactWay").val();
        var content =$("#content").val();

        var me = this;
        // Before submitting the form, hold form, to prevent duplicate submission.
        me.holdSubmit();
        $.ajax({
            url: "addLetter",
            data: {
                userName:uname,
                contactWay:contactWay,
                content:content
            },
            type: "POST",
            success: function(response){
                // After the form is submitted successfully, release hold.
                if(response.errNo == 0){
                    swal("成功!", response.errMsg, "success")
                    $("#uname").val("");
                    $("#contactWay").val("");
                    $("#content").val("");
                }else {
                    swal("失败!", response.errMsg, "error")
                }
                me.holdSubmit(false);//防止重复提交
            },
            error: function () {
                swal("发送失败", "系统内部错误！", "error");
                me.holdSubmit(false);
            }
        });
    }
});
