/**
 * 自定义angular指令
 * Created by Administrator on 2018-03-09.
 */
var app = angular.module("myApp");
app.directive("backTopDirective", function() {
    return {
        templateUrl: '../html/backTop.html'
    };
});
