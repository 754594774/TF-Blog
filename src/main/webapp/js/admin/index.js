//angularJs路由
angular.module('myApp', ['ngRoute'])
    .controller('userCtrl', function($scope,$rootScope,$http,$location) {
        $http({
            method: 'GET',
            url: 'findLoginUser'
        }).then(function successCallback(response) {
            $rootScope.user = response.data;
        }, function errorCallback(response) {
            // 请求失败执行代码
            toastr.error("请求登录用户数据失败");
        });
    })
    .controller('menuCtrl', function($scope,$routeParams) {
        $scope.params = $routeParams;
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
            .when('/noticeList', {
                templateUrl: 'html/admin/noticeList.html',
                controller: 'menuCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });
    }]);
