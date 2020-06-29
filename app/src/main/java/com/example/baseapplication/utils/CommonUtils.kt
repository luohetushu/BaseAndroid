package com.example.baseapplication.utils

import android.content.Context
import android.view.Gravity
import android.widget.Toast
import androidx.annotation.StringRes
import com.example.baseapplication.main.MainApplication

object CommonUtils {

    /**
     * 获取全局上下文
     * @return
     */
    private fun getContext(): Context {
        return MainApplication.getInstance()
    }

    /**
     * Toast
     * @param text
     */
    fun showToast(text: String) {
        showToast(getContext(), text)
    }

    fun showToast(@StringRes resId: Int) {
        showToast(getContext(), getContext().resources.getString(resId))
    }

    private var toast: Toast? = null
    /**
     * 解决Toast重复弹出 长时间不消失的问题
     */
    private fun showToast(context: Context, text: CharSequence) {
        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT)
            toast!!.setGravity(Gravity.CENTER, 0, 0)
            toast!!.show()
        } else {
            toast!!.setText(text)
            toast!!.show()
        }
    }

}