<template>
  <view class="container">
    <!-- 个人信息区域 -->
    <view class="profile-section">
      <view class="profile-header">
        <text class="check-icon">✓</text>
        <text class="profile-title">我的内容</text>
        <text class="settings-icon">⚙️</text>
      </view>
      <view class="cards-container">
        <view class="card">
          <view class="card-title">回顾</view>
          <view class="card-content">
            <text>0词</text>
            <image class="play-icon" src="/static/play.png"></image>
          </view>
        </view>
        <view class="card">
          <view class="card-title">预习</view>
          <view class="card-content">
            <text>20词</text>
            <image class="play-icon" src="/static/play.png"></image>
          </view>
        </view>
      </view>
      <view class="review-button">回顾</view>
    </view>

    <!-- 功能列表区域 -->
    <view class="feature-list">
      <view class="feature-item">
        <image class="feature-icon" src="/static/notebook.png"></image>
        <text class="feature-text">在学词书</text>
        <text class="feature-count">6592 词</text>
      </view>
      <view class="feature-item">
        <image class="feature-icon" src="/static/calendar.png"></image>
        <text class="feature-text">近日回顾</text>
        <text class="feature-count">2020 词</text>
      </view>
      <!-- ... 其他功能项 -->
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      // ...
    };
  },
  // ...
};
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  background-color: #f9f9f9;
}

.profile-section {
  background-color: #FFEDE7;
  padding: 20rpx;
}

.profile-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20rpx;
}

.check-icon, .settings-icon {
  font-size: 28rpx;
}

.profile-title {
  font-size: 32rpx;
  font-weight: bold;
}

.cards-container {
  display: flex;
  justify-content: space-around;
}

.card {
  background-color: #ffffff;
  box-shadow: 0 2rpx 4rpx rgba(0, 0, 0, 0.1);
  border-radius: 10rpx;
  padding: 20rpx;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.card-title {
  color: #666666;
  font-size: 28rpx;
  margin-bottom: 10rpx;
}

.card-content {
  display: flex;
  align-items: center;
}

.play-icon {
  width: 40rpx;
  height: 40rpx;
  margin-left: 10rpx;
}

.review-button {
  background-color: #5BC8AF;
  color: white;
  text-align: center;
  padding: 20rpx;
  border-radius: 20rpx;
  margin-top: 20rpx;
}

.feature-list {
  margin-top: 20rpx;
}

.feature-item {
  display: flex;
  align-items: center;
  padding: 20rpx;
  background-color: #ffffff;
  margin-bottom: 2rpx;
}

.feature-icon {
  width: 50rpx;
  height: 50rpx;
  margin-right: 20rpx;
}

.feature-text {
  flex: 1;
  font-size: 28rpx;
  color: #333333;
}

.feature-count {
  font-size: 24rpx;
  color: #999999;
}
</style>
