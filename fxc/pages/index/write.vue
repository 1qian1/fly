<template>
  <view class="container">
    <view class="question">
      <text class="question-title">{{ question }}</text>
      <text class="question-info">{{ answers.length }} 回答 | {{ date }}</text>
    </view>
    <view class="answer-list">
      <view v-for="(answer, index) in answers" :key="index" class="answer-item">
        <text class="answer-user">{{ answer.user }}:</text>
        <text class="answer-content">{{ answer.content }}</text>
      </view>
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      question: "有多少种方式可以在Python中创建一个字典？",
      answers: [
        { user: "小明", content: "在Python中，可以使用字面量语法、dict() 构造函数、或者推导式等多种方式来创建字典。" },
        { user: "张三", content: "Python中创建字典有多种方式，如字面量、dict()构造函数等，选择适合场景的方式即可。" }
      ],
      date: "2023年5月2日",
    
    };
  }
};
</script>

<style>
.container {
  padding: 20rpx;
}

.question {
  margin-bottom: 20rpx;
}

.question-title {
  font-size: 18px;
  font-weight: bold;
  color: #333;
}

.question-info {
  font-size: 14px;
  color: #666;
  margin-top: 10rpx;
}

.answer-list {
  margin-top: 20rpx;
}

.answer-item {
  margin-bottom: 20rpx;
}

.answer-user {
  font-size: 14px;
  font-weight: bold;
  color: #333;
}

.answer-content {
  font-size: 16px;
  color: #666;
}
</style>
