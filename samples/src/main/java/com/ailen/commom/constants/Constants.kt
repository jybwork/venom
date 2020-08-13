package com.ailen.commom.constants

import com.ailen.BuildConfig


/**
 * top-level declaration 顶层申明
 * 不隶属于任何class 而是直接隶属于package
 * 可以在package下直接调用
 */


/**
 * const 用于修饰常量（编译期常量）
 * val 修饰为最终值  不可更改 类似于java的 final
 */
const val VERSIONCHECK: String = "a/ios/checkVersion";

const val BASE_API: String = BuildConfig.API_URL;