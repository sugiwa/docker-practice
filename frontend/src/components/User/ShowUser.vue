<template>
    <v-container>
        <v-row>
            <v-col cols="12">
                {{ this.$route.params.id}}
                <v-btn color="primary">Get Users</v-btn>
                <v-btn color="success" @click="openNewUser">
                    <!-- <router-link to="/users/new" class="text-decoration-none text-white"> -->
                        Create User
                    <!-- </router-link> -->
                </v-btn>
                <v-table density="compact">
                    <tbody>
                        <tr>
                            <td class="text-center">{{ user.id }}</td>
                            <td class="text-center">{{ user.name }}</td>
                            <td class="text-center">{{ user.email }}</td>
                            <td class="text-center"><v-btn size="small" color="error" @click="deleteUser">show</v-btn></td>
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
let user_id = 0

export default {
    name: "UserIndex",
    data: () => ({
        user: {},
    }),
    mounted() {
        user_id = this.$route.query.user_id
        axios.get(url + `users/${user_id}`)
            .then((res) => {
                console.log(res.data)
                this.user = res.data
            }).catch((err) => {
                console.log(err)
            })
    },
    methods: {
        getUser(){
            axios.get(url + 'users')
                .then((res) => {
                    console.log(res.data)
                    this.users = res.data
                }).catch((err) => {
                    console.log(err)
                })
        },
        deleteUser(data) {
            if(confirm("本当に削除しますか？")){
                console.log(data)
                axios.delete(url + `users/${user_id}/delete`)
                    .then((res) => {
                        console.log(res)
                        this.$router.push({ path: '/users' })
                    }).catch((err) => {
                        console.log(err)
                    })
            }
        },
    }
}
</script>