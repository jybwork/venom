package com.venom.core.base

import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

abstract class VBaseActivity : AppCompatActivity(), BaseView {
    lateinit var mContext: VBaseActivity
    lateinit var mDialog: AlertDialog.Builder

    /**
     * 用英语修饰隶属于本类的静态变量于方法
     * 类似于object的修饰  但是不是单例
     */
    companion object {
        val TAG: String = javaClass.simpleName
    }


    @LayoutRes
    protected abstract fun findLayoutId(savedInstanceState: Bundle?): Int

    //初始化
    protected abstract fun initView();


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        mDialog = AlertDialog.Builder(mContext)
        setContentView(findLayoutId(savedInstanceState))
        initView()
    }

    override fun showDialog() {
        mDialog
            .setTitle("提示")
            .setMessage("加载中，请稍等!")
            .create()
            .show()
    }

    override fun closeDialog() {
        mDialog.create().dismiss()
    }

    /**
     * 隐藏输入框
     */
    fun hideSoftKeyboard() {
        if (window.attributes.softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
                currentFocus?.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )

        }

    }
}