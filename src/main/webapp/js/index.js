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
        vm.categorys = "";
        $.ajax({
            url : 'toCategoryList',
            type : 'POST',
            success : function(data) {
                vm.categorys = data;
            },
            error : function() {
                alert("error");
            }
        });
    }

    function getArchiveList(vm) {
        // `this` 指向 vm 实例
        // 需要将参数赋值为空串(就是实例化)，因为该方法是异步的，方法执行后还未回调
        vm.archives = "";
        $.ajax({
            url : 'getArchiveList',
            type : 'POST',
            //async : false,
            success : function(data) {
                vm.archives = data;
            },
            error : function() {
                alert("error");
            }
        });
    }

});
