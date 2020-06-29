package com.example.baseapplication.http

import com.example.baseapplication.entity.BaseResponse
import com.example.baseapplication.entity.SplashEntity
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    /**
     * 启动页加载
     */
    @POST("/xjdApi/doCall")
    fun loadSplash(@Body requestBody: RequestBody): Observable<BaseResponse<List<SplashEntity>>>

}