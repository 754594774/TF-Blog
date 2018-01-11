<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/mm-vertical.css" rel="stylesheet">
    <%@include file="../common/common.jsp"%>
    <style>
        .col-md-2{
            padding-left: 0px;
            /*padding-right: 50px;*/
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
        <div class="col-md-2" >
            <nav class="sidebar-nav" style="background-color: #212529;height: 100%">
                <ul class="metismenu" id="menu1">
                    <li>
                        <a class="has-arrow" href="#">
                            <span class="fa fa-fw fa-github fa-lg"></span>
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
                                    <span class="fa fa-fw fa-star"></span> Star
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
                        <a class="has-arrow" href="#" aria-expanded="false">Menu 0</a>
                        <ul aria-expanded="false">
                            <li><a href="#">item 0.1</a></li>
                            <li><a href="#">item 0.2</a></li>
                            <li><a href="http://onokumus.com">onokumus</a></li>
                            <li><a href="#">item 0.4</a></li>
                        </ul>
                    </li>
                    <li id="removable">
                        <a class="has-arrow" href="#" aria-expanded="false">Menu 1</a>
                        <ul aria-expanded="false">
                            <li><a href="#">item 1.1</a></li>
                            <li><a href="#">item 1.2</a></li>
                            <li>
                                <a class="has-arrow" href="#" aria-expanded="false">Menu 1.3</a>
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
                        <a class="has-arrow" href="#" aria-expanded="false">Menu 2</a>
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
            <p>
                使得反恐军事反恐军事
                十大富豪科技手段和福克斯交电话费
            </p>
        </div>
    </div>
</div>
</body>
</html>
