
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/OrderManager"
import PaymentManager from "./components/PaymentManager"

import StoreOrderManager from "./components/StoreOrderManager"
import MenuManager from "./components/MenuManager"

import TopBook from "./components/TopBook"
import DeliveryManager from "./components/DeliveryManager"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/payments',
                name: 'PaymentManager',
                component: PaymentManager
            },

            {
                path: '/storeOrders',
                name: 'StoreOrderManager',
                component: StoreOrderManager
            },
            {
                path: '/menus',
                name: 'MenuManager',
                component: MenuManager
            },

            {
                path: '/topBooks',
                name: 'TopBook',
                component: TopBook
            },
            {
                path: '/deliveries',
                name: 'DeliveryManager',
                component: DeliveryManager
            },



    ]
})
