export default {
    state:{
   isCollapse: false,//控制菜单的展开还是收起
        tabsList:[
            {
                path:'/',
                name:'user',
                label:"学习资料",
                icon:'s-home',
                url:'User/user'
            },
        ]
    },
    mutations:{
        //修改菜单状态的方法
        collapseMenu(state){
            state.isCollapse=!state.isCollapse
        },
        //更新面包xie
        selectMenu(state,val){
            console.log(val,'val')
            //判断添加的数据是否为首页
            if(val.name!=='user'){
                const index=state.tabsList.findIndex(item=>item.name===val.name)
                //如果不存在
                if(index===-1){
                    state.tabsList.push(val)
                }
            }
        },
        CloseTag(state,item){
            // console.log(item,'item')
            const index=state.tabsList.findIndex(val=>val.name===item.name)
            state.tabsList.splice(index,1)


        }

    }
}
