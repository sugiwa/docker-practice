import { createApp } from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import { createRouter, createWebHashHistory } from 'vue-router'
// import axios from 'axios'
import { loadFonts } from './plugins/webfontloader'

import UserIndex from './components/User/UserIndex.vue'
import NewUser from './components/User/NewUser.vue'
import ShowUser from './components/User/ShowUser.vue'
import UserLogin from './components/User/UserLogin.vue'
import UserCookie from './components/User/UserCookie.vue'

import HelloWorld from './components/HelloWorld.vue'

loadFonts()
// axios.defaults.withCredentials = true;
// axios.defaults.headers.get['Access-Control-Allow-Origin'] = 'http://localhost:8080';
// axios.defaults.headers.post['Access-Control-Allow-Origin'] = 'http://localhost:8080';

const routes = [
  { path: '/', component: HelloWorld },
  { path: '/users', component: UserIndex },
  { path: '/users/new', component: NewUser },
  { path: '/users/detail', component: ShowUser },
  { path: '/users/login/cookie', component: UserCookie },
  { path: '/users/login', component: UserLogin },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
})

createApp(App)
  .use(vuetify)
  .use(router)
  .mount('#app')
