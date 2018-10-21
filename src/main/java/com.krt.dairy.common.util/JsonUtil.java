package com.krt.dairy.common.util;


import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtil {
	
    private static  ObjectMapper mapper;
    static{
        mapper=new ObjectMapper();
    }
    public static String toJson(Object obj) throws IOException {
        String json = mapper.writeValueAsString(obj);
        return json;
    }
}
