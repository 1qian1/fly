<template>
	<view class="container">
		<view class="question">
			<view class="question-title">
				<text>{{ question }}</text>
			</view>
			<view class="write-answer">
				<textarea v-model="newAnswerContent" placeholder="写回答"></textarea>
				<view class="write-answer-btn" @tap="postAnswer">回答</view>
			</view>
		</view>
		<view class="answer-list">
			<view v-for="(answer, index) in answers" :key="index" class="answer-item">
				<text class="answer-user">{{ answer.userNickname }}:</text>
				<text class="answer-content">{{ answer.answerContent }}</text>
			</view>
		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				question: '',
				answers: [],
				questionId: '', // 初始化 questionId,
				newAnswerContent: '' // 存储新回答的内容
			};
		},
		onLoad(query) {
			// query 是页面加载时获取的参数对象
			this.questionId = query.questionId;
			console.log('Received questionId:', this.questionId);
			// 在这里调用相应的接口，使用 this.questionId 做为参数来获取数据
			this.fetchQuestions();
			this.fetchQuestionContent();
		},
		methods: {
			fetchQuestionContent() {
				uni.request({
					url: 'http://localhost:8084/questions/' + this.questionId, // 在 URL 中添加问题ID作为参数
					method: 'POST',
					success: (res) => {
						this.question = res.data.questionContent;
						console.log('Question content:', this.question);
					},
					fail: (err) => {
						console.error('Error fetching question content:', err);
					}
				});
			},
			fetchQuestions() {
			    uni.request({
			        url: 'http://localhost:8084/answers/qq/' + this.questionId,
			        method: 'GET',
			        success: (res) => {
			            this.answers = res.data.reverse(); // 将回答列表逆序排列
			            console.log(res);
			        },
			        fail: (err) => {
			            console.error('Error fetching answers:', err);
			        }
			    });
			},
			postAnswer() {
				const newAnswer = {
					questionId: this.questionId,
					userId: 2, // 设置用户ID为2
					answerContent: this.newAnswerContent,
					answerDate: new Date().toISOString().slice(0, 10) // 获取当前日期并格式化为YYYY-MM-DD
				};

				uni.request({
					url: 'http://localhost:8084/answers',
					method: 'POST',
					data: newAnswer,
					success: (res) => {
						console.log('Answer posted successfully:', res);
						// 发布成功后刷新回答列表
						this.fetchQuestions();
						// 清空文本框内容
						this.newAnswerContent = '';
					},
					fail: (err) => {
						console.error('Error posting answer:', err);
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
		width: 100%;
		height: 10%;
		position: fixed;
		margin-bottom: 20rpx;
		justify-content: center;
		align-items: center;
		position: sticky;
		/* 使用 sticky 定位 */
		top: 0;
		/* 顶部定位 */
		background-color:#f0f4e4;
		/* 添加背景色，防止覆盖其他内容 */
		z-index: 9999;
	}

	.question-title {
		font-size: 18px;
		font-weight: bold;
		color: #333;
		margin-bottom: 10px;
	}

	.answer-list {
		margin-top: 20px;
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

	.write-answer {
		margin-top: 20rpx;
		justify-content: space-between;
		display: flex;
	}

	textarea {
		width: 60%;
		height: 30px;
		padding: 10rpx;
		border: 1rpx solid #ccc;
		border-radius: 5rpx;
		margin-bottom: 10rpx;
	}

	.write-answer-btn {
		width: 20%;
		height: 30px;
		margin-right: 10%;
		justify-content: center;
		align-items: center;
		background-color: #007AFF;
		color: #FFF;
		text-align: center;
		padding: 10rpx;
		border-radius: 5rpx;
		cursor: pointer;
		display: flex;
	}
</style>