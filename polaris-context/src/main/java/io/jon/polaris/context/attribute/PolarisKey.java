package io.jon.polaris.context.attribute;

/**
 * @author binghe(微信 : hacker_binghe)
 * @version 1.0.0
 * @description 网关顶层属性接口
 * @github https://github.com/binghe001
 * @copyright 公众号: 冰河技术
 */
public interface PolarisKey<T> {

    /**
     * 将Object对象转换成指定的类型
     */
    T cast(Object obj);
}
