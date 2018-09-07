<template>
  <div id="app">
    <img src="./assets/msLogo.gif">
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
  export default {
    name: 'App',
    data () {
            return {
                theme1: 'light'
            }
        }
  }
</script>

<style scoped>



@import './pages/css/index.css';

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align:left;
  color: #2c3e50;
  margin-top: 10px;
}

</style>
