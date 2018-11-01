// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import Usfiling from './UsfilingModule.vue'
import router from './../../router/usfilingrouter'
import iView from 'iview'
import 'iview/dist/styles/iview.css'
import VueResource from 'vue-resource'

Vue.use(iView);
Vue.use(VueResource);

Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
  el: '#usfilingapp',
  router,
  components: { Usfiling },
  template: '<Usfiling/>'
})
