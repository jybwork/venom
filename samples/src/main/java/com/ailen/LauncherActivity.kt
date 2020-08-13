package com.ailen

import android.os.Bundle
import com.hjq.permissions.OnPermission
import com.hjq.permissions.Permission
import com.hjq.permissions.XXPermissions
import com.venom.core.base.KBaseActivity
import com.venom.utilcode.util.ActivityUtils
import com.venom.utilcode.util.LogUtils


/**
 * 类描述:
 * 创建人:    Ailen
 * 创建时间: 2020/7/3 15:34
 * 修改时间:  ?
 * 修改备注:  说明本次修改内容
 */
class LauncherActivity : KBaseActivity() {

    override fun findLayoutId(savedInstanceState: Bundle?): Int {
        return R.layout.launcher_activity;
    }

    override fun initView() {
        XXPermissions.with(mContext)
            .permission(Permission.Group.STORAGE)
            .request(object : OnPermission {
                override fun hasPermission(granted: List<String>, all: Boolean) {
                    LogUtils.e("all", "" + all)
                    if (all) {
                        ActivityUtils.startActivity(MainActivity::class.java)
                        ActivityUtils.finishActivity(mContext)
                    }
                }

                override fun noPermission(denied: List<String>, quick: Boolean) {
                    LogUtils.e("quick", "" + quick)
                }
            })

    }

}