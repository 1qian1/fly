<template>
  <view class="container">
    <view class="question">
      <text class="question-title">{{ question }}</text>
     <!-- <text class="question-info">{{ answers.length }} 回答 | {{ date }}</text> -->
    </view>
    <view class="answer-list">
      <view v-for="(answer, index) in answers" :key="index" class="answer-item">
        <text class="answer-user">{{ answer.user }}:</text>
        <text class="answer-content">{{ answer.content }}</text>
      </view>
    </view>
    <view class="write-answer-btn" @tap="goToAnswerPage">写回答</view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      question: "有多少种方式可以在Python中创建一个字典？",
      answers: [ { user: "小明", content: "在Python中，可以使用字面量语法、dict() 构造函数、或者推导式等多种方式来创建字典。" },
          { user: "张三", content: "Python中创建字典有多种方式，如字面量、dict()构造函数等，选择适合场景的方式即可。" }],
      date: "2023年5月2日"
    };
  },
  mounted() {
    // 从路由参数中获取问题信息
    const { question, date } = JSON.parse(decodeURIComponent(this.$route.query.question));
    // 在实际应用中，这里可以通过接口调用从服务器获取相应的回答内容
    // 这里为了演示，直接从 data 中获取回答内容
    this.question = question;
    this.date = date;
    this.answers = answers; // 这里假设有一个方法来获取对应问题的回答
  },
  methods: {
    goToAnswerPage() {
      // 跳转到写回答页面，传递当前问题的信息
      uni.navigateTo({
        url: '/pages/view/questionAnswer.vue?question=' + encodeURIComponent(JSON.stringify(this.question))
      });
    },
    // 模拟获取对应问题的回答内容的方法
    getAnswers() {
      // 实际应用中可以从数据库或者其他数据源获取回答内容
      // 这里假设有一个固定的数据结构来存储问题和回答
      const answersData = {
        "有多少种方式可以在Python中创建一个字典？": [
          { user: "小明", content: "在Python中，可以使用字面量语法、dict() 构造函数、或者推导式等多种方式来创建字典。" },
          { user: "张三", content: "Python中创建字典有多种方式，如字面量、dict()构造函数等，选择适合场景的方式即可。" }
        ],
        // 其他问题的回答数据...
      };
      return answersData[this.question];
    }
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

.write-answer-btn {
  background-color: #007AFF;
  color: #FFF;
  text-align: center;
  padding: 10rpx;
  border-radius: 5rpx;
  margin-top: 20rpx;
}
</style>
