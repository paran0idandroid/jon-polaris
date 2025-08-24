package io.jon.polaris.context.ctx;

import io.jon.polaris.common.utils.AssertUtils;
import io.jon.polaris.context.attribute.AttributeKey;
import io.jon.polaris.context.request.HttpPolarisRequest;
import io.jon.polaris.context.response.PolarisResponse;
import io.jon.polaris.context.rule.FilterRule;
import io.jon.polaris.context.rule.Rule;
import io.micrometer.core.instrument.Timer;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

/**
 * @author jon(微信 : hacker_jon)
 * @version 1.0.0
 * @description 请求与响应上下文
 * @github https://github.com/jon001
 * @copyright 公众号: 冰河技术
 */
public class RequestResponseContext extends AbstractContext {

    private final HttpPolarisRequest request;

    private PolarisResponse response;

    private Rule rule;

    private boolean gray;

    private Timer.Sample timerSample;

    public RequestResponseContext(String protocol,
                                  ChannelHandlerContext nettyCcontext,
                                  boolean keepAlive,
                                  HttpPolarisRequest request,
                                  Rule rule){
        super(protocol, nettyCcontext, keepAlive);
        this.request = request;
        this.rule = rule;
    }

    @Override
    public Rule getRule() {
        return this.rule;
    }

    @Override
    public Object getRequest() {
        return this.request;
    }

    @Override
    public Object getResponse() {
        return this.response;
    }

    @Override
    public void setResponse(Object response) {
        this.response = (PolarisResponse) response;
    }

    @Override
    public <T> T getRequiredAttribute(AttributeKey<T> key) {
        T value = getAttribute(key);
        AssertUtils.notNull(value, "获取的上下文属性为空, 此时的key为: " + key);
        return value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getAttributeOrDefault(AttributeKey<T> key, T defaultValue) {
        return (T) attributes.getOrDefault(key, defaultValue);
    }

    @Override
    public FilterRule getFilterRule(String filterId) {
        return rule.getFilterRule(filterId);
    }

    @Override
    public String getUniqueId() {
        return request.getUniqueId();
    }

    /**
     * 重写覆盖父类的方法，真正释放资源
     */
    @Override
    public void releaseRequest() {
        if(requestReleased.compareAndSet(false, true)) {
            ReferenceCountUtil.release(request.getFullHttpRequest());
        }
    }

    @Override
    public HttpPolarisRequest getOriginRequest() {
        return request;
    }

    @Override
    public HttpPolarisRequest getMudifyRequest() {
        return request;
    }

    @Override
    public void setGray(boolean gray) {
        this.gray = gray;
    }

    @Override
    public boolean isGray() {
        return gray;
    }

    @Override
    public void setTimerSample(Timer.Sample timerSample) {
        this.timerSample = timerSample;
    }

    @Override
    public Timer.Sample getTimerSample() {
        return timerSample;
    }
}
