<template>
     <view class="container" >
       <!-- 轮播图 -->
       <lunbo></lunbo>
   
       <!-- 文章卡片列表 -->
	   <cardlist></cardlist>
	   </view>
   </template>
   
   <script>
	   	import lunbo from '@/pages/component/lunbo.vue';
		import cardlist from '@/pages/component/cardlist.vue';
   export default {
  components: {
    lunbo,
	cardlist,
  },
    
   };
   </script>
   
   <style scoped>
   .container {
     padding: 20rpx;
   }
   </style>
