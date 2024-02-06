import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import router from './router'//router引入
import store from './store'
import './api/mock'
import Cookie from "js-cookie"

Vue.config.productionTip = false
//全局引入
Vue.use(ElementUI);
//添加全局前置导航守卫router.beforeEach((to, from, next) => {
// //   // token存不存在
// //   const token=Cookie.get('token')
// //   //如果token不存在,说明当前用户未登录
// //   if (!token) {
// //     if (to.name === 'login' || to.path === '/p2') {
// //       // 如果用户访问的是登录页或/p2界面，则直接放行，允许访问
// //       next()
// //     } else {
// //       // 否则重定向到登录页
// //       next({ name: 'login' })
// //     }
// //   } else if(token && (to.name === 'login' || to.path === '/p2')){
// //     //说明token存在，用户处于登录状态，此时跳转到首页
// //      next({name:'user'})
// //   }else{
// //     next()
// //   }
// // })
//
new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
