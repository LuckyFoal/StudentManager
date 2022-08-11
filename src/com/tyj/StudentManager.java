package com.tyj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    public static void main(String[] args) throws IOException {
        //创建集合对象，用于存储学生信息
        ArrayList<CollegeStudent> list1 = new ArrayList<>();
        ArrayList<GraduateStudent> list2 = new ArrayList<>();

        //导入学生信息
        int index1 = CollegeStudent.leadInCollege(list1);
        int index2 = GraduateStudent.leadInGraduate(list2);

        menuDriven(list1 , list2);//功能实现

       //保存学生信息
        CollegeStudent.saveCollegeData(list1);
        GraduateStudent.saveGraduateData(list2 );
    }

    public static void menuDriven(ArrayList<CollegeStudent> list1 , ArrayList<GraduateStudent> list2){
        boolean out = true;//判断跳出循环
        while (out) {
            System.out.println("  ******************************************************  ");
            System.out.println("  *                学生信息管理系统                    *");
            System.out.println("  ******************************************************");
            System.out.println("  *******************系统功能菜单*************************     ");
            System.out.println("     ----------------------   ----------------------   ");
            System.out.println("     *********************************************     ");
            System.out.println("     *********************************************     ");
            System.out.println("     * 1.添加学生信息    * *  2.删除学生信息    *     ");
            System.out.println("     *********************************************     ");
            System.out.println("     * 3.修改学生信息    * *  4.查看学生信息  *     ");
            System.out.println("     *********************************************     ");
            System.out.println("     * 5.查看学生成绩  * *  6.统计学生人数    * ");
            System.out.println("     *********************************************     ");
            System.out.println("     * 7.退出系统       * *                  *");
            System.out.println("     **********************  ********************* ");
            System.out.println("     **********************  ********************* ");
            System.out.println("     ----------------------   ---------------------- ");
            System.out.println("请选择菜单编号:");
            //用Scanner完成键盘录入数据
            Scanner sc = new Scanner(System.in);
            String line = sc.next();
            //用switch语句完成操作的选择
            switch (line) {
                case "1":
                    System.out.println("请选择：1、 添加本科生信息2、添加研究生信息");
                    int num1;
                    num1 = sc.nextInt();
                    if (num1 == 1) {
                        CollegeStudent stu1 = (CollegeStudent) Method.addStudent(new CollegeStudent());
                        list1.add(stu1);
                        Method.sutdentSort1(list1);
                    } else if (num1 == 2) {
                        GraduateStudent stu2 = (GraduateStudent) Method.addStudent(new GraduateStudent());
                        list2.add(stu2);
                        Method.studentSort2(list2);
                    } else {
                        System.out.println("error!");
                    }
                    break;
                case "2":
                    Method.deleteStudent(list1, list2);
                    //System.out.println("删除学生信息");
                    break;
                case "3":
                    Method.updateStudent(list1, list2);
                    //System.out.println("修改学生信息");
                    break;
                case "4":
                    System.out.println("请选择：1、 查看本科生信息2、查看研究生信息");
                    int num2;
                    num2 = sc.nextInt();
                    if (num2 == 1) {
                        Method.showStudent(list1.toArray(new CollegeStudent[list1.size()]));
                    } else if (num2 == 2) {
                        Method.showStudent(list2.toArray(new GraduateStudent[list2.size()]));
                    }else {
                        System.out.println("error!");
                    }
                    break;
                case "5":
                    System.out.println("请选择：1、 查看本科生成绩2、查看研究生成绩");
                    int num3;
                    num3 = sc.nextInt();
                    if (num3 == 1) {
                        Method.showSore(list1.toArray(new CollegeStudent[list1.size()]));
                    } else if (num3 == 2) {
                        Method.showSore(list2.toArray(new GraduateStudent[list2.size()]));
                    } else {
                        System.out.println("error!");
                    }
                    break;
                case "6":
                    Method.statisticStudent(list1, list2);
                    break;
                case "7":
                    System.out.println("谢谢使用!");
                    out = false;
            }
        }
    }
}



