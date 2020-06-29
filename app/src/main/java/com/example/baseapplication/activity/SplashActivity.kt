package com.example.baseapplication.activity

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import com.example.baseapplication.R
import com.example.baseapplication.entity.SplashEntity
import com.example.baseapplication.main.MainActivity
import com.example.baseapplication.presenter.SplashPresenter
import com.example.baseapplication.view.SplashView

class SplashActivity: BaseActivity(), SplashView {

    private var mPresenter: SplashPresenter? = null

    override fun getLayout(): Int {
        return R.layout.activity_splash
    }

    override fun initPresenter() {
        mPresenter = SplashPresenter(this, this)
    }

    override fun initView(savedInstanceState: Bundle?) {
        //全屏
        setFullScreen()

        //load
        mPresenter!!.loadSplash(1)

    }

    override fun setListener() {

    }

    //全屏
    private fun setFullScreen() {
        if (Build.VERSION.SDK_INT >= 21) {
            val decorView = window.decorView
            val option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            decorView.systemUiVisibility = option
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    override fun loadSplashSuccess(data: List<SplashEntity>?) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun loadSplashFailure(code: Int) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}