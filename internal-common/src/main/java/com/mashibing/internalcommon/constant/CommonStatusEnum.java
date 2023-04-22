package com.mashibing.internalcommon.constant;

import lombok.Getter;

/**
 * @Auther: zhoulz
 * @Description: com.mashibing.internalcommon.constant
 * @Date: 2023/4/1 - 04 - 01 - 11:08
 */

public enum CommonStatusEnum {
    /**
     * 成功
     */
    SUCCESS(1,"success"),

    /**
     * 失败
     */
    FAIL(0,"fail")

    ;

    @Getter
    private int code;
    @Getter
    private String value;

    CommonStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }
}
