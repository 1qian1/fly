<template>
  <view>
    <!-- 显示留言列表 -->
    <view class="message" v-for="(message, index) in messages" :key="index">
      <view class="message-content">
        <view class="content">{{ message.content }}</view>
        <view class="source">
          <text>发布于{{ message.date }} </text>
          <text>出自“{{ message.source }}”</text>
        </view>
      </view>
    </view>

    <!-- 悬浮按钮 -->
    <view class="floating-button" @click="showInputDialog">+</view>

    <!-- 输入框弹窗 -->
    <view class="input-dialog" v-if="showDialog">
      <view class="input-container">
        <textarea v-model="newMessage" placeholder="请输入留言内容"></textarea>
        <view class="button-container">
          <button @click="publishMessage">发布</button>
          <button @click="cancelMessage">取消</button>
        </view>
      </view>
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
     messages: [
		 
		 {
		 		content: "而在这里，你会看到一个不同的我，一个在生活中发现美，感受痛苦，洞察人性的我。",
		 		date: "24年3月31日",
		 		source: "雨爱"
		 	},
		 {
		 		content: "当第一颗卫星飞向大气层外，我们便以为自己终有一日会征服宇宙。",
		 		date: "24年3月31日",
		 		source: "雨爱"
		 	},
		 {
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
     ],
      showDialog: false,
      newMessage: ""
    };
  },
  methods: {
    // 点击悬浮按钮显示输入框
    showInputDialog() {
      this.showDialog = true;
    },
    // 点击确认发布按钮
    publishMessage() {
      if (this.newMessage.trim() !== "") {
        const currentDate = this.getCurrentDate();
        const newMessage = {
          content: this.newMessage,
          date: currentDate,
          source: "用户"
        };
        // 将新留言添加到留言列表的顶部
        this.messages.unshift(newMessage);
        this.newMessage = ""; // 清空输入框
      }
      this.showDialog = false; // 关闭输入框
    },
    // 点击取消按钮
    cancelMessage() {
      this.showDialog = false; // 关闭输入框
    },
    // 获取当前日期
    getCurrentDate() {
      const currentDate = new Date();
      const year = currentDate.getFullYear();
      const month = currentDate.getMonth() + 1;
      const day = currentDate.getDate();
      return `${year}年${month}月${day}日`;
    }
  }
};
</script>

<style scoped>
  /* 样式可自行修改 */
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
  .input-dialog {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: rgba(0, 0, 0, 0.5); /* 半透明背景 */
    z-index: 9998; /* 确保在按钮之上，但比底层页面低 */
  }
  .input-container {
    width: 70%;
    max-width: 400px;
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.3);
  }
  .input-container textarea {
    width: 90%;
    height: 100px;
    margin-bottom: 20px;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    resize: none;
  }
  .button-container {
	
    display: flex;
    justify-content: space-between;
  }
  .button-container button {
    padding: 10px 20px;
    border-radius: 4px;
    cursor: pointer;
	height: 60px;;
  }
</style>
