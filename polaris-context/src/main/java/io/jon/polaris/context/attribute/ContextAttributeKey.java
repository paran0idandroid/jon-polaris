package io.jon.polaris.context.attribute;

/**
 * @author binghe(微信 : hacker_binghe)
 * @version 1.0.0
 * @description 上下文属性简单实现类
 * @github https://github.com/binghe001
 * @copyright 公众号: 冰河技术
 */
public final class ContextAttributeKey<T> extends AttributeKey<T> {

    private final Class<T> valueClass;

    ContextAttributeKey(final Class<T> valueClass) {
        super();
        this.valueClass = valueClass;
    }

    @Override
    public T cast(Object value) {
        if (valueClass == null){
            return null;
        }
        return valueClass.cast(value);
    }

    @Override
    public String toString() {
        if(valueClass != null) {
            StringBuilder sb = new StringBuilder(this.getClass().getName());
            sb.append("<");
            sb.append(valueClass.getName());
            sb.append(">");
            return sb.toString();
        }
        return super.toString();
    }
}
