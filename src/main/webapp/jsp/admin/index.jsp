<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/mm-vertical.css" rel="stylesheet">
    <%@include file="../common/common.jsp" %>
    <script src="${pageContext.request.contextPath}/js/admin/index.js"></script>
    <style>
        .col-md-2 {
            padding: 0 0px;
        }

        .col-md-10 {
            padding: 0 0px;;
        }
    </style>
    <script>
        $(function () {
            $('#menu1').metisMenu();
        });
    </script>
</head>
<body>
<div id="app" class="container-fluid">
    <div class="row">
        <div class="col-md-2">
            <nav class="sidebar-nav" style="background-color: #212529;height: 100%">
                <ul class="metismenu" id="menu1">
                    <li>
                        <a class="has-arrow" href="#">
                            <span class="fa fa-fw fa-edit fa-2x"></span>
                            文章管理
                        </a>
                        <ul aria-expanded="true">
                            <li>
                                <router-link to="/foo">
                                    <span class="fa fa-circle-o fa-fw"></span>
                                    文章分类
                                </router-link>
                            </li>
                            <li>
                                <router-link to="/bar">
                                    <span class="fa fa-circle-o fa-fw"></span>
                                    发布文章
                                </router-link>
                            </li>
                            <li>
                                <a href="#"><span class="fa fa-circle-o fa-fw"></span>
                                    文章列表
                                </a>
                            </li>
                            <li>
                                <a href="#"><span class="fa fa-circle-o fa-fw"></span>
                                    文章留言
                                </a>
                            </li>
                            <li>
                                <a href="#"><span class="fa fa-circle-o fa-fw"></span>
                                    文章归档
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a class="has-arrow" href="#" aria-expanded="false">
                            <span class="fa fa-fw fa-code-fork fa-2x"></span>
                            友链分类
                        </a>
                        <ul aria-expanded="false">
                            <li>
                                <a href="#"><span class="fa fa-circle-o fa-fw"></span>
                                    友链列表
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a class="has-arrow" href="#" aria-expanded="false">
                            <span class="fa fa-fw fa-user fa-2x"></span>
                            用户管理
                        </a>
                        <ul aria-expanded="false">
                            <li>
                                <a href="#"><span class="fa fa-circle-o fa-fw"></span>
                                    用户列表
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a class="has-arrow" href="#" aria-expanded="false">
                            <span class="fa fa-fw fa-cog fa-2x"></span>
                            系统管理
                        </a>
                        <ul aria-expanded="false">
                            <li>
                                <a href="#"><span class="fa fa-circle-o fa-fw"></span>
                                    邮件列表
                                </a></li>
                            <li>
                                <a href="#"><span class="fa fa-circle-o fa-fw"></span>
                                    公告管理
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="col-md-10">
            <nav class="navbar navbar-default" role="navigation">
                <div class="container-fluid">
                    <ul class="nav navbar-nav navbar-left">
                        <li>
                            <a href="#">
                                <span class="fa fa-bars fa-2x"></span>
                            </a>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#">
                                <span class="fa fa-envelope-o"></span>
                                <span class="badge">3</span>
                            </a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <span class="fa fa-user"></span>
                                Admin
                                <span class="fa fa-angle-down"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">设置</a></li>
                                <li><a href="#">登出</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
            <div class="container">
                <router-view></router-view>
            </div>
        </div>
    </div>
</div>
</body>
</html>
