$(document).ready(function () {
// 4. 创建和挂载根实例。
    const app = new Vue({
        router: router,
        data: {
            categorys: null,
            archives:  null,
            categoryRoutePath:categoryRoutePath,
            archivesRoutePath:archiveRoutePath
        },
        created: function () {
            getCategoryList(this);
            getArchiveList(this);
        }
    }).$mount('#app')

    function getCategoryList(vm) {
        // `this` 指向 vm 实例
        vm.categorys = null;
        var resp = null;
        $.ajax({
            url : 'categoryServlet',
            type : 'POST',
            async : false,
            data : {
                action:'getCategoryList'
            },
            success : function(data) {
                resp = $.parseJSON(data);
            },
            error : function() {
                resp = $.parseJSON(data);
            }
        });
        vm.categorys = resp;
    }

    function getArchiveList(vm) {
        // `this` 指向 vm 实例
        vm.archives = null;
        var resp = null;
        $.ajax({
            url : 'articleServlet',
            type : 'POST',
            async : false,
            data : {
                action:'getArchiveList'
            },
            success : function(data) {
                resp = $.parseJSON(data);
            },
            error : function() {
                resp = $.parseJSON(data);
            }
        });
        vm.archives = resp;
    }
});
