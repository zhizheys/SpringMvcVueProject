<template>
    <div>
        <Modal
        v-model="showAddUserModal"
        title="UserInfo"
        :loading="loading"
        @on-ok="asyncOK"
        okText='Add User'
        cancelText='Cancel'>
        <div>
             {{msg}}
             <Form :model="addUserItem" :label-width="80">
                <FormItem label="UserName">
                    <Input v-model="addUserItem.userName" placeholder="Enter user name ..."></Input>
                </FormItem>
                <FormItem label="UserAge">
                    <InputNumber v-model="addUserItem.userAge" :max="100" :min="0" :step="1" ></InputNumber>
                </FormItem>
                <FormItem label="UserAddress">
                    <Select v-model="addUserItem.userAddress">
                    <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                    </Select>
                </FormItem>
                <FormItem label="Birthday">
                    <Row>
                        <Col span="11">
                            <DatePicker type="date" placeholder="Select date" format="yyyy-MM-dd" v-model="addUserItem.userBirthday" ></DatePicker>
                        </Col>
                    </Row>
                </FormItem>
                <FormItem label="UserPassword">
                    <Input v-model="addUserItem.userPassword" type="password"></Input>
                </FormItem>
            </Form>
        </div>
    </Modal>
    </div>
</template>

<script>
export default {
  name: 'addUser',
  data () {
    return {
      msg:null,
      loading: true,
      showAddUserModal:true,
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
      addUserItem: {
                    userName: null,
                    userAge:null,
                    userAddress: null,
                    userPassword: null,
                    userBirthday: null
                }
    }
  },
  methods:{
       
        asyncOK: () => {
            setTimeout(() => {
                this.$Modal.remove();
                this.$Message.info('Asynchronously close the dialog box');
            }, 2000);
        }
    },
    props: {
      // 这个 prop 属性接收父组件传递进来的值
      formData: Object
    },
    watch: {
      // 因为不能直接修改 props 里的属性，所以不能直接把 formData 通过v-model进行绑定
      // 在这里我们需要监听 formData，当它发生变化时，立即将值赋给 data 里的 form
      formData: {
        immediate: true,
        handler (val) {
          this.addUserItem = val
        }
      }
    },
    mounted () {
      // props 是单向数据流，通过触发 update 事件绑定 formData，
      // 将 data 里的 form 指向父组件通过 formData 绑定的那个对象
      // 父组件在绑定 formData 的时候，需要加上 .sync
      //this.$emit('update:formData', this.form)
    }
}
</script>

<style scoped>

</style>
