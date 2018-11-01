<template>
  <div id="pageUser" style="margin:20px auto;width:1000px;">
    
        <div style="width:800px;margin-top:20px;">
                <Table class="margin-top-10" height="500" :columns="columns6" :data="data6" size="small" ref="table"></Table>
        </div>

  </div>
</template>

<script>
  
  //import addUser from '../components/addUser.vue'
  //import updateUserComponent from '../components/updateUser.vue'

  export default {
    name: 'pageUsfiling',
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
                columns6: [
                    {
                        "title": "FilingId",
                        "key": "filingId",
                        "width": 200
                    },
                    {
                        "title": "CompanyName",
                        "key": "companyName",
                        "width": 200
                    },
                    {
                        "title": "ProcessStatus",
                        "key": "processStatus",
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
                                }, 'Detail')
                                
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
        getAllUser: function () {
              
            console.log("get us filing");
            
            var filingData=[{"filingId":82410887, "companyName":"JPMorganTrust", "processStatus":"Complete"},
                            {"filingId":76755007, "companyName":"GoldmanSachsTrust", "processStatus":"IsParsing"},
                            {"filingId":77878910, "companyName":"GoldmanSachsTrust", "processStatus":"Pending"}
            ];

            this.data6=filingData;
              
                
        },
        showUpdateUserModel:function(){
            window.location.href="http://localhost:8080/usfiling.html#/parseprocess";
        }
    },
    beforeCreate:function(){},
    created:function(){},
    beforeMount:function(){},
    mounted:function(){
      console.log(this.$el);
      this.getAllUser();

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
