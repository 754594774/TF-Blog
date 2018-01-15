$(document).ready(function () {
// 4. 创建和挂载根实例。
    const app = new Vue({
        el: '#app',
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
            url : 'toCategoryList',
            type : 'POST',
            async : false,
            data : {
                //action:'getCategoryList'
            },
            success : function(data) {
                resp = data;
            },
            error : function() {
                resp = data;
            }
        });
        vm.categorys = resp;
    }

    function getArchiveList(vm) {
        // `this` 指向 vm 实例
        vm.archives = null;
        var resp = null;
        $.ajax({
            url : 'getArchiveList',
            type : 'POST',
            async : false,
            success : function(data) {
                resp = data;
            },
            error : function() {
                resp = data;
            }
        });
        vm.archives = resp;
    }

});
