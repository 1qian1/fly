<template>
  <view class="container">
    <button @tap="chooseImage">选择图片</button>
    <image v-if="imageUrl" :src="imageUrl" mode="aspectFit" style="width: 300px; height: 300px;" @tap="previewImage"></image>
  </view>
</template>

<script>
export default {
  data() {
    return {
      imageUrl: '' // 存储图片路径
    }
  },
  methods: {
    // 选择图片
    chooseImage() {
      uni.chooseImage({
        count: 10, // 一次只能选择一张图片
        success: (res) => {
          let filePath = res.tempFilePaths[0];
          this.uploadImage(filePath);
        },
        fail: (err) => {
          console.error('Image selection failed:', err);
        }
      });
    },
    // 上传图片
    uploadImage(filePath) {
      // 将图片保存到 /static/jw 目录下
      let savePath = '/static/jw/' + this.getFileName(filePath); // 构建保存路径
      console.log('Saving image to path:', savePath);

 // 保存图片到本地
  uni.saveFile({
    tempFilePath: filePath,
    filePath: savePath,
    success(res) {
      // 保存成功后将图片路径保存到data中
      that.imageUrl = savePath;
      console.log('Image URL:', that.imageUrl);
    },
    fail(err) {
      console.error('Image save failed:', err);
    }
  });
      // 模拟保存操作，实际应替换为真实保存逻辑
      // 延迟1秒钟模拟保存过程
      setTimeout(() => {
        // 保存成功后将图片路径保存到data中
        this.imageUrl = savePath;
        console.log('Image URL:', this.imageUrl);
      }, 1000);
    },
    // 预览图片
    previewImage() {
      if (this.imageUrl) {
        uni.previewImage({
          urls: [this.imageUrl]
        });
      }
    },
    // 获取文件名
    getFileName(filePath) {
      let index = filePath.lastIndexOf('/');
      return filePath.substring(index + 1);
    }
  }
}
</script>

<style>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
}
</style>
