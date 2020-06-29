package com.example.baseapplication.request

import com.example.baseapplication.http.ApiAction


class SplashRequest : BaseRequest() {
    var bannerType: Int = 0
    var mac: String? = null
    init {
        createHeader()
    }

    override fun createHeader() {
        super.createHeader()
        header.action = ApiAction.SPLASH
    }
}
