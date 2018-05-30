//angularJs路由
angular.module('backApp', ['ngRoute'])
    .controller('userCtrl', function() {
    })
    .controller('menuCtrl', function($scope,$routeParams,$location) {
        $scope.params = $routeParams;
    })
    .controller('changePwdCtrl', function($scope,$http,$rootScope) {
        // 初始化验证
        $('#changePwdForm').validator({
            timely: 3,
            theme: 'yellow_top',
            fields: {
                'oldPwd': '原密码:required',
                'newPwd': '新密码:required'
            }
        });
        //修改密码
        $scope.changePwd = function() {
            $('#changePwdForm').isValid(function(){
                $http({
                    method: 'POST',
                    url: 'changePwd',
                    data: {
                        userName: $rootScope.user.userName,
                        passWord:$scope.oldPwd,
                        newPwd:$scope.newPwd
                    }
                }).then(function successCallback(response) {
                    if(response.data.errNo == 0){
                        $('#myModal').modal('hide');
                        toastr.success(response.data.errMsg);
                    }else{
                        toastr.error(response.data.errMsg);
                    }
                }, function errorCallback(response) {
                    // 请求失败执行代码
                    toastr.error("修改密码失败");
                })
            });
        };
    })
    .controller('headerCtrl', function($scope,$http) {
        $http({
            method: 'POST',
            url: 'findCountByStatus'
        }).then(function successCallback(response) {
            if(response.data.errNo == 0){
                $scope.unReadCount = response.data.obj;
            }else{
                toastr.error(response.data.errMsg);
            }
        }, function errorCallback(response) {
            // 请求失败执行代码
            toastr.error("请求未读信件异常");
        })
        //登出
        $scope.logout = function() {
            $http({
                method: 'POST',
                url: 'admin/logout'
            }).then(function successCallback(response) {
                if(response.data.errNo == 0){
                    window.location.href="/admin/login";
                }else{
                    toastr.error(response.data.errMsg);
                }
            }, function errorCallback(response) {
                // 请求失败执行代码
                toastr.error("请求登出异常");
            })
        };
    })
    .controller('pubArticleCtrl', function($scope,$http,$rootScope) {
        $http({
            method: 'GET',
            url: 'toCategoryList'
        }).then(function successCallback(response) {
            $scope.catgs = response.data;
            $scope.selectedCatg = $scope.catgs[0];//分类默认选择第一个
            if($rootScope.article != undefined){
                $scope.article = $rootScope.article;
                $.each(response.data,function(index,value){
                    if(value.id == $rootScope.article.categoryId)
                    {
                        $scope.selectedCatg = value;
                    }
                });
                $rootScope.article= null;
            }
        }, function errorCallback(response) {
            // 请求失败执行代码
            toastr.error("请求分类数据失败");
        });
    })
    .config(['$routeProvider', function($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'html/admin/welcome.html',
                controller: 'userCtrl'
            })
            .when('/catgList', {
                templateUrl: 'html/admin/catgList.html',
                controller: 'menuCtrl'
            })
            .when('/articleList', {
                templateUrl: 'html/admin/articleList.html',
                controller: 'menuCtrl'
            })
            .when('/publishArticle', {
                templateUrl: 'html/admin/publishArticle.html',
                controller: 'menuCtrl'
            })
            .when('/linkList', {
                templateUrl: 'html/admin/linkList.html',
                controller: 'menuCtrl'
            })
            .when('/userList', {
                templateUrl: 'html/admin/userList.html',
                controller: 'menuCtrl'
            })
            .when('/letterList', {
                templateUrl: 'html/admin/letterList.html',
                controller: 'menuCtrl'
            })
            .when('/noticeList', {
                templateUrl: 'html/admin/noticeList.html',
                controller: 'menuCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });
    }]);

//提示框配置
//需要在html里引用toastr的插件
$(function () {
    //弹出提示框
    toastr.options = {
        closeButton: false,//是否显示关闭按钮（提示框右上角关闭按钮）
        debug: false,//是否为调试
        progressBar: true,//是否显示进度条（设置关闭的超时时间进度条）
        positionClass: "toast-top-right",//消息框在页面显示的位置
        onclick: null,//点击消息框自定义事件
        showDuration: "300",//显示动作时间
        hideDuration: "1000",//隐藏动作时间
        timeOut: "5000",//自动关闭超时时间
        extendedTimeOut: "1000",
        showEasing: "swing",
        hideEasing: "linear",
        showMethod: "fadeIn",//显示的方式，和jquery相同
        hideMethod: "fadeOut"//隐藏的方式，和jquery相同
    };
});