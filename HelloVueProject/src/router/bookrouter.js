import Vue from 'vue'
import Router from 'vue-router'

import index from './../modules/book/pages/index.vue'
import pageBook from './../modules/book/pages/pageBook.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: index
    },
    {
      path: '/book',
      name: 'book',
      component: pageBook
    },
    
  ]
})
