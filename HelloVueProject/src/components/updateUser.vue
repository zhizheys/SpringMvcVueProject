<template>
    <div>
        <Modal
        v-model="isShowUpdateUserModal"
        title="update user"
        :loading="loading"
        @on-ok="UpdateUser"
        okText='Update User'
        cancelText='Cancel'>
        <div>
             
             <Form :model="UpdateUserItem" :label-width="80">
                 <FormItem label="UserId">
                    <Input v-model="UpdateUserItem.userId"></Input>
                </FormItem>
                <FormItem label="UserName">
                    <Input v-model="UpdateUserItem.userName" placeholder="Enter user name ..."></Input>
                </FormItem>
                <FormItem label="UserAge">
                    <InputNumber v-model="UpdateUserItem.userAge" :max="100" :min="0" :step="1" ></InputNumber>
                </FormItem>
                <FormItem label="UserUpdateress">
                    <Select v-model="UpdateUserItem.userUpdateress">
                    <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                    </Select>
                </FormItem>
                <FormItem label="Birthday">
                    <Row>
                        <Col span="11">
                            <DatePicker type="date" placeholder="Select date" format="yyyy-MM-dd" v-model="UpdateUserItem.userBirthday" ></DatePicker>
                        </Col>
                    </Row>
                </FormItem>
                <FormItem label="UserPassword">
                    <Input v-model="UpdateUserItem.userPassword" type="password"></Input>
                </FormItem>

  
            </Form>
        </div>
    </Modal>
    </div>
</template>

<script>
export default {
  name: 'UpdateUser',
  data () {
    return {
      msg:null,
      loading: true,
      isShowUpdateUserModal:false,
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
      UpdateUserItem: {
                    userId:null,
                    userName: null,
                    userAge:null,
                    userUpdateress: null,
                    userPassword: null,
                    userBirthday: null
                }
       }
   },
   methods:{
        showUpdateUserModal:function(e){
            this.isShowUpdateUserModal=true;
            this.UpdateUserItem=e;
        },
        UpdateUser: function() {

            var url="http://localhost:9999/hellospringmvcproject/user/updateuser";
            var userObj=this.UpdateUserItem;
            var userJson=JSON.stringify(userObj);
     
            this.$http.put(url,userObj).then(function(data){
                var result=data.body;
                
                if(result.isSuccess){
                    alert("update success");
                    this.UpdateUserItem={
                                    userId:null,
                                    userName: null,
                                    userAge:null,
                                    userUpdateress: null,
                                    userPassword: null,
                                    userBirthday: null
                                };
                }else{
                    alert(result.message);
                }

            },function(response){
                console.info("=====error=======" + JSON.stringify(response));
            });

        }
    }
   
}

//-----------------------------------


var UpdateUserAction=(function(){
  
    function saveUpdateUser(userObj,callback) {
         var url="http://localhost:9999/hellospringmvcproject/user/Updateuser";
            //var userObj=this.formItem;
            var userJson=JSON.stringify(userObj);

            this.$http.post(url,userObj).then(function(data){
                var result=data.body;
                
                if(result.isSuccess){
                    alert("Update success");
                    callback("hello");
                }else{
                    alert(result.message);
                }


            },function(response){
                console.info("=====error=======" + JSON.stringify(response));
            });
    }

    return {
        saveUpdateUser:saveUpdateUser
    }

})();


</script>

<style scoped>

</style>
