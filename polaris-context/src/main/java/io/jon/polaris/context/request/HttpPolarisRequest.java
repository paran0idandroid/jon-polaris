package io.jon.polaris.context.request;

import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.QueryStringDecoder;
import org.asynchttpclient.Request;
import org.asynchttpclient.cookie.Cookie;

import java.nio.charset.Charset;
import java.util.List;

public interface HttpPolarisRequest extends PolarisRequest{

    /**
     * 设置请求时的主机或者域名
     */
    void setRequestHost(String host);

    /**
     * 获取请求时的主机或者域名
     */
    String getRequestHost();

    /**
     * 设置请求时的路径
     */
    void setRequestPath(String path);

    /**
     * 获取请求时的路径
     */
    String getRequestPath();

    /**
     * 设置请求头
     */
    void setHeader(CharSequence name, String value);

    /**
     * 添加请求头
     */
    void addHeader(CharSequence name, String value);

    /**
     * 设置请求超时时间
     */
    void setRequestTimeout(int timeout);

    /**
     * 添加查询参数，一般是放到请求路径后面
     */
    void addQueryParam(String name, String value);

    /**
     * 添加form表单参数
     */
    void addFormParam(String name, String value);

    /**
     * 添加或者更新Cookie，前端请求到网关可能会携带Cookie信息
     */
    void addOrUpdateCookie(Cookie cookie);

    /**
     * 获取最终生成的请求路径
     */
    String getRequestFinalUrl();

    /**
     * 获取请求体
     */
    String getBody();

    /**
     * 获取Cookie内容
     */
    io.netty.handler.codec.http.cookie.Cookie getCookie(String name);

    /**
     * 获取查询参数
     */
    List<String> getQueryParameters(String name);

    /**
     * 查询post查询参数
     */
    List<String> getPostParameters(String name);

    /**
     * 构建请求对象
     */
    Request buildRequest();

    /**
     * 获取唯一id
     */
    String getUniqueId();

    /**
     * 获取开始时间
     */
    long getBeginTime();

    /**
     * 获取编码
     */
    Charset getCharset();

    /**
     * 获取客户端ip
     */
    String getClientIp();

    /**
     * 获取目标host
     */
    String getTargetHost();

    /**
     * 获取uri
     */
    String getUri();

    /**
     * 获取请求path
     */
    String getPath();

    /**
     * 获取Method
     */
    HttpMethod getMethod();

    /**
     * 获取请求头content-type
     */
    String getContentType();

    /**
     * 获取header
     */
    HttpHeaders getHeaders();

    /**
     * 获取解码器
     */
    QueryStringDecoder getQueryDecoder();

    /**
     * 获取FullHttpRequest
     */
    FullHttpRequest getFullHttpRequest();

}
