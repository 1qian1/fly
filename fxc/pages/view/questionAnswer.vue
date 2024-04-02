<template>
  <view class="container">
    <view v-if="questions.length > 0" v-for="(item, index) in questions" :key="index" class="question-item" @tap="goToQuestionDetail(item.questionId)">
      <text class="question">{{ item.questionContent }}</text>
      <view class="info">
        <text>{{ item.answerCount}} 回答 | {{ item.userNickname }}</text>
        <text class="user-nickname">{{ item.questionDate }}</text>
      </view>
    </view>
    <view v-else>
      <text>暂无问题数据</text>
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      questions: []
    };
  },
  mounted() {
    this.fetchQuestions();
  },
  methods: {
    fetchQuestions() {
      uni.request({
        url: 'http://localhost:8084/questions',
        method: 'GET',
        success: (res) => {
          this.questions = res.data;
		  console.log(res)
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
 }
  }
};
</script>

<style>
.container {
  padding: 20rpx;
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
</style>
