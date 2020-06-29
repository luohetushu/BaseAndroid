package com.example.baseapplication.custom

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.example.baseapplication.R

class ProgressDialog @JvmOverloads constructor(
    context: Context?,
    private val canCancel: Boolean = false
) : Dialog(context!!, R.style.ProgressDialog) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_progress)
        setCancelable(canCancel)
        setCanceledOnTouchOutside(canCancel)
    }
}
