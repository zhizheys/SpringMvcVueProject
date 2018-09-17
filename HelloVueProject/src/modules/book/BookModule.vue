<template>
  <div id="bookapp">
    <img src="./../../assets/msLogo.gif">
    <div class="mod-module mod-parallel">
  
    <Menu mode="horizontal" active-name="0">
       <MenuItem name="0">
            <Icon type="ios-paper" />
            <a class="page-link" href="#/"></a>
            图书首页
        </MenuItem>
        <MenuItem name="1">
            <Icon type="ios-paper" />
            <a class="page-link" href="#/book"></a>
            图书管理
        </MenuItem>
      
    </Menu>

    
  </div>

    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'Book'
}
</script>

<style>


#bookapp {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color:blueviolet;
  margin-top: 60px;
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
