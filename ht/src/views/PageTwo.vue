<template>
  <div id="building">
    <el-form ref="form" label-width="70px" class="login-container" :inline="true" :model="form" :rules="rules">
      <h3 class="login_title">系统注册</h3>
      <el-form-item  prop="username">
        <el-input placeholder="请输入用户名" v-model="form.username"></el-input>
      </el-form-item>
      <el-form-item  prop="password">
        <el-input type="password" placeholder="请输入密码" v-model="form.password"></el-input>
      </el-form-item>
      <el-form-item  prop="email">
        <el-input placeholder="请输入邮箱" v-model="form.email"></el-input>
      </el-form-item>
      <el-form-item  prop="vc">
        <el-input placeholder="请输入验证码" v-model="form.vc" style="width:200px;" ></el-input>
        <el-button @click="getVerificationCode" style="margin-left: 10px;text-align: center" type="primary" size="medium" >
          发送验证码
        </el-button>
      </el-form-item>
      <el-form-item>
        <el-button @click="regist" style="margin-left: 0px; margin-top: 4px; width:320px" type="primary">注册</el-button>
        <!--      <el-button style="margin-left: 20px; margin-top: 4px;" type="primary">注册</el-button>-->
        <br>
        <router-link to="/login" tag="el-link" type="primary" style="margin-left:100px;">
          已有账号? 返回登录
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
  data() {
    return {
      da: [],
      showDialog: false,
      form: {
        email: '',
        vc: '' // 新增验证码字段
      },
      yz: '',
      rules: {
        email: [
          { required: true, trigger: 'blur', message: "请输入邮箱" }
        ],
        vc: [ // 新增验证码校验规则
          { required: true, trigger: 'blur', message: "请输入验证码" }
        ]
      }
    }
  },
  methods: {
    async getVerificationCode() {
      // 简单的邮箱验证正则表达式
      const emailRegex = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;

      // 验证邮箱格式是否正确
      if (!this.form.email || !this.form.email.match(emailRegex)) {
        this.$message.error('请输入有效的邮箱地址');
        return;
      }

      // 向后端发送请求获取验证码
      axios.get('/kweb/email/sendEmail', {
        params: {
          emailReceiver: this.form.email
        }
      })
          .then(response => {
            // 请求成功处理
            console.log(response.data);
            this.$message.success('验证码已发送，请查收邮件');
            this.yz = response.data;
          })
          .catch(error => {
            // 请求失败处理
            console.error(error);
            this.$message.error('获取验证码失败');
          });
    },
    async  regist(){
      const formData = new FormData();
      formData.append('username', this.form.username);
      formData.append('password', this.form.password);
// 发送POST请求
      axios.post('/kweb/singin', formData)
          .then(response => {
            console.log(response.data);
            const yzAsNumber = parseInt(this.yz, 10); // 将this.yz转换为数字类型
            const vcAsNumber = parseInt(this.form.vc, 10);
            if (yzAsNumber === vcAsNumber && this.yz !== '') {
              if(response.data.trim()==="请重新输入用户名"){
                // 请求成功处理
                this.$message.warning('该用户名已被注册');

                // 2秒后自动关闭弹窗
                setTimeout(() => {
                  this.showDialog = false;
                }, 2000);
              }else{
                this.$message.success('注册成功');
                this.$router.push('/login')
              }
              // this.$message.success('注册成功');
              // const token=Mock.Random.guid()
              // Cookie.set('token',token)
              // this.$router.push('/')
            } else {
              this.$message.error('验证码有误');
              console.log(this.yz);
            }

          })
          .catch(error => {
            // 请求失败处理
            console.error(error);
          });
    },
    // async submit() {
    //
    //   console.log(this.form.vc); // 输出正确获取验证码的值
    //   const yzAsNumber = parseInt(this.yz, 10); // 将this.yz转换为数字类型
    //   const vcAsNumber = parseInt(this.form.vc, 10); // 将this.form.vc转换为数字类型
    //   if (yzAsNumber === vcAsNumber && this.yz !== '') {
    //     this.$message.success('登录成功');
    //     const token=Mock.Random.guid()
    //     Cookie.set('token',token)
    //     this.$router.push('/')
    //   } else {
    //     this.$message.error('验证失败');
    //     console.log(this.yz);
    //   }
    // }
  }
}
</script>

<style lang="less" scoped>

.login-container{

  position: relative;
  left: -15px;
  width:500px;
  background-color: rgba(255,255,255,0.1);
  border:1px solid  transparent;
  //border:1px solid #eaeaea;
  margin:50px auto;
  padding:35px 35px 15px 35px;
  //background-color: #fff;
  border-radius: 15px;
  box-shadow: 0 0 25px #cac6c6;
  box-sizing: border-box;
  .login_title{
    text-align: center;
    margin-bottom: 40px;
    color: #505458;

  }
  .el-form-item{

    .el-input{
      width:320px;
    }
  }
  // 改变input里的字体颜色
  /deep/input::-webkit-input-placeholder {
    color: #17a1e5;
    font-size: 15px;
  }

  // 改变input框背景颜色
  /deep/.el-input__inner {
    background-color: transparent;
    border: 1px solid #1296db;
  }
}
</style>