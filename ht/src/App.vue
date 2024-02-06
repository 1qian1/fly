<template>
  <div id="app">
    <keep-alive>
      <router-view v-if='$route.meta.keepAlive' />
    </keep-alive>
    <router-view v-if='!$route.meta.keepAlive' />
  </div>
</template>


<script>
export default {
  name: 'App',
}
</script>

<style lang="less">

#building{
  background:url("./views/img/cc.png");
  width:100%;
  height:100%;
  position:fixed;
  background-size:100% 100%;
}

html,body,h3,p{

    margin:0;
    padding:0;
  border:0
}
</style>

