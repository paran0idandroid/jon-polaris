package io.jon.polaris.context.rule;

import java.util.Objects;

/**
 * @author binghe(微信 : hacker_binghe)
 * @version 1.0.0
 * @description 过滤器配置
 * @github https://github.com/binghe001
 * @copyright 公众号: 冰河技术
 */
public class FilterRule {
    /**
     * 过滤器唯一ID
     */
    private String id;
    /**
     * 过滤器规则，例如{"timeOut":200,"balance":random}
     */
    private String config;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    @Override
    public  boolean equals(Object o){
        if (this == o) return  true;

        if((o== null) || getClass() != o.getClass()){
            return false;
        }

        FilterRule filterRule =(FilterRule)o;
        return id.equals(filterRule.id);
    }

    @Override
    public  int hashCode(){
        return Objects.hash(id);
    }
}
