package com.clewill.javase1;

import com.clewill.javase1.chapter05.Employer;
import com.clewill.javase1.chapter05.Manager;
import org.junit.Test;

/**
 * 测试类（测试javase基础）
 *
 * @author wangkai
 * @create 2018:01:16 16:58
 **/
public class test {

  @Test
  /**
  * @Author: wangkai
  * @Description: java.lang.ArrayStoreException 测试 多态中经常出现的错误
  * @param
  * @CreateDate: 2018/1/16 17:00
  * @ModifyDate: 2018/1/16 17:00
  */
  public void test1() {
    Manager[] managers = new Manager[10];
    Employer[] staff = managers;
    //staff数组相当于已经指定好了装Manager 体积就是Manager的大小
    staff[0] = new Employer("clew", 1000, 2004, 4, 3);
    managers[0].setBonus(5000);
  }


}
