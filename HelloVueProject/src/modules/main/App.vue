<template>
  <div id="app">
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



</style>
