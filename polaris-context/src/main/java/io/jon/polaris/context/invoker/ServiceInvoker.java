package io.jon.polaris.context.invoker;

/**
 * @author binghe(微信 : hacker_binghe)
 * @version 1.0.0
 * @description 服务调用
 * @github https://github.com/binghe001
 * @copyright 公众号: 冰河技术
 */
public interface ServiceInvoker extends PolarisInvoker {

    /**
     * 获取规则id
     */
    String getRuleId();

    /**
     * 设置规则id
     */
    void setRuleId(String ruleId);
}
