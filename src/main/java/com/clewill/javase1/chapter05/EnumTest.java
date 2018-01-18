package com.clewill.javase1.chapter05;

import java.util.Scanner;

/**
 * 枚举测试
 * static Enum toString方法：返回枚举常量名
 * String valueOf(Class enumClass,String name)  (和toString相反的方法)将name转化为枚举常量
 * (前提是name和enumClass中的枚举常量名一致)
 * int ordinal() 返回枚举常量在enum声明中的位置 从0开始
 * int compareTo(E other) 返回other在当前枚举常量的相对位置(例如：-1 表示在之前一个位置，0 表示相等 1 表示在之后一个位置)
 * @author wangkai
 * @create 2018:01:18 10:49
 **/
public class EnumTest {
  public static void main(String[] args) {
    //small
    Scanner in = new Scanner(System.in);
    System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) ");
    //SMALL
    String input = in.next().toUpperCase();
    //将枚举常量名字符串设置成枚举常量（前提是这里的input是和枚举常量名一致）
    Size size = Enum.valueOf(Size.class, input);
    //相对位置
    int i = size.compareTo(Size.LARGE);
    System.out.println(i);
    //Size 的toString方法
    System.out.println("size=" + size);
    System.out.println("abbreviation=" + size.getAbbreviation());
    if (size == Size.EXTRA_LARGE) {
      System.out.println("Good job--you paid attention to the _.");
    }
  }


  enum Size
  {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL"),small("s",170);

    private Size(String abbreviation) { this.abbreviation = abbreviation; }
    private Size(String abbreviation,Integer length){this.abbreviation = abbreviation;this.length
        = length;}
    public String getAbbreviation() { return abbreviation; }

    public Integer getLength() {
      return length;
    }

    private String abbreviation;
    private Integer length;
  }

}
