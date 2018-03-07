var $btnLogin = $('#btnLogin');
// 初始化验证
$('#loginForm').validator({
    timely: 3,
    theme: 'yellow_top',
    fields: {
        'userName': '用户名:required',
        'passWord': '密码:required'
    }
});

$btnLogin.click(function () {
    $('#loginForm').isValid(function() {
        //全局rootScope
        var userName = $("#inputUser").val();
        var passWord = $("#inputPassword").val();
        var rememberMe = $("#rememberMe").prop('checked');
        //发送ajax请求
        $.ajax({
            url: '/admin/index',
            type: 'POST',
            data: {
                userName: userName,
                passWord: passWord,
                rememberMe: rememberMe
            },
            success: function (data) {

                if (data.errNo == 0) {
                    $("#btnLogin").addClass("disabled");
                    var time = 3;
                    var timer = setInterval(function () {
                        var msg = "登录成功，将在" + time + "秒后跳转到主页面";
                        $("#message").text(msg);
                        time--;
                        if (time==0) {
                            clearInterval(timer);
                            window.location.href="/admin";
                        }
                    }, 1000);
                    //window.location.href="输入另一个页面的链接";
                    //$("#message").text(data.errMsg);
                } else {
                    $("#message").text(data.errMsg);
                }
            },
            error: function (data) {
                console.log(data);
                $("#message").text("登录出错，请联系管理员！");
            }
        });
    });
});

