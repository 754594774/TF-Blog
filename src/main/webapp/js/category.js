const listGroup = Vue.extend({
    template: "<div id='list' class=\"list-group\">\n" +
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
    },
    created:function () {
        // 组件创建完后获取数据，
        // 此时 data 已经被 observed 了
        this.fetchData()
    },
    watch: {
        // 如果路由有变化，会再次执行该方法
        '$route': 'fetchData'
    },
    methods: {
        fetchData:function(){
            alert(this.$route.params.id);

        }
    }
})

const Bar = {
    template: '<div>{{$route.params.id}}</div>'
}
//Vue.component('mycontent', {
//    props: ['content'],
//
//    render: function(h) {
//        this.coms = [];
//        for(var i = 0; i < this.content.length; i++) {
//            this.coms.push(h(this.content[i], {}))
//        }
//        return h('div', {},
//            this.coms)
//    },
//});
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
