package com.ailen

import android.os.Bundle
import android.widget.TextView
import com.venom.core.base.VBaseActivity
import com.venom.core.imageload.ImageConfig
import com.venom.core.imageload.ImageLoadBaseTool

class MainActivity : VBaseActivity() {

    override fun findLayoutId(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        showDialog()

    }

}
