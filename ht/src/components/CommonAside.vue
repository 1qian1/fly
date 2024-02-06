<template>
  <el-menu :default-active="this.$route.name" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
           :collapse="isCollapse" background-color="#545c64"
           text-color="#fff"
           active-text-color="#ffd04b">
    <h3>{{ isCollapse ? '飞星' : '飞星词后台管理' }}</h3>
    <el-menu-item @click="clickMenu(item)" v-for="item in noChildren" :key="item.name" :index="item.name">
      <i :class="'el-icon-' + item.icon"></i>
      <span slot="title">{{ item.label }}</span>
    </el-menu-item>
    <el-submenu v-for="item in hasChildren" :key="item.label" :index="item.label">
      <template slot="title">
        <i :class="'el-icon-' + item.icon"></i>
        <span>{{ item.label }}</span>
      </template>
      <el-menu-item-group v-for="subItem in item.children" :key="subItem.name">
        <el-menu-item @click="clickMenu(subItem)" :index="subItem.name">{{ subItem.label }}</el-menu-item>
      </el-menu-item-group>
    </el-submenu>
  </el-menu>
</template>

<script>
export default {
  data() {
    return {
      // isCollapse: false,
      menuData: [
        {
          path: '/',
          name: 'user',
          label: "学习资料",
          icon: 'user',
          //url:'UserManage/UserManage'
        },
        {
          path: '/home',
          name: 'home',
          label: "用户数据",
          icon: 's-home',
          //url:'Home/home'
        },
        {
          path: '/mall',
          name: 'mall',
          label: "互动管理",
          icon: 'video-play',
          //url:'MallManage/MallManage'
        },
        {
          path: '/page1',
          name: 'page1',
          label: "大屏可视化",
          icon: 'setting',
          //url:'Other/PageOne'
        },
      ]
    };
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    // 点击菜单
    clickMenu(item) {
      console.log(item);

      // 判断是否需要进行路由跳转
      if (this.$route.path !== item.path && !(this.$route.path === '/user' && item.path === '/')) {
        this.$router.push(item.path);
        this.$store.commit("selectMenu", item);
      }
    }
  },
  computed: {
    //无子菜单
    noChildren() {
      return this.menuData.filter(item => !item.children)
    },
    //有子菜单
    hasChildren() {
      return this.menuData.filter(item => item.children)
    },
    isCollapse() {
      return this.$store.state.tab.isCollapse
    }
  }
}
</script>

<style lang="less">
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}
.el-menu{
  border-right: none;
  height: 190vh;
  h3{
    margin: 10px;
    color: #fff;
    text-align: center;
    font-size: 16px;
    font-weight: 400;
    line-height: 48px; /* 这里修改为 line-height */
  }
}
</style>
