package com.bagicode.foodmarketkotlin.ui.order

import com.bagicode.foodmarketkotlin.base.BasePresenter
import com.bagicode.foodmarketkotlin.base.BaseView
import com.bagicode.foodmarketkotlin.model.response.home.HomeResponse
import com.bagicode.foodmarketkotlin.model.response.login.LoginResponse
import com.bagicode.foodmarketkotlin.model.response.transaction.TransactionResponse

interface OrderContract {

    interface View: BaseView {
        fun onTransactionSuccess(transactionResponse: TransactionResponse)
        fun onTransactionFailed(message:String)

    }

    interface Presenter : OrderContract, BasePresenter {
        fun getTransaction()
    }
}