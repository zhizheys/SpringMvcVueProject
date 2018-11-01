import Vue from 'vue'
import Router from 'vue-router'

import index from './../modules/usfiling/pages/pageIndex.vue'
import pageUsfiling from './../modules/usfiling/pages/pageUsfiling.vue'
import pageParseProcess from './../modules/usfiling/pages/pageParseProcess.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: index
    },
    {
      path: '/usfiling',
      name: 'usfiling',
      component: pageUsfiling
    },
    {
      path: '/parseprocess',
      name: 'parseprocess',
      component: pageParseProcess
    }
    
  ]
})
