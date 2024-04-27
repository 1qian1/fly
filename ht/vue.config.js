
module.exports = {
  transpileDependencies: true,
  lintOnSave:false,
  devServer: {
    client: {
      overlay: false,
    },
    port: 8080, //前端服务启动的端口号
    host: 'localhost', //前端服务启动后的访问ip，默认为localhost, host和port组成了前端服务启动后的访问入口。
    https: false,
    open: true,
    proxy: {
      '/kweb': { //拦截上下文
        target: 'http://localhost:8084',//酒店
        // target: 'http://192.168.1.149:9999', //匹配到要代理的上下文后，将上下文前面的地址替换为此代理地址
        changeOrigin: true, //是否跨域
        pathRewrite: {
          '^/kweb':'' //拦截到的上下文重写，这里可以将 kweb 重写为空或者其它值，因为我不需要重写，所以这里这么配置。
        }
      }
    }
  }

}
