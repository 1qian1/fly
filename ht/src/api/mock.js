import Mock from "mockjs"
import homeApi from "./mockServerData/home"
import user from "./mockServerData/user"
import permission from"./mockServerData/permission"
//定义mock请求拦截
Mock.mock('/home/getData',homeApi.getStatisticalData)
//定义用户列表的数据
Mock.mock('/user/add','post',user.createUser)
Mock.mock('/user/edit','post',user.updateUser)
Mock.mock('/user/del','post',user.deleteUser)
// Mock.mock(/user\/getUser/,user.getUserList)
// Mock.mock(/permission\/getMenu/,permission.getMenu)

