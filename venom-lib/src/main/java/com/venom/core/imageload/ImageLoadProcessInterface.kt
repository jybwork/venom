package com.venom.core.imageload

interface ImageLoadProcessInterface {
    /**
     * 开始加载
     */
    fun onLoadStarted()

    /**
     * 资源准备妥当
     */
    fun onResourceReady()

    /**
     * 资源已经释放
     */
    fun onLoadCleared()

    /**
     * 资源加载失败
     */
    fun onLoadFailed()
}