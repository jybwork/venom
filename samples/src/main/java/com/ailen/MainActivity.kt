package com.ailen

import android.os.Bundle
import com.venom.core.base.KBaseActivity

class MainActivity : KBaseActivity() {

    override fun findLayoutId(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        showDialog()
    }

}
