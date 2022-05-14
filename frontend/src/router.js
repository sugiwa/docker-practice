import { createRouter, createWebHashHistory } from 'vue-router'

import UserIndex from './components/User/UserIndex.vue'
import NewUser from './components/User/NewUser.vue'
import ShowUser from './components/User/ShowUser.vue'
import UserLogin from './components/User/UserLogin.vue'

import HelloWorld from './components/HelloWorld.vue'
import axios from './util/axios'
import store from './store'

const routes = [
    { path: '/', component: HelloWorld },
    { path: '/users', component: UserIndex },
    { path: '/users/new', component: NewUser },
    { path: '/users/detail', component: ShowUser },
    { path: '/users/login', component: UserLogin },
];
  
const router = createRouter({
    history: createWebHashHistory(),
    routes,
})

router.beforeEach((to, from, next) => {

    if(to.fullPath == '/' || to.fullPath == '/users/login'){
        next();
    }else{
        axios
            .get('http://localhost:8080/spring_api/api/login/check')
            .then(res => {
                if(res.data){
                    store.commit('setCurrentUser', res.data)
                    next()
                }else{
                    next({
                        path: '/users/login'
                    })
                }
            }).catch(err => {
                console.log(err)
                next({
                    path: '/users/login'
                })
            })
    }
})

// router.beforeUpdate((to, from, next) => {
//     store.commit('setCurrentUser', store.state.current_user)
//     next()
// })

export default router