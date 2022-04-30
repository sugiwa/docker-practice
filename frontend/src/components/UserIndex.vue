<template>
    <v-container>
        <v-row>
            <v-col cols="12">
                <v-btn>Get Users</v-btn>
                <v-table density="compact">
                    <thead>
                        <tr>
                            <th class="text-center">ID</th>
                            <th class="text-center">Name</th>
                            <th class="text-center">email</th>
                            <th class="text-center">password</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="user in users" :key="user.id">
                            <td class="text-center">{{ user.id }}</td>
                            <td class="text-center">{{ user.name }}</td>
                            <td class="text-center">{{ user.email }}</td>
                            <td class="text-center">{{ user.password }}</td>
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
}
</script>