
<template>
    
    <div id="pageUser" style="margin:20px auto;width:1000px;">
            <div style="width:1000px;margin-top:20px;">
                    <Form :label-width="120">
                        <FormItem>
                            <Row style="float:right;">
                                <Button type="primary">Save</Button>
                            </Row>
                        </FormItem>
                  </Form>
            </div>

            <div style="width:1000px;margin-top:20px;">
                    <Table class="margin-top-10" height="500" :columns="parseDataColumn" :data="parseDataContent" size="small" ref="table"></Table>
            </div>

    </div>
  </template>


<script>
  export default {
      name: 'index',
      components: {
        
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
                parseDataColumn: [
                    {
                        "title": "FundId",
                        "key": "fundId",
                        "width": 150
                    },
                    {
                        "title": "SecId",
                        "key": "secId",
                        "width": 150
                    },
                    {
                        "title": "EffectiveDate",
                        "key": "effectiveDate",
                        "width": 150,
                        "sortable": true
                    },
                    {
                        "title": "DocumentId",
                        "key": "documentId",
                        "width": 150,
                        "sortable": true
                    },
                    {
                        "title": "DataPointName",
                        "key": "dataPointName",
                        "width": 150,
                        "sortable": true
                    },
                    {
                        "title": "RawValue",
                        "key": "rawValue",
                        "width": 150,
                        "sortable": true
                    },
                    {
                        "title": "TransformValue",
                        "key": "transformValue",
                        "width": 150,
                        "sortable": true
                    },
                    {
                        "title": "MsValue",
                        "key": "msValue",
                        "width": 150,
                        "sortable": true
                    },
                    {
                        "title": "CompareResult",
                        "key": "compareResult",
                        "width": 150,
                        "sortable": true
                    },
                    {
                        "title": "ProcessStatus",
                        "key": "processStatus",
                        "width": 150,
                        "sortable": true
                    },
                    {
                        "title": "ValidationMessage",
                        "key": "validationMessage",
                        "width": 150,
                        "sortable": true
                    }
                    
                ],
                parseDataContent: []
            }
        },
        methods:{
            show (index) {
                    this.formItem=this.parseDataContent[index];
            },
            getAllParseData: function () {
                
                var parseDataInfo=[
                {"fundId":"FSAUS05ISW", "secId":"F0AUS05EX7", "effectiveDate":"2018/08/09","documentId":"105650956","dataPointName":"Management Fee","rawValue":"0.1","transformValue":"0.2","msValue":"0.3","compareResult":"UnMatch","processStatus":"pending","validationMessage":"ok"},
                {"fundId":"FSAUS05ISW", "secId":"F0AUS05EX7", "effectiveDate":"2018/08/09","documentId":"105650956","dataPointName":"Management Fee","rawValue":"0.1","transformValue":"0.2","msValue":"0.3","compareResult":"UnMatch","processStatus":"pending","validationMessage":"ok"},
				{"fundId":"FSAUS05ISW", "secId":"F0AUS05EX7", "effectiveDate":"2018/08/09","documentId":"105650956","dataPointName":"Management Fee","rawValue":"0.1","transformValue":"0.2","msValue":"0.3","compareResult":"UnMatch","processStatus":"pending","validationMessage":"ok"}
                ];

                this.parseDataContent=parseDataInfo;
                
                    
            }
        },
        mounted:function(){
            this.getAllParseData();

        }
    }
    



</script>

<style scoped>

  .margin-top-10{
    margin-top: 20px;
  }

</style>
