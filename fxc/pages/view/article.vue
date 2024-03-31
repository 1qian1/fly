<template>
  <view class="container">
    <!-- 文章封面 -->
    <image :src="article.cover" class="cover"></image>

    <!-- 文章标题 -->
    <text class="title">{{ article.title }}</text>

    <!-- 文章内容 -->
    <view class="content">
      <text>{{ article.content }}</text>
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      article: {}
    };
  },
  onLoad(options) {
    // 从页面参数中获取文章ID
    const articleId = options.id;
    // 根据文章ID从文章列表中查找对应的文章数据
    this.article = this.articles.find(article => article.id === parseInt(articleId));
  },
  computed: {
    // 模拟文章数据
    articles() {
      return [
        {
          id: 1,
          title: '如何提高英语口语？',
          cover: '/static/img/b1.jpg',
          content: '提高英语口语的方法有很多，比如多说、多听、多模仿。...'
        },
        {
          id: 2,
          title: '英语听力训练的重要性',
          cover: '/static/img/b2.jpg',
          content: '英语听力是学习英语的重要组成部分，如何进行有效的听力训练？...'
        },
        {
          id: 3,
          title: '阅读英文文章的技巧',
          cover: '/static/img/b3.jpg',
          content: '阅读英文文章是提高英语水平的有效方法，本文将介绍一些阅读技巧。...'
        }
      ];
    }
  }
};
</script>

<style scoped>
.container {
  padding: 20rpx;
}

.cover {
  width: 100%;
  height: 300rpx;
  object-fit: cover;
  margin-bottom: 20rpx;
}

.title {
  display: flex;
  justify-content: center; 
  font-size: 24rpx;
  font-weight: bold;
  margin-bottom: 20rpx;
}

.content {
  line-height: 1.5;
}
</style>
