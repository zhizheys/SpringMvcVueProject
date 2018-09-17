import Vue from 'vue'
import Router from 'vue-router'

import index from './../modules/user/pages/pageIndex.vue'
import pageUser from './../modules/user/pages/pageUser.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: index
    },
    {
      path: '/user',
      name: 'user',
      component: pageUser
    },
    
  ]
})
