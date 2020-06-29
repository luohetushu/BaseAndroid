package com.example.baseapplication.entity


import android.content.pm.PackageInfo
import com.example.baseapplication.R
import com.example.baseapplication.main.MainApplication
import java.io.Serializable

/**
 * @Author murongyunge
 * @Describe
 * @Date 2019-12-18
 */
class BaseHeader: Serializable {
    var sessionId: String? = null

    var msgType: String? = "0"

    var action: String? = null

    var deviceType: Int = 4

    var version: String = "1.0.0"

    var locLatitude: Double = 0.toDouble()

    var locLongitude: Double = 0.toDouble()

    var page: BasePager? = null
    var code: Int = 0
    var msg: String? = null
    var appName: String = MainApplication.getInstance().getString(R.string.app_name)
    var appPackage: String = MainApplication.getInstance().packageName

    constructor()

    constructor(header: BaseHeader): this(){
        this.action = header.action
        this.sessionId = header.sessionId
        if (header.page != null && this.page == null) {
            this.page = header.page
        }
    }

}