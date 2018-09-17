// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import User from './UserModule.vue'
import router from './../../router/userrouter'
import iView from 'iview'
import 'iview/dist/styles/iview.css'
import VueResource from 'vue-resource'

Vue.use(iView);
Vue.use(VueResource);

Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
  el: '#userapp',
  router,
  components: { User },
  template: '<User/>'
})
