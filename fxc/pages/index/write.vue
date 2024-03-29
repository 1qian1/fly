<template>
  <view class="bc-container">
    <view v-for="index in 25" :key="index" class="bc"></view>
  </view>
</template>

<style scoped>
.bc-container {
	margin-top: 20px;
	margin-left: 20px;
  display: flex;
  align-items: center;
}

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
