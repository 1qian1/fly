<template>
	<view>
		<!-- 显示留言列表 -->
		<view class="message" v-for="(message, index) in messages" :key="index">
			<view class="message-content">
				<view class="content">{{ message.messageContent }}</view>
				<view class="source">
					<text>{{ message.messageDate }} </text>
					<text>出自“{{ message.userNickname }}”</text>
				</view>
			</view>
		</view>

		<!-- 悬浮按钮 -->
		<view class="floating-button" @click="showInputDialog">+</view>

		<!-- 输入框弹窗 -->
		<view class="input-dialog" v-if="showDialog">
			<view class="input-container">
				<textarea v-model="newMessage" placeholder="请输入留言内容"></textarea>
				<view class="button-container">
					<button @click="publishMessage">发布</button>
					<button @click="cancelMessage">取消</button>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				userId: 1,
				messages: [],
				showDialog: false,
				newMessage: "",
				currentDate: '', // 存储当前日期
			};
		},
		mounted() {
			this.fetchMessages();
			const currentDate = new Date();
			this.currentDate = currentDate;
		},
		methods: {
			//获取留言
			fetchMessages() {
				uni.request({
					url: 'http://localhost:8084/messages',
					method: 'GET',
					success: (res) => {
						// 将后端返回的留言数据保存到 messages 数组中
						this.messages = res.data.map(message => {
							const messageDate = new Date(message.messageDate);
							const year = messageDate.getFullYear().toString().slice(-2);
							const month = (messageDate.getMonth() + 1).toString().padStart(2, '0');
							const day = messageDate.getDate().toString().padStart(2, '0');
							message.messageDate = `${year} 年 ${month} 月 ${day} 日`;
							return message;
						});

					},
					fail: (err) => {
						console.error('Error fetching messages:', err);
					}
				});
			},







			// 点击悬浮按钮显示输入框
			showInputDialog() {
				this.showDialog = true;
			},
			// 点击确认发布按钮
			publishMessage() {
				// 构建问题对象
				const messageData = {
					userId: this.userId,
					messageContent: this.newMessage,
					messageDate: this.currentDate // 使用当前日期
				};

				// 发送留言数据到后端
				uni.request({
					url: 'http://localhost:8084/messages', // 修改为后端接收问题数据的URL
					method: 'POST',
					data: messageData,
					success: (res) => {
						console.log('Message published successfully:', res);
						// 刷新问题数据
						this.fetchMessages();
					},
					fail: (err) => {
						console.error('Error publishing message:', err);
					}
				});
				this.newMessage = ""; // 清空输入框
				this.showDialog = false; // 关闭输入框
			},
			// 点击取消按钮
			cancelMessage() {
				this.showDialog = false; // 关闭输入框
			},

		}
	};
</script>

<style scoped>
	/* 样式可自行修改 */
	.message {
		border: 2px solid #ff8d2a;
		padding: 10px;
		margin-left: 5%;
		margin-top: 4%;
		margin-bottom: 4%;
		border-top: 0;
		border-right: 0;
		border-bottom: 0;
	}

	.message-content {
		display: flex;
		flex-direction: column;
	}

	.content {
		font-size: 16px;
		margin-bottom: 10px;
	}

	.source {
		display: flex;
		align-items: center;
		justify-content: space-between;
		font-size: 12px;
		color: #666;
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

	.input-dialog {
		position: fixed;
		top: 0;
		left: 0;
		right: 0;
		bottom: 0;
		display: flex;
		align-items: center;
		justify-content: center;
		background-color: rgba(0, 0, 0, 0.5);
		/* 半透明背景 */
		z-index: 9998;
		/* 确保在按钮之上，但比底层页面低 */
	}

	.input-container {
		width: 70%;
		max-width: 400px;
		background-color: #fff;
		padding: 20px;
		border-radius: 8px;
		box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.3);
	}

	.input-container textarea {
		width: 90%;
		height: 100px;
		margin-bottom: 20px;
		padding: 10px;
		border: 1px solid #ccc;
		border-radius: 4px;
		resize: none;
	}

	.button-container {

		display: flex;
		justify-content: space-between;
	}

	.button-container button {
		padding: 10px 20px;
		border-radius: 4px;
		cursor: pointer;
		height: 60px;
		;
	}
</style>