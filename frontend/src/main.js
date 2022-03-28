 /*eslint-disable*/
import Vue from "vue";
import App from "./App.vue";
import vuetify from "./plugins/vuetify";
import Managing from "./components";
import router from './router'
Vue.config.productionTip = false;

const axios = require("axios").default;

// backend host url
<<<<<<< LOCAL 
 
 
axios.backend = "http://localhost:8088";
 
 

=======
axios.backend = null; //"http://localhost:8088";
 
>>>>>>> NEW 

<<<<<<< LOCAL 
 
 
axios.backendUrl = new URL(axios.backend);
 
 

=======
// axios.backendUrl = new URL(axios.backend);
 
>>>>>>> NEW 
axios.fixUrl = function(original){

  if(!axios.backend) return original;

  var url = null;

  try{
    url = new URL(original);
  }catch(e){
    url = new URL(axios.backend + original);
  }

  url.hostname = axios.backendUrl.hostname;
  url.port = axios.backendUrl.port;

  return url.href;
}

const templateFiles = require.context("./components", true);
Vue.prototype.$ManagerLists = [];
templateFiles.keys().forEach(function(tempFiles) {
  if (!tempFiles.includes("Manager.vue") && tempFiles.includes("vue")) {
    Vue.prototype.$ManagerLists.push(
      tempFiles.replace("./", "").replace(".vue", "")
    );
  }
});
Vue.use(Managing);
const pluralCaseList = []

pluralCaseList.push( {plural: "orders", pascal: "Order"} )
pluralCaseList.push( {plural: "payments", pascal: "Payment"} )

pluralCaseList.push( {plural: "storeOrders", pascal: "StoreOrder"} )
pluralCaseList.push( {plural: "menus", pascal: "Menu"} )

pluralCaseList.push( {plural: "topBooks", pascal: "TopBook"} )
pluralCaseList.push( {plural: "deliveries", pascal: "Delivery"} )


Vue.prototype.$ManagerLists.forEach(function(item, idx) {
  pluralCaseList.forEach(function(tmp) {
    if(item.toLowerCase() == tmp.pascal.toLowerCase()) {
      var obj = {
        name: item,
        plural: tmp.plural
      }
      Vue.prototype.$ManagerLists[idx] = obj
    }
  })
})

new Vue({
  vuetify,
  router,
  render: h => h(App)
}).$mount("#app");
