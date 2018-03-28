// 初始化验证
$('#loginForm').validator({
    timely: 3,
    theme: 'yellow_top',
    fields: {
        'userName': '用户名:required',
        'passWord': '密码:required'
    }
});
angular.module('loginApp', ['ngRoute'])
    .controller('loginCtrl', function($scope, $http) {
        $scope.login = function() {
            $('#loginForm').isValid(function() {
                $http({
                    method: 'POST',
                    url: '/admin/index',
                    data: {
                        userName: $scope.user.userName,
                        passWord: $scope.user.passWord,
                        rememberMe: $scope.user.rememberMe
                    }
                }).then(function successCallback(response) {
                    if(response.data.errNo == 0){
                        window.location.href="/admin";
                    }else{
                        $("#message").text(response.data.errMsg);
                    }
                }, function errorCallback(response) {
                    // 请求失败执行代码
                    $("#message").text("请求异常");
                });
            });
        }
    });

//js方式

//var $btnLogin = $('#btnLogin');
//
//$btnLogin.click(function () {
//    $('#loginForm').isValid(function() {
//        //全局rootScope
//        var userName = $("#inputUser").val();
//        var passWord = $("#inputPassword").val();
//        var rememberMe = $("#rememberMe").prop('checked');
//        //发送ajax请求
//        $.ajax({
//            url: '/admin/index',
//            type: 'POST',
//            data: {
//                userName: userName,
//                passWord: passWord,
//                rememberMe: rememberMe
//            },
//            success: function (data) {
//
//                if (data.errNo == 0) {
//                    $("#btnLogin").addClass("disabled");
//                    var time = 3;
//                    var timer = setInterval(function () {
//                        var msg = "登录成功，将在" + time + "秒后跳转到主页面";
//                        $("#message").text(msg);
//                        time--;
//                        if (time==0) {
//                            clearInterval(timer);
//                            window.location.href="/admin";
//                        }
//                    }, 1000);
//                } else {
//                    $("#message").text(data.errMsg);
//                }
//            },
//            error: function (data) {
//                console.log(data);
//                $("#message").text("登录出错，请稍后再试！");
//            }
//        });
//    });
//});
//
