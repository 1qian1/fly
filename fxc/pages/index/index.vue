<template>
	<view>
		<view class="card" style="	margin-top: 20%;
		margin-left: 22.5%;" @click="goToOneWord">
			<view class="card-content">
				<!-- 留言内容 -->
				<text class="title">一言</text>
				<text class="description">心灵的微语</text>
			</view>
		</view>
		<view style="display: flex;justify-content: space-between;align-items: center;margin-top: 50%;">
			<view class="card" style="width: 30%;margin-left: 5%;" @click="goToQuestionAnswer">
				<view class="card-content">
					<!-- 留言内容 -->
					<text class="title">问答</text>
					<text class="description">思想的火花</text>
				</view>
			</view>
			<view class="card" style="width: 30%;margin-right: 5%;" @click="goToObservation">
				<view class="card-content">
					<!-- 留言内容 -->
					<text class="title">见闻</text>
					<text class="description">生活的观察</text>
				</view>
			</view>
		</view>


	</view>
</template>
<script>
	export default {
		methods: {
		         goToOneWord() {
		                uni.navigateTo({
		                    url: '/pages/view/oneWord' // 替换成你的一言页面路径
		                });
		            },
		            goToQuestionAnswer() {
		                uni.navigateTo({
		                    url: '/pages/view/questionAnswer' // 替换成你的问答页面路径
		                });
		            },
		            goToObservation() {
		                uni.navigateTo({
		                    url: '/pages/view/observation' // 替换成你的见闻页面路径
		                });
		            }
		    }
	}
</script>
<style>
	/* 卡片容器样式 */
	.card {
		/* 水平居中对齐*/
		display: flex;
		justify-content: center;
		align-items: center;
		width: 48%;
		/* 设置卡片宽度 */
		height: 80px;
		/* 设置卡片高度 */
		background-color: #f0f0f0;
		/* 设置卡片背景色 */
		border-radius: 10px;
		/* 设置卡片边框圆角 */
		padding: 10px;
		/* 设置卡片内边距 */
		box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
		/* 设置卡片阴影 */

	}


	/* 卡片内容样式 */
	.card-content {
		justify-content: center;
		display: flex;
		align-items: center;
		flex-direction: column;
		justify-content: space-between;
	}

	.title {
		font-size: 16px;
		font-weight: bold;
	}

	.description {
		font-size: 14px;
		color: #666;
	}
</style>