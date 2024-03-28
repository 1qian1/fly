<template>
	<swiper class="swiper" autoplay interval="3000" circular>
	  <swiper-item v-for="(item, index) in swiperItems" :key="index">
	    <image :src="item.image" class="swiper-image"></image>
	  </swiper-item>
	</swiper>
</template>
<script>
	export default {
		name:"lunbo",
	  data() {
	   return {
	         // 模拟轮播图数据
	         swiperItems: [
	           { image: '/static/img/th.jpg' },
	           { image: '/static/img/th2.jpg' },
	           { image: '/static/img/th3.jpg' }
	         ]
	       };
	     },
	}
</script>

<style  scoped>
	.swiper {
	  height: 300rpx;
		 width:100%;
	  margin-bottom: 20rpx;
	}
	
	.swiper-image {
	  width: 100%;
	  height: 100%;
	  border-radius: 10rpx;
	}
	
</style>