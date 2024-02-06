import Vue from 'vue'
import VueRouter from "vue-router"

import Home from "../views/Home"
import User from "../views/User"
import Main from "../views/Main"
import Mall from "../views/Mall"
import PageOne from "../views/PageOne"
import PageTwo from "../views/PageTwo"
import Login from "../views/Login"

Vue.use(VueRouter);
//1 创建路由界面
//2 将路由与组件进行映射
//3 创建router实例
const routes=[
    //主路由
    {
        path:'/',
        component: Main,
        redirect: '/user',//重定向
        children:[
            //子路由
            {path:'user',name:'user',component:User,meta: {keepAlive: true, key: 'user'}},
            {path:'home',name:'home', component:Home},
            {path:'mall',name:'mall',component:Mall},
            {path:'page1',name:'page1',component:PageOne},
        ]
    },
    {
        path:'/login',
        name:'login',
        component: Login,
    },
    {
        path:'/p2',
        name:'p2',
        component: PageTwo,
    }
]
const router=new VueRouter({
    routes//缩写，相当于routes:routes
})
export default router



