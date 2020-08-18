package com.venom.core.imageload

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.widget.ImageView
import android.widget.ImageView.ScaleType
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.bumptech.glide.request.target.ImageViewTarget
import com.bumptech.glide.request.target.SizeReadyCallback
import com.bumptech.glide.request.transition.Transition
import com.venom.utilcode.util.LogUtils

/**
 * @创建人 ailen
 * @创建时间 2020/8/18
 * @描述
 */
class ImageLoadByGlide :ImageLoadInterface {
    private val TAG = "GlideUtils"

    /**
     * glide加载图片
     *
     * @param imageView view
     * @param url       url
     */
    override fun display(
        mContext: Context?,
        imageView: ImageView?,
        url: String?,
        config: ImageConfig?,
        imageLoadProcessInterface: ImageLoadProcessInterface?
    ) {
        if (mContext == null) {
            LogUtils.e("GlideUtils", "GlideUtils -> display -> mContext is null")
            return
        }
        // 不能崩
        if (imageView == null) {
            LogUtils.e("GlideUtils", "GlideUtils -> display -> imageView is null")
            return
        }
        val context = imageView.context
        // View你还活着吗？
        if (context is Activity) {
            if (context.isFinishing) { //activity是否结束
                return
            }
        }
        try {
            if ((config == null || config.height <= 0) && TextUtils.isEmpty(url)) {
                LogUtils.e("GlideUtils", "GlideUtils -> display -> url is null and config is null")
                return
            }
            val requestOptions = RequestOptions()
            if (config != null) {
                if (config.defaultRes > 0) {
                    requestOptions.placeholder(config.defaultRes)
                }
                if (config.failRes > 0) {
                    requestOptions.error(config.failRes)
                }
                if (config.scaleType != null) {
                    when (config.scaleType) {
                        ScaleType.CENTER_CROP -> requestOptions.centerCrop()
                        ScaleType.FIT_CENTER -> requestOptions.fitCenter()
                        else -> requestOptions.fitCenter()
                    }
                } else {
                    requestOptions.fitCenter()
                }
                if (config.radius > 0) {
                    requestOptions.transform(RoundedCorners(config.radius))
                }
            }
            val simpleTarget: BitmapImageViewTarget = object : BitmapImageViewTarget(imageView) {
                override fun onLoadStarted(placeholder: Drawable?) {
                    super.onLoadStarted(placeholder)
                    LogUtils.i("image", "onLoadStarted")
                    imageLoadProcessInterface?.onLoadStarted()
                }

                override fun onResourceReady(
                    resource: Bitmap,
                    transition: Transition<in Bitmap?>?
                ) {
                    super.onResourceReady(resource, transition)
                    LogUtils.i("image", "onResourceReady")
                    imageLoadProcessInterface?.onResourceReady()
                }

                override fun onLoadFailed(errorDrawable: Drawable?) {
                    super.onLoadFailed(errorDrawable)
                    LogUtils.i("image", "onLoadFailed")
                    imageLoadProcessInterface?.onLoadFailed()
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    super.onLoadCleared(placeholder)
                    LogUtils.i("image", "onLoadCleared")
                    imageLoadProcessInterface?.onLoadCleared()
                }

                override fun getSize(cb: SizeReadyCallback) {
                    if (config != null && config.width >= 0 && config.height >= 0) cb.onSizeReady(
                        config.width,
                        config.height
                    ) else {
                        super.getSize(cb)
                    }
                }
            }
            if (simpleTarget != null) {
                Glide.with(context).asBitmap().load(url).apply(requestOptions)
                    .into(simpleTarget)
            } else {
                Glide.with(context).asBitmap().load(url).apply(requestOptions).into(imageView)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    /**
     * 恢复加载图片
     *
     * @param context
     */
    override fun resumeLoad(context: Context?, url: String?) {
        if (context != null) Glide.with(context).resumeRequests()
    }

    /**
     * 清除一个资源的加载
     *
     * @param context
     */
    override fun clearImageView(
        context: Context?,
        imageView: ImageView?,
        url: String?
    ) {
        if (context != null && imageView != null) Glide.with(context).clear(imageView)
    }

    /**
     * 暂停加载图片
     *
     * @param context
     */
    override fun pauseLoad(context: Context?, url: String?) {
        if (context != null) Glide.with(context).pauseRequests()
    }

}