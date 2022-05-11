<template>
    <div>
        <h2>Cookie</h2>
        {{ cookie }}        
    </div>
</template>

<script>

import axios from 'axios'

export default {
    name: 'UserCookie',
    data: () => ({
        cookie: null
    }),
    methods: {
        test(){
            console.log(this.cookie)
        }
    },
    created() {
        axios.get("http://localhost:8080/spring_api/api/users/login/cookie")
            .then((res) => {
                console.log(res)
                this.cookie = res.data
            })
    },
}
</script>