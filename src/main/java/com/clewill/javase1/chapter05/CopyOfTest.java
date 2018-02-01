package com.clewill.javase1.chapter05;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 利用反射编写泛型数组
 *
 * @author wangkai
 * @create 2018:01:19 14:09
 **/
public class CopyOfTest {
  public static void main(String[] args)
  {
    int[] a = { 1, 2, 3 };
    a = (int[]) goodCopyOf(a, 10);
    System.out.println(Arrays.toString(a));

//    int[] ints = Arrays.copyOf(a, 10);
//    System.out.println(Arrays.toString(ints));

    String[] b = { "Tom", "Dick", "Harry" };
    b = (String[]) goodCopyOf(b, 10);
    System.out.println(Arrays.toString(b));

    System.out.println("The following call will generate an exception.");
    b = (String[]) badCopyOf(b, 10);
  }

  /**
   * This method attempts to grow an array by allocating a new array and copying all elements.
   * @param a the array to grow
   * @param newLength the new length
   * @return a larger array that contains all elements of a. However, the returned array has
   * type Object[], not the same type as a
   */
  public static Object[] badCopyOf(Object[] a, int newLength) // not useful
  {
    Object[] newArray = new Object[newLength];
    //Math.min(a.length, newLength) : the number of array elements to be copied
    System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
    return newArray;
  }

  /**
   * This method grows an array by allocating a new array of the same type and
   * copying all elements.
   * @param a the array to grow. This can be an object array or a primitive
   * type array
   * @return a larger array that contains all elements of a.
   */
  public static Object goodCopyOf(Object a, int newLength)
  {
    Class cl = a.getClass();
    if (!cl.isArray()) {
      return null;
    }
    Class componentType = cl.getComponentType();
    int length = Array.getLength(a);

    //创建一个类型是componentType 长度是newLength的数组对象
    Object newArray = Array.newInstance(componentType, newLength);
    //和Arrays工具类中数组的拷贝的原理是一样的  也是调用了System的这个方法
    //Math.min(a.length, newLength) : the number of array elements to be copied
    System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
    return newArray;
  }
}
