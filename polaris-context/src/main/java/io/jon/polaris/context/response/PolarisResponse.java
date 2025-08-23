package io.jon.polaris.context.response;


import io.jon.polaris.common.enums.ResponseCode;
import org.asynchttpclient.Response;

public interface PolarisResponse {

    /**
     * 获取网关的响应对象
     */
    PolarisResposeData getPolarisResponse(Response response);

    /**
     * 获取网关的响应对象
     */
    PolarisResposeData getPolarisResponse(ResponseCode code, Object ... args);

    /**
     * 获取网关响应对象
     */
    PolarisResposeData getPolarisResponse(Object content);
}
