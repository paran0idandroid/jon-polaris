package io.jon.polaris.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author binghe(微信 : hacker_binghe)
 * @version 1.0.0
 * @description 断言工具
 * @github https://github.com/binghe001
 * @copyright 公众号: 冰河技术
 */
public final class AssertUtils {

    private AssertUtils(){}

    public static void notEmpty(String string, String message) {
        if (StringUtils.isEmpty(string)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void assertNotBlank(String string, String message) {
        if (StringUtils.isBlank(string)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isTrue(boolean value, String message) {
        if (!value) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void assertState(boolean condition, String message) {
        if (!condition) {
            throw new IllegalStateException(message);
        }
    }
}
