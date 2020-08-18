package com.venom.core.imageload

import android.content.Context
import android.widget.ImageView

interface ImageLoadInterface {
    /**
     * 显示路径中的图片（网络、文件中）
     *
     * @param mContext
     * @param view
     * @param url
     * @param config                    配置参数
     * @param imageLoadProcessInterface 加载过程监听
     */
    fun display(
        mContext: Context?,
        view: ImageView?,
        url: String?,
        config: ImageConfig?,
        imageLoadProcessInterface: ImageLoadProcessInterface?
    )

    /**
     * 开始加载
     *
     * @param context
     */
    fun resumeLoad(context: Context?, url: String?)

    /**
     * 暂停加载
     *
     * @param context
     */
    fun pauseLoad(context: Context?, url: String?)

    /**
     * 清除一个资源的加载
     *
     * @param context
     */
    fun clearImageView(
        context: Context?,
        imageView: ImageView?,
        url: String?
    )
}