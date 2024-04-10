<template>
  <view class="container">
    <editor
      ref="editor"
      class="editor"
      :placeholder="placeholder"
      @ready="onEditorReady"
      @statuschange="onEditorStatusChange"
    ></editor>
    <button @click="uploadImage">上传图片</button>
    <button @click="publish">发布</button>
  </view>
</template>

<script>
export default {
  data() {
    return {
      placeholder: "请输入见闻内容",
      editorContent: "",
      editor: null
    };
  },
  methods: {
    onEditorReady() {
      // 编辑器准备就绪
      this.editor = this.$refs.editor;
    },
    onEditorStatusChange(e) {
      // 编辑器内容变化时的处理
      this.editorContent = e.detail.html;
    },
    uploadImage() {
      // 上传图片
      uni.chooseImage({
        count: 1,
        success: (res) => {
          const tempFilePath = res.tempFilePaths[0];
          uni.uploadFile({
            url: 'YOUR_UPLOAD_URL',
            filePath: tempFilePath,
            name: 'image',
            success: (uploadRes) => {
              const imageUrl = uploadRes.data;
              this.editor.insertImage({ src: imageUrl });
            }
          });
        }
      });
    },
    publish() {
      // 发布见闻
      // 将 this.editorContent 提交到后端保存
      console.log("发布见闻：", this.editorContent);
    }
  }
};
</script>

<style scoped>
.container {
  padding: 20px;
}
.editor {
  width: 100%;
  height: 300px;
  border: 1px solid #ccc;
  margin-bottom: 10px;
}
button {
  margin-top: 10px;
}
</style>
