<template>
	<view class="container">
		<swiper class="swiper" vertical @change="handleWordChange">
			<swiper-item v-for="(word, index) in words" :key="index">
				<view class="word">
					<view class="word-name-laba">
						<text style="font-weight: bold;">{{ word.name }}</text>

						<view class="word-info" style=" display: flex;
  align-items: center; ">
							<text class="word-spelling">{{ word.spelling }}</text>
							<laba :soundSrc="word.soundSource"></laba>
						</view>

					</view>
					<view class="word-info">
						<view class="bc-container">
							<text>词频：</text>
							<view v-for="index in word.cp" :key="index" class="bc"></view>
						</view>
						<view class="word-meaning">
							<view style='display: flex;margin-bottom: 5px;'>{{ word.cx}}
								<view style="margin-left:10px">{{word.meaning}}</view>
							</view>
							<view style="margin-bottom: 5px;">{{ word.englishExample }}</view>
							<view style="font-size: 14px;color: #666;margin-bottom: 5px;">{{ word.chineseExample }}</view>
							<View style="display: flex; ">
								<View v-for="(ct, index) in word.wordClassArray" :key="index" class="card">{{ ct }}</View>
							</View>
						</view>
					</view>

				</view>
			</swiper-item>
		</swiper>
	</view>
</template>

<script>
	import laba from '@/pages/component/laba.vue';

	export default {
		components: {
			laba
		},
		data() {
			return {
				words:[],
				tp:"cet4",
				wordClassJSON:[], 
			};
		},
		mounted(){
			this.fetchWords();
		},
		methods: {
			handleWordChange(e) {
				console.log('当前单词索引:', e.detail.current);
				// 在这里可以根据索引来处理当前显示的单词
			},
			fetchWords(){
				uni.request({
					url: 'http://localhost:8084/words/'+this.tp,
					method: 'GET',
					success: (res) => {
					
				if (Array.isArray(res.data)) {
				    res.data.forEach(item => {
				        if (item.wordClass) {
				            item.wordClassArray = item.wordClass.split(',');
				        } else {
				            console.error("wordClass 字段不存在或为空。");
				        }
				    });
				    this.words = res.data;
				} else {
				    console.error("res.data 不是一个数组。");
				}


					    console.log(res.data);
					},
					fail: (err) => {
						console.error('Error fetching words:', err);
					}
				});
			} 
		}
	};
</script>

<style scoped>
	.container {
		height: 100vh;
	}

	.word {
		margin-top: 10%;
		font-size: 24px;
		/* 	font-weight: bold; */
	}

	.word-name-laba {
		display: flex;
		justify-content: center;
		align-items: center;
		flex-direction: column;

	}

	.word-info {
		margin-top: 10px;
		font-size: 16px;
	}

	/* 	.word-info text {
		display: block;
		margin-bottom: 5px;
	} */


	.swiper {
		height: 100%;
	}

	.bc-container {
		margin-top: 20px;
		display: flex;
		align-items: center;
		margin-bottom: 10px;
		margin-left: 10%;
	}

	/* 	词频 */
	.bc {
		width: 3px;
		height: 10px;
		margin-right: 1px;
		/* 将间距调整为1% */
		background-color: #BFE5BF;
		border-radius: 2px;
		/* 添加圆角 */
	}
.word-meaning{
	margin-left: 10%;
}
	.bar:last-child {
		margin-right: 0;
		/* 最后一个小长条去掉右边距 */
	}

	.card {
		border-radius: 10px;
		/* 圆角 */
		background-color: #BFE5BF;
		/* 白色背景 */
		padding: 10px;
		/* 可以根据需要调整内边距 */
		margin-left: 10px;
		/* 间距 */
	}
</style>