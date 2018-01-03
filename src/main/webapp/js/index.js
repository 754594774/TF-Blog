$(document).ready(function () {
// 4. 创建和挂载根实例。
    const app = new Vue({
        router: router,
        data: {
            sites: null,
            routePath:categoryRoutePath
        },
        created: function () {
            // `this` 指向 vm 实例
            this.sites=getCategoryData();
        }
    }).$mount('#app')

//调用后台接口方法，使用同步调用，保证在页面构建完成前渲染数据
    function getCategoryData(id) {
        var resp = null;
        $.ajax({
            url : 'categoryServlet',
            type : 'POST',
            async : false,
            data : {
                action:'toCategoryList',
                id:id
            },
            success : function(data) {
                resp = $.parseJSON(data);
            },
            error : function() {
                resp = $.parseJSON(data);
            }
        });
        return resp;
    }
});
