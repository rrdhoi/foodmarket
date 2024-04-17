package com.bagicode.foodmarketkotlin.ui.detail

import android.view.View
import com.bagicode.foodmarketkotlin.base.BasePresenter
import com.bagicode.foodmarketkotlin.base.BaseView
import com.bagicode.foodmarketkotlin.model.response.checkout.CheckoutResponse
import com.bagicode.foodmarketkotlin.model.response.home.HomeResponse
import com.bagicode.foodmarketkotlin.model.response.login.LoginResponse

interface PaymentContract {

    interface View: BaseView {
        fun onCheckoutSuccess(checkoutResponse: CheckoutResponse, view: android.view.View)
        fun onCheckoutFailed(message:String)

    }

    interface Presenter : PaymentContract, BasePresenter {
        fun getCheckout(foodId:String, userId:String, quantity:String, total:String, view: android.view.View)
    }
}