import { createStore } from 'vuex'

const store = createStore({
    state() {
        return {
            current_user: null
        }
    },
    mutations: {
        setCurrentUser(state, user){
            state.current_user = user
        }
    }
})

export default store