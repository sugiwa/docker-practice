const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  configureWebpack: {
    watchOptions:{
      poll: 1000,
      ignored: /node_modules/,
    }
  },

  devServer: {
    proxy: "http://localhost:8080",
  },

  pluginOptions: {
    vuetify: {
		}
  }
})
