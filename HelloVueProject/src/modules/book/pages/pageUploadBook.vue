<template>
  <div id="pageUploadBook" style="margin-top:20px;width:800px;margin:0 auto;">
        <h2>upload book </h2>
        <Upload action="//jsonplaceholder.typicode.com/posts/">
            <Button icon="ios-cloud-upload-outline">Upload files</Button>
        </Upload>
  </div>
</template>

<script>

  export default {
    name: 'pageUser',
    components: {
      
    },
    data () {
            return {
                msg:"hello",
                formItem: {
                    userName: null,
                    userAge:null,
                    userAddress: null,
                    radio: null,
                    userPassword: null,
                    userBirthday: null,
                }
                
            }
        },
    methods:{
        
        getUser: function () {
     
            var url="http://localhost:9999/hellospringmvcproject/user/userinfo/3";
            
            this.$http.get(url).then(function(data){
                var result=data.body;
                
                if(result.isSuccess){
                    this.formItem=result.data;
                }else{
                    alert(result.message);
                }


            },function(response){
                console.info("=====error=======" + response);
            });

        }
                
    
    },
    beforeCreate:function(){},
    created:function(){},
    beforeMount:function(){},
    mounted:function(){
      console.log(this.$el);
      
    },
    beforeUpdate:function(){},//组件更新前
    updated:function(){},//组件更新比如修改了文案
    beforeDestroy:function(){},//组件销毁之前
    destroyed:function(){}//组件已经销毁
  }

var pageUserAction=(function(){
    function deleteUserInfo(id,callback) {

       jsLibAction.ajax({ 
            type:"DELETE", 
            url:"http://localhost:9999/hellospringmvcproject/user/deleteuser/" + id,
            dataType:"json", 
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
        deleteUserInfo:deleteUserInfo
    }

})();


</script>

<style scoped>
    .margin-top-10{
        margin-top: 10px;
    }
</style>
