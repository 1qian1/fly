<template>
	<view class="container">
		<!-- 用户头像及昵称 -->
		<view class="avatar-container">
			<image class="avatar" :src="userData.avatar"></image>
			<text class="nickname">{{ userData.nickname }}</text>
		</view>


		<!-- 用户所选择的单词书 -->
		<view class="big-card">
			<view class="small-card" @click="wordselect">
				<uni-icons type="wallet">正在学习</uni-icons>
				<text>{{ userData.selectedBook }}</text>
				<text>></text>
			</view>
			<view class="small-card">
				<uni-icons type="wallet-filled">自定义单词本</uni-icons>
			
				<text>></text>
			</view>
		<!-- 	发音 -->
			<view class="small-card">
				
						<uni-icons type="sound-filled">发音</uni-icons>
                <view class="pronunciation-buttons">
                      <button class="pronunciation-button" :class="{ active: currentPronunciation === 'us' }" @tap="selectPronunciation('us')">US</button>
                      |
                      <button class="pronunciation-button" :class="{ active: currentPronunciation === 'uk' }" @tap="selectPronunciation('uk')">UK</button>
                    </view>
                 
			</view>
			<view class="small-card">
				<text>外观</text>
			</view>

			<!-- 展开的单词选择卡片 -->
			<view v-if="isWordSelectVisible" class="select-card">
				<!-- 关闭按钮 -->
				<view style="display: flex; justify-content: space-between;margin-top: 10px;">
					<view style="align-items: center;margin-left: 10px;">切换单词本</view>
					<view class="close-button" @click="closeWordSelect">关闭</view>
				</view>
				<!-- 单词选择项 -->
				<view v-for="(content, index) in cardContents" :key="index" class="select-item">
					<view class="ch">
						<text>{{ content }}</text>
						<text>共计{{ wordCounts[index] }}个单词</text>
					</view>
					<!-- 根据条件显示不同的按钮 -->
					<view class="but" @click="switchword(content)">
						<text v-if="userData.selectedBook === content">当前单词本</text>
						<text v-else>切换</text>
					</view>
				</view>

			</view>
		</view>
		<!-- 遮罩层 -->
		<view v-if="isWordSelectVisible" class="mask" @click="closeWordSelect" @touchmove.stop=""></view>

	</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				 currentPronunciation: 'us',
				isWordSelectVisible: false, // 控制单词选择卡片的显示
				cardContents: ['中考词汇', '高考词汇', 'CET-4 四级词汇', 'CET-6 六级词汇', '专升本词汇', '英语专业四级词汇', '英语专业八级词汇', '考研英语词汇',
					'IELTS 雅思词汇', 'TOEFL 托福词汇'
				],
				wordCounts: [100, 200, 300, 400, 500, 600, 700, 800, 900, 1000], // 对应的单词数量
				userData: {
					avatar: '/static/img/b1.jpg', // 用户头像
					nickname: 'User123', // 用户昵称
					selectedBook: 'CET-4 四级词汇', // 用户所选择的单词书
					message: '您有一条新消息', // 用户的消息
					customDictionary: '自定义单词本' // 用户的自建单词本
				}
			};
		},
		methods: {
			selectPronunciation(pronunciation) {
			      if (pronunciation === 'us') {
			        this.pronunciationText = '美式发音';
			        this.currentPronunciation = 'us';
			      } else {
			        this.pronunciationText = '英式发音';
			        this.currentPronunciation = 'uk';
			      }
			    },
			wordselect() {
				this.isWordSelectVisible = true;
			},
			closeWordSelect() {
				// 关闭单词选择卡片
				this.isWordSelectVisible = false;
			},
			switchword(content) {
				this.userData.selectedBook = content;
				this.closeWordSelect(); // 关闭展开的卡片

			}
		}

	};
</script>

<style scoped>
	.container {
		padding: 20px;
	}

	/* 头像和昵称 */
	.avatar-container {
		text-align: center;
		display: flex;
		flex-direction: column;
		align-items: center;
	}

	.avatar {
		width: 90px;
		height: 90px;
		border-radius: 50%;
	}

	.nickname {
		font-size: 18px;
		margin-top: 10px;
	}

	/* 单词等组件 */
	.big-card {
		background-color: #ffffff;
		padding: 20px;
		margin-top: 20px;
		border-radius: 8px;
		box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
	}

	.small-card {
		background-color: #ffffff;
		justify-content: space-between;
		display: flex;
		align-items: center;
		padding: 10px;
		border-bottom: 1px solid #ccc;

		/* 添加下划线 */
	}

	/* 最后一个 .small-card 不显示底部下划线 */
	.small-card:last-child {
		border-bottom: none;
		/* 最后一个不显示底部下划线 */
	}

	/* 	选择卡片 */
	.select-card {
		position: fixed;

		bottom: 0;
		left: 0;
		width: 100%;
		max-height: 75%;
		/* 占据页面75%的高度 */
		overflow-y: auto;
		/* 添加滚动条 */
		background-color: #fff;
		border-top-left-radius: 10px;
		border-top-right-radius: 10px;
		box-shadow: 0 -4px 4px rgba(0, 0, 0, 0.1);
		/* 从底部弹出的阴影 */
		z-index: 1000;
		/* 确保在最上层 */

	}

	.select-item {
		background-color: #f9f9f9;
		justify-content: space-between;
		display: flex;
		align-items: center;
		padding: 20px;
		margin-top: 20px;
		border-radius: 8px;
		border: 1px solid #f9f9f9;
	}

	/* 遮罩层样式 */
	.mask {
		position: fixed;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		background-color: rgba(0, 0, 0, 0.3);
		/* 半透明黑色 */
		z-index: 999;
		/* 确保在卡片之上 */
	}

	/* 关闭按钮样式 */
	.close-button {
		cursor: pointer;
	}

	/* 选择内容 */
	.ch {
		display: flex;
		flex-direction: column;
	}

	.but {
		cursor: pointer;
		border: 1px solid #00ff00;
		/* 绿色边框 */
		padding: 5px 10px;
		/* 调整按钮内边距 */
		border-radius: 4px;
		/* 圆角 */
	}
/* 	发音 */
.pronunciation-buttons {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #f9f9f9;
  border:1 solid #f9f9f9 ; 
}
.pronunciation-button {
  flex: 1;
  height: 60upx;
  line-height: 60upx;
  text-align: center;
}

.active {
  background-color: lightblue;
}
</style>