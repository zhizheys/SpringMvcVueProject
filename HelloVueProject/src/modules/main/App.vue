<template>
  <div id="appModuleDiv">
     
    <div style="width:800px;margin:100px auto;">
      <div><img src="static/image/msLogo.gif"></div>
      <table style="width:100%;margin-top:10px;">
        <tbody>
          <tr>
            <td class="green-b"><a href="#" v-on:mouseover = "aMouseover(0)">Index</a></td>
            <td class="yellow-b"><a href="usfiling.html" target="_Blank"  v-on:mouseover = "aMouseover(1)">Usfiling</a></td>
            <td class="blue-b"><a href="#" v-on:mouseover = "aMouseover(4)"></a></td>
          </tr>
          <tr>
              <td class="blue-1"><a href="#" v-on:mouseover = "aMouseover(4)"></a></td>
              <td class="blue-2"><a href="#" v-on:mouseover = "aMouseover(4)"></a></td>
              <td class="blue-3"><a href="#" v-on:mouseover = "aMouseover(5)"></a></td>
            </tr>
        </tbody>
      </table>

      <p style="margin-top:20px;">Current module is: {{msg}}</p>

    </div>
  </div>

</template>

<script>
  export default {
    name: 'App',
    data () {
            return {
                msg: null,
                moduleInfo:[
                  "the index page is show index",
                  "this is the usfiling module",
                  "the user page is show user",
                  "the user page is show user",
                  "the demo page is show demo2",
                  "the demo page is show demo3"
                ]
            }
        },
    methods:{
      aMouseover:function(index){
         this.msg=this.moduleInfo[index];
      }
    }
  }
</script>

<style scoped>
   
  a {
    color:white;
    font-weight:bolder;
    font-size:30px;
  }

  tr{
        height: 150px;
        line-height: 150px;
    }

    td{
        width:30%;
        text-align: center;
        margin-left: 200px;
        font-size: 20px;
        font-weight: bolder;
        color:white;
    }

  .green-b{
    background-color: #19be6b;
  }

   .yellow-b{
    background-color:#ff9900;
  }

   .blue-b{
    background-color:#2db7f5;
  }

     .blue-1{
    background-color:#5cadff;
  }

     .blue-2{
    background-color:#515a6e;
  }
     .blue-3{
    background-color:#808695;
  }

</style>
