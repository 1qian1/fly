<template>
	<view class="container">
		<swiper class="swiper" vertical @change="handleWordChange">
			<swiper-item v-for="(word, index) in words" :key="index">
				<view class="word">
					<view class="word-name-laba">
						<text>{{ word.name }}</text>

						<view class="word-info" style=" display: flex;
  align-items: center; ">
							<text class="word-spelling">{{ word.spelling }}</text>
							<laba :soundSrc="word.soundSrc"></laba>
						</view>

					</view>
					<view class="word-info">
						<view class="bc-container">
						  <text >词频：</text>
						  <view v-for="index in 25" :key="index" class="bc"></view>
						</view>
						<text class="word-meaning">释义：{{ word.meaning }}</text>
						<text class="word-type">词性：{{ word.partOfSpeech }}</text>
						<text class="word-phrases">常见词组：{{ word.commonPhrases }}</text>
						<text class="word-example">例句：{{ word.example }}</text>
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
						name: 'example',
						spelling: '/ɪɡˈzæmpl/',
						meaning: 'something chosen to show what a whole is like',
						partOfSpeech: 'noun',
						commonPhrases: 'for example, set an example, follow the example',
						soundSrc: '/static/mp3/example.mp3',
						example: 'For example, this is a sentence using the word "example".'
					},
					{
						name: 'apple',
						spelling: '/ˈæpl/',
						meaning: 'a round fruit with red or green skin and a whitish inside',
						partOfSpeech: 'noun',
						commonPhrases: 'an apple a day keeps the doctor away, apple pie, apple juice',
						soundSrc: '/static/mp3/apple.mp3',
						example: 'She eats an apple every day.'
					},
					{
						name: 'banana',
						spelling: '/bəˈnæn.ə/',
						meaning: 'a long, curved fruit with a yellow skin and soft, sweet flesh',
						partOfSpeech: 'noun',
						commonPhrases: 'banana peel, banana split',
						soundSrc: '/path/to/banana-sound.mp3',
						example: 'He grabbed a banana as a snack.'
					},
					{
						name: 'computer',
						spelling: '/kəmˈpjuː.t̬ɚ/',
						meaning: 'an electronic machine that can store and arrange large amounts of information, and do many different types of work',
						partOfSpeech: 'noun',
						commonPhrases: 'personal computer, laptop computer',
						soundSrc: '/path/to/computer-sound.mp3',
						example: 'I use a computer for work.'
					}
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
		font-size: 24px;
		font-weight: bold;
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

	.word-info text {
		display: block;
		margin-bottom: 5px;
	}

	.swiper {
		height: 100%;
	}
	.bc-container {
		margin-top: 20px;
	   display: flex;
	   align-items: center;
	}
/* 	词频 */
	 .bc{
		 
	  width: 3px;
	  height: 10px;
	  margin-right: 1px; /* 将间距调整为1% */
	  background-color: #BFE5BF;
	  border-radius: 2px; /* 添加圆角 */
	}
	.bar:last-child {
	  margin-right: 0; /* 最后一个小长条去掉右边距 */
	}
	
</style>