// 初始化验证
$('#articleForm').validator({
    timely:3,
    theme:'yellow_top',
    fields: {
        'articleTitle': '标题:required',
        'articleAuthor':'作者:required',
        'selectedCatg':'分类:required',
        'articleContent':'内容:required'
    },
    valid: function(form){
        var $scope = $('div[ng-controller="pubArticleCtrl"]').scope();
        console.log($scope);
        var me = this;
        // Before submitting the form, hold form, to prevent duplicate submission.
        me.holdSubmit();
        $.ajax({
            url: "publishArticle",
            data: {
                id: $scope.article.id,
                categoryId:$scope.selectedCatg.id,
                title:$scope.article.title,
                author:$scope.article.author,
                content:$scope.article.content
            },
            type: "POST",
            success: function(response){
                // After the form is submitted successfully, release hold.
                toastr.success(response.errMsg);
                $scope.article = null;
                $scope.$apply();//刷新数据

                //全局rootScope
                var $body = angular.element(document.body);   // 1
                var $rootScope = $body.scope().$root;         // 2
                $rootScope.article = null;
                $rootScope.$apply();

                me.holdSubmit(false);//防止重复提交
            },
            error: function () {
                toastr.error('添加失败');
                me.holdSubmit(false);
            }
        });
    }
});

