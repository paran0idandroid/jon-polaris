package io.jon.polaris.context.response;

import com.alibaba.fastjson.JSONObject;
import io.jon.polaris.common.constants.Constants;
import io.jon.polaris.common.enums.ResponseCode;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.asynchttpclient.Response;

/**
 * @author binghe(微信 : hacker_binghe)
 * @version 1.0.0
 * @description 响应实现类
 * @github https://github.com/binghe001
 * @copyright 公众号: 冰河技术
 */
public class DefaultPolarisResponse implements PolarisResponse{
    @Override
    public PolarisResposeData getPolarisResponse(Response response) {
        PolarisResposeData resposeData = new PolarisResposeData();
        resposeData.setFutureResponse(response);
        resposeData.setHttpResponseStatus(HttpResponseStatus.valueOf(response.getStatusCode()));
        return resposeData;
    }

    @Override
    public PolarisResposeData getPolarisResponse(ResponseCode code, Object... args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constants.STATUS, code.getStatus().code());
        jsonObject.put(Constants.CODE, code.getCode());
        jsonObject.put(Constants.MESSAGE, code.getMessage());
        PolarisResposeData resposeData = new PolarisResposeData();
        resposeData.setHttpResponseStatus(code.getStatus());
        resposeData.putHeader(HttpHeaderNames.CONTENT_TYPE,HttpHeaderValues.APPLICATION_JSON + ";charset=utf-8");
        resposeData.setContent(jsonObject.toJSONString());
        return resposeData;
    }

    @Override
    public PolarisResposeData getPolarisResponse(Object content) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constants.STATUS, ResponseCode.SUCCESS.getStatus().code());
        jsonObject.put(Constants.CODE, ResponseCode.SUCCESS.getCode());
        jsonObject.put(Constants.DATA, content);
        PolarisResposeData resposeData = new PolarisResposeData();
        resposeData.setHttpResponseStatus(ResponseCode.SUCCESS.getStatus());
        resposeData.putHeader(HttpHeaderNames.CONTENT_TYPE,
                HttpHeaderValues.APPLICATION_JSON + ";charset=utf-8");
        resposeData.setContent(jsonObject.toJSONString());
        return resposeData;
    }
}
