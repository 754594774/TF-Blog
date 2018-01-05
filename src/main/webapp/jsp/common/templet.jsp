<!-- 引入顺序不能错：1.引入常量--2.引入模板--3.定义路由 -->
<script src="${pageContext.request.contextPath}/js/const.js"></script>
<!-- 模板在这里引入 -->
<script src="${pageContext.request.contextPath}/js/templete/categoryList.js"></script>
<script src="${pageContext.request.contextPath}/js/templete/articleDetail.js"></script>
<script src="${pageContext.request.contextPath}/js/templete/archiveDetail.js"></script>
<!-- 路由在这里定义 -->
<script src="${pageContext.request.contextPath}/js/router.js"></script>