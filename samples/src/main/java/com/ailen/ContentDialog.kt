package com.ailen

import android.os.Bundle
import com.venom.core.base.VBaseFragDialog
import kotlinx.android.synthetic.main.frag_content_dialog.*

/**
 * 类描述:
 * 创建人:    Ailen
 * 创建时间: 2020/7/9 11:12
 * 修改时间:  ?
 * 修改备注:  说明本次修改内容
 */
class ContentDialog : VBaseFragDialog() {
    companion object {
        fun newInstance(mContent: String): ContentDialog {
            var instance = ContentDialog()
            val args = Bundle()
            args.putString("content", mContent)
            instance.arguments = args
            return instance;
        }
    }

    private lateinit var mContent: String
    override fun findLayoutId(savedInstanceState: Bundle?): Int {
        return R.layout.frag_content_dialog
    }

    override fun initView() {
        mContent = arguments?.getString("content").toString()
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
//        dialog?.setOnKeyListener { _, keyCode, _ ->
//            keyCode == KeyEvent.KEYCODE_BACK
//        }
        tv_content?.text = mContent
        cancel.setOnClickListener {
            dialog?.dismiss()
        }
        confirm.setOnClickListener {
            dialog?.dismiss()
        }
    }
}