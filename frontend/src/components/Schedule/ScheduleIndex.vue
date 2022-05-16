<template>
    <v-container>
        <v-row>
            <v-col cols="10" class="mx-auto">
                <h2 class="d-inline mr-10">Users</h2>
                <v-btn color="success" class="mx-5" @click="openNewSchedule">
                    Create Schedule
                </v-btn>
                <v-table density="compact">
                    <thead>
                        <tr>
                            <th class="text-center">ID</th>
                            <th class="text-center">Title</th>
                            <th class="text-center">Content</th>
                            <th class="text-center">start</th>
                            <th class="text-center">finish</th>
                            <th class="text-center"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="schedule in schedules" :key="schedule.id">
                            <td class="text-center">{{ schedule.id }}</td>
                            <td class="text-center">{{ schedule.title }}</td>
                            <td class="text-center">{{ schedule.content }}</td>
                            <td class="text-center">{{ schedule.started_at }}</td>
                            <td class="text-center">{{ schedule.finished_at }}</td>
                            <td class="text-center"><v-btn size="small">show</v-btn></td>
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
    name: "ScheduleIndex",
    data: () => ({
        schedules: [],
    }),
    mounted() {
        axios.get(url + 'schedules')
            .then((res) => {
                console.log(res.data)
                this.schedules = res.data
            }).catch((err) => {
                console.log(err)
            })
    },
    methods: {
        openNewSchedule(){
            // this.$router.push({ path: '/users/new' })
        }
    }
}
</script>