<template>
    <v-form v-model="valid">
        <v-container>
            <v-row>
                <v-col
                cols="12"
                md="4"
                >
                <v-text-field
                    v-model="name"
                    :rules="nameRules"
                    :counter="10"
                    label="Name"
                    required
                ></v-text-field>
                </v-col>

                <v-col
                cols="12"
                md="4"
                >
                <v-text-field
                    v-model="email"
                    :rules="emailRules"
                    label="E-mail"
                    required
                ></v-text-field>
                </v-col>

                <v-col
                cols="12"
                md="4"
                >
                <v-text-field
                    v-model="password"
                    :rules="passwordRules"
                    :counter="4"
                    label="Password"
                    required
                ></v-text-field>
                </v-col>

                <v-col
                cols="12"
                md="4"
                >
                <v-btn
                    :disabled="!valid"
                    color="success"
                    class="mr-4"
                    @click="CreateUser"
                    >
                    Create
                </v-btn>
                </v-col>
            </v-row>
        </v-container>
    </v-form>
</template>

<script>

import axios from 'axios'

const url = 'http://localhost:8080/spring_api/api/'

export default {
    name: "NewUser",
    data: () => ({
        valid: false,
        name: '',
        nameRules: [
            v => !!v || 'Name is required',
            v => v.length <= 10 || 'Name must be less than 10 characters',
        ],
        email: '',
        emailRules: [
            v => !!v || 'E-mail is required',
            v => /.+@.+/.test(v) || 'E-mail must be valid',
        ],
        password: '',
        passwordRules: [
            v => !!v || 'Password is required',
            v => v.length >= 4 || 'Password must be more than 4 characters',
        ]
    }),
    methods: () => ({
        CreateUser: () => {
            axios.post(url + 'users/', {
                name: this.name,
                email: this.email,
                password: this.password,
            })
            .then((res) => {
                console.log("success: ", res)
            }).catch((err) => {
                console.log("error: ", err)
            })
        }
    })
}
</script>