package com.clewill.javase1.chapter05;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * 对象分析类
 * setAccessible(boolean flag)
 * @author wangkai
 * @create 2018:01:19 11:13
 **/
public class ObjectAnalyzer {

  private ArrayList<Object> visited = new ArrayList<>();

  /**
   * Converts an object to a string representation that lists all fields.
   *
   * @param obj an object
   * @return a string with the object's class name and all field names and values
   */
  public String toString(Object obj) {
    if (obj == null) {
      return "null";
    }
    if (visited.contains(obj)) {
      return "...";
    }
    visited.add(obj);
    Class cl = obj.getClass();
    if (cl == String.class) {
      return (String) obj;
    }
    //判断这个对象是否是数组
    if (cl.isArray()) {
      //java.lang.Integer[]{
      String r = cl.getComponentType() + "[]{";
      for (int i = 0; i < Array.getLength(obj); i++) {
        if (i > 0) {
          r += ",";
        }
        //java.lang.reflect包中的Array方法
        Object val = Array.get(obj, i);
        //如果是8类基础数据类型 打印值 否则递归调用toString方法
        //{@code boolean}, {@code byte},{@code char}, {@code short}, {@code int},{@code long}, {@code float}, and {@code double}
        if (cl.getComponentType().isPrimitive()) {
          r += val;
        } else {
          r += toString(val);
        }
      }
      return r + "}";
    }

    //如果这个对象不是数组  重新组合并输出
    String r = cl.getName();
    // inspect the fields of this class and all superclasses
    do {
      r += "[";
      Field[] fields = cl.getDeclaredFields();
      //当返回的是Field而非Field[]时候 调用public void setAccessible(boolean flag)重载方法
      AccessibleObject.setAccessible(fields, true);
      // get the names and values of all fields
      for (Field f : fields) {
        if (!Modifier.isStatic(f.getModifiers())) {
          if (!r.endsWith("[")) {
            r += ",";
          }
          r += f.getName() + "=";
          try {
            Class t = f.getType();
            Object val = f.get(obj);
            if (t.isPrimitive()) {
              r += val;
            } else {
              r += toString(val);
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }
      r += "]";
      cl = cl.getSuperclass();
    }
    while (cl != null);

    return r;
  }
}
