<template>
  <div id="pageUser" style="margin-top:20px;">
    <div class="margin-top-10">
          <i-button type="primary" @click="getUser">get user</i-button>
    </div>

    <div style="width:800px;margin:0 auto;">
        <h3>Add User:{{formItem.userName}}</h3>
        <Form :model="formItem" :label-width="80">
            <FormItem label="UserName">
                <Input v-model="formItem.userName" placeholder="Enter user name ..."></Input>
            </FormItem>
            <FormItem label="UserAge">
                <InputNumber v-model="formItem.userAge" :max="100" :min="0" :step="1" ></InputNumber>
            </FormItem>
            <FormItem label="UserAddress">
                <Select v-model="formItem.userAddress">
                   <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                </Select>
            </FormItem>
            <FormItem label="Birthday">
                <Row>
                    <Col span="11">
                        <DatePicker type="date" placeholder="Select date" v-model="formItem.userBirthday"></DatePicker>
                    </Col>
                </Row>
            </FormItem>
            <FormItem label="UserPassword">
                <Input v-model="formItem.userPassword" type="password"></Input>
            </FormItem>
            <FormItem label="Radio">
                <RadioGroup v-model="formItem.radio">
                    <Radio label="male">Male</Radio>
                    <Radio label="female">Female</Radio>
                </RadioGroup>
            </FormItem>
    
            <FormItem>
                <Button type="primary" @click="addUser">Submit</Button>
                <Button style="margin-left: 8px">Cancel</Button>
            </FormItem>
        </Form>

   </div>

    <div class="margin-top-10">
          <i-button type="primary" @click="getAllUser">get all user</i-button>
    </div>
    <Table class="margin-top-10" :columns="columns6" :data="data6" size="small" ref="table"></Table>
  </div>
</template>

<script>

  export default {
    name: 'pageUser',
    components: {
      
    },
    data () {
            return {
                formItem: {
                    userName: null,
                    userAge:null,
                    userAddress: null,
                    radio: null,
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
                        "fixed": "left",
                        "width": 200
                    },
                    {
                        "title": "Name",
                        "key": "userName",
                        "fixed": "left",
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
                    }
                    
                ],
                data6: []
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
                
        },
        addUser: function () {
     
            var url="http://localhost:9999/hellospringmvcproject/user/adduser";

             var userObj=this.formItem;
             var userJson=JSON.stringify(userObj);
             console.log(userJson);

            this.$http.post(url,userJson,{emulateJSON:true}).then(function(data){
                var result=data.body;
                
                if(result.isSuccess){
                    alert("add success");
                }else{
                    alert(result.message);
                }


            },function(response){
                console.info("=====error=======" + response.body);
            });
                
        }
    },
    beforeCreate:function(){},//组件实例化之前
    created:function(){},//组件实例化了
    beforeMount:function(){},//组件写入dom结构之前
    mounted:function(){//组件写入dom结构了
      console.log(this.$el);
      
    },
    beforeUpdate:function(){},//组件更新前
    updated:function(){},//组件更新比如修改了文案
    beforeDestroy:function(){},//组件销毁之前
    destroyed:function(){}//组件已经销毁
  }
</script>

<style scoped>
    .margin-top-10{
        margin-top: 10px;
    }
</style>
