<template>
    <v-navigation-drawer app v-model="drawer" temporary>
      <v-list nav color="black">
        <v-list-item-group>
          <router-link :to="{ path: '/'}">
            <v-btn block elevation="0">
              <v-list-item prepend-icon="mdi-folder" title="HOME"></v-list-item>
            </v-btn>
          </router-link>
          <router-link :to="{ path: '/users'}">
            <v-btn block elevation="0">
              <v-list-item prepend-icon="mdi-account-supervisor-circle" title="USERS"></v-list-item>
            </v-btn>
          </router-link>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>
</template>

<script>
export default {
    name: "NavigationDrawer"
}
</script>