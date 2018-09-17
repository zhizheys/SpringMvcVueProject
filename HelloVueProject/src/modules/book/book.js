// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import Book from './BookModule.vue'
import router from './../../router/bookrouter'
import iView from 'iview'
import 'iview/dist/styles/iview.css'
import VueResource from 'vue-resource'

Vue.use(iView);
Vue.use(VueResource);

Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
  el: '#bookapp',
  router,
  components: { Book },
  template: '<Book/>'
})
