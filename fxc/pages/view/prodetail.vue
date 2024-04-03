<template>
	<view class="container">
		<view class="question">
			<text class="question-title">{{ question }}</text>
		<!-- 	<text class="question-info">{{ answers.length }} 回答 </text> -->
		</view>
		<view class="answer-list">
			<view v-for="(answer, index) in answers" :key="index" class="answer-item">
				<text class="answer-user">{{ answer.userNickname }}:</text>
				<text class="answer-content">{{ answer.answerContent }}</text>
			</view>
		</view>
		<view class="write-answer-btn" @tap="goToAnswerPage">写回答</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				 question:'',
				answers: [],
				questionId: '' // 初始化 questionId,
			};
		},
		onLoad(query) {
		    // query 是页面加载时获取的参数对象
		    this.questionId = query.questionId;
		    console.log('Received questionId:', this.questionId);
		    // 在这里调用相应的接口，使用 this.questionId 做为参数来获取数据
		  },
		mounted() {
			this.fetchQuestions();
		},
		methods: {
			fetchQuestions() {
				uni.request({
					url: 'http://localhost:8084/answers/qq/'+ this.questionId, // 在 URL 中添加问题ID作为参数,
					method: 'GET',
					success: (res) => {
						this.answers = res.data;
						this.question=res.data[0].questionContent;
						console.log(res)
					},
					fail: (err) => {
						console.error('Error fetching answers:', err);
					}
				});
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