package com.clewill.javase1.chapter05;

/**
 * 经理类
 *
 * @author wangkai
 * @create 2018:01:16 15:47
 **/
public class Manager extends Employer
{
  private double bonus;

  /**
   * @param name the employee's name
   * @param salary the salary
   * @param year the hire year
   * @param month the hire month
   * @param day the hire day
   */
  public Manager(String name, double salary, int year, int month, int day)
  {
    super(name, salary, year, month, day);
    bonus = 0;
  }

  @Override
  public double getSalary()
  {
    double baseSalary = super.getSalary();
    return baseSalary + bonus;
  }

  public void setBonus(double b)
  {
    bonus = b;
  }

  @Override
  public Manager getBubby() {
    return this;
  }
}
