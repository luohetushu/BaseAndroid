package com.example.baseapplication.entity

import java.io.Serializable

/**
 * @Author murongyunge
 * @Describe
 * @Date 2019-12-18
 */
class BaseResponse<T>: Serializable {
    var header: BaseHeader? = null
    var data: T? = null
}