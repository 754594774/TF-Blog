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
    <script src="${pageContext.request.contextPath}/js/vue.js"></script>
</head>

<body>
<div id="app" class="container">
    <div class="row">
        <div class="col-sm-8">
            <!-- 路由出口 -->
            <!-- 路由匹配到的组件将渲染在这里 -->
            <router-view></router-view>
        </div>

        <div class="col-sm-3 col-sm-offset-1">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">分类</h3>
                </div>
                <ul class="list-group">
                    <a v-for="site in sites" class="list-group-item"><router-link :to="site.url">{{ site.name }}</router-link></a>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
