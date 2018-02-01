package com.clewill.javase1.chapter05;

import java.util.ArrayList;

/**
 * 测试 在运行时使用反射分析对象
 * 查看任意对象的内部信息
 *(这个类待认真分析)
 * 反射中关于运行时候分析对象的过程有待学习
 * @author wangkai
 * @create 2018:01:19 11:14
 **/
public class ObjectAnalyzerTest {
  public static void main(String[] args)
  {
    ArrayList<Integer> squares = new ArrayList<>();
    for (int i = 1; i <= 5; i++) {
      squares.add(i * i);
    }
    //非数组对象的输出结果
    System.out.println(new ObjectAnalyzer().toString(squares));
    System.out.println("\n");
    //原始类型数组的输出结果
    int[] arr = {1,23,4};
    System.out.println(new ObjectAnalyzer().toString(arr));

    //封装类型数组的输出结果
    Integer[] arr2 = {12,23,11};
    System.out.println(new ObjectAnalyzer().toString(arr2));

  }
}
