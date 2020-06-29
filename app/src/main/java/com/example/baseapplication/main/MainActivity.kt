package com.example.baseapplication.main

import android.os.Bundle
import com.example.baseapplication.R
import com.example.baseapplication.activity.BaseActivity

/**
 * @Author murongyunge
 * @Describe
 * @Date 2020/3/5
 */
class MainActivity: BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun initPresenter() {

    }

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun setListener() {

    }
}