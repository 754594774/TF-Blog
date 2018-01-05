<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <link rel="icon" href="plugins/bootstrap-3.3.7/favicon.ico">
    <title>BootStrap</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <%@include file="jsp/common/common.jsp"%>
    <%@include file="jsp/common/templet.jsp"%>
    <script src="${pageContext.request.contextPath}/js/index.js"></script>
</head>

<body>
    <div id="app" class="container">
        <nav class="navbar navbar-inverse" role="navigation">
            <div class="container-fluid">
                <div>
                    <ul class="nav navbar-nav navbar-left">
                        <li class="active"><a href="#">首页</a></li>
                        <li><a href="#">联系我</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                传送门
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">文章</a></li>
                                <li><a href="#">友链</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
                    </ul>
                    <form class="navbar-form navbar-right">
                        <input type="text" class="form-control" placeholder="Search...">
                    </form>
                </div>
            </div>
        </nav>

        <div class="row">
            <div class="col-sm-8">
                <!-- 路由出口 -->
                <!-- 路由匹配到的组件将渲染在这里 -->
                <router-view></router-view>
            </div>

            <div class="col-sm-3 col-sm-offset-1">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">公告</h3>
                    </div>
                    <div class="panel-body">
                        这是一个基本的面板
                    </div>
                </div>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">分类</h3>
                    </div>
                    <ul class="list-group">
                        <!-- 使用 router-link 组件来导航. -->
                        <!-- 通过传入 `to` 属性指定链接. -->
                        <!-- <router-link> 默认会被渲染成一个 `<a>` 标签 -->
                        <a v-for="category in categorys" class="list-group-item">
                            <h4 class="list-group-item-heading"><router-link :to="categoryRoutePath + category.id">{{ category.name }}</router-link></h4>
                        </a>
                    </ul>
                </div>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">归档</h3>
                    </div>
                    <ul class="list-group">
                        <a v-for="archive in archives" class="list-group-item">
                            <h4 class="list-group-item-heading"><router-link :to="archivesRoutePath + archive.date">{{ archive.date| archiveDateFilter}} </router-link>({{archive.count}})</h4>
                        </a>
                        <%--<li class="list-group-item"><a href="#">2017年12月</a></li>--%>
                    </ul>
                </div>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">友链</h3>
                    </div>
                    <ul class="list-group">
                        <li class="list-group-item"><a href="#">Hamster-blog</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <ul class="pager">
            <li><a href="#">Previous</a></li>
            <li><a href="#">Next</a></li>
        </ul>

        <footer>
            <p class="pull-right"><a href="#">Back to top</a></p>
            <p>&copy; 2016 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
        </footer>

    </div>
</body>
</html>
