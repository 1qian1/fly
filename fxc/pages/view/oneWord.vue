<template>
	<view>
		<view class="message" v-for="(message, index) in messages">
			<view class="message-content">
				<view class="content">{{ message.content }}</view>
				<view class="source">
					<text>发布于{{ message.date }} </text>
					<text>出自“{{ message.source }}”</text>
				</view>
			</view>
		</view>
		<view class="floating-button"  @click="handleButtonClick">+</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				messages: [{
						content: "世事无常，生命是短暂的，我们都活在生死边缘，哪怕只有一天，一刹那，我们都想要活下去。",
						date: "23年7月5日",
						source: "铃芽户缔"
					},
					{
						content: "有的时候，这个世界看上去是灰色的。不像梦里，那么五彩斑斓。可是就算是这样，也一定有一些光亮在等着你，哪怕只是些很小的瞬间，也值得你努力活下去。",
						date: "23年3月26日",
						source: "深海"
					},
					{
						content: "世界上最无耻最阴险、最歹毒的赞美，就是用穷人的艰辛和苦难，当做励志故事愚弄底层人。",
						date: "22年7月30日",
						source: "王朔"
					},
					{
						content: "井底之蛙，不知大海之宽广，却知晓天空之蓝。",
						date: "20年12月19日",
						source: "知晓天空之蓝的人啊"
					},
					{
						content: "没有任何一个成功不冒风险，直面风险，豁出去干。成功往往不是规划出来的，危机是你想不到的机会。",
						date: "20年8月12日",
						source: "雷军"
					}
				]
			};
		},
		methods: {
			handleButtonClick() {
				// 点击按钮时的操作
				console.log('按钮被点击了！');
			}
		}
	}
</script>

<style scoped>
	
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
</style>