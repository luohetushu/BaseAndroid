package com.example.baseapplication.http

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @Author murongyunge
 * @Describe
 * @Date 2019-12-18
 */
class ApiRetrofit {

    companion object {
        const val BASE_URL = "http://api-vn.sanjinxia.com"

        //time out
        const val TIME_OUT = 20

        @Volatile
        private var apiRetrofit: ApiRetrofit? = null

        fun getInstance(): ApiRetrofit? {
            if (apiRetrofit == null) {
                synchronized(ApiRetrofit::class.java) {
                    if (apiRetrofit == null) {
                        apiRetrofit = ApiRetrofit()
                    }
                }
            }
            return apiRetrofit
        }

    }

    private val httpClient: OkHttpClient
        get() {

            /**
             * 请求访问quest
             * response拦截器
             */
            val interceptor = Interceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    .method(original.method(), original.body())
                    .build()
                val response = chain.proceed(request)
                val mediaType = response.body()!!.contentType()
                val content = response.body()!!.string()
                Log.e("TAG", "----------Request Start----------------")
                Log.e("TAG", "| Response:$content")
                Log.e("TAG", "----------Request End----------")
                response.newBuilder().body(ResponseBody.create(mediaType, content)).build()
            }

            return OkHttpClient.Builder()
                .connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
                .readTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
                .callTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
                .addInterceptor(interceptor)  //添加log拦截器
                .build()
        }

    private val retrofit: Retrofit
    private val apiService: ApiService

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            //支持RxJava2
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    fun getApiService(): ApiService {
        return apiService
    }

}