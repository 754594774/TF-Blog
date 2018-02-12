angular.module('myApp', ['ngRoute'])
    .controller('noticeCtrl', function ($scope,$http) {
        $http({
            method: 'GET',
            url: 'toNoticeDetail'
        }).then(function successCallback(response) {
            $scope.notice = response.data;

        }, function errorCallback(response) {
            // 请求失败执行代码
        });
    })
    .controller('catgsCtrl', function ($scope,$http) {
        $http({
            method: 'GET',
            url: 'toCategoryList'
        }).then(function successCallback(response) {
            $scope.catgs = response.data;

        }, function errorCallback(response) {
            // 请求失败执行代码
        });
    })
    .controller('archsCtrl', function ($scope,$http) {
        $http({
            method: 'GET',
            url: 'getArchiveList'
        }).then(function successCallback(response) {
            $scope.archs = response.data;

        }, function errorCallback(response) {
            // 请求失败执行代码
        });
    })
    .controller('linksCtrl', function ($scope,$http) {
        $http({
            method: 'GET',
            url: 'toLinkList'
        }).then(function successCallback(response) {
            $scope.links = response.data;

        }, function errorCallback(response) {
            // 请求失败执行代码
        });
    })
    .controller('articlesCtrl', function ($scope, $routeParams,$http) {
        $http({
            method: 'POST',
            url: 'toArticleList',
            data: {
                categoryId: $routeParams.id,
                date:$routeParams.date
            }
        }).then(function successCallback(response) {

            $scope.articles = response.data;
        }, function errorCallback(response) {
            // 请求失败执行代码
        });
    })
    .controller('articleDetailCtrl', function ($scope, $routeParams,$http) {
        $http({
            method: 'POST',
            url: 'toArticleDetail',
            data: {
                id: $routeParams.id
            }
        }).then(function successCallback(response) {
            $scope.article = response.data;
        }, function errorCallback(response) {
            // 请求失败执行代码
        });
    })//可选参数 /:date? ///article?type&id
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'html/welcome.html'
            })
            .when('/articleList/:id?/:date?', {
                templateUrl: 'html/articleList.html',
                controller: 'articlesCtrl'
            })
            .when('/articleDetail/:id', {
                templateUrl: 'html/articleDetail.html',
                controller: 'articleDetailCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });
    }]);
