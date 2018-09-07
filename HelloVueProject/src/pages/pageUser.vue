<template>
  <div id="pageUser" style="margin-top:20px;">
    <h1>Users Info:</h1>
    <Table :columns="columns8" :data="data7" size="small" ref="table"></Table>

    <div class="margin-top-10">
          <i-button @click="getAllUser">get user</i-button>
    </div>
    <Table :columns="columns6" :data="data6" size="small" ref="table"></Table>
  </div>
</template>

<script>

  export default {
    name: 'pageUser',
    components: {
      
    },
    data () {
            return {
                columns8: [
                    {
                        "title": "Name",
                        "key": "name",
                        "fixed": "left",
                        "width": 200
                    },
                    {
                        "title": "Show",
                        "key": "show",
                        "width": 150,
                        "sortable": true,
                        filters: [
                            {
                                label: 'Greater than 4000',
                                value: 1
                            },
                            {
                                label: 'Less than 4000',
                                value: 2
                            }
                        ],
                        filterMultiple: false,
                        filterMethod (value, row) {
                            if (value === 1) {
                                return row.show > 4000;
                            } else if (value === 2) {
                                return row.show < 4000;
                            }
                        }
                    },
                    {
                        "title": "Weak",
                        "key": "weak",
                        "width": 150,
                        "sortable": true
                    },
                    {
                        "title": "Signin",
                        "key": "signin",
                        "width": 150,
                        "sortable": true
                    },
                    {
                        "title": "Click",
                        "key": "click",
                        "width": 150,
                        "sortable": true
                    },
                    {
                        "title": "Active",
                        "key": "active",
                        "width": 150,
                        "sortable": true
                    },
                    {
                        "title": "7, retained",
                        "key": "day7",
                        "width": 150,
                        "sortable": true
                    },
                    {
                        "title": "30, retained",
                        "key": "day30",
                        "width": 150,
                        "sortable": true
                    },
                    {
                        "title": "The next day left",
                        "key": "tomorrow",
                        "width": 150,
                        "sortable": true
                    },
                    {
                        "title": "Day Active",
                        "key": "day",
                        "width": 150,
                        "sortable": true
                    },
                    {
                        "title": "Week Active",
                        "key": "week",
                        "width": 150,
                        "sortable": true
                    },
                    {
                        "title": "Month Active",
                        "key": "month",
                        "width": 150,
                        "sortable": true
                    }
                ],
                data7: [
                    {
                        "name": "Name1",
                        "fav": 0,
                        "show": 7302,
                        "weak": 5627,
                        "signin": 1563,
                        "click": 4254,
                        "active": 1438,
                        "day7": 274,
                        "day30": 285,
                        "tomorrow": 1727,
                        "day": 558,
                        "week": 4440,
                        "month": 5610
                    },
                    {
                        "name": "Name2",
                        "fav": 0,
                        "show": 4720,
                        "weak": 4086,
                        "signin": 3792,
                        "click": 8690,
                        "active": 8470,
                        "day7": 8172,
                        "day30": 5197,
                        "tomorrow": 1684,
                        "day": 2593,
                        "week": 2507,
                        "month": 1537
                    },
                    {
                        "name": "Name3",
                        "fav": 0,
                        "show": 7181,
                        "weak": 8007,
                        "signin": 8477,
                        "click": 1879,
                        "active": 16,
                        "day7": 2249,
                        "day30": 3450,
                        "tomorrow": 377,
                        "day": 1561,
                        "week": 3219,
                        "month": 1588
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
                data6: [
                   {"userName":"张三","userAge":100,"userAddress":"深圳","userPassword":"eecc","userBirthday":"2015-03-04 00:00:00","userId":3},{"userName":"李四","userAge":30,"userAddress":"深圳","userPassword":"ffff","userBirthday":"2016-03-05 00:00:00","userId":10}
                ]
        
            }
        },
    methods:{
        getAllUser: function () {
     
            var url="http://localhost:9999/hellospringmvcproject/user/showalluser";
            
            // this.$http.get(url).then(function(data){
            //     var json=data.body;
            //     alert(json);
            //     var result=JSON.parse(json);
                
            //     if(result.isSuccess){
            //         this.data6=result.data;
            //     }else{
            //         alert(result.message);
            //     }


            // },function(response){
            //     console.info(response);
            // })


            this.$http.get('http://news-at.zhihu.com/api/4/news/latest', data => {
                this.$set('news', data.stories);
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
