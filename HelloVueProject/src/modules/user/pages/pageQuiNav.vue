//index.vue
<template>
  <div id="pageQuiNav" style="margin-top:50px;">
    <qui-nav v-on:navClickEvent="dosth"></qui-nav>
  </div>
</template>

<script>
  import quiNav from './../../../components/common/quiNav.vue'
  export default {
    name: 'pageQuiNav',
    components: {
      'qui-nav': quiNav
    },
    methods:{
      dosth:function(items,index){
        console.log(items[index].text + index);
      }
    }
  }
</script>

<style scoped>

</style>
