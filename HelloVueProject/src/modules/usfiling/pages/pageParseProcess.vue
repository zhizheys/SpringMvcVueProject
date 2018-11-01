
<template>
        <div id="appModuleDiv">
           
          <div style="width:1000px;margin:10px auto;">

            <div style="width:800px;margin-top:20px;">
                <Form :label-width="120">
                    <FormItem>
                        <Row style="float:right;">
                            <Button type="primary">New Company</Button>
                            <Button style="margin-left: 8px">New RegularExpress</Button>
                        </Row>
                    </FormItem>
              </Form>
            </div>
      
            <div style="width:500px;margin-top:50px;">
                
                <Form :label-width="120">
                    <FormItem label="Select Company:">
                        <Select  filterable>
                            <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                        </Select>
                    </FormItem>
      
                   
                    <FormItem label="Filing Id:">
                            <Input placeholder="Enter filing id..." style="width: auto" />
                    </FormItem>
      
                    <FormItem>
                        <Button type="primary">Start Parse File</Button>
                   </FormItem>
      
              </Form>
            </div>
      
          <div style="clear:both;margin-top:50px;">
              <div style="width:500px; float:left;border:0px solid red;">
                  <Steps :current="1" direction="vertical">
                    <Step title="准备文档" content="准备US filing文档和选择对应的公司以及正则表达式"></Step>
                    <Step title="切割Filing" content="将Filing文档切割为Document文件"></Step>
                    <Step title="提取Fund信息" content="提取Fund summary整块信息和涉及到的Fund信息,并进行compare比较" status="error"></Step>
                    <Step title="提取Management信息" content="提取Management信息"></Step>
                    <Step title="提取Fees and Expenses" content="提取Fees and Expenses 信息"></Step>
                    <Step title="提取Fund Risks" content="提取Fund Risks信息"></Step>
                  </Steps>
              </div>
              <div id="step-resut-div" style="border:0px solid blue;">
                <ul>
                  <li><a href="http://www.w3school.com.cn">step 1-result</a></li>
                  <li>step 2-result</li>
                  <li>step 3-result</li>
                  <li>step 4-result</li>
                  <li>step 5-result</li>
                  <li>step 6-result</li>
                </ul>
              </div>
          </div>
      
           
              
           <div style="clear:both;margin-bottom: 50px;">
              <h3 style="margin-top:40px;">Current step process messge is: {{msg}}</h3>
           </div>
           <p></p>
      
      
          </div>
        </div>
      
      </template>
      
      <script>
        export default {
          name: 'pageParseProcess',
          data () {
                  return {
                      msg: null,
                      cityList: [
                          {
                              value: '1',
                              label: 'Goldman Sachs Trust'
                          },
                          {
                              value: '2',
                              label: 'JPMorganTrust'
                          }
                      ]
                  }
              },
          methods:{
            aMouseover:function(index){
               this.msg=this.moduleInfo[index];
            },
            next () {
                      alert("cc");
                  }
          }
        }
      </script>
      
      <style scoped>
         
      
        tr{
              height: 150px;
              line-height: 150px;
          }
      
          td{
              width:30%;
              text-align: center;
              margin-left: 200px;
              font-size: 20px;
              font-weight: bolder;
              color:#515a6e;
          }
      
        .green-b{
          background-color: #19be6b;
        }
      
         .yellow-b{
          background-color:#ff9900;
        }
      
         .blue-b{
          background-color:#2db7f5;
        }
      
           .blue-1{
          background-color:#5cadff;
        }
      
           .blue-2{
          background-color:#515a6e;
        }
           .blue-3{
          background-color:#808695;
        }
      
       #step-resut-div ul li{
          height: 65px;
          list-style:none;
          font-weight: bolder;
          font-size: 15px;
        }
      
      
      
      </style>
            