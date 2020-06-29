package com.example.baseapplication.presenter

import android.content.Context
import com.alibaba.fastjson.JSON
import com.example.baseapplication.entity.BaseHeader
import com.example.baseapplication.entity.SplashEntity
import com.example.baseapplication.http.ApiRetrofit
import com.example.baseapplication.http.ApiService
import com.example.baseapplication.http.BaseObserver
import com.example.baseapplication.request.SplashRequest
import com.example.baseapplication.utils.ConstantUtils
import com.example.baseapplication.utils.SharedPreUtils
import com.example.baseapplication.view.SplashView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.RequestBody

/**
 * @Author murongyunge
 * @Describe
 * @Date 2019-12-19
 */
class SplashPresenter(var mContext: Context, var mView: SplashView): ISplashPresenter{

    private val apiService: ApiService = ApiRetrofit.getInstance()!!.getApiService()

    override fun loadSplash(type: Int) {
        val request = SplashRequest()
        request.bannerType = type
        request.mac = "25:21:56:12:we"
        request.header.sessionId = SharedPreUtils.getString(ConstantUtils.SESSION_ID, null)
        val jsonString = JSON.toJSONString(request)
        val requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonString)
        apiService.loadSplash(requestBody)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : BaseObserver<List<SplashEntity>>(mContext, mView, false){
                override fun onSuccess(data: List<SplashEntity>?, header: BaseHeader) {
                    mView.loadSplashSuccess(data)
                }

                override fun onFailure(code: Int, message: String) {
                    mView.loadSplashFailure(code)
                }

                override fun onError(e: Throwable) {
                    super.onError(e)
                    mView.loadSplashFailure(-1)
                }

            })
    }
}