//angularJs路由
angular.module('myApp', ['ngRoute'])
    .controller('menuCtrl', function($scope,$routeParams) {
        $scope.params = $routeParams;
    })
    .config(['$routeProvider', function($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'html/admin/welcome.html'
            })
            .when('/catgList', {
                templateUrl: 'html/admin/catgList.html',
                controller: 'menuCtrl'
            })
            .when('/articleList', {
                templateUrl: 'html/admin/articleList.html',
                controller: 'menuCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });
    }])

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