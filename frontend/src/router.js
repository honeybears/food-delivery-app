
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);



import RestaurantManagementRestaurantManager from "./components/listers/RestaurantManagementRestaurantCards"
import RestaurantManagementRestaurantDetail from "./components/listers/RestaurantManagementRestaurantDetail"

import OrderManagementOrderManager from "./components/listers/OrderManagementOrderCards"
import OrderManagementOrderDetail from "./components/listers/OrderManagementOrderDetail"

import DeliveryManagementDeliveryManager from "./components/listers/DeliveryManagementDeliveryCards"
import DeliveryManagementDeliveryDetail from "./components/listers/DeliveryManagementDeliveryDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [

            {
                path: '/restaurantManagements/restaurants',
                name: 'RestaurantManagementRestaurantManager',
                component: RestaurantManagementRestaurantManager
            },
            {
                path: '/restaurantManagements/restaurants/:id',
                name: 'RestaurantManagementRestaurantDetail',
                component: RestaurantManagementRestaurantDetail
            },

            {
                path: '/orderManagements/orders',
                name: 'OrderManagementOrderManager',
                component: OrderManagementOrderManager
            },
            {
                path: '/orderManagements/orders/:id',
                name: 'OrderManagementOrderDetail',
                component: OrderManagementOrderDetail
            },

            {
                path: '/deliveryManagements/deliveries',
                name: 'DeliveryManagementDeliveryManager',
                component: DeliveryManagementDeliveryManager
            },
            {
                path: '/deliveryManagements/deliveries/:id',
                name: 'DeliveryManagementDeliveryDetail',
                component: DeliveryManagementDeliveryDetail
            },




    ]
})
