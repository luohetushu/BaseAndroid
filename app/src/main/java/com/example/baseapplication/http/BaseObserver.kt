package com.example.baseapplication.http

import android.content.Context
import com.example.baseapplication.entity.BaseHeader
import com.example.baseapplication.entity.BaseResponse
import com.example.baseapplication.utils.CommonUtils
import com.example.baseapplication.view.BaseView
import io.reactivex.observers.DisposableObserver
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class BaseObserver<T>: DisposableObserver<BaseResponse<T>> {

    private var mContext: Context? = null
    private var baseView: BaseView? = null

    //是否显示加载框
    private var showProgress: Boolean = false

    constructor(context: Context, baseView: BaseView, show: Boolean){
        this.mContext = context
        this.baseView = baseView
        this.showProgress = show
    }

    override fun onStart() {
        super.onStart()
        if (showProgress && baseView != null){
            baseView!!.showProgressDialog()
        }
    }

    override fun onNext(response: BaseResponse<T>) {
        if (showProgress && baseView != null){
            baseView!!.dismissProgressDialog()
        }
        if (response.header!!.code == 0){
            onSuccess(response.data, response.header!!)
        } else {
            onFailure(response.header?.code!!, response.header?.msg!!)
        }
    }

    override fun onError(e: Throwable) {
        if (showProgress && baseView != null){
            baseView!!.dismissProgressDialog()
        }
        var errMsg = ""
        when (e){
            is HttpException -> {
                errMsg = e.message!!
            }
            is SocketTimeoutException -> {
                errMsg = e.message!!
            }
            is ConnectException -> {
                errMsg = e.message!!
            }
            is UnknownHostException -> {
                errMsg = e.message!!
            }
        }
        CommonUtils.showToast(errMsg)
    }

    override fun onComplete() {
        if (showProgress && baseView != null){
            baseView!!.dismissProgressDialog()
        }
    }

    abstract fun onSuccess(data: T?, header: BaseHeader)

    abstract fun onFailure(code: Int, message: String)

}