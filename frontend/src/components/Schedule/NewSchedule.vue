<template>
    <v-card
        class="mx-auto mt-10"
        max-width="600"
    >
        <h2 class="ml-5">Create Schedule</h2>
        <v-form v-model="valid">
            <v-container>
                <v-row>
                    <v-col
                    cols="12"
                    class="mx-auto"
                    >
                    <v-text-field
                        v-model="title"
                        :rules="titleRules"
                        :counter="10"
                        label="Title"
                        required
                    ></v-text-field>
                    </v-col>
                    <v-col
                    cols="12"
                    class="mx-auto"
                    >
                    <v-text-field
                        v-model="content"
                        :rules="contentRules"
                        :counter="10"
                        label="Content"
                        required
                    ></v-text-field>
                    </v-col>

                    <v-col
                    cols="3"
                    class="ml-auto"
                    >
                    <v-btn
                        :disabled="!valid"
                        color="success"
                        class="ml-auto"
                        v-on:click="CreateUser"
                        >
                        Create
                    </v-btn>
                    </v-col>
                </v-row>
            </v-container>
        </v-form>
    </v-card>
</template>

<script>

import axios from 'axios'

const url = 'http://localhost:8080/spring_api/api/'

export default {
    name: "NewSchedule",
    data: () => ({
        valid: false,
        title: '',
        titleRules: [
            v => !!v || 'Title is required',
            // v => v.length <= 10 || 'Name must be less than 10 characters',
        ],
        content: '',
        contentRules: [
            v => !!v || 'Title is required',
            // v => v.length <= 10 || 'Name must be less than 10 characters',
        ],
    }),
    methods: {
        CreateSchedule() {
            axios.post(url + 'schedules/', {
                user_id: 1,
                title: this.title,
                content: this.content,
            })
            .then((res) => {
                console.log("success: ", res)
                this.$router.push('/schedules')
            }).catch((err) => {
                console.log("error: ", err)
                this.$router.push('/schedules/new')
            })
        },
    }
}
</script>