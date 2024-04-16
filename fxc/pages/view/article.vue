<template>
	<view class="container">
		<view class="title">{{ newsTitle }}</view>
		<view class="content" v-html="newsContent"></view>
		<view class="publish-time">{{ publishTime }}</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				newsTitle: "",
				newsContent: "",
				publishTime: ""
			};
		},
		onLoad(options) {
			// 从页面参数中获取文章ID
			const newsId = options.id;
			// 调用方法获取新闻详情数据
			this.fetchNewsDetail(newsId);
		},
		methods: {
			fetchNewsDetail(newsId) {
				// 这里需要调用后端接口获取新闻详情数据
				// 假设后端接口地址为 http://localhost:8084/news/{newsId}
				uni.request({
					url: `http://localhost:8084/news/${newsId}`,
					method: "post",
					success: (res) => {
						const data = res.data;
						this.newsTitle = data.newsTitle;
						 this.newsContent = data.newsContent;
						this.publishTime = data.publishTime;
						
					},
					fail: (err) => {
						console.error("获取新闻详情失败:", err);
					}
				});
			},

		}
	};
</script>

<style>
	.container {
		padding: 20px;
	}
.cc {
    display: block;
    margin: 0 auto;
}

	.title {
		font-size: 24px;
		font-weight: bold;
		margin-bottom: 10px;
	}

	.content {
		margin-bottom: 20px;
	}


	.publish-time {
		color: #999;
	}


</style>