package com.example.baseapplication.presenter

/**
 * @Author murongyunge
 * @Describe
 * @Date 2019-12-19
 */
interface ISplashPresenter {
    /**
     * @param type 1：开屏  2：弹窗  3浮窗
     */
    fun loadSplash(type: Int)
}