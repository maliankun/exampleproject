package com.inspur.exampleproject.util;

import java.lang.reflect.Field;

/**
 * 利用反射生成实体类toString的方法值 
 * @author liyakun
 */
public class ReflectToStringUtil {
	
	static StringBuffer sb = new StringBuffer();
	 
    /**
     * 	
     * @param clazs
     * @param isOutputNull 是否输出null的属性
     * @return
     */
    public static String toStringUtil(Object clazs,boolean isOutputNull) {
 
        getParamAndValue(clazs, clazs.getClass(), isOutputNull);
 
        return sb.toString();
    }
 
    private static void getParamAndValue(Object clazs, Class<?> clazz,boolean isOutputNull) {
        
        
        Class<?> sc = clazz.getSuperclass();
        Field[] sfields = sc.getDeclaredFields();
        if (sfields.length > 0) {
            getParamAndValue(clazs, sc, isOutputNull);
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                if (null != f.get(clazs)||isOutputNull){
                    sb.append(f.getName() + "=" + f.get(clazs) + "\n");
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
