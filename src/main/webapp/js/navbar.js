//1.显示置顶的文章，每页显示10条（按照文章修改日期排序）
//2.无置顶文章，或置顶不足一页，按照文章修改日期排序显示

//1. 定义（路由）组件。
const listGroup = Vue.extend({
    template: "<div class=\"list-group\">\n" +
    "    <a href=\"#\" class=\"list-group-item\">\n" +
    "        <h4 class=\"list-group-item-heading\">\n" +
    "            {{ $route.params.id  }}\n" +
    "        </h4>\n" +
    "        <span class=\"text-muted\">{{ message }}.</span>\n" +
    "    </a>\n" +
    "</div>",
    data: function () {
        return {
            title: '通知消息',
            message: 'Hello, vue router!'
        }
    }
})
const Bar = {
    template: '<div>{{$route.params.id}}</div>'
}

// 2. 定义路由
const routes = [
    { path: '/category/:id', component: listGroup },
    { path: '/category/:id', component: Bar }
]

// 3. 创建 router 实例，然后传 `routes` 配置
const router = new VueRouter({
    routes: routes // （缩写）相当于 routes: routes
})

// 4. 创建和挂载根实例。
const app = new Vue({
    router: router
}).$mount('#app')
