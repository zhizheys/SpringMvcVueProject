
<template>
  <div id="pageIndex">
     <div style="margin:10px auto;width:500px;">
        <h1>the  index page index vue</h1>

       <RadioGroup v-model="phone">
            <Radio label="apple">
                <Icon type="logo-apple"></Icon>
                <span>Apple</span>
            </Radio>
            <Radio label="android">
                <Icon type="logo-android"></Icon>
                <span>Android</span>
            </Radio>
            <Radio label="windows">
                <Icon type="logo-windows"></Icon>
                <span>Windows</span>
            </Radio>
        </RadioGroup>
        <RadioGroup v-model="animal">
            <Radio label="香蕉"></Radio>
            <Radio label="苹果"></Radio>
            <Radio label="哈密瓜"></Radio>
        </RadioGroup>
     </div>

  </div>
</template>

<script>
  export default {
      name: 'index',
      components: {
        
      },
      methods: {
        show: function () {
              this.visible = true;
      
            }
      },
      data () {
            return {
                 visible: false,
                 phone: 'apple',
                animal: '爪哇犀牛',
                 valueHalf: 2.5,
                cityList: [
                    {
                        value: 'New York',
                        label: 'New York'
                    },
                    {
                        value: 'London',
                        label: 'London'
                    },
                    {
                        value: 'Sydney',
                        label: 'Sydney'
                    },
                    {
                        value: 'Ottawa',
                        label: 'Ottawa'
                    },
                    {
                        value: 'Paris',
                        label: 'Paris'
                    },
                    {
                        value: 'Canberra',
                        label: 'Canberra'
                    }
                ],
                formItem: {
                    input: '',
                    select: '',
                    radio: 'male',
                    checkbox: [],
                    switch: true,
                    date: '',
                    time: '',
                    slider: [20, 50],
                    textarea: ''
                },
                model1: ''
            }
        }
    }
    



</script>

<style scoped>

  .margin-top-10{
    margin-top: 20px;
  }

</style>
