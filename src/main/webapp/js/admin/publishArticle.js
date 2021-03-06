var $publishArticle = $('#publishArticle');
var $saveDraft = $('#saveDraft');
var isDraft = 0;//不是草稿
$(function () {
    $publishArticle.click(function (e) {//点击确认按钮
        isDraft = 0;
    });
    $saveDraft.click(function (e) {//点击确认按钮
        isDraft = 1;
    });
});
// Replace the <textarea id="editor1"> with a CKEditor
// instance, using default configuration.
var editor = CKEDITOR.replace( 'articleContent' );

//初始化验证
$('#articleForm').validator({
    beforeSubmit: function(){
        editor.updateElement();
    },
    timely:0,//0：关闭实时验证，只在提交表单的时候执行验证
    theme:'yellow_top',
    fields: {
        'articleTitle': '标题:required;length(1~30)',
        'articleAuthor':'作者:required;length(1~15)',
        'articleIntro':'简介:required;length(1~50)',
        'selectedCatg':'分类:required',
        'articleContent':'内容:required'
    },
    valid: function(form){
        var $scope = $('div[ng-controller="pubArticleCtrl"]').scope();
        //判断checkbox 是否选中
        var allowComment = 0;//是否允许评论
        var isStick = 0;//是否置顶
        if($scope.myVar){
            allowComment = 1;
        }
        if($scope.myVar1){
            isStick = 1;
        }
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
                intro:$scope.article.intro,
                allowComment:allowComment,
                isStick:isStick,
                isDraft:isDraft,
                content:editor.getData()
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
                editor.setData('');

                me.holdSubmit(false);//防止重复提交
            },
            error: function () {
                toastr.error('添加失败');
                me.holdSubmit(false);
            }
        });
    }
});

