<template>
  <view class="container">
    <!-- 单词展示区域 -->
    <view class="word-display">
      <text class="word">capture</text>
      <text class="phonetic">/ˈkæptʃər/</text>
	  <br>
      <view class="meaning">
        <text>n. the act of forcibly dispossessing an owner of property</text>
        <text>n. a process whereby a star or planet holds an object in its gravitational field</text>
        <!-- ... 其他定义 ... -->
      </view>
      <view class="example">
        <text>She captured all the men's hearts</text>
        <text>她俘获了所有男人的心。</text>
      </view>
      <view class="operation-bar">
        <button class="operation-button favorite">⭐</button>
        <button class="operation-button trash">🗑️</button>
        <button class="operation-button more">•••</button>
      </view>
    </view>

    <!-- 底部导航区域 -->
    <view class="bottom-nav">
      <view class="nav-item">
        <image class="nav-icon" src="/static/book.png"></image>
        <text>单词</text>
      </view>
      <view class="nav-item">
        <image class="nav-icon" src="/static/search.png"></image>
        <text>搜索</text>
      </view>
      <view class="nav-item">
        <image class="nav-icon" src="/static/stats.png"></image>
        <text>图表</text>
      </view>
      <view class="nav-item">
        <image class="nav-icon" src="/static/settings.png"></image>
        <text>设置</text>
      </view>
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      // 数据部分
    };
  },
  methods: {
    // 方法部分
  }
}
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  font-family: "Arial", sans-serif;
  height: 100%;
  background-color: #F7F7F7;
}

.word-display {
  flex: 1;
  padding: 30rpx;
  text-align: center;
}

.word {
  font-size: 50rpx;
  font-weight: bold;
  margin-bottom: 20rpx;
}

.phonetic {
  font-size: 32rpx;
  color: #787878;
}

.meaning {
  text-align: left;
  margin-top: 20rpx;
}

.example {
  background-color: #E8F5E9;
  padding: 20rpx;
  margin-top: 30rpx;
}

.operation-bar {
  display: flex;
  justify-content: space-around;
  margin-top: 30rpx;
}

.operation-button {
  font-size: 50rpx;
}

.bottom-nav {
  display: flex;
  justify-content: space-around;
  background-color: #FFF;
}

.nav-item {
  align-items: center;
  padding: 20rpx;
}

.nav-icon {
  width: 50rpx;
  height: 50rpx;
}
</style>
