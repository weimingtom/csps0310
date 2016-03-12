package com.edot.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

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

            try {
            	PropertyDescriptor getPd = new PropertyDescriptor(fieldName, object.getClass());
                Method getMethod = getPd.getReadMethod();
                Object value = getMethod.invoke(object);

            	PropertyDescriptor setPd = new PropertyDescriptor(fieldName, clazz); 
                Method setMethod = setPd.getWriteMethod();
                setMethod.invoke(t, value);
            } catch (Exception exception) {
                logger.debug("[" + fieldName + "] can't merge");
            }
        }
        return t;
    }
}
