<template>
    <div class="tags">
        <el-tag
                v-for="(item,index) in tags"
                :key="item.label"
                :closable="item.name!=='user'"
                :effect="$route.name===item.name ? 'dark' :'plain'"
                @click="changeMenu(item)"
                @close="handleClose(item,index)"
                size="small"
        >
            {{ item.label }}
        </el-tag>
    </div>
</template>

<script>
    import {mapState, mapMutations} from 'vuex'
    export default {
        name: "CommonTag",
        data(){
            return {}
        },
        computed:{
            ...mapState({
                tags:state=>state.tab.tabsList
                     })
        },
        methods:{
            ...mapMutations(['CloseTag']),
          // 点击tag跳转功能
          changeMenu(item) {
            if (this.$route.path !== item.path) {
              this.$router.push(item.path).catch(error => {
                console.error(`Error while navigating to ${item.path}:`, error);
              });
            }
          },
            //点击tag删除的功能
            handleClose(item,index){
                //调用store中的方法
                this.CloseTag(item)
                const length=this.tags.length
                //删除后的逻辑编写
                if(item.name!==this.$route.name){
                    return
                }
                //表示的是删除的最后一项
                if(index === length)
                {
                    this.$router.push({
                        name:this.tags[index-1].name
                    })
                }else{
                    this.$router.push({
                        name:this.tags[index].name
                    })
                }


            }
        }
    }
</script>

<style lang="less" >
.tags{
    padding:20px;
    .el-tag{
        margin-right: 15px;
        cursor: pointer;
    }
}
</style>
