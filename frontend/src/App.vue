<template>
  <v-app>

    <v-app-bar color="primary" prominent>
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
        <v-toolbar-title>
          <router-link :to="{ path: '/'}" class="text-decoration-none text-white">
            Vuetify
          </router-link>
        </v-toolbar-title>

        <!-- <v-spacer></v-spacer> -->
        <p v-if="this.current_user">{{ this.current_user.name }}</p>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <v-btn
              color="primary"
              dark
              v-bind="attrs"
              v-on="on"
              @click="logout"
            >
              Button
            </v-btn>
          </template>
          <span>Tooltip</span>
        </v-tooltip>

        <v-btn variant="text" icon="mdi-account-circle" @click="openLoginForm"></v-btn>
        <v-btn variant="text" icon="mdi-magnify"></v-btn>
    </v-app-bar>
    
    <v-navigation-drawer app v-model="drawer" temporary>
      <v-list nav color="black">
        <v-list-item-group>
          <router-link :to="{ path: '/'}" class="text-decoration-none">
            <v-btn block elevation="0">
              <v-list-item prepend-icon="mdi-folder" title="HOME"></v-list-item>
            </v-btn>
          </router-link>
          <router-link :to="{ path: '/users'}" class="text-decoration-none">
            <v-btn block elevation="0">
              <v-list-item prepend-icon="mdi-account-supervisor-circle" title="USERS"></v-list-item>
            </v-btn>
          </router-link>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>

    <v-main>
      <router-view></router-view>
    </v-main>


  </v-app>
</template>

<script>
import axios from './util/axios'

export default {
  name: 'App',

  computed: {
    current_user() {
      return this.$store.state.current_user
    }
  },
  data: () => ({
    drawer: false,
    group: null,
  }),
  methods: {
    openLoginForm() {
      this.$router.push({ path: '/users/login' })
    },
    logout() {
      if(window.confirm("ログアウトしますか？")){
        axios.post('http://localhost:8080/spring_api/api/logout')
          .then(res => {
            console.log(res)
            this.$store.commit('current_user', null)
            this.$router.push({ path: '/users/login' })
          })
      }
    }
  }
}
</script>
