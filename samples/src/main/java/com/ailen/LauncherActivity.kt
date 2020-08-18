package com.ailen

import android.os.Bundle
import com.venom.core.base.VBaseActivity
import com.venom.core.imageload.ImageLoadBaseTool
import kotlinx.android.synthetic.main.launcher_activity.*


/**
 * 类描述:
 * 创建人:    Ailen
 * 创建时间: 2020/7/3 15:34
 * 修改时间:  ?
 * 修改备注:  说明本次修改内容
 */
class LauncherActivity : VBaseActivity() {

    override fun findLayoutId(savedInstanceState: Bundle?): Int {
        return R.layout.launcher_activity;
    }

    override fun initView() {
        ImageLoadBaseTool.display(mContext,image,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1597666695444&di=c7773ce7e0ae4bb0bde61732b2129ee5&imgtype=0&src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201105%2F17%2F113554rnu40q7nbgnn3lgq.jpg");
//        XXPermissions.with(mContext)
//            .permission(Permission.Group.STORAGE)
//            .request(object : OnPermission {
//                override fun hasPermission(granted: List<String>, all: Boolean) {
//                    LogUtils.e("all", "" + all)
//                    if (all) {
//                        ActivityUtils.startActivity(MainActivity::class.java)
//                        ActivityUtils.finishActivity(mContext)
//                    }
//                }
//
//                override fun noPermission(denied: List<String>, quick: Boolean) {
//                    LogUtils.e("quick", "" + quick)
//                }
//            })
    }

}