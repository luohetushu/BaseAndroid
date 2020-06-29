package com.example.baseapplication.view

import com.example.baseapplication.entity.SplashEntity


/**
 * @Author murongyunge
 * @Describe
 * @Date 2019-12-19
 */
interface SplashView: BaseView {
    fun loadSplashSuccess(data: List<SplashEntity>?)

    fun loadSplashFailure(code: Int)

}