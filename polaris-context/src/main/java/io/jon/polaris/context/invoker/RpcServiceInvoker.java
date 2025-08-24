package io.jon.polaris.context.invoker;

/**
 * @author binghe(微信 : hacker_binghe)
 * @version 1.0.0
 * @description Rpc调用
 * @github https://github.com/binghe001
 * @copyright 公众号: 冰河技术
 */
public class RpcServiceInvoker extends AbstractServiceInvoker {
    /**
     * 注册中心地址
     */
    private String registerAddress;
    /**
     * 接口全类名
     */
    private String interfaceClass;
    /**
     * 方法名称
     */
    private String methodName;
    /**
     * 参数名字的集合
     */
    private String[] parameterTypes;
    /**
     * RPC服务版本号
     */
    private String version;

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    public String getInterfaceClass() {
        return interfaceClass;
    }

    public void setInterfaceClass(String interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(String[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
