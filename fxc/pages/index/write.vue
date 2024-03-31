<template>
  <view class="question-list">
    <view class="question-item" v-for="(question, index) in questionList" :key="index" @click="goToQuestionDetail(question)">
      <text class="question-title">{{ question.title }}</text>
      <text class="question-status" :class="{ 'unanswered': question.status === 'unanswered', 'answered': question.status === 'answered' }">{{ question.status === 'unanswered' ? '未回答' : '已回答' }}</text>
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      questionList: [
        { id: '1', title: '如何学习编程？', status: 'unanswered' },
        { id: '2', title: '如何提高英语口语？', status: 'answered' }
      ]
    };
  },
  methods: {
    goToQuestionDetail(question) {
      uni.navigateTo({
        url: `/pages/view/questionAnswer?id=${question.id}`
      });
    }
  }
};
</script>

<style scoped>
.question-list {
  padding: 20rpx;
}

.question-item {
  margin-bottom: 20rpx;
  padding: 20rpx;
  background-color: #f5f5f5;
  border-radius: 10rpx;
  box-shadow: 0 2rpx 5rpx rgba(0, 0, 0, 0.1);
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.question-title {
  font-size: 28rpx;
  color: #333;
}

.question-status {
  font-size: 24rpx;
  color: #999;
}

.unanswered {
  color: #ff4d4f;
}

.answered {
  color: #52c41a;
}
</style>
