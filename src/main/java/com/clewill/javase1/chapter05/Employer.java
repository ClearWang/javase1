package com.clewill.javase1.chapter05;

import java.time.LocalDate;

/**
 * 雇员类
 *
 * @author wangkai
 * @create 2018:01:16 15:46
 **/
public class Employer {
  private String name;
  private double salary;
  private LocalDate hireDay;

  public Employer(String name, double salary, int year, int month, int day)
  {
    this.name = name;
    this.salary = salary;
    hireDay = LocalDate.of(year, month, day);
  }

  public Employer getBubby(){
    return this;
  }
  public String getName()
  {
    return name;
  }

  public double getSalary()
  {
    return salary;
  }

  public LocalDate getHireDay()
  {
    return hireDay;
  }

  public void raiseSalary(double byPercent)
  {
    double raise = salary * byPercent / 100;
    salary += raise;
  }
}