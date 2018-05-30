/**
 * 自定义angular指令
 * Created by Administrator on 2018-03-09.
 */
angular.module('frontApp')
    .directive("backTopDirective", function() {
        return {
            templateUrl: 'html/backTop.html'
        };
    });
