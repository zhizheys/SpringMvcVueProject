//index.vue
<template>
  <div id="pageQuiList">
    <qui-list tipsText="自定义文案，默认右边是按钮" msg="弹层"></qui-list>
    <qui-list v-on:btnClickEvent="test"></qui-list>
    <qui-list ref="child1" tipsText="最右边是箭头" currentView="qui-arrow"></qui-list>
    
    <div style="margin-top:50px;">
         <Table class="margin-top-10" height="400" :columns="columnsList" :data="userBookList" size="small" ref="table"></Table>
    </div>
  
  </div>
</template>

<script>
  import quiList from '../components/quiList.vue'
  export default {
    name: 'pageQuiList',
    components: {
      'qui-list': quiList
    },
    data(){
      return {
          columnsList: [
                    {
                        "title": "Name",
                        "key": "userName",
                        "width": 200
                    },
                    {
                        "title": "Age",
                        "key": "userAge",
                        "width": 150,
                        "sortable": true
                    },
                    {
                        "title": "Birthday",
                        "key": "userBirthday",
                        "width": 150,
                        "sortable": true
                    },
                    {
                        "title": "BookName",
                        "key": "bookName",
                        "width": 150,
                        "sortable": true
                    },
                    {
                        "title": "BookPrice",
                        "key": "bookPrice",
                        "width": 150,
                        "sortable": true
                    }
                ],
                userBookList:[]
      }
        
    },
    methods:{
      test:function(){
        alert("test");
      },
      getAllUserBook: function () {
            var self=this;

            pageQuiListAction.getAllUserBookInfo(function(obj){
                if(obj !=null){
                    if(obj.isSuccess){
                        self.userBookList=obj.data;
                    }else{
                        alert("error");
                    }
                }

            });
        }
    },
    beforeCreate:function(){ console.log("beforeCreate");},//组件实例化之前
    created:function(){ console.log("created");},//组件实例化了
    beforeMount:function(){ console.log("beforeMount");},//组件写入dom结构之前
    mounted:function(){//组件写入dom结构了
      console.log("mounted");
      this.getAllUserBook();
    },
    beforeUpdate:function(){ console.log("beforeUpdate");},//组件更新前
    updated:function(){ console.log("updated");},//组件更新比如修改了文案
    beforeDestroy:function(){ console.log("beforeDestroy");},//组件销毁之前
    destroyed:function(){ console.log("destroyed");}//组件已经销毁
  }


var pageQuiListAction=(function(){
    function getAllUserBookInfo(callback) {

       jsLibAction.ajax({ 
            type:"GET", 
            url:"http://localhost:9999/hellospringmvcproject/user/showalluserbook",
            dataType:"json", 
            //data:{"val1":"abc","val2":123,"val3":"456"}, 
            beforeSend:function(){ 
                //some js code 
            }, 
            success:function(msg){ 
                callback(msg); 
            }, 
            error:function(){
                var obj={
                    "isSuccess":false,
                    "message":"server error",
                    "data":null
                }
                callback(obj); 
            } 
        });
    
    }

    return {
        getAllUserBookInfo:getAllUserBookInfo
    }

})();


</script>

<style scoped>

</style>
