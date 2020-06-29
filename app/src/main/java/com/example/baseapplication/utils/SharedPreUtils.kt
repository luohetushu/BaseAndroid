package com.example.baseapplication.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.baseapplication.main.MainApplication

/**
 * @Author murongyunge
 * @Describe
 * @Date 2019-12-19
 */
object SharedPreUtils {

    @Volatile
    private var sp: SharedPreferences? = null

    /**
     * 获取sp实例
     */
    private fun getSP(context: Context): SharedPreferences? {
        if (sp == null) {
            synchronized(SharedPreUtils::class.java) {
                if (sp == null) {
                    sp = context.getSharedPreferences(ConstantUtils.FILE_NAME, Context.MODE_PRIVATE)
                }
            }

        }
        return sp
    }

    private val context = MainApplication.getInstance()

    /**
     * 保存boolean变量
     */
    fun saveBoolean(key: String, value: Boolean) {
        getSP(context)!!.edit().putBoolean(key, value).apply()
    }

    /**
     * 获取布局型变量的值
     * @param key
     * @param defValue 获取不到时，给定的默认的值
     * @return
     */
    fun getBoolean(key: String, defValue: Boolean): Boolean {
        return getSP(context)!!.getBoolean(key, defValue)
    }

    /**
     * 保存字符串变量
     */
    fun saveString(key: String, value: String) {
        getSP(context)!!.edit().putString(key, value).apply()
    }

    /**
     * 获取字符串型变量的值
     * @param key
     * @param defValue 获取不到时，给定的默认的值
     * @return
     */
    fun getString(key: String, defValue: String?): String? {
        return getSP(context)!!.getString(key, defValue)
    }

    /**
     * 保存小数变量
     */
    fun saveFloat(key: String, value: Float) {
        getSP(context)!!.edit().putFloat(key, value).apply()
    }

    /**
     * 获取浮点型变量的值
     * @param key
     * @param defValue 获取不到时，给定的默认的值
     * @return
     */
    fun getFloat(key: String, defValue: Float): Float {
        return getSP(context)!!.getFloat(key, defValue)
    }

    /**
     * 保存整型变量
     */
    fun saveInt(key: String, value: Int) {
        getSP(context)!!.edit().putInt(key, value).apply()
    }

    /**
     * 获取整型变量的值
     * @param key
     * @param defValue 获取不到时，给定的默认的值
     * @return
     */
    fun getInt(key: String, defValue: Int): Int {
        return getSP(context)!!.getInt(key, defValue)
    }

    /**
     * 保存Long变量
     */
    fun saveLong(key: String, value: Long) {
        getSP(context)!!.edit().putLong(key, value).apply()
    }

    /**
     * 获取Long变量的值
     * @param key
     * @param defValue 获取不到时，给定的默认的值
     * @return
     */
    fun getLong(key: String, defValue: Long): Long {
        return getSP(context)!!.getLong(key, defValue)
    }

}