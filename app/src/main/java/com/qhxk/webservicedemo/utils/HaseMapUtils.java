package com.qhxk.webservicedemo.utils;

import com.googlecode.openbeans.BeanInfo;
import com.googlecode.openbeans.Introspector;
import com.googlecode.openbeans.PropertyDescriptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建者     WLD
 * 创建时间   2018/8/15 9:57
 * 描述	     HaseMap 构造的Utils
 * 更新描述
 */
public class HaseMapUtils {

    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null)
            return null;

        Object obj = beanClass.newInstance();

        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            Method setter = property.getWriteMethod();
            if (setter != null) {
                setter.invoke(obj, map.get(property.getName()));
            }
        }

        return obj;
    }

    public static HashMap<String, Object> objectToMap(Object obj) throws Exception {
        if (obj == null)
            return null;

        HashMap<String, Object> map = new HashMap<String, Object>();

        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (key.compareToIgnoreCase("class") == 0) {
                continue;
            }
            Method getter = property.getReadMethod();
            Object value = getter != null ? getter.invoke(obj) : null;
            map.put(key, value);
        }

        return map;
    }

}
