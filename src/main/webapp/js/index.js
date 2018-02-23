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


function loadCommentList(data){

    console.log(data);
    var innerHtml =
        "<li class=\"list0\"> <a class=\"close\" href=\"javascript:;\">X</a>\n" +
        "  <div class=\"head\"><img src=\"../resources/images/foot.png\" alt=\"\"></div>\n" +
        "  <div class=\"content\">\n" +
        "    <p class=\"text\"><span class=\"name\">Andy：</span>哈哈哈哈哈谁</p>\n" +
        "    <div class=\"good\"><span class=\"date\">02-14 23:01</span><a class=\"dzan\" href=\"javascript:;\">赞</a></div>\n" +
        "    <div class=\"people\" total=\"0\" style=\"display: none;\"></div>\n" +
        "    <div class=\"comment-list\">\n" +
        "      <div class=\"comment\" user=\"self\">\n" +
        "        <div class=\"comment-left\"><img src=\"../resources/images/foot.png\" alt=\"\"></div>\n" +
        "        <div class=\"comment-right\">\n" +
        "          <div class=\"comment-text\"><span class=\"user\">我：</span>看哭了留卡号吧</div>\n" +
        "          <div class=\"comment-date\">02-14 24:00 <a class=\"comment-zan\" href=\"javascript:;\" total=\"286\" my=\"1\">286 取消赞</a> <a class=\"comment-dele\" href=\"javascript:;\">删除</a> </div>\n" +
        "        </div>\n" +
        "      </div>\n" +
        "    </div>\n" +
        "    <div class=\"hf\">\n" +
        "      <textarea type=\"text\" class=\"hf-text\" autocomplete=\"off\" maxlength=\"100\">评论…</textarea>\n" +
        "      <button class=\"hf-btn\">回复</button>\n" +
        "      <span class=\"hf-nub\">0/100</span> </div>\n" +
        "  </div>\n" +
        "</li>";
    $("#pn").append(innerHtml);
}