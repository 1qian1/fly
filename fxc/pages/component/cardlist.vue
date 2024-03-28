<template>
	<view class="card-list">
	    <view v-for="(article, index) in articles" :key="index" class="card" @click="goToArticle(article)">
	      <image :src="article.cover" class="card-cover"></image>
	      <view class="card-content" >
	        <text class="card-title" >{{ article.title }}</text>
				 <br>
	        <text class="card-summary">{{ article.summary }}</text>
	      </view>
	    </view>
	  </view>
	</view>
</template>

<script>
	export default {
		name:"cardlist",
	  data() {
	   return {
	        articles: [
	          {
	            id: 1,
	            title: '如何提高英语口语？',
	            cover: '/static/img/b1.jpg',
	            summary: '提高英语口语的方法有很多，本文将分享一些有效的技巧和建议。'
	          },
	          {
	            id: 2,
	            title: '英语听力训练的重要性',
	            cover: '/static/img/b2.jpg',
	            summary: '英语听力是学习英语的重要组成部分，如何进行有效的听力训练？'
	          },
	          {
	            id: 3,
	            title: '阅读英文文章的技巧',
	            cover: '/static/img/b3.jpg',
	            summary: '阅读英文文章是提高英语水平的有效方法，本文将介绍一些阅读技巧。'
	          }
	        ]
	       };
	     },
		 methods: {
		   // 进入文章浏览界面
		   goToArticle(article) {
		     uni.navigateTo({
		       url: '/pages/component/article?id=' + article.id
		     });
		   },
		   // 生成随机颜色
		 
		 }
	}
</script>

<style scoped>
	.card-list {
	  display: flex;
	  flex-wrap: wrap;
	  justify-content: space-between;
	}
	
	.card {
	  width: 48%;
	  margin-bottom: 20rpx;
	  border-radius: 10rpx;
	  overflow: hidden;
		 border: 1rpx solid #ddd; /* 添加边框 */
		 box-shadow: 0 2rpx 4rpx rgba(0, 0, 0, 0.1); /* 添加阴影 */
	}
	
	.card-cover {
	  width: 100%;
	  height: 200upx;
	  object-fit: cover;
	  margin-bottom: 10rpx; 
	}
	
	.card-content {
	  padding:0 20rpx;
	}
	
	.card-title {
	  font-size: 18rpx;
	  font-weight: bold;
	}
	
	.card-summary {
	  font-size: 14rpx;
	  color: #666666;
	  margin: 0;
	}
</style>