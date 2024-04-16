<template>
	<view class="container">
		<!-- 轮播图 -->
		<swiper class="swiper" autoplay interval="3000" circular>
			<swiper-item v-for="(item, index) in swiperItems" :key="index">
				<image :src="item.image" class="swiper-image"></image>
			</swiper-item>
		</swiper>

		<!-- 文章卡片列表 -->
		<view class="card-list">
			<view v-for="(article, index) in articles" :key="index" class="card" @click="goToArticle(article)">
				<!-- <image :src="article.cover" class="card-cover"></image> -->
				<view class="card-content">
					<text class="card-title">{{ article.newsTitle }}</text>
					<br>
					<text class="card-summary">{{ article.publishTime}}</text>
				</view>
			</view>
		</view>
			<view class="floating-button"  @click="navigateToJWPage">+</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				// 模拟轮播图数据
				swiperItems: [{
						image: '/static/img/th.jpg'
					},
					{
						image: '/static/img/th2.jpg'
					},
					{
						image: '/static/img/th3.jpg'
					}
				],
				articles: []
			};
		},
		created() {
			// 调用方法获取文章数据
			this.fetchArticles();
		},
		methods: {
			// 获取文章数据
			fetchArticles() {
				// 这里需要调用后端接口获取文章数据
				// 假设后端接口地址为 http://localhost:8084/articles
				uni.request({
					url: 'http://localhost:8084/news', // 更换为后端接口地址
					method: 'GET',
					success: (res) => {
						this.articles = res.data; // 更新 articles 数组
					},
					fail: (err) => {
						console.error('获取文章列表失败:', err);
					}
				});
			},
			// 进入文章浏览界面
			goToArticle(article) {
				uni.navigateTo({
					url: '/pages/view/article?id=' + article.newsId
				});
			},
			// 进入发布界面
			navigateToJWPage() {
				uni.navigateTo({
					url: '/pages/view/jw' // jw 页面的路径
				});
			}
		}
	};
</script>


<style scoped>
	.container {
		padding: 20rpx;
	}

	.swiper {
		height: 300rpx;
		width: 100%;
		margin-bottom: 20rpx;
	}

	.swiper-image {
		width: 100%;
		height: 100%;
		border-radius: 10rpx;
	}

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
		background-color: #ffffff;;
		border: 1rpx solid #ddd;
		/* 添加边框 */
		box-shadow: 0 2rpx 4rpx rgba(0, 0, 0, 0.1);
		/* 添加阴影 */
	}

	.card-cover {
		width: 100%;
		height: 200upx;
		object-fit: cover;
		margin-bottom: 10rpx;
	}

	.card-content {
		padding: 0 20rpx;
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

	.floating-button {
		display: flex;
		justify-content: center;
		align-items: center;
		position: fixed;
		bottom: 10%;
		right: 20px;
		width: 45px;
		height: 45px;
		line-height: 60px;
		background-color: rgba(255, 255, 255, 0.7);
		/* 白色，透明度为 0.8 */

		text-align: center;
		border-radius: 50%;
		cursor: pointer;
		box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.3);
		z-index: 9999;
		/* 确保按钮在页面上其他元素之上 */
	}
</style>