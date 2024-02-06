<template>
<div id="building">
  <el-form ref="form" label-width="70px" class="login-container" :inline="true" :model="form" :rules="rules">

    <h3 class="login_title">系统登陆</h3>
    <el-form-item  label="用户名" prop="username">
      <el-input placeholder="请输入用户名" v-model="form.username"></el-input>
    </el-form-item>
    <el-form-item  label="密码" prop="password">
      <el-input type="password" placeholder="请输入密码" v-model="form.password"></el-input>
    </el-form-item>

    <el-form-item >
      <el-button @click="submit" style="margin-left:70px; margin-top: 4px; width:320px" type="primary">登录</el-button>
      <br>
      <router-link to="/p2" tag="el-link" type="primary" style="margin-left:100px;">
        还没有账号? 点我注册
      </router-link>
    </el-form-item>

  </el-form>
</div>
</template>

<script>
import Cookie from 'js-cookie'
import Mock from 'mockjs'
import axios from "axios";
export default {
  data(){
    return{
      verificationCode: '', // 存储验证码
      isCodeSent: false, // 标记是否成功发送验证码
      da:[],
      showDialog :false,
      form:{
        username:'',
        password:''
      },
      rules:{
        username:[
          {   required:true, trigger:'blur',message:"请输入用户名"}
        ],
        password:[
          {   required:true, trigger:'blur',message:"请输入密码"}
        ]
      }
    }
  },
  methods:{
    // getEmailVerificationCode() {
    //   if (this.form.email === '') {
    //     this.$message.warning('请输入邮箱');
    //     return;
    //   }
    //   axios.get('/kweb/email/sendEmail', {params:{emailReceiver: this.form.email}})
    //       .then(response => {
    //         this.$message.success('验证码已发送至邮箱，请注意查收');
    //         this.isCodeSent = true;
    //       })
    //       .catch(error => {
    //         this.$message.error('验证码发送失败，请稍后重试');
    //         console.error(error);
    //       });
    // },
    async  regist(){
      const formData = new FormData();
      formData.append('username', this.form.username);
      formData.append('password', this.form.password);
// 发送POST请求
      axios.post('/kweb/singin', formData)
          .then(response => {
            // console.log(response.data);
            if(response.data.trim()==="请重新输入用户名"){
              // 请求成功处理
              this.$message.warning('该用户名已被注册');

              // 2秒后自动关闭弹窗
              setTimeout(() => {
                this.showDialog = false;
              }, 2000);
            }else{
              this.$message.success('注册成功');

            }

          })
          .catch(error => {
            // 请求失败处理
            console.error(error);
          });
    },
    async  submit(){
      const formData = new FormData();
      formData.append('username', this.form.username);
      formData.append('password', this.form.password);
// 发送POST请求

      axios.post('/kweb/login', formData)
          .then(response => {
            console.log(response.data);
            if(response.data.trim()==="登录成功"){
              // 请求成功处理
              this.$message.success('登录成功');
              const token=Mock.Random.guid()
              Cookie.set('token',token)
              this.$router.push('/')
            }
            else{
              this.$message.error('用户名或密码错误');
            }

          })
          .catch(error => {
            // 请求失败处理

            console.error(error);
          });
    }
  }
}
</script>

<style lang="less" scoped>
.login-container {

  position: relative;
  left: -15px;
  width: 500px;
  background-color: rgba(255, 255, 255, 0.1);
  border: 1px solid transparent;
  //border:1px solid #eaeaea;
  margin: 180px auto;
  padding: 35px 35px 15px 35px;
  //background-color: #fff;
  border-radius: 15px;
  box-shadow: 0 0 25px #cac6c6;
  box-sizing: border-box;

  .login_title {
    text-align: center;
    margin-bottom: 40px;
    color: #505458;

  }

  .el-form-item {

    .el-input {
      width: 320px;
    }
  }

  // 改变input里的字体颜色
  /deep/ input::-webkit-input-placeholder {
    color: #17a1e5;
    font-size: 15px;
  }

  // 改变input框背景颜色
  /deep/ .el-input__inner {
    background-color: transparent !important;
    border: 1px solid #1296db;
  }
}
</style>
