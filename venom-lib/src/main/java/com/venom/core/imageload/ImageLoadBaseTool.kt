package com.venom.core.imageload

import android.content.Context
import android.widget.ImageView
import androidx.annotation.DrawableRes

/**
 * @创建人 ailen
 * @创建时间 2020/8/17
 * @描述
 */
object ImageLoadBaseTool {
    private const val TAG = "ImageTool"
    private val imageLoad: ImageLoadInterface = ImageLoadByGlide()

    /**
     * imageView中加载项目内资源
     *
     * @param mContext
     * @param view
     * @param resId
     */
    fun display(
        mContext: Context?,
        view: ImageView?,
        @DrawableRes resId: Int
    ) {
        display(mContext, view, null, resId)
    }

    /**
     * 加载网络图片/本地图片
     *
     * @param mContext
     * @param view
     * @param url
     */
    fun display(
        mContext: Context?,
        view: ImageView?,
        url: String?
    ) {
        display(mContext, view, url, -1)
    }

    /**
     * 加载图片
     *
     * @param mContext     上下文
     * @param view         imageview
     * @param url          图片地址
     * @param defaultImage 默认显示内容
     */
    fun display(
        mContext: Context?,
        view: ImageView?,
        url: String?,
        defaultImage: Int
    ) {
        display(mContext, view, url, defaultImage, null)
    }

    /**
     * @param mContext
     * @param view
     * @param url
     * @param imageLoadProcessInterface
     */
    fun display(
        mContext: Context?,
        view: ImageView?,
        url: String?,
        imageLoadProcessInterface: ImageLoadProcessInterface?
    ) {
        display(mContext, view, url, -1, imageLoadProcessInterface)
    }

    /**
     * @param mContext                  上下文
     * @param view                      imageview
     * @param url                       地址
     * @param defaultImage              默认图片
     * @param imageLoadProcessInterface 监听
     */
    fun display(
        mContext: Context?,
        view: ImageView?,
        url: String?,
        defaultImage: Int,
        imageLoadProcessInterface: ImageLoadProcessInterface?
    ) {
        display(mContext, view, url, defaultImage, -1, imageLoadProcessInterface)
    }

    fun display(
        mContext: Context?,
        view: ImageView?,
        url: String?,
        defaultImage: Int,
        failImage: Int,
        imageLoadProcessInterface: ImageLoadProcessInterface?
    ) {
        display(
            mContext,
            view,
            url,
            ImageConfig(defaultImage, failImage, 0),
            imageLoadProcessInterface
        )
    }


    fun display(
        mContext: Context?,
        view: ImageView?,
        url: String?,
        config: ImageConfig?,
        imageLoadProcessInterface: ImageLoadProcessInterface?
    ) {
        displayUrl(mContext, view, url, config, imageLoadProcessInterface)
    }

    /**
     * glide加载图片
     *
     * @param imageView view
     * @param url       url
     */
    fun displayUrl(
        mContext: Context?,
        imageView: ImageView?,
        url: String?,
        config: ImageConfig?,
        imageLoadProcessInterface:
        ImageLoadProcessInterface?
    ) {
        try {
            imageLoad?.display(mContext, imageView, url, config, imageLoadProcessInterface);
        } catch (e: Exception) {
            e.printStackTrace();
        }
    }

    /**
     * 恢复加载图片
     *
     * @param context
     */
    fun resumeLoad(context: Context?, url: String?) {
        imageLoad?.resumeLoad(context, url)
    }

    /**
     * 清除一个资源的加载
     *
     * @param context
     */
    fun clearImageView(
        context: Context?,
        imageView: ImageView?,
        url: String?
    ) {
        imageLoad?.clearImageView(context, imageView, url)
    }

    /**
     * 暂停加载图片
     *
     * @param context
     */
    fun pauseLoad(context: Context?, url: String?) {
        imageLoad?.pauseLoad(context, url)
    }

}