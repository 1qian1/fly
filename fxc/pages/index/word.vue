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
							<laba :soundSrc="word.soundSrc"></laba>
						</view>

					</view>
					<view class="word-info">
						<view class="bc-container">
							<text>词频：</text>
							<view v-for="index in word.cp" :key="index" class="bc"></view>
						</view>
						<view class="word-meaning">
							<view style='display: flex;margin-bottom: 5px;'>{{ word.cx}}
								<view style="margin-left:10px">{{word.m}}</view>
							</view>
							<view style="margin-bottom: 5px;">{{ word.en }}</view>
							<view style="font-size: 14px;color: #666;margin-bottom: 5px;">{{ word.ch }}</view>
							<View style="display: flex; ">
								<View v-for="(ct, index) in word.class" :key="index" class="card">{{ ct }}</View>
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
				words: [{
						cp: 10,
						name: 'example',
						spelling: '[ɪɡˈzɑːmpl]',
						cx: 'n.',
						m: "例子；实例；范例；典型；榜样；样品；例证；样板；模范；楷模",
						en: "Can you give me an example of what you mean ? ",
						ch: "你能给我举个实例来解释你的意思吗？",
						class: ['cet6', 'cet4', '高考'],
						soundSrc: 'http://dict.youdao.com/dictvoice?type=0&audio=example',
					},
					{
						cp: 6,
						name: 'apple',
						spelling: '[ˈæpl]',
						cx: 'n.',
						m: "苹果",
						en: "Have an apple to keep you going till dinner time ",
						ch: "吃个苹果就能挨到吃晚饭了。",
						class: ['cet6', 'cet4', '高考'],
						soundSrc: 'http://dict.youdao.com/dictvoice?type=0&audio=apple',
					},
					{
						cp: 15,
						name: 'miss',
						spelling: '[mɪs]',
						cx: 'v.',
						m: "错过；不在；思念；迟到；未达到；避开（不愉快的事）；不懂；未击中；不做；不理解；未得到；未觉察；未见到；未听到；发觉丢失",
						en: "The company has missed its profit forecast again. ",
						ch: "公司又未达到其利润预测。",
						class: ['cet6', 'cet4', '高考','小学'],
						soundSrc: 'http://dict.youdao.com/dictvoice?type=0&audio=miss',
					},


					// 可以继续添加更多的单词
				],
			};
		},
		methods: {
			handleWordChange(e) {
				console.log('当前单词索引:', e.detail.current);
				// 在这里可以根据索引来处理当前显示的单词
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