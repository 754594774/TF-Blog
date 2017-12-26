<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="common/common.jsp"%>
    <link href="${pageContext.request.contextPath}/css/cover.css" rel="stylesheet">
    <%--<link href="${pageContext.request.contextPath}/css/blog.css" rel="stylesheet">--%>

</head>
<body>
<div class="site-wrapper">
    <div class="site-wrapper-inner">
        <div class="cover-container">
            <div id="page-header">
                <blog-header></blog-header>
            </div>

            <div class="inner cover">
                <div class="row">
                    <div class="col-sm-8 blog-main">

                    </div>
                    <div class="col-sm-3 col-sm-offset-1 blog-sidebar">

                    </div>
                </div>
            </div>
            <div id="page-footer">
                <blog-footer></blog-footer>
            </div>
        </div>
    </div>
</div>
</body>
</html>
