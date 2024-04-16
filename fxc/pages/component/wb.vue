<template>
	<view class="content">

		<view class="dy">
			<img src="@/static/img/blod.png" alt="" @click="format('bold','')">
			<img src="@/static/img/italic.png" alt="" @click="format('italic','')">
			<img src="@/static/img/divider.png" alt="" @click="insertDivider">
			<img src="@/static/img/left.png" alt="" @click="format('align','left')">
			<img src="@/static/img/center.png" alt="" @click="format('align','center')">
			<img src="@/static/img/right.png" alt="" @click="format('align','right')">
			<img src="@/static/img/justify.png" alt="" @click="format('align','justify')">
			<img src="@/static/img/list.png" alt="" @click="format('list','ordered')">
			<img src="@/static/img/img.png" alt="" @click="insertImage">

			<button style="height: 20px;line-height: 20px;margin-left: 10px;" @click="undo">撤销</button>
			<button style="height: 20px;line-height: 20px;margin-left: 10px;" @click="getContents">保存</button>

		</view>

		<view class="title-input">
			<!-- 文章标题输入框 -->
			<input v-model="title" type="text" placeholder="请输入见闻标题" class="title-input-field">
		</view>
		<view class="wb">
			<editor :show-img-size="true" :show-img-resize="true" :show-img-toolbar="true" id="editor"
				class="ql-container" placeholder="请输入见闻内容" @ready="onEditorReady"></editor>
		</view>


	</view>
</template>

<script>
	// 以下路径需根据项目实际情况填写
	export default {
		data() {
			return {
				editorCtx: null,
				title: '', // 添加 title 属性来保存文章标题
				imageFiles: [] // 用于存储选择的图片文件
			}
		},
		created() {
			// 这里可以防止在弹框中获取不到节点
			this.$nextTick(() => {
				uni.createSelectorQuery().in(this).select('#editor').context((res) => {
					console.log("热水", res);
					this.editorCtx = res.context
				}).exec()
			})
		},
		methods: {
			onEditorReady() {
				uni.createSelectorQuery().select('#editor').context((res) => {
					// console.log("热水", res);
					this.editorCtx = res.context
				}).exec()
			},
			format(name, value) {
				this.editorCtx.format(name, value)
			},
			// 撤销
			undo() {
				this.editorCtx.undo()
			},
			// 插入下划线
			insertDivider() {
				console.log("下划线");
				this.editorCtx.insertDivider()
			},
			// 插入图片
			insertImage() {
				console.log("插入图片");
				let that = this;
				uni.chooseImage({
					count: 1, //默认9
					sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
					sourceType: ['album'], //从相册选择
					success: function(res) {
						console.log("图片地址", res);
						// 将选择的图片文件存储起来
						that.imageFiles.push(res.tempFilePaths[0]);
						// 在编辑器中插入图片
						that.editorCtx.insertImage({
							src: res.tempFilePaths[0],
							alt: "图片失效",
							extClass: "img",
							success: (res) => {
								console.log("图片成功", res);
							},
							fail: (res) => {
								console.log("图片失败", res);
							}
						})

					}
				});
			},
			// 获取编辑器内容
			getContents() {
				console.log("标题:", this.title); // 打印标题
				// 上传临时图片链接并替换为真实链接
				this.uploadImagesAndReplace();
			},
			// 上传临时图片链接并替换为真实链接
			uploadImagesAndReplace() {
				let that = this;
				// 遍历已选择的图片文件，逐个上传到后端
				this.imageFiles.forEach((filePath, index) => {
					// 上传图片逻辑，这部分代码需要根据你的后端接口来实现
					uni.uploadFile({
						url: 'http://localhost:8084/upload', // 后端接口地址
						filePath: filePath,
						name: 'file',
						success: function(res) {
							console.log('上传成功！', res.data);
							// 将返回的真实图片URL替换编辑器中对应的临时链接
							that.editorCtx.getContents({
								success: (editorContent) => {
									let content = editorContent.html;
									// 使用正则表达式替换临时链接为真实链接
									content = content.replace(new RegExp(that.imageFiles[
										index], 'g'), res.data);
									// 更新编辑器内容
									that.editorCtx.setContents({
										html: content,
										success: function(res) {
											console.log('图片链接替换成功！');
											// 如果所有图片链接都替换完成，则打印编辑器内容
											if (index === that.imageFiles
												.length - 1) {
												that.printEditorContent();
											}
										},
										fail: function(err) {
											console.error('设置编辑器内容失败！', err);
										}
									});
								},
								fail: function(err) {
									console.error('获取编辑器内容失败！', err);
								}
							});
						},
						fail: function(err) {
							console.error('上传失败！', err);
						}
					});
				});
			},
			// 打印编辑器内容
			printEditorContent() {
				console.log("编辑器内容:", this.editorCtx.action.args.html); // 打印编辑器内容
			}

		}
	}
</script>

<style>
	.content {}

	.dy {
		height: 60px;
		/* 使用固定高度代替百分比 */
		width: 100%;
		display: flex;
		align-items: center;
		justify-content: center;
		position: fixed;
		top: 0;
		z-index: 999;
		background-color: #f0f4e4;
		border: 1px solid #E5E5E5;
	}

	.dy img {
		width: 20px;
		height: 20px;
		margin-right: 8px;
	}

	.title-input {
		/* 文章标题输入框区域样式 */
		margin-top: 65px;
		padding: 10px;
	}

	.title-input-field {
		/* 文章标题输入框样式 */
		width: 81%;
		height: 30px;
		border: 1px solid #ccc;
		border-radius: 5px;
		padding: 5px;
	}

	.wb {
		margin-top: 10px;
		/* 保持原来的间距 */
		border: 1px solid #E5E5E5;
		width: 100%;
		height: 90%;
		/* 调整编辑器区域的高度 */
		overflow: auto;
		/* 添加滚动条以处理编辑器内容过多时的情况 */
	}

	.ql-container {
		width: 100%;
		height: 100%;
		/* 设置为100%以占据整个编辑器区域的高度 */
		padding: 0 15px;
	}
</style>