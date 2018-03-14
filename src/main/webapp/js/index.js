angular.module('frontApp', ['ngRoute','tm.pagination'])
    .controller('searchCtrl', function ($scope,$http,$location) {//搜索
        $scope.search = function() {
            var searchContent = $scope.searchContent;
            $location.url('/articleList///' + searchContent);
        }
    })
    .controller('noticeCtrl', function ($scope,$http) {
        $http({
            method: 'GET',
            url: 'toNoticeDetail'
        }).then(function successCallback(response) {
            //x上限，y下限
            var x = response.data.length-1;
            var y = 0;
            var rand = parseInt(Math.random() * (x - y + 1) + y);
            $scope.notice = response.data[rand];
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
        $scope.paginationConf = {
            currentPage: 1,
            totalItems: 0,
            itemsPerPage: 10,
            pagesLength: 10,
            perPageOptions: [5,10, 20, 30, 40, 50],
            onChange: function(){

                var categoryId =  $routeParams.id;
                var date = $routeParams.date;
                var searchContent = $routeParams.searchContent;

                if(!categoryId && !date && searchContent){
                    $http({
                        method: 'POST',
                        url: 'searchArticleList',
                        data: {
                            searchContent: searchContent,
                            pageNum:$scope.paginationConf.currentPage,
                            pageSize:$scope.paginationConf.itemsPerPage
                        }
                    }).then(function successCallback(response) {
                        $scope.articles = response.data.list;
                        $scope.paginationConf.totalItems = response.data.total;

                    }, function errorCallback(response) {
                        // 请求失败执行代码
                        $scope.articles =null;
                    });
                }else if(!categoryId || !date){
                    $http({
                        method: 'POST',
                        url: 'toArticleList',
                        data: {
                            categoryId: $routeParams.id,
                            date:$routeParams.date,
                            pageNum:$scope.paginationConf.currentPage,
                            pageSize:$scope.paginationConf.itemsPerPage
                        }
                    }).then(function successCallback(response) {
                        $scope.articles = response.data.list;
                        $scope.paginationConf.totalItems = response.data.total;
                    }, function errorCallback(response) {
                        // 请求失败执行代码
                        $scope.articles =null;
                    });
                }else{
                    $scope.articles = null;
                    $scope.paginationConf.totalItems = 0;
                }
            }
        };
    })
    .controller('articleDetailCtrl', function ($scope, $routeParams,$http) {
        //文章详细
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

        //评论列表
        $http({
            method: 'GET',
            url: 'toCommentList',
            params:{articleId:$routeParams.id}
        }).then(function successCallback(response) {

            loadCommentList(response.data);
        }, function errorCallback(response) {
            // 请求失败执行代码
        });

    })//可选参数 /:date? ///article?type&id
    .filter('to_trusted', ['$sce', function($sce){
        return function(text) {
            return $sce.trustAsHtml(text);
        };
    }])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'html/welcome.html'
            })
            .when('/articleList/:id?/:date?/:searchContent?', {
                templateUrl: 'html/articleList.html',
                controller: 'articlesCtrl'
            })
            .when('/articleDetail/:id', {
                templateUrl: 'html/articleDetail.html',
                controller: 'articleDetailCtrl'
            })
            .when('/contactMe', {
                templateUrl: 'html/contactMe.html'
            })
            .otherwise({
                redirectTo: '/'
            });
    }]);
