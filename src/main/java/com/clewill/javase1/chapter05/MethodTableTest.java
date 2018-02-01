package com.clewill.javase1.chapter05;

import java.lang.reflect.Method;

/**
 * 通过反射调用任意方法
 * invoke方法
 * obj：被调用的这个方法的类的实例对象 如果这个方法为static修饰 则obj为null
 * args：方法参数
 * public Object invoke(Object obj, Object... args)
 *
 * @author wangkai
 * @create 2018:01:19 14:28
 **/
public class MethodTableTest {

  public static void main(String[] args) throws Exception {
    // get method pointers to the square and sqrt methods
    Method square = MethodTableTest.class.getMethod("square", double.class);
    Method sqrt = Math.class.getMethod("sqrt", double.class);

    //如果这个方法被调用的方法是静态的 那么第一参数为null 否则第一个参数表示被调用方法的类的实例对象
    Method f1 = MethodTableTest.class.getMethod("f1", null);
    //反射的返回值代表这个被调用方法的返回值
    int result = (int)f1.invoke(new MethodTableTest(), null);
    System.out.println(result);

    // print tables of x- and y-values
    printTable(1, 10, 10, square);
    printTable(1, 10, 10, sqrt);
  }

  /**
   * Returns the square of a number
   *
   * @param x a number
   * @return x squared
   */
  public static double square(double x) {
    return x * x;
  }

  public int f1(){
    System.out.println("1234");
    return 1;
  }
  /**
   * Prints a table with x- and y-values for a method
   *
   * @param from the lower bound for the x-values
   * @param to the upper bound for the x-values
   * @param n the number of rows in the table
   * @param f a method with a double parameter and double return value
   */
  public static void printTable(double from, double to, int n, Method f) {
    // print out the method as table header
    //Method类重写了toString方法  打印方法名
    System.out.println(f);

    double dx = (to - from) / (n - 1);

    for (double x = from; x <= to; x += dx) {
      try {

        //如果这个方法被调用的方法是静态的 那么第一参数为null 否则第一个参数表示被调用方法的类的实例对象
        double y = (Double) f.invoke(null, x);
        System.out.printf("%10.4f | %10.4f%n", x, y);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
