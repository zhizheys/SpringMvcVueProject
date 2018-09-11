<template>
  <div id="pageUser" style="margin-top:20px;">

   <div class="margin-top-10">
          <i-button type="primary" @click="getAllUser">get all user</i-button>
          <i-button type="primary" @click="getUser">get user</i-button>
          <i-button type="primary" @click="addUserModal">add user</i-button>
    </div>
    <Table class="margin-top-10" height="250" :columns="columns6" :data="data6" size="small" ref="table"></Table>

    <div style="width:800px;margin:0 auto;margin-top:30px;">
        <h3>Update User:{{formItem.userName}}</h3>
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
                <Button type="primary" @click="updateUser">Update user</Button>
                <Button style="margin-left: 8px">Cancel</Button>
            </FormItem>
        </Form>

   </div>

   <adduser-modal :formData.sync="formAddUser"></adduser-modal>
 
  </div>
</template>

<script>
  
  import addUser from '../components/addUser.vue'

  export default {
    name: 'pageUser',
    components: {
         'adduser-modal': addUser,
         props:{
            showAddUserModal:true,
        }
    },
    data () {
            return {
                formAddUser: {
                    userName: 'aaa',
                    userAge: 500,
                    userAddress: 'shenzhen'
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
                                            this.show(params.index)
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
            this.data6.splice(index, 1);
        },
        addUserModal:function(){
            alert("cc");
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
                
        },
        addUser: function () {
     
            var url="http://localhost:9999/hellospringmvcproject/user/adduser";
            var userObj=this.formItem;
            var userJson=JSON.stringify(userObj);

            this.$http.post(url,userObj).then(function(data){
                var result=data.body;
                
                if(result.isSuccess){
                    alert("add success");
                }else{
                    alert(result.message);
                }


            },function(response){
                console.info("=====error=======" + JSON.stringify(response));
            });
                
        },
        updateUser: function () {
     
            var url="http://localhost:9999/hellospringmvcproject/user/updateuser";
            var userObj=this.formItem;
            var userJson=JSON.stringify(userObj);
     
            this.$http.put(url,userObj).then(function(data){
                var result=data.body;
                
                if(result.isSuccess){
                    alert("update success");
                    this.formItem={
                                    userName: null,
                                    userAge:null,
                                    userAddress: null,
                                    radio: null,
                                    userPassword: null,
                                    userBirthday: null,
                                };
                }else{
                    alert(result.message);
                }

            },function(response){
                console.info("=====error=======" + JSON.stringify(response));
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
</script>

<style scoped>
    .margin-top-10{
        margin-top: 10px;
    }
</style>
