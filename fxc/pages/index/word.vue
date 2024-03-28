<template>
  <view>
    <!-- 轮播图 -->
    <lunbo></lunbo>
    <!-- 单词展示 -->
    <view class="word-container" v-for="(word, index) in words" :key="index">
      <view class="word">
        <view class="word-name-laba">
          <text class="word-name">{{ word.name }}</text>
          <laba :soundSrc="word.soundSrc"></laba>
        </view>
        <view class="word-info">
          <text class="word-spelling">拼写：{{ word.spelling }}</text>
          <text class="word-meaning">释义：{{ word.meaning }}</text>
          <text class="word-type">词性：{{ word.partOfSpeech }}</text>
          <text class="word-phrases">常见词组：{{ word.commonPhrases }}</text>
          <text class="word-example">例句：{{ word.example }}</text> <!-- 添加例句展示 -->
        </view>
      </view>
    </view>
  </view>
</template>

<script>
import laba from '@/pages/component/laba.vue';
import lunbo from '@/pages/component/lunbo.vue';
export default {
  components: {
    laba,lunbo
  },
  data() {
    return {
      images: ['/static/img/th3.jpg', '/static/img/th2.jpg', '/static/img/th3.jpg'],
      words: [
        {
          name: 'example',
          spelling: '/ɪɡˈzæmpl/',
          meaning: 'something chosen to show what a whole is like',
          partOfSpeech: 'noun',
          commonPhrases: 'for example, set an example, follow the example',
          soundSrc: '/static/mp3/example.mp3', // 添加音频路径
          example: 'For example, this is a sentence using the word "example".' // 添加例句
        },
        {
          name: 'apple',
          spelling: '/ˈæpl/',
          meaning: 'a round fruit with red or green skin and a whitish inside',
          partOfSpeech: 'noun',
          commonPhrases: 'an apple a day keeps the doctor away, apple pie, apple juice',
          soundSrc: '/static/mp3/apple.mp3', // 添加音频路径
          example: 'She eats an apple every day.' // 添加例句
        },
        {
          name: 'banana',
          spelling: '/bəˈnæn.ə/',
          meaning: 'a long, curved fruit with a yellow skin and soft, sweet flesh',
          partOfSpeech: 'noun',
          commonPhrases: 'banana peel, banana split',
          soundSrc: '/path/to/banana-sound.mp3', // 添加音频路径
          example: 'He grabbed a banana as a snack.' // 添加例句
        },
        {
          name: 'computer',
          spelling: '/kəmˈpjuː.t̬ɚ/',
          meaning: 'an electronic machine that can store and arrange large amounts of information, and do many different types of work',
          partOfSpeech: 'noun',
          commonPhrases: 'personal computer, laptop computer',
          soundSrc: '/path/to/computer-sound.mp3', // 添加音频路径
          example: 'I use a computer for work.' // 添加例句
        }
        // 可以继续添加更多的单词
      ]
    };
  }
};
</script>

<style>

.word-name-laba {
  display: flex;
  align-items: center; /* 垂直居中 */
  margin-right: 10px; /* 设置间距 */
}
.word-container {
  margin-top: 20px;
}

.word {
  margin-bottom: 20px;
  padding: 10px;
  background-color: #ffffff;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.word-name {
  font-size: 20px;
  font-weight: bold;
  margin-bottom: 5px;
}

.word-info {
  font-size: 16px;
}

.word-info text {
  display: block;
  margin-bottom: 5px;
}
</style>
