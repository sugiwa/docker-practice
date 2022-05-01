import { createApp } from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import { createRouter, createWebHashHistory } from 'vue-router'
import { loadFonts } from './plugins/webfontloader'

import UserIndex from './components/UserIndex.vue'
import NewUser from './components/NewUser.vue'
import HelloWorld from './components/HelloWorld.vue'

loadFonts()

const routes = [
  { path: '/', component: HelloWorld },
  { path: '/users', component: UserIndex },
  { path: '/users/new', component: NewUser },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
})

createApp(App)
  .use(vuetify)
  .use(router)
  .mount('#app')
