<template>
  <v-card
    class="mx-auto mt-10"
    max-width="400"
  >
    <v-container>

      <v-form
        ref="form"
        v-model="valid"
        lazy-validation
      >
        <h2>ログイン</h2>
        <v-text-field
          v-model="email"
          :rules="emailRules"
          label="E-mail"
          required
        ></v-text-field>

        <v-text-field
          v-model="password"
          :counter="10"
          :rules="passwordRules"
          label="Password"
          required
        ></v-text-field>
        <v-btn
          :disabled="!valid"
          color="success"
          class="mr-4"
          @click="validate"
        >
          Validate
        </v-btn>
    </v-form>
    </v-container>
  </v-card>
</template>

<script>
import axios from "../../util/axios.js"
// import axios from "axios"

const url = 'http://localhost:8080/spring_api/api/'

export default {
data: () => ({
    valid: true,
    email: '',
    emailRules: [
        v => !!v || 'E-mail is required',
        v => /.+@.+\..+/.test(v) || 'E-mail must be valid',
    ],
    password: '',
    passwordRules: [
        v => !!v || 'Name is required',
        v => (v && v.length >= 4) || 'Name must be more than 4 characters',
    ],
}),

methods: {
    validate () {
        axios.post(url + 'login', {
            email: this.email,
            password: this.password,
        }).then((res) => {
          console.log(res)
          this.$router.push({ path: '/users' })
        }).catch((err) => {
          console.log(err)
        })
    },
},
}
</script>