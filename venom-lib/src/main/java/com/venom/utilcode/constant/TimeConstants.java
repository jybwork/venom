package com.venom.utilcode.constant;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author ailen
 * @createTime 2018/11/30
 * @describe  constants of time
 * @note 备注
 */
public class TimeConstants {
    public static final int MSEC = 1;
    public static final int SEC = 1000;
    public static final int MIN = 60000;
    public static final int HOUR = 3600000;
    public static final int DAY = 86400000;

    @IntDef({MSEC, SEC, MIN, HOUR, DAY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Unit {
    }
}
