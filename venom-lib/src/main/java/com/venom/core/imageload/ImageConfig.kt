package com.venom.core.imageload

import android.widget.ImageView.ScaleType

/**
 * @创建人 ailen
 * @创建时间 2020/8/17
 * @描述
 */
class ImageConfig {
    var defaultRes: Int = 0 //默认占位符
    var failRes = 0 //失败占位符
    var radius = 0  // 圆角
    var scaleType: ScaleType? = null //图片展示样式
    var width = -1 //图片宽
    var height = -1 //图片高



    constructor(defaultResValVal: Int) {
       defaultRes = defaultResValVal
    }

    constructor(defaultResVal: Int, failResVal: Int) : this(defaultResVal) {
        failRes = failResVal
    }

    constructor(defaultResVal: Int, failResVal: Int, radiusVal: Int) : this(defaultResVal, failResVal) {
        radius = radiusVal
    }

    constructor(defaultResVal: Int, failResVal: Int, widthVal: Int, heightVal: Int) : this(
        defaultResVal,
        failResVal
    ) {
        width = widthVal
        height = heightVal
    }

    constructor(defaultResVal: Int, failResVal: Int, radiusVal: Int, widthVal: Int, heightVal: Int) : this(
        defaultResVal,
        failResVal,
        widthVal, heightVal
    ) {
        radius = radiusVal
    }

    constructor(
        defaultResVal: Int,
        failResVal: Int,
        radiusVal: Int,
        widthVal: Int,
        heightVal: Int,
        scaleTypeVal: ScaleType?
    ) : this(
        defaultResVal,
        failResVal,
        radiusVal,
        widthVal,
        heightVal
    ) {
        scaleType = scaleTypeVal
    }



}