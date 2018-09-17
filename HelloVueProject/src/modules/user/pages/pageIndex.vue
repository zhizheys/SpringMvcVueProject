
<template>
  <div id="pageIndex">
     <div style="margin:10px auto;width:500px;">
        
        <div class="margin-top-10">
          <i-button @click="show">Click me!</i-button>
        </div>
       
        <div class="margin-top-10">
            Props：
            <Input prefix="ios-contact" placeholder="Enter name" style="width: auto" />
        </div>

     <div class="margin-top-10">
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

     <div class="margin-top-10">
       <Row>
          <span span="12">
              <DatePicker type="date" placeholder="Select date" style="width: 200px"></DatePicker>
          </span>
          <span span="12">
              <DatePicker type="daterange" placement="bottom-end" placeholder="Select date" style="width: 200px"></DatePicker>
          </span>
      </Row>
     </div>

     <div class="margin-top-10">
       <Rate allow-half v-model="valueHalf" />
     </div>

     <div class="margin-top-10">
     </div>


        
        <Modal v-model="visible" title="Welcome">Welcome to iView</Modal>
        
        

      <Form :model="formItem" :label-width="80">
          <FormItem label="Input">
              <Input v-model="formItem.input" placeholder="Enter something..."></Input>
          </FormItem>
          <FormItem label="Select">
              <Select v-model="formItem.select">
                  <Option value="beijing">New York</Option>
                  <Option value="shanghai">London</Option>
                  <Option value="shenzhen">Sydney</Option>
              </Select>
          </FormItem>
          <FormItem label="DatePicker">
              <Row>
                  <Col span="11">
                      <DatePicker type="date" placeholder="Select date" v-model="formItem.date"></DatePicker>
                  </Col>
                  <Col span="2" style="text-align: center">-</Col>
                  <Col span="11">
                      <TimePicker type="time" placeholder="Select time" v-model="formItem.time"></TimePicker>
                  </Col>
              </Row>
          </FormItem>
          <FormItem label="Radio">
              <RadioGroup v-model="formItem.radio">
                  <Radio label="male">Male</Radio>
                  <Radio label="female">Female</Radio>
              </RadioGroup>
          </FormItem>
          <FormItem label="Checkbox">
              <CheckboxGroup v-model="formItem.checkbox">
                  <Checkbox label="Eat"></Checkbox>
                  <Checkbox label="Sleep"></Checkbox>
                  <Checkbox label="Run"></Checkbox>
                  <Checkbox label="Movie"></Checkbox>
              </CheckboxGroup>
          </FormItem>
          <FormItem label="Switch">
              <i-switch v-model="formItem.switch" size="large">
                  <span slot="open">On</span>
                  <span slot="close">Off</span>
              </i-switch>
          </FormItem>
          <FormItem label="Slider">
              <Slider v-model="formItem.slider" range></Slider>
          </FormItem>
          <FormItem label="Text">
              <Input v-model="formItem.textarea" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="Enter something..."></Input>
          </FormItem>
          <FormItem>
              <Button type="primary">Submit</Button>
              <Button style="margin-left: 8px">Cancel</Button>
          </FormItem>
      </Form>

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

  /*列表*/
.mod-parallel{
  overflow: hidden;
}
.mod-parallel .img-list{
  overflow: hidden;
  padding-top: 8px;
}
.mod-parallel .img-list .img-box{
  height: 50px;
  border: none;
  width: 25%;
  border-right: 12px solid transparent;
  border-left: 12px solid transparent;
  float: left;
  margin: 0 0 8px 0;
  position: relative;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}
.mod-parallel .img-list .img-item{
  display: block;
  width: 100%;
  margin: 0;
  background-position: 50% 50%;
  background-color: #19C3FF;
  background-repeat: no-repeat;
  background-size: cover;
  padding-top: 100%;/*宽高比*/
}
.mod-parallel .img-list.type-full{
  margin: 0 -1px;
}
.mod-parallel .img-list.type-full .img-box{
  border-right-width: 1px;
  border-left-width: 1px;
  margin: 0 0 2px 0;
}
.mod-parallel .img-list.type-full .img-item{
  border-radius: 0;
}
.mod-parallel a,
.mod-parallel .page-link{
  position: absolute;
  display: block;
  text-align: center;
  height: 100%;
  top: 0;
  color: #fff;
  text-decoration: none;
  line-height: inherit;
  width: 100%;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-box-pack: center;
  -webkit-box-align: center;
}


</style>
