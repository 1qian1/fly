<template>
  <view class="container">
    <!-- 文章封面 -->
    <image :src="article.cover" class="cover"></image>

    <!-- 文章标题 -->
    <text class="title">{{ article.title }}</text>

    <!-- 文章作者和发布时间 -->
    <view class="meta">
      <text class="author">作者: {{ article.author }}</text>
      <text class="publish-time">发布时间: {{ article.publishTime }}</text>
    </view>

    <!-- 文章内容 -->
    <view class="content">
      <!-- 使用 rich-text 渲染富文本内容 -->
      <rich-text :nodes="formatContent(article.content)"></rich-text>
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
          author: '小明',
          publishTime: '2024-04-15',
          content: '提高英语口语的方法有很多，比如多说、多听、多模仿。多看英文资料，多和外国人交流，多练习口语表达。以下是一些提高英语口语的技巧和方法：<br><img src="/static/img/b1.jpg"><br>多参加英语角和英语学习小组，进行英语口语练习。<br><img src="/static/img/b1.jpg"><br>利用网络资源，如英语学习网站、英语社交平台等，进行英语口语交流和学习。<br><img src="/static/img/b1.jpg"><br>定期参加英语口语考试，检验自己的口语水平，并及时调整学习方法和策略。'
        },
        {
          id: 2,
          title: '英语听力训练的重要性',
          cover: '/static/img/b2.jpg',
          author: '小红',
          publishTime: '2024-04-14',
          content: '英语听力是学习英语的重要组成部分，如何进行有效的听力训练？...'
        },
        {
          id: 3,
          title: '阅读英文文章的技巧',
          cover: '/static/img/b3.jpg',
          author: '小李',
          publishTime: '2024-04-13',
          content: '阅读英文文章是提高英语水平的有效方法，本文将介绍一些阅读技巧。...'
        }
      ];
    }
  },
  methods: {
    // 格式化文章内容，插入图片并首行缩进两字符
formatContent(content) {
  // 如果内容不存在或者不是字符串类型，则返回空字符串
  if (!content || typeof content !== 'string') {
    return '';
  }

  // 将文章内容按照换行符拆分成数组
  const paragraphs = content.split('<br>');
  // 新建一个数组用于存储格式化后的段落
  const formattedParagraphs = [];
  // 对每个段落进行处理
  for (let paragraph of paragraphs) {
    // 如果段落包含图片标签
    if (paragraph.includes('<img src=')) {
      // 将图片标签插入段落中
      paragraph = paragraph.replace('<img src=', '<br><img src=');
    }
    // 首行缩进两字符，拼接到格式化后的段落数组中
    formattedParagraphs.push('<div style="text-indent: 2em; word-wrap: break-word;">' + paragraph + '</div>');
  }
  // 使用 rich-text 渲染富文本内容
  return formattedParagraphs.join('');
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
  margin-bottom: 10rpx;
}

.meta {
  display: flex;
  justify-content: space-between;
  margin-bottom: 10rpx;
}

.author,
.publish-time {
  font-size: 14rpx;
  color: #666;
}

.content {
  line-height: 1.5;
}
</style>
