package com.example.baseapplication.utils

import androidx.appcompat.app.AppCompatActivity
import java.util.LinkedList


class AppManagerUtils private constructor() {

    companion object {
        private var instance: AppManagerUtils? = null
        //单例模式中获取唯一的 AppManagerUtils 实例
        fun getInstance(): AppManagerUtils {
            if (null == instance) {
                instance = AppManagerUtils()
            }
            return instance as AppManagerUtils
        }
    }

    private val activityList = LinkedList<AppCompatActivity>()

    //添加Activity到容器中
    fun addActivity(activity: AppCompatActivity) {
        activityList.add(activity)
    }

    fun removeActivity(activity: AppCompatActivity) {
        activityList.remove(activity)
    }

    //清除activity
    fun finish() {
        for (activity in activityList) {
                activity.finish()
        }
    }

    //清除或者保留指定activity
    fun finish(simpleName: String, isReserve: Boolean) {
        for (activity in activityList) {
            if (isReserve != (activity.javaClass.simpleName == simpleName)) {
                activity.finish()
            }
        }
    }

    //获取指定的activity
    fun getActivityBySimpleName(simpleName: String): AppCompatActivity? {
        for (activity in activityList) {
            if (activity.javaClass.simpleName == simpleName) {
                return activity
            }
        }
        return null
    }


}
