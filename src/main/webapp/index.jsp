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
    <script src="${pageContext.request.contextPath}/js/index.js"></script>
</head>

<body>
    <div class="container">
        <div id="page-header">
            <blog-header></blog-header>
        </div>

        <div class="row">
            <div class="col-sm-8">
                <div class="list-group">
                    <a href="#" class="list-group-item">
                        <h4 class="list-group-item-heading">
                            免费域名注册
                        </h4>
                        <span class="text-muted">It'll blow your mind.</span>
                    </a>
                </div>
            </div>
            <div class="col-sm-3 col-sm-offset-1">
                <!--公告-->
                <div id="page-notice">
                    <blog-notice></blog-notice>
                </div>
                <div id="page-panel">
                    <blog-panel v-for="item in sites" v-bind:todo="item"></blog-panel>
                </div>
            </div>
        </div>

        <ul class="pager">
            <li><a href="#">Previous</a></li>
            <li><a href="#">Next</a></li>
        </ul>
        <div id="page-footer">
            <blog-footer></blog-footer>
        </div>
    </div>
</body>
</html>
