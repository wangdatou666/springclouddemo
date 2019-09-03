package com.wangdatou.springclouddemo_common.common.utils;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class JsonUtil {

    public static Map<String,Object> parseJSONToMap(String jsonString){
        Object parseObj = JSON.parse(jsonString);
        if (parseObj instanceof Map){
            return (Map)parseObj;
        }else {
            throw new RuntimeException("target JSON is not a form of Map");
        }
    }

    public static List<Object> parseJSONToList(String jsonString){
        Object parseObj = JSON.parse(jsonString);
        if (parseObj instanceof List){
            return (List)parseObj;
        }else{
            throw new RuntimeException("target JSON is not a form of List");
        }
    }

    public static Map<String,Object> parseJSONToMapWithUpperCaseStringKey(String jsonString){
        Object parseObj = JSON.parse(jsonString);
        if (parseObj instanceof Map){
            return formatMapWithUpperCaseStringKey((Map)parseObj);
        }else {
            throw new RuntimeException("target JSON is not a form of Map");
        }
    }

    public static List<Object> parseJSONToListWithUpperCaseStringKey(String jsonString){
        Object parseObj = JSON.parse(jsonString);
        if (parseObj instanceof List){
            return formatMapInListWithUpperCaseStringKey((List)parseObj);
        }else {
            throw new RuntimeException("target JSON is not a form of List");
        }
    }

    public static Map<String,Object> formatMapWithUpperCaseStringKey(Map<String,Object> map){
        HashMap<String, Object> tmpMap = new HashMap<>();
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        for (Map.Entry<String, Object> entry : entrySet) {
            String key = entry.getKey();
            Object obj = entry.getValue();
            if (obj instanceof Map){
                obj = formatMapWithUpperCaseStringKey((Map) obj);
            }else if (obj instanceof List){
                obj = formatMapInListWithUpperCaseStringKey((List)obj);
            }
            tmpMap.put(key.toUpperCase(),obj);
        }
        return tmpMap;
    }

    public static List<Object> formatMapInListWithUpperCaseStringKey(List<Object> list){
        ArrayList<Object> tmpList = new ArrayList<>();
        for (Object obj : list) {
            if (obj instanceof Map){
                obj = formatMapWithUpperCaseStringKey((Map) obj);
            }else if (obj instanceof List){
                obj = formatMapInListWithUpperCaseStringKey((List) obj);
            }
            tmpList.add(obj);
        }
        return tmpList;
    }

}
