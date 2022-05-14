<template>
    <v-container>
        <v-row>
            <v-col cols="10"  class="mx-auto">
                <h2 class="d-inline mr-10">User Detail</h2>
                <v-btn size="small" color="error" @click="deleteUser">delete</v-btn>
                <v-table density="compact">
                    <tbody>
                        <tr>
                            <th>id</th>
                            <td class="text-center">{{ user.id }}</td>
                        </tr>
                        <tr>
                            <th>name</th>
                            <td class="text-center">{{ user.name }}</td>
                        </tr>
                        <tr>
                            <th>email</th>
                            <td class="text-center">{{ user.email }}</td>
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
                axios.delete(url + `users/${this.user.id}/delete`)
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