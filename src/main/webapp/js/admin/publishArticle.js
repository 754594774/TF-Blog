//业务逻辑在admin/index.js,该文件可以删除
// 初始化验证
$('#catgForm').validator({
    fields: {
        'articleTitle': '标题:required;length(6~16)'
    }
});

