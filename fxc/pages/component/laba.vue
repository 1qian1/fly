<template>
	<view>
	<i class="iconfont" style="color: #00aaff;font-size:16px;margin-left:20px;" @click="playSound">&#xe600</i>
	</view>
</template>

<script>
	
		
	export default{
		name:"laba",
		  methods: {
		    playSound() {
		         const innerAudioContext = wx.createInnerAudioContext();
		         innerAudioContext.src = this.soundSrc;
		         innerAudioContext.play();
		       }
		  },
		  props: {
		    soundSrc: String // 音频路径的 prop
		  }
	}
	
</script>

<style lang=scss scoped>
	@font-face {
	  font-family: "iconfont"; /* Project id 4457931 */
	  src: url('https://at.alicdn.com/t/c/font_4457931_hop63tnnyi5.woff2?t=1709811699685') format('woff2'),
	       url('https://at.alicdn.com/t/c/font_4457931_hop63tnnyi5.woff?t=1709811699685') format('woff'),
	       url('https://at.alicdn.com/t/c/font_4457931_hop63tnnyi5.ttf?t=1709811699685') format('truetype');
	}
	
	.iconfont {
	  font-family: "iconfont" !important;
	  font-size: 16px;
	  font-style: normal;
	  -webkit-font-smoothing: antialiased;
	  -moz-osx-font-smoothing: grayscale;
	}
	
	.icon-laba:before {
	  content: "\e600";
	}

</style>