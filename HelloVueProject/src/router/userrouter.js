import Vue from 'vue'
import Router from 'vue-router'

import index from './../modules/user/pages/pageIndex.vue'
import pageUser from './../modules/user/pages/pageUser.vue'
import pageQuiButton from './../modules/user/pages/pageQuiButton.vue'
import pageQuiList from './../modules/user/pages/pageQuiList.vue'
import pageQuiNav from './../modules/user/pages/pageQuiNav.vue'

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
    {
      path: '/btn',
      name: 'btn',
      component: pageQuiButton
    },
    {
      path: '/list',
      name: 'list',
      component: pageQuiList
    },
    {
      path: '/nav',
      name: 'nav',
      component: pageQuiNav
    }
    
  ]
})
