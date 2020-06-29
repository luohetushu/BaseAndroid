package com.example.baseapplication.request

import com.example.baseapplication.entity.BaseHeader


open class BaseRequest {

    lateinit var header: BaseHeader

    open fun createHeader() {
        header = BaseHeader()
        header.action = BaseHeader().action
    }
}
