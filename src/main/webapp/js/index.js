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
            this.sites = null;
            var resp = null;
            $.ajax({
                url : 'categoryServlet',
                type : 'POST',
                async : false,
                data : {
                    action:'toCategoryList'
                },
                success : function(data) {
                    resp = $.parseJSON(data);
                },
                error : function() {
                    resp = $.parseJSON(data);
                }
            });
            this.sites = resp;
        }
    }).$mount('#app')
});
//[Archive{date='20180102', count='3'}, Archive{date='20180103', count='9'}, Archive{date='20180104', count='1'}]