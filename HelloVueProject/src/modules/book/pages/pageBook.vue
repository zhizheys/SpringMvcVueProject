<template>
  <div id="pageUser" style="margin-top:20px;">
   <h2>all the book </h2>
   
  </div>
</template>

<script>
  
  //import addUser from '../components/addUser.vue'
  //import updateUserComponent from '../components/updateUser.vue'

  export default {
    name: 'pageUser',
    components: {
         //'adduser-modal': addUser,
         //'updateuser-modal': updateUserComponent
    },
    data () {
            return {
                formAddUser: {
                   showAddUserModal:false
                },
                loading: true,
                formItem: {
                    userName: null,
                    userAge:null,
                    userAddress: null,
                    radio: null,
                    userPassword: null,
                    userBirthday: null,
                },
                updateUserItem: {
                    userId:null,
                    userName: null,
                    userAge:null,
                    userAddress: null,
                    userPassword: null,
                    userBirthday: null,
                },
                cityList: [
                    {
                        value: 'shanghai',
                        label: '上海'
                    },
                    {
                        value: 'beijing',
                        label: '北京'
                    },
                    {
                        value: 'shenzhen',
                        label: '深圳'
                    }
                ],
                columns6: [
                    {
                        "title": "UserId",
                        "key": "userId",
                        "width": 200
                    },
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
                        "title": "Address",
                        "key": "userAddress",
                        "width": 150,
                        "sortable": true
                    },
                    {
                        "title": "Password",
                        "key": "userPassword",
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
                        title: 'Action',
                        key: 'action',
                        width: 150,
                        align: 'center',
                        render: (h, params) => {
                            return h('div', [
                                h('Button', {
                                    props: {
                                        type: 'primary',
                                        size: 'small'
                                    },
                                    style: {
                                        marginRight: '5px'
                                    },
                                    on: {
                                        click: () => {
                                            this.showUpdateUserModel(params.index)
                                        }
                                    }
                                }, 'Edit'),
                                h('Button', {
                                    props: {
                                        type: 'error',
                                        size: 'small'
                                    },
                                    on: {
                                        click: () => {
                                            this.remove(params.index)
                                        }
                                    }
                                }, 'Delete')
                            ]);
                        }
                    
                    }
                    
                ],
                data6: []
            }
        },
    methods:{
        show (index) {
                this.formItem=this.data6[index];
            },
        remove (index) {
            var self=this;
            var userId=self.data6[index].userId;

            self.$Modal.confirm({
                    title: 'Delete Data',
                    content: '<p>Are you sure to delete ?</p>',
                    onOk: () => {
                        pageUserAction.deleteUserInfo(userId,function(obj){
                            if(obj !=null){
                                if(obj.isSuccess){
                                    self.data6.splice(index, 1);
                                    self.$Message.success('delete user success');
                                }else{
                                    alert(obj.message);
                                }
                            }
                        });
                    }
           });

        },
        showAddUser:function(){
            //console.log("eeeeee");
            //this.$refs.mychild.parentHandleclick("嘿嘿嘿");
            this.$refs.mychild.showModal();
        },
        showUpdateUserModel:function(index){
            //this.formItem=this.data6[index];
            this.$refs.updateuserchild.showUpdateUserModal(this.data6[index]);
        },
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
                
        },
        getAllUser: function () {
     
            var url="http://localhost:9999/hellospringmvcproject/user/showalluser";
            
            this.$http.get(url).then(function(data){
                var result=data.body;
                
                if(result.isSuccess){
                    this.data6=result.data;
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
