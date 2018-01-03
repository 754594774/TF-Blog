// 2. 定义路由
const routes = [
    { path: categoryRoutePath + ':id', component: categoryList },
    { path: articleRoutePath + ':id', component: articleDetail }
]

// 3. 创建 router 实例，然后传 `routes` 配置
const router = new VueRouter({
    routes: routes // （缩写）相当于 routes: routes
})
