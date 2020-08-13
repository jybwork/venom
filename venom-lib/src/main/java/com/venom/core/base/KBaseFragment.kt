package com.venom.core.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class KBaseFragment : KLazyFragment(), BaseView {
    protected var rootView: View? = null

    protected var mContext: Context? = null

    /**
     * 用英语修饰隶属于本类的静态变量于方法
     * 类似于object的修饰  但是不是单例
     */
    companion object {
        val TAG: String = javaClass.simpleName;
    }

    @LayoutRes
    protected abstract fun findLayoutId(savedInstanceState: Bundle?): Int

    //初始化
    protected abstract fun initView();

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (rootView == null) {
            rootView = layoutInflater.inflate(findLayoutId(savedInstanceState), container, false)
        } else {
            var viewGroup: ViewGroup? = rootView?.parent as ViewGroup?
            viewGroup?.removeView(rootView)
        }
        return rootView
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }

    override fun showDialog() {
        TODO("Not yet implemented")
    }

    override fun closeDialog() {
        TODO("Not yet implemented")
    }

    /**
     * 隐藏输入框
     */
    fun hideSoftKeyboard() {
        if (activity!!.window.attributes.softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            (activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
                activity!!.currentFocus?.windowToken,InputMethodManager.HIDE_NOT_ALWAYS
            )

        }

    }

}