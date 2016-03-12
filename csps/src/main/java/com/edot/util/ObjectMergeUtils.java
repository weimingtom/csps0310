package com.edot.util;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;

/**
 * 对象合并工具类
 * Created by tony on 16/2/14.
 */
public class ObjectMergeUtils {

    private static final Logger logger = Logger.getLogger(ObjectMergeUtils.class);

    public static <T> T merge(Object object, Class<T> clazz) throws Exception {
        T t = clazz.newInstance();
        for (Field field : clazz.getDeclaredFields()) {
            String fieldName = field.getName();
            field.setAccessible(true);

            try {
                Field objectField = object.getClass().getDeclaredField(fieldName);
                objectField.setAccessible(true);
                field.set(t, objectField.get(object));
            } catch (Exception exception) {
                logger.debug("[" + fieldName + "] can't merge");
            }
        }
        return t;
    }
}
