package io.jon.polaris.context.attribute;

import io.jon.polaris.context.definition.ServiceInstance;
import io.jon.polaris.context.invoker.ServiceInvoker;

import java.util.Map;
import java.util.Set;

/**
 * @author jon(微信 : hacker_jon)
 * @version 1.0.0
 * @description 获取AttributeKey的工厂类
 * @github https://github.com/jon001
 * @copyright 公众号: 冰河技术
 */
public final class AttributeKeyFactory {

    public static AttributeKey<ServiceInvoker> getHttpInvoker(){
        return AttributeKey.HTTP_INVOKER;
    }

    public static AttributeKey<ServiceInvoker> getRpcInvoker(){
        return AttributeKey.RPC_INVOKER;
    }

    public static AttributeKey<ServiceInvoker> getWebSocketInvoker(){
        return AttributeKey.WEBSOCKET_INVOKER;
    }

    public static AttributeKey<Set<ServiceInstance>> getMatchInstances(){
        return AttributeKey.MATCH_INSTANCES;
    }

    public static AttributeKey<ServiceInstance> getLoadInstance(){
        return AttributeKey.LOAD_INSTANCE;
    }

    public static AttributeKey<Map<String, String>> getAttachment(){
        return AttributeKey.ATTACHMENT;
    }

    public static AttributeKey<?> getAttributeKey(String name){
        return AttributeKey.getAttributeKey(name);
    }
}
