package com.example.baseapplication.activity

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.baseapplication.custom.ProgressDialog
import com.example.baseapplication.utils.AppManagerUtils
import com.example.baseapplication.view.BaseView

/**
 * @Author murongyunge
 * @Describe
 * @Date 2019-12-19
 */
abstract class BaseActivity: AppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayout())

        AppManagerUtils.getInstance().addActivity(this)

        initPresenter()
        initView(savedInstanceState)
        setListener()

    }

    //布局
    protected abstract fun getLayout(): Int

    //presenter
    protected abstract fun initPresenter()

    //view 控件
    protected abstract fun initView(savedInstanceState: Bundle?)

    //事件监听
    protected abstract fun setListener()

    //加载框
    private var mProgress: ProgressDialog? = null

    override fun showProgressDialog() {
        mProgress = ProgressDialog(this, false)
        if (!isFinishing){
            mProgress!!.show()
        }
    }

    override fun dismissProgressDialog() {
        if (mProgress != null && mProgress!!.isShowing){
            mProgress!!.dismiss()
            mProgress = null
        }
    }

    /**
     * 防止字体受系统字体大小影响
     * @return
     */
    override fun getResources(): Resources {
        val res = super.getResources()
        val config = Configuration()
        config.setToDefaults()
        res.updateConfiguration(config, res.displayMetrics)
        return res
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManagerUtils.getInstance().removeActivity(this)
    }

}