package com.bagicode.foodmarketkotlin.ui.auth.signin

import com.bagicode.foodmarketkotlin.base.BasePresenter
import com.bagicode.foodmarketkotlin.base.BaseView
import com.bagicode.foodmarketkotlin.model.response.login.LoginResponse

interface SigninContract {

    interface View: BaseView {
        fun onLoginSuccess(loginResponse: LoginResponse)
        fun onLoginFailed(message:String)

    }

    interface Presenter : SigninContract, BasePresenter {
        fun subimtLogin(email:String, password:String)
    }
}