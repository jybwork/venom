package com.venom.core.base

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import com.venom.R

/**
 * 类描述:
 * 创建人:    Ailen
 * 创建时间: 2020/7/9 11:08
 * 修改时间:  ?
 * 修改备注:  说明本次修改内容
 */
abstract class VBaseFragDialog : DialogFragment(){

    private var rootView: View? = null

    private var mContext: Context? = null

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.fullScreenDialog)
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

    override fun onStart() {
        super.onStart()
        val dm = DisplayMetrics()
        activity!!.windowManager.defaultDisplay.getMetrics(dm)
        dialog?.window!!.setLayout(dm.widthPixels, dialog?.window!!.attributes.height)
    }

}