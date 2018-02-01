package com.clewill.javase1.chapter05;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 反射测试（这个测试类很有用）
 * 输入一个类名（全限定名）可以：输出类中的所有构造器方法（包括默认的）、成员方法、成员变量（域）

 int getModifiers( );
 getDeclaredConstructors();
 getParameterTypes();
 getDeclaredMethods();
 getReturnType();
 getDeclaredFields();

 * @author wangkai
 * @create 2018:01:19 9:53
 **/
public class ReflectionTest {

  public static void main(String[] args) {
    // read class name from command line args or user input
    //输入一个类名（全限定名）
    String name;
    if (args.length > 0) {
      name = args[0];
    } else {
      Scanner in = new Scanner(System.in);
      System.out.println("Enter class name (e.g. java.util.Date): ");
      name = in.next();
    }

    try {
      // print class name and superclass name (if != Object)
      //获取当前类的字节码对象
      Class cl = Class.forName(name);
      //获取当前类父类的字节码对象
      Class supercl = cl.getSuperclass();
      //返回一个用于描述构造器、 方法或域的修饰符的整型数值。使用 Modifier 类中的这个
      //方法可以分析这个返回值。 例如：Class对象调用这个方法 返回一个值 代表这个方法修饰符的类型
      //例如：返回1 调用Modifier的toString方法就会返回一个public 的修饰符 具体看源码
      int modifiers1 = cl.getModifiers();
      String modifiers = Modifier.toString(modifiers1);
      if (modifiers.length() > 0) {
        System.out.print(modifiers + " ");
      }
      System.out.print("class " + name);
      if (supercl != null && supercl != Object.class) {
        System.out.print(" extends "
            + supercl.getName());
      }

      System.out.print("\n{\n");
      //输出构造器方法
      printConstructors(cl);
      System.out.println();
      //输出成员方法
      printMethods(cl);
      System.out.println();
      //输出成员字段
      printFields(cl);
      System.out.println("}");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    System.exit(0);
  }

  /**
   * Prints all constructors of a class
   *
   * @param cl a class
   */
  public static void printConstructors(Class cl) {
    //获取所有构造器
    Constructor[] constructors = cl.getDeclaredConstructors();
    //获取public类型的构造器
//    Constructor[] constructors = cl.getConstructors();

    for (Constructor c : constructors) {
      String name = c.getName();
      System.out.print("   ");
      String modifiers = Modifier.toString(c.getModifiers());
      if (modifiers.length() > 0) {
        System.out.print(modifiers + " ");
      }
      System.out.print(name + "(");

      // print parameter types
      //获取传入参数类型
      Class[] paramTypes = c.getParameterTypes();
      for (int j = 0; j < paramTypes.length; j++) {
        if (j > 0) {
          System.out.print(", ");
        }
        System.out.print(paramTypes[j].getName());
      }
      System.out.println(");");
    }
  }

  /**
   * Prints all methods of a class
   *
   * @param cl a class
   */
  public static void printMethods(Class cl) {
    //获取所有方法
    Method[] methods = cl.getDeclaredMethods();
    //获取public修饰的方法
//    Method[] methods = cl.getMethods();

    for (Method m : methods) {
      //获取返回参数类型
      Class retType = m.getReturnType();
      String name = m.getName();

      System.out.print("   ");
      // print modifiers, return type and method name
      String modifiers = Modifier.toString(m.getModifiers());
      if (modifiers.length() > 0) {
        System.out.print(modifiers + " ");
      }
      System.out.print(retType.getName() + " " + name + "(");

      // print parameter types
      Class[] paramTypes = m.getParameterTypes();
      for (int j = 0; j < paramTypes.length; j++) {
        if (j > 0) {
          System.out.print(", ");
        }
        System.out.print(paramTypes[j].getName());
      }
      System.out.println(");");
    }
  }

  /**
   * Prints all fields of a class
   *
   * @param cl a class
   */
  public static void printFields(Class cl) {
    //获取所有字段
    Field[] fields = cl.getDeclaredFields();
    //获取public修饰的字段
//    Field[] fields = cl.getFields();

    for (Field f : fields) {
      Class type = f.getType();
      String name = f.getName();
      System.out.print("   ");
      String modifiers = Modifier.toString(f.getModifiers());
      if (modifiers.length() > 0) {
        System.out.print(modifiers + " ");
      }
      System.out.println(type.getName() + " " + name + ";");
    }
  }
}
