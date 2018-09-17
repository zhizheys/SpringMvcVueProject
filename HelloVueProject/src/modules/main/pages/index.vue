
<template>
  <div id="pageIndex">
      <p>module info is: {{msg}}</p>
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
                msg:'aaa',
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
