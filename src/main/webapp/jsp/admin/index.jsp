<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/mm-vertical.css" rel="stylesheet">
    <%@include file="../common/common.jsp" %>
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
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
            <nav class="sidebar-nav" style="background-color: #212529;height: 100%">
                <ul class="metismenu" id="menu1">
                    <li>
                        <a class="has-arrow" href="#">
                            <span class="fa fa-fw fa-github fa-2x"></span>
                            metisMenu
                        </a>
                        <ul aria-expanded="true">
                            <li>
                                <a href="https://github.com/onokumus/metisMenu">
                                    <span class="fa fa-fw fa-code-fork"></span> Fork
                                </a>
                            </li>
                            <li>
                                <a href="https://github.com/onokumus/metisMenu">
                                    <span class="fa fa-fw fa-star fa-2x"></span> Star
                                </a>
                            </li>
                            <li>
                                <a href="https://github.com/onokumus/metisMenu/issues">
                                    <span class="fa fa-fw fa-exclamation-triangle"></span> Issues
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a class="has-arrow" href="#" aria-expanded="false">
                            <span class="fa fa-fw fa-code-fork fa-2x"></span>
                            Menu 0
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="#">item 0.1</a></li>
                            <li><a href="#">item 0.2</a></li>
                            <li><a href="http://onokumus.com">onokumus</a></li>
                            <li><a href="#">item 0.4</a></li>
                        </ul>
                    </li>
                    <li id="removable">
                        <a class="has-arrow" href="#" aria-expanded="false">
                            <span class="fa fa-fw fa-snapchat fa-2x"></span>
                             Menu 1
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="#">item 1.1</a></li>
                            <li><a href="#">item 1.2</a></li>
                            <li>
                                <a class="has-arrow" href="#" aria-expanded="false">
                                    <span class="fa fa-fw fa-exclamation-triangle"></span>Menu 1.3
                                </a>
                                <ul aria-expanded="false">
                                    <li><a href="#">item 1.3.1</a></li>
                                    <li><a href="#">item 1.3.2</a></li>
                                    <li><a href="#">item 1.3.3</a></li>
                                    <li><a href="#">item 1.3.4</a></li>
                                </ul>
                            </li>
                            <li><a href="#">item 1.4</a></li>
                            <li>
                                <a class="has-arrow" href="#" aria-expanded="false">Menu 1.5</a>
                                <ul aria-expanded="false">
                                    <li><a href="#">item 1.5.1</a></li>
                                    <li><a href="#">item 1.5.2</a></li>
                                    <li><a href="#">item 1.5.3</a></li>
                                    <li><a href="#">item 1.5.4</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a class="has-arrow" href="#" aria-expanded="false">
                            <span class="fa fa-fw fa-star fa-2x"></span> Menu 2
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="#">item 2.1</a></li>
                            <li><a href="#">item 2.2</a></li>
                            <li><a href="#">item 2.3</a></li>
                            <li><a href="#">item 2.4</a></li>
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
                                John Doe
                                <span class="fa fa-angle-down"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">setting</a></li>
                                <li><a href="#">logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
            <div class="container">

            </div>
        </div>
    </div>
</div>
</body>
</html>
