package com.example.kotlinmvplogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlinmvplogin.Presenter.ILoginPresenter
import com.example.kotlinmvplogin.Presenter.LoginPresenter
import com.example.kotlinmvplogin.View.ILoginView
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ILoginView {
    override fun onLoginResult(message: String) {
        Toasty.info(this,message, Toast.LENGTH_SHORT).show()
    }

    internal lateinit var loginPresenter: ILoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init
        loginPresenter = LoginPresenter(this)

        //Event
        btn_login.setOnClickListener {
            loginPresenter.onLogin(edt_email.text.toString(),edt_password.text.toString())
        }
    }
}
