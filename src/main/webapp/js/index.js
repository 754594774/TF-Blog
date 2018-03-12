angular.module('myApp', ['ngRoute'])
    .controller('searchCtrl', function ($scope,$http,$location) {//搜索
        $scope.toggle = function() {
            var searchContent = $scope.searchContent;
            if(searchContent != '' && searchContent!=null && searchContent!=undefined) {
                $location.url('/articleList///' + searchContent);
            }
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
        var categoryId =  $routeParams.id;
        var date = $routeParams.date;
        var searchContent = $routeParams.searchContent;

        if((categoryId=='' || categoryId==null || categoryId==undefined) && (date=='' || date==null || date==undefined)){
            $http({
                method: 'POST',
                url: 'searchArticleList',
                data: {
                    searchContent: searchContent
                }
            }).then(function successCallback(response) {
                $scope.articles = response.data;
            }, function errorCallback(response) {
                // 请求失败执行代码
            });
        }else{
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
        }
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

//创建一个函数，用于返回一个无参数函数
function _loopNotice(date){
    return function(){
        loopNotice(date);
    }
}
function loopNotice(date){

    console.log(date);
}

function loadCommentList(data){

    $("#pn").empty();
    var innerHtml = '';
    for(var i=0;i<data.length;i++){
        str = '';
        //评论实体
        var comment = data[i];
        //非叶子节点 查看回复
        if(comment.isleaf == 0){
            tree(comment.childCommentList,comment.memberName);
        }
        innerHtml +=
            "<li class=\"list0\"> <a class=\"close\" href=\"javascript:;\">X</a>\n" +
            "  <div class=\"head\"><img src=\"../resources/images/foot.png\" alt=\"\"></div>\n" +
            "  <div class=\"content\">\n" +
            "    <p class=\"text\"><span class=\"name\" rootId=" + comment.id + ">" + comment.memberName + "：</span>" + comment.content + "</p>\n" +
            "    <div class=\"good\"><span class=\"date\">" + formatDateTime(comment.pdate) + "</span><a class=\"dzan\" href=\"javascript:;\">赞</a></div>\n" +
            "    <div class=\"people\" total=\"0\" style=\"display: none;\"></div>\n" +
            "    <div class=\"comment-list\">\n" +
            str +
            "    </div>" +
            "    <div class=\"hf\">\n" +
            "      <textarea type=\"text\" class=\"hf-text\" autocomplete=\"off\" maxlength=\"100\">评论…</textarea>\n" +
            "      <button class=\"hf-btn\">回复</button>\n" +
            "      <span class=\"hf-nub\">0/100</span> </div>\n" +
            "  </div>\n" +
            "</li>";
    }

    $("#pn").append(innerHtml);
    initCommentEvent();
}

var str = '';
function tree(comments,toUser){
    for(var i=0;i<comments.length;i++){
        var comment = comments[i];
        var replayUser = '';
        if(toUser != null || toUser != undefined){
            replayUser +=  " 回复 " + toUser + "：";
        }
        str +=
            "      <div class=\"comment\" user=\"self\">\n" +
            "        <div class=\"comment-left\"><img src=\"../resources/images/foot.png\" alt=\"\"></div>\n" +
            "        <div class=\"comment-right\">\n" +
            "          <div class=\"comment-text\"><span class=\"user\" pid=" + comment.id + ">" +comment.memberName  + "：</span>" + replayUser + comment.content + "</div>\n" +
            "          <div class=\"comment-date\">" + formatDateTime(comment.pdate) + " <a class=\"comment-zan\" href=\"javascript:;\" total=\"286\" my=\"1\">286 取消赞</a> <a class=\"comment-dele\" href=\"javascript:;\">回复</a> </div>\n" +
            "        </div>\n" +
            "      </div>\n";
        if(comment.isleaf == 0) {
            tree(comment.childCommentList,comment.memberName)
        }
    }
};

function initCommentEvent() {
    var pn = document.getElementById("pn");
    var lists = pn.children;
    var pid =0;
    var rootId =0;
    //删除当前节点
    function remove(node) {
        node.parentNode.removeChild(node);
    }
    //上面的点赞
    function praisebox(box, el) {
        //获取赞数量容器
        var praise = box.getElementsByClassName("people")[0];
        //获取容器当前total值
        var total = parseInt(praise.getAttribute("total"));
        //获取点击的innerHTML
        var txt = el.innerHTML;
        //创建一个新的total存储用
        var newtotal;
        //判断点击的文字内容
        if (txt == "赞") {
            //total值+1 因为我还没点击赞，所以要点击的时候就多了一个人 total+1
            newtotal = total + 1;
            //判断赞数量 把相应文字放到赞容器里
            praise.innerHTML = newtotal == 1 ? "我觉得很赞" : "我和" + total + "个人觉得很赞";
            el.innerHTML = "取消赞";
        } else {
            //反之total值-1
            newtotal = total - 1;
            praise.innerHTML = newtotal == 0 ? "" : newtotal + "个人觉得很赞";
            el.innerHTML = "赞";
        }
        //更新total值
        praise.setAttribute("total", newtotal);
        //如果没有人点赞容器隐藏
        praise.style.display = (newtotal == 0) ? "none" : "block";
    }
    //回复评论
    function reply(box) {
        var replyId = 0;
        //获取评论框
        var textarea = box.getElementsByTagName("textarea")[0];
        //获取包含所有评论的容器
        var comment = box.getElementsByClassName("comment-list")[0];
        var content = textarea.value.split("：");
        var commentStr = "";
        if(content.length == 2){
            commentStr = content[1];
            replyId = pid;
        }else {
            commentStr = content[0];
            replyId = rootId;
        }

        ////发送ajax请求
        $.ajax({
            url: 'addComment',
            type: 'POST',
            data: {
                pid: replyId,
                content:commentStr,
                memberName:'游客',
                articleId:$("#articleId").val()
            },
            success: function (data) {
                if(data.errNo == 0){
                    swal("成功!", "添加评论成功:)!", "success")
                }else {
                    swal("失败!", data.errMsg, "error")
                }
            },
            error: function () {
                swal("评论失败", "添加评论时出错了！", "error");
            }
        });
        //初始化pid
        pid = 0;
        rootId = 0;

        //创建新的评论div
        var div = document.createElement("div");
        //赋类名
        div.className = "comment";
        //设置属性
        div.setAttribute("user", "self");
        //获取每条评论的innerHTML结构，每次只替换textarea的输入内容和 当前发送时间
        var html = '<div class="comment-left">' + '<img src="../resources/images/foot.png" alt=""/>' + '</div>' +
            '<div class="comment-right">' +
            '<div class="comment-text"><span>我：</span>' + textarea.value + '</div>' +
            '<div class="comment-date">' +
            getTime() +
            '<a class="comment-zan" href="javascript:;" total="0" my="0">赞</a>' +
            '<a class="comment-dele" href="javascript:;">删除</a>' +
            '</div>' +
            '</div>';
        //插入到新建的评论div
        div.innerHTML = html;
        //把新评论插入到评论列表
        comment.appendChild(div);
        //评论后初始化textarea输入框
        textarea.value = "评论…";
        textarea.parentNode.className = "hf";
    }
    //获取当前时间回复评论时调用
    function getTime() {
        var t = new Date();
        var y = t.getFullYear();
        var m = t.getMonth() + 1;
        var d = t.getDate();
        var h = t.getHours();
        var mi = t.getMinutes();
        m = m < 10 ? "0" + m : m;
        d = d < 10 ? "0" + d : d;
        h = h < 10 ? "0" + h : h;
        mi = mi < 10 ? "0" + mi : mi;
        return y + "-" + m + "-" + d + "" + h + ":" + mi;
    }
    //回复里点赞
    function praiseReply(el) {
        //获取当前total值 也就是所有点赞数量
        var total = parseInt(el.getAttribute("total"));
        //获取当前my值 我的点赞
        var my = parseInt(el.getAttribute("my"));
        //创建新的total
        var newtotal;
        //判断my=0就是我准备要点赞
        if (my == 0) {
            //我点了赞总数量就要+1
            newtotal = total + 1;
            //更新total值
            el.setAttribute("total", newtotal);
            //更新my值
            el.setAttribute("my", 1);
            //更新文字 就是我点了后 文字就是取消赞了
            el.innerHTML = newtotal + " 取消赞";
        } else {
            //反之-1
            newtotal = total - 1;
            el.setAttribute("total", newtotal);
            el.setAttribute("my", 0);
            el.innerHTML = (newtotal == 0) ? " 赞" : newtotal + " 赞";
        }
    }
    //操作回复
    function operateReply(el) {
        //每条评论
        var comment = el.parentNode.parentNode.parentNode;
        //整个状态
        var box = comment.parentNode.parentNode.parentNode;
        //评论框
        var textarea = box.getElementsByTagName("textarea")[0];
        //名字
        var user = comment.getElementsByClassName("user")[0];
        //点击的innerHTML
        var txt = el.innerHTML;
        //判断当前点击的是否为回复
        if (txt == "回复") {
            //评论框触发焦点事件 也就是变高
            textarea.onfocus();
            //内容变为回复+当前人的名字
            textarea.value = "回复 " + user.innerHTML;
            //调用键盘事件
            textarea.onkeyup();
        } else {
            //否则就是删除节点
            remove(comment);
        }
    }
    //遍历所有状态消息
    for (var i = 0; i < lists.length; i++) {
        //全部事件代理
        lists[i].onclick = function(e) {
            //获取当前点击事件
            var e = e || window.event;
            var el = e.srcElement;
            if (!el) {
                el = e.target; //兼容火狐
            }
            //判断点击的类名
            switch (el.className) {
                //关闭整个状态
                case "close":
                    remove(el.parentNode);
                    break;
                //上面的点赞
                case "dzan":
                    praisebox(el.parentNode.parentNode.parentNode, el);
                    break;
                //回复评论
                case "hf-btn hf-btn-on":
                    rootId = $(el).parent().siblings("p.text").children(".name").attr("rootId");
                    reply(el.parentNode.parentNode.parentNode);
                    break;
                //每条评论中点赞
                case "comment-zan":
                    praiseReply(el);
                    break;
                case "comment-dele":
                    pid =  $(el).parent().prev().children(".user").attr("pid");
                    operateReply(el);
                    break;
            }
        }
        var textarea = lists[i].getElementsByClassName("hf-text")[0];
        //焦点事件
        textarea.onfocus = function() {

            this.parentNode.className = 'hf hf-on';
            this.value = this.value == '评论…' ? '' : this.value;
        }
        //失焦事件
        textarea.onblur = function() {

            if (this.value == '') {
                this.parentNode.className = 'hf';
                this.value = '评论…';
            }
        }
        //键盘事件
        textarea.onkeyup = function() {
            var len = this.value.length;
            var textParentNode = this.parentNode;
            var textBtn = textParentNode.children[1];
            var textNub = textParentNode.children[2];
            if (len == 0 /*|| len>100*/ ) {
                textBtn.className = "hf-btn";
            } else {
                textBtn.className = "hf-btn hf-btn-on";
                /*this.style.color="#333"; */
            }
            textNub.innerHTML = len + "/100";
        }
    }
    //遍历结束
}