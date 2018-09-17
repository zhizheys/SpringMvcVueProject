
<template>
  <div id="pageIndex">
     <div style="margin:10px auto;width:500px;">
        <h1>the user index vue</h1>
     <div class="margin-top-10">
       
     </div>

     <div class="margin-top-10">
       <Select  style="width:200px">
            <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
        </Select>

        <Row>
        <span span="12" style="padding-right:10px">
            <Select  filterable>
                <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
            </Select>
        </span>
        <span span="12">
            <Select  filterable multiple>
                <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
            </Select>
        </span>
    </Row>

     </div>


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
