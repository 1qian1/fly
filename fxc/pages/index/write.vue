<template>
  <view class="container">
    <button class="publish-button" @tap="showPublishDialog">发布问题</button>


  <!-- 发布问题对话框 -->
  <view v-show="showDialog" class="dialog-mask">
    <view class="dialog-content">
      <text>请输入您的问题：</text>
      <textarea v-model="newQuestionContent" placeholder="在这里输入您的问题"></textarea>
      <view class="dialog-buttons">
        <view class="button" @tap="hidePublishDialog">取消</view>
        <view class="button confirm" @tap="publishNewQuestion">确认发布</view>
      </view>
    </view>
  </view>
    </view>
</template>

<script>
export default {
  data() {
    return {
      userId: 1, // 默认用户ID为1
      showDialog: false,
      newQuestionContent: '',
      currentDate: '' // 存储当前日期
    };
  },
  mounted() {
    // 获取并格式化当前日期
    const currentDate = new Date().toISOString().slice(0, 10);
    this.currentDate = currentDate;
  },
  methods: {
    // 弹出发布问题的对话框
    showPublishDialog() {
      this.showDialog = true;
    },
    // 隐藏发布问题的对话框
    hidePublishDialog() {
      this.showDialog = false;
      this.newQuestionContent = ''; // 隐藏对话框时清空输入内容
    },
    // 发布新问题
    publishNewQuestion() {
      // 构建问题对象
      const questionData = {
        userId: this.userId,
        questionContent: this.newQuestionContent,
        questionDate: this.currentDate // 使用当前日期
      };

      // 发送问题数据到后端
      uni.request({
        url: 'http://localhost:8084/questions', // 修改为后端接收问题数据的URL
        method: 'POST',
        data: questionData,
        success: (res) => {
          console.log('Question published successfully:', res);
          // 发布成功后关闭对话框
          this.hidePublishDialog();
          // 可以根据后端返回的结果进行相应处理
        },
        fail: (err) => {
          console.error('Error publishing question:', err);
        }
      });
    }
  }
};
</script>

<style>
.container {
  padding: 20rpx;
}

.publish-button {
  width: 100px;
  height:40px;
  line-height: 40rpx;
  text-align: center;
  justify-content: center;
  align-items: center;
  display: flex;
  background-color: #007AFF;
  color: #fff;
  border-radius: 5rpx;
}

/* 弹出对话框样式 */
.dialog-mask {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 9999;
}

.dialog-content {
  background-color: #fff;
  padding: 20rpx;
  border-radius: 10rpx;
}

.dialog-content text, .dialog-content textarea {
  margin-bottom: 10rpx;
}

.dialog-buttons {
  display: flex;
  justify-content: flex-end;
}

.dialog-buttons .button {
  width: 80rpx;
  height: 40rpx;
  line-height: 40rpx;
  text-align: center;
  background-color: #007AFF;
  color: #fff;
  border-radius: 5rpx;
  margin-left: 10rpx;
}

.dialog-buttons .confirm {
  background-color: #FF9500;
}
</style>
