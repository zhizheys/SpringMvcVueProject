<template>
  <div id="app">
    <img src="./../../assets/msLogo.gif">
   
    <h2>the inde page </h2>
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


#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align:left;
  color: #2c3e50;
  margin-top: 10px;
}

</style>
