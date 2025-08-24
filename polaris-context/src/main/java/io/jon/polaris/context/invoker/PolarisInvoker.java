package io.jon.polaris.context.invoker;

/**
 * @author binghe(微信 : hacker_binghe)
 * @version 1.0.0
 * @description 服务调用顶层接口，预留
 * @github https://github.com/binghe001
 * @copyright 公众号: 冰河技术
 */
public interface PolarisInvoker {
    /**
     * 获取服务调用的全路径信息
     */
    String getInvokerPath();

    /**
     * 设置服务调用的全链路信息
     */
    void setInvokerPath(String invokerPath);

    /**
     * 获取超时时间
     */
    int getTimeout();

    /**
     * 设置超时时间
     */
    void setTimeout(int timeout);
}
