package com.lewis.leetcode;

/*
 * 公司每个员工都符合Employee类的描述。整个公司的人员结构可以看做是一颗标准的、
 * 没有环的多叉树。树的头节点是公司唯一的老板。除老板外每个员工都有唯一的上级。
 * 叶节点是没有任何下属的基层员工，除基层员工之外，每个员工都有一个或者多个直接下级。
 *
 * 这个公司要办party, 你可以决定哪些员工来，哪些员工不来。但是要遵循如下规则
 * 1. 如果某个员工来了，那么这个员工的所有直接下级都不能来
 * 2. party整体的快乐值是所有到场员工快乐值的累加
 * 3. 你的目标是让party的整体快乐值尽量大
 */

import java.util.LinkedList;
import java.util.List;

public class EmployeeCode {

      public static class Info{
          public int comeMaxHappy;
          public int notMaxHappy;

          public Info(int comeMaxHappy, int notMaxHappy){
              this.comeMaxHappy = comeMaxHappy;
              this.notMaxHappy = notMaxHappy;
          }
      }

      public static class Employee{
          public int value;
          public List<Employee> lower;

          Employee(int value){
              this.value = value;
          }
      }

      public static Info process(Employee x){
          if(x.lower.isEmpty()){
              return new Info(x.value, 0);
          }
          int come = x.value;
          int not = 0;
          for(int i = 0; i < x.lower.size(); ++i){
              Info info = process(x.lower.get(i));
              come += info.notMaxHappy;;
              not += info.comeMaxHappy;
          }
          return new Info(come, not);
      }

}
