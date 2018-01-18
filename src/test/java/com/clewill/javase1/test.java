package com.clewill.javase1;

import com.clewill.javase1.chapter05.Employer;
import com.clewill.javase1.chapter05.Manager;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import org.junit.Test;

/**
 * 测试类（测试javase基础）
 *
 * @author wangkai
 * @create 2018:01:16 16:58
 **/
public class test {


  /**
  * @Author: wangkai
  * @Description: java.lang.ArrayStoreException 测试 多态中经常出现的错误
  * @param
  * @CreateDate: 2018/1/16 17:00
  * @ModifyDate: 2018/1/16 17:00
  */
  @Test
  public void test1() {
    Manager[] managers = new Manager[10];
    Employer[] staff = managers;
    //staff数组相当于已经指定好了装Manager 体积就是Manager的大小
    staff[0] = new Employer("clew", 1000, 2004, 4, 3);
    managers[0].setBonus(5000);
  }

  /**
  * @Author: wangkai
  * @Description: 测试ArrayList的ensureCapacity方法和TrimToSize()方法
  * @param
  * @CreateDate: 2018/1/18 10:00
  * @ModifyDate: 2018/1/18 10:00
  */
  @Test
  public void test2(){
    Manager manager = new Manager("clew", 1000, 2004, 4, 3);
    new Date().clone();
    ArrayList<Employer> arrayList =new ArrayList<>();
//    用指定容量构造一个空数组列表
    arrayList.ensureCapacity(100);
    //将数组列表的存储容量削减到当前尺寸
    arrayList.trimToSize();
//    add是添加，而set是修改
    //    arrayList.add();
//    arrayList.set();
  }

  /**
  * @Author: wangkai
  * @Description: 可变参数的本质数组  printf函数接收可变参数(MessageFormat.format(),String.format()等都是jdk中的可变参数)
  * @CreateDate: 2018/1/18 10:05
  * @ModifyDate: 2018/1/18 10:05
  */
  @Test
  public void test3(){
    System.out.printf("%d %s\n", 1, "widgets");
    System.out.printf("%d %s\n", new Integer(1), "widgets");
    System.out.printf("%d %s",new Object[] { new Integer(1), "widgets" });
//    MessageFormat.format();
//    String.format();
  }

  @Test
  public void test4(){

  }


}
