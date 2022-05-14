<template>
    <v-container>
        <v-row>
            <v-col cols="10" class="mx-auto">
                <h2 class="d-inline mr-10">Users</h2>
                <v-btn color="success" class="mx-5" @click="openNewUser">
                    <!-- <router-link to="/users/new" class="text-decoration-none text-white"> -->
                        Create User
                    <!-- </router-link> -->
                </v-btn>
                <v-table density="compact">
                    <thead>
                        <tr>
                            <th class="text-center">ID</th>
                            <th class="text-center">Name</th>
                            <th class="text-center">email</th>
                            <th class="text-center"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="user in users" :key="user.id">
                            <td class="text-center">{{ user.id }}</td>
                            <td class="text-center">{{ user.name }}</td>
                            <td class="text-center">{{ user.email }}</td>
                            <td class="text-center"><v-btn size="small" color="" @click="showUserDetail(user.id)">show</v-btn></td>
                        </tr>
                    </tbody>
                </v-table> 
            </v-col>
        </v-row>
    </v-container>

</template>

<script>
import axios from 'axios'

const url = 'http://localhost:8080/spring_api/api/'

export default {
    name: "UserIndex",
    data: () => ({
        users: [],
    }),
    mounted() {
        axios.get(url + 'users')
            .then((res) => {
                console.log(res.data)
                this.users = res.data
            }).catch((err) => {
                console.log(err)
            })
    },
    methods: {
        getUsers(){
            axios.get(url + 'users')
                .then((res) => {
                    console.log(res.data)
                    this.users = res.data
                }).catch((err) => {
                    console.log(err)
                })
        },
        showUserDetail(id){
            this.$router.push({path: '/users/detail', query: {user_id: id}})
            // let resolvedRoute = this.$router.resolve({
            //     path: '/users/:id',
            //     query: { user_id: id}
            // });
            // window.open(resolvedRoute.href, '_blank')
        },
        openNewUser(){
            this.$router.push({ path: '/users/new' })
            // let resolvedRoute = this.$router.resolve({
            //     path: '/users/new',
            //     params: {}
            // });
            // window.open(resolvedRoute.href, '_blank')
            // window.open(resolvedRoute.href, null, '_blank')
        }
    }
}
</script>