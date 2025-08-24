package io.jon.polaris.context.ctx;

import io.jon.polaris.context.attribute.AttributeKey;
import io.jon.polaris.context.request.HttpPolarisRequest;
import io.jon.polaris.context.rule.FilterRule;
import io.jon.polaris.context.rule.Rule;
import io.micrometer.core.instrument.Timer;
import io.netty.channel.ChannelHandlerContext;

import java.util.function.Consumer;

/**
 * @author jon(微信 : hacker_jon)
 * @version 1.0.0
 * @description 网关上下文接口
 * @github https://github.com/jon001
 * @copyright 公众号: 冰河技术
 */
public interface PolarisContext extends Context{
    /**
     * 获取当前请求的协议，http/rpc/websocket等
     */
    String getProtocol();

    /**
     * 获取当前请求的规则
     */
    Rule getRule();

    /**
     * 获取请求的对象
     */
    Object getRequest();

    /**
     * 获取响应对象
     */
    Object getResponse();

    /**
     * 设置响应对象
     */
    void setResponse(Object response);

    /**
     * 由于网关是异步执行任务，如果触发异常，需要将异常封装到上下文
     */
    void setThrowable(Throwable throwable);

    /**
     * 获取异常信息
     */
    Throwable getThrowable();

    /**
     * 获取网关上下文属性对应的泛型对象
     */
    <T> T getAttribute(AttributeKey<T> key);

    /**
     * 添加网关上下文属性对应的泛型对象
     */
    <T> T putAttribute(AttributeKey<T> key, T value);

    /**
     * 获取网关使用的Netty上下文信息
     */
    ChannelHandlerContext getNettyContext();

    /**
     * 判断当前请求是否保持连接
     */
    boolean isKeepAlive();
    /**
     * 释放请求的资源
     */
    void releaseRequest();

    /**
     * 设置当前请求执行的回调函数
     */
    void setCallback(Consumer<PolarisContext> callback);

    /**
     * 执行回调函数
     */
    void invokeCallback();

    /**
     * 获取上下文属性
     */
    <T> T getRequiredAttribute(AttributeKey<T> key);

    /**
     * 获取上下文属性
     */
    <T> T getAttributeOrDefault(AttributeKey<T> key, T defaultValue);

    /**
     * 根据id获取过滤规则
     */
    FilterRule getFilterRule(String filterId);

    /**
     * 获取唯一id
     */
    String getUniqueId();

    /**
     * 获取原始请求
     */
    HttpPolarisRequest getOriginRequest();

    /**
     * 获取可修改的请求
     */
    HttpPolarisRequest getMudifyRequest();

    /**
     * 设置灰度标识
     */
    void setGray(boolean gray);

    /**
     * 判断是否是灰度
     */
    boolean isGray();

    /**
     * 设置时间
     */
    void setTimerSample(Timer.Sample timerSample);

    /**
     * 获取时间
     */
    Timer.Sample getTimerSample();
}
