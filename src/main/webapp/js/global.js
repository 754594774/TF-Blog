function active(li){
    $(li).attr('class', 'active');
    $(li).siblings().attr('class','');
}

$(document).ready(function () {
    Vue.component('blog-header', {
        template: '<div class="masthead clearfix">' +
        '<div class="inner">' +
        '<h3 class="masthead-brand">Cover</h3>' +
        '<nav>' +
        '<ul class="nav masthead-nav">' +
        '<li onclick="active(this)"><a href="#">Home</a></li>' +
        '<li onclick="active(this)"><a href="#">Features</a></li>' +
        '<li onclick="active(this)"><a href="#">Contact</a></li>' +
        '</ul>' +
        '</nav>' +
        '</div>' +
        '</div>'
    })

    Vue.component('blog-footer', {
        template: '<div class="mastfoot">' +
        '<div class="inner">' +
        '<p>Design by @lnn. <a href="http://www.miitbeian.gov.cn/">皖ICP备17026796号</a>.</p>' +
        '</div>' +
        '</div>'
    })

    // 创建根实例
    new Vue({
        el: '#page-header'
    })

    // 创建根实例
    new Vue({
        el: '#page-footer'
    })
});







