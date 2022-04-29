<template>
  <v-app>
    <v-navigation-drawer app v-model="drawer" clipped right>
      Navi
    </v-navigation-drawer>
    <v-app-bar color="primary" app clipped-left>
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>Vuetify</v-toolbar-title>
    </v-app-bar>

    <v-main>
      <HelloWorld/>
    </v-main>

    <v-footer color="primary" app>
      Vuetify  
    </v-footer>
  </v-app>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',

  components: {
    HelloWorld,
  },

  data: () => ({
    drawer: null
  }),
}
</script>
