package com.example.baseapplication.fragment

import androidx.fragment.app.Fragment
import com.example.baseapplication.view.BaseView

/**
 * @Author murongyunge
 * @Describe
 * @Date 2019-10-23
 */
abstract class BaseFragment : Fragment(), BaseView {

    override fun onResume() {
        super.onResume()
        if (isAdded && !isHidden) {
            onVisible();
        }
    }

    override fun onPause() {
        super.onPause()
        if (isVisible){
            onHidden()
        }
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) {
            onVisible()
        } else {
            onHidden()
        }
    }

    protected abstract fun onVisible()

    protected abstract fun onHidden()

    override fun showProgressDialog() {

    }

    override fun dismissProgressDialog() {

    }

}