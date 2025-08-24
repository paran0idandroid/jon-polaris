package io.jon.polaris.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binghe(微信 : hacker_binghe)
 * @version 1.0.0
 * @description Json工具类
 * @github https://github.com/binghe001
 * @copyright 公众号: 冰河技术
 */
public class JsonUtils {

    private static final SerializerFeature[] featuresWithNullValue = {
            SerializerFeature.WriteMapNullValue,
            SerializerFeature.WriteNullBooleanAsFalse,
            SerializerFeature.WriteNullListAsEmpty,
            SerializerFeature.WriteNullNumberAsZero,
            SerializerFeature.WriteNullStringAsEmpty
    };

    /**
     * 将JSON字符串转换为实体对象
     * @param data JSON字符串
     * @param clazz 转换对象
     * @return T
     */
    public static <T> T parseJSONToObject(String data, Class<T> clazz) {
        try {
            return JSON.parseObject(data, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将JSONObject对象转换为实体对象
     * @param data JSONObject对象
     * @param clazz 转换对象
     * @return T
     */
    public static <T> T parseJSONToObject(JSONObject data, Class<T> clazz) {
        try {
            return JSONObject.toJavaObject(data, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将JSON字符串数组转为List集合对象
     * @param data JSON字符串数组
     * @param clazz 转换对象
     * @return List<T>集合对象
     */
    public static <T> List<T> parseJSONToArray(String data, Class<T> clazz) {
        try {
            return JSON.parseArray(data, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将List<JSONObject>转为List集合对象
     * @param data List<JSONObject>
     * @param clazz 转换对象
     * @return List<T>集合对象
     */
    public static <T> List<T> parseJSONToArray(List<JSONObject> data, Class<T> clazz) {
        try {
            List<T> t = new ArrayList<T>();
            for (JSONObject jsonObject : data) {
                t.add(parseJSONToObject(jsonObject, clazz));
            }
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将对象转为JSON字符串
     * @param obj 任意对象
     * @return JSON字符串
     */
    public static String parseObjectToJSON(Object obj) {
        try {
            return JSON.toJSONString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将对象转为JSONObject对象
     * @param obj 任意对象
     * @return JSONObject对象
     */
    public static JSONObject parseObjectToJSONObject(Object obj){
        try {
            return (JSONObject) JSONObject.toJSON(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String convertObjectToJSONWithNullValue(Object obj) {
        try {
            return JSON.toJSONString(obj, featuresWithNullValue);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
