package io.jon.polaris.context.cache;

/**
 * @author binghe(微信 : hacker_binghe)
 * @version 1.0.0
 * @description 配置缓存工厂类
 * @github https://github.com/binghe001
 * @copyright 公众号: 冰河技术
 */
public class ConfigCacheFactory {

    private static class SingletonHolder {
        private static final ConfigCache INSTANCE = new ContextConfigCache();
    }

    public static ConfigCache getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
