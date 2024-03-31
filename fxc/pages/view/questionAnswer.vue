<template>
  <view class="question-detail">
    <text class="question-title">{{ question.title }}</text>
    <text class="question-status" :class="{ 'unanswered': question.status === 'unanswered', 'answered': question.status === 'answered' }">{{ question.status === 'unanswered' ? '未回答' : '已回答' }}</text>
    <view class="question-content">
      <text>{{ question.content }}</text>
    </view>
    <view v-if="question.status === 'unanswered'" class="answer-form">
      <textarea v-model="answer" placeholder="请输入您的回答"></textarea>
      <button @click="submitAnswer">提交回答</button>
    </view>
    <view v-else class="answer-content">
      <text>回答内容：{{ question.answer || '暂无回答' }}</text>
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      question: null,
      answer: ''
    };
  },
  mounted() {
    // 通过路由参数获取问题详情
    if (this.$route && this.$route.query && this.$route.query.id) {
      const questionId = this.$route.query.id;
      this.question = this.getQuestionById(questionId);
    }
  },
  methods: {
    getQuestionById(id) {
      // 假设从后端获取问题详情数据
      return { id: '1', title: '如何学习编程？', status: 'answered', content: '这是一个示例问题，欢迎回答。', answer: '这是一个示例回答。' };
    },
    submitAnswer() {
      // 提交回答
      this.question.answer = this.answer;
      this.question.status = 'answered';
      // 此处可以调用后端接口将回答提交到服务器
    }
  }
};
</script>

<style scoped>
.question-detail {
  padding: 20rpx;
}

.question-title {
  font-size: 32rpx;
  color: #333;
}

.question-status {
  font-size: 28rpx;
  color: #999;
  margin-bottom: 20rpx;
}

.question-content {
  font-size: 28rpx;
  color: #333;
  margin-bottom: 20rpx;
}

.answer-form textarea {
  width: 100%;
  height: 200rpx;
  margin-bottom: 20rpx;
  padding: 10rpx;
  font-size: 28rpx;
  border: 1rpx solid #ccc;
  border-radius: 5rpx;
}

.answer-form button {
  width: 100%;
  height: 60rpx;
  background-color: #007bff;
  color: #fff;
  font-size: 28rpx;
  border: none;
  border-radius: 5rpx;
}

.answer-content {
  font-size: 28rpx;
  color: #333;
}
</style>
