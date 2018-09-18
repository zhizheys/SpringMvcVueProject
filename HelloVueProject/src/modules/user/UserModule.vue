<template>
  <div id="userapp">
    <div style="height:50px;line-height:50px;margin-top:20px;">
      <header-info></header-info>
    </div>
     
    <div class="mod-module mod-parallel">
  
      <Menu mode="horizontal" :theme="theme1" active-name="0">
        <MenuItem name="0">
              <Icon type="ios-paper" />
              <a class="page-link" href="#/"></a>
              首页
          </MenuItem>
          <MenuItem name="1">
              <Icon type="ios-paper" />
              <a class="page-link" href="#/list"></a>
              内容管理
          </MenuItem>
          <MenuItem name="2">
              <Icon type="ios-people" />
              <a class="page-link" href="#/user"></a>
              用户管理
          </MenuItem>
          <Submenu name="3">
              <template slot="title">
                  <Icon type="ios-stats" />
                  <a class="page-link" href="#/nav"></a>
                  统计分析
              </template>
              <MenuGroup title="使用">
                  <MenuItem name="3-1">新增和启动</MenuItem>
                  <MenuItem name="3-2">活跃分析</MenuItem>
                  <MenuItem name="3-3">时段分析</MenuItem>
              </MenuGroup>
              <MenuGroup title="留存">
                  <MenuItem name="3-4">用户留存</MenuItem>
                  <MenuItem name="3-5">流失用户</MenuItem>
              </MenuGroup>
          </Submenu>
          <MenuItem name="4">
              <Icon type="ios-construct" />
              <a class="page-link" href="#/btn"></a>
              综合设置
          </MenuItem>
      </Menu>

  </div>

    <router-view/>
  </div>
</template>

<script>

  import header from './../../components/common/header.vue'

  export default {
    name: 'User',
    components: {
         'header-info': header,
    },
    data () {
              return {
                  theme1: 'light'
              }
          }
  }
</script>

<style>


#userapp {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  text-align:left;
}

/*列表*/
.mod-parallel{
  overflow: hidden;
}
.mod-parallel .img-list{
  overflow: hidden;
  padding-top: 8px;
}
.mod-parallel .img-list .img-box{
  height: 50px;
  border: none;
  width: 25%;
  border-right: 12px solid transparent;
  border-left: 12px solid transparent;
  float: left;
  margin: 0 0 8px 0;
  position: relative;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}
.mod-parallel .img-list .img-item{
  display: block;
  width: 100%;
  margin: 0;
  background-position: 50% 50%;
  background-color: #19C3FF;
  background-repeat: no-repeat;
  background-size: cover;
  padding-top: 100%;/*宽高比*/
}
.mod-parallel .img-list.type-full{
  margin: 0 -1px;
}
.mod-parallel .img-list.type-full .img-box{
  border-right-width: 1px;
  border-left-width: 1px;
  margin: 0 0 2px 0;
}
.mod-parallel .img-list.type-full .img-item{
  border-radius: 0;
}
.mod-parallel a,
.mod-parallel .page-link{
  position: absolute;
  display: block;
  text-align: center;
  height: 100%;
  top: 0;
  color: #fff;
  text-decoration: none;
  line-height: inherit;
  width: 100%;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-box-pack: center;
  -webkit-box-align: center;
}


</style>
