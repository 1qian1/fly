<template>
  <view class="container">
    <!-- 搜索框 -->
    <input class="search-input" v-model="searchText" placeholder="搜索问题或回答内容">
    
    <!-- 问题列表 -->
    <view v-if="filteredQuestions.length > 0" v-for="(item, index) in filteredQuestions" :key="index" class="question-item" @tap="goToQuestionDetail(item.questionId)">
      <text class="question">{{ item.questionContent }}</text>
      <view class="info">
        <text>{{ item.answerCount }} 回答 | {{ item.userNickname }}</text>
        <text class="user-nickname">{{ item.questionDate }}</text>
      </view>
    </view>
    <view v-else>
      <text>暂无匹配结果</text>
    </view>

    <!-- 发布问题按钮 -->
    <button class="publish-button" @tap="showPublishDialog">+</button>

    <!-- 发布问题对话框 -->
    <view v-show="showDialog" class="dialog-mask">
      <view class="dialog-content">
        <textarea v-model="newQuestionContent" placeholder="在这里输入您的问题"></textarea>
        <view class="dialog-buttons">
          <view class="button" @tap="hidePublishDialog">取消</view>
          <view class="button confirm" @tap="publishNewQuestion">发布</view>
        </view>
      </view>
    </view>

    <!-- 发布成功提示 -->
    <view v-if="showSuccessMessage" class="success-message">
      发布成功
    </view>

    <!-- 暂无匹配结果提示 -->
    <view v-if="showNoResultMessage" class="no-result-message">
      暂无该问题
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
       questions: [],
           userId: 1, // 默认用户ID为1
           showDialog: false,
           newQuestionContent: '',
           currentDate: '', // 存储当前日期
           showSuccessMessage: false, // 控制发布成功提示的显示
           searchText: '', // 存储搜索文本
           showNoResultMessage: false // 控制显示暂无匹配结果提示的显示
    };
  },
  computed: {
     reversedQuestions() {
         // 反转问题数组
         return this.questions.slice().reverse();
       },
       filteredQuestions() {
         // 过滤问题数组，根据搜索文本进行模糊匹配
         const filtered = this.reversedQuestions.filter(question => {
           return question.questionContent.toLowerCase().includes(this.searchText.toLowerCase());
         });
         // 如果模糊查询结果为空，则显示暂无匹配结果提示
         this.showNoResultMessage = filtered.length === 0;
         return filtered;
       }
  },
  mounted() {
  this.fetchQuestions();
      // 获取并格式化当前日期
      const currentDate = new Date();
      this.currentDate = currentDate;
    },
  methods: {
fetchQuestions() {
  uni.request({
    url: 'http://localhost:8084/questions',
    method: 'GET',
    success: (res) => {
      // 对获取的数据进行处理
      this.questions = res.data.map(question => {
        // 将后端传来的日期字符串转换为 JavaScript Date 对象
        const questionDate = new Date(question.questionDate);
        // 获取年月日
        const year = questionDate.getFullYear().toString().slice(-2);
        const month = (questionDate.getMonth() + 1).toString().padStart(2, '0'); // 补零
        const day = questionDate.getDate().toString().padStart(2, '0'); // 补零  
        // 格式化为年月日的形式
        const formattedDate = `${year} 年 ${month} 月 ${day} 日`;
        // 将格式化后的日期更新到 question 对象中
        question.questionDate = formattedDate;
        return question;
      });
    },
    fail: (err) => {
      console.error('Error fetching questions:', err);
    }
  });
},

    goToQuestionDetail(questionId) {
      uni.navigateTo({
        url: '/pages/view/prodetail?questionId=' + questionId
      });
    },
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
          // 显示发布成功消息
          this.showSuccessMessage = true;
          // 2秒后隐藏发布成功消息
          setTimeout(() => {
            this.showSuccessMessage = false;
          }, 2000);
          // 刷新问题数据
          this.fetchQuestions();
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
  display: flex;
  justify-content: center;
  align-items: center;
  position: fixed;
  bottom: 10%;
  right: 20px;
  width: 45px;
  height: 45px;
  line-height: 60px;
  background-color: rgba(255, 255, 255, 0.7); /* 白色，透明度为 0.8 */
  text-align: center;
  border-radius: 50%;
  cursor: pointer;
  box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.3);
  z-index: 9999; /* 确保按钮在页面上其他元素之上 */
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
.dialog-content text,
.dialog-content textarea {
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
.question-item {
  margin-bottom: 20rpx;
  background-color: #f7f7f7;
  padding: 20rpx;
  border-radius: 10rpx;
  box-shadow: 0 2rpx 4rpx rgba(0, 0, 0, 0.1);
}
.question {
  font-size: 16px;
  font-weight: bold;
  color: #333;
}
.user-nickname {
  font-size: 14px;
  color: #666;
}
.info {
  display: flex;
  justify-content: space-between;
}
.success-message {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: rgba(0, 0, 0, 0.7);
  color: #fff;
  padding: 10px 20px;
  border-radius: 5px;
  z-index: 9999;
}
.search-input {
  width: 100%;
  padding: 10rpx;
  margin-bottom: 10rpx;
  border: 1rpx solid #ccc;
  border-radius: 5rpx;
  position: sticky;
  /* 使用 sticky 定位 */
  top: 0;
  /* 顶部定位 */
  background-color:#f0f4e4;
}
</style>
