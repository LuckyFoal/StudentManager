package com.tyj;

import java.util.*;

public class Method {

    //使用多态定定义方法的参数，可增强代码的扩展性
    public static Student addStudent(Student stu) {
        stu.addStudent();
        System.out.println("添加学生数据成功");
        return stu;
    }

    //多态的使用
    public static void showStudent(Student[] stu) {
        if (stu.length == 0) {
            System.out.println("无数据，请先输入数据");
            return;
        }

        //instanceof判断传入的参数是原本哪一个的子类
        if (stu[0] instanceof CollegeStudent) {
            System.out.println("学号\t\t\t姓名\t\t\t年龄\t\t\t班级\t\t\t省份\t\t\t城市\t\t\t街道\t\t\t门牌号\t\t专业");
            for (int i = 0; i < stu.length; i++) {
                CollegeStudent s = (CollegeStudent) stu[i];
                System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s\n", s.getId(), s.getName(), s.getAge()
                        , s.getGrade(), s.getProvince(), s.getCity(), s.getStreet(), s.getNumber(), s.getMajor());
            }
        } else if (stu[0] instanceof GraduateStudent) {
            System.out.println("学号\t\t\t姓名\t\t\t年龄\t\t\t班级\t\t\t省份\t\t\t城市\t\t\t街道\t\t\t门牌号\t\t研究领域\t\t\t导师");
            for (int i = 0; i < stu.length; i++) {
                GraduateStudent s = (GraduateStudent) stu[i];
                System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-16s%-12s\n", s.getId(), s.getName(), s.getAge()
                        , s.getGrade(), s.getProvince(), s.getCity(), s.getStreet(), s.getNumber(), s.getArea(), s.getTutor());
            }
        }
    }

    public static void showSore(Student[] stu){
        System.out.println("学生姓名" + "\t\t数学" + "\t\t英语" + "\t\t专业课成绩");
        for (int i = 0; i < stu.length; i++) {
            stu[i].showSore();
        }
    }

    //定义一个方法，用于删除学生信息
    public static void deleteStudent(ArrayList<CollegeStudent> list1, ArrayList<GraduateStudent> list2) {
        //从键盘录入学生的学号
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学生的学号：");
        String id = sc.nextLine();

        //遍历集合将对应的学生从集合中删除
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).getId().equals(id)) {
                list1.remove(i);
                System.out.println("删除学生信息成功");
                return;
            }
        }

        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).getId().equals(id)) {
                list2.remove(i);
                System.out.println("删除学生信息成功");
                return;
            }
        }
        System.out.println("未找到此学生！");
    }

    //定义一个方法，用于修改学生信息
    public static void updateStudent(ArrayList<CollegeStudent> list1, ArrayList<GraduateStudent> list2) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要修改的学生的学号：");
        String id1 = sc.next();
        //遍历集合修改学生的信息
        for (int i = 0; i < list1.size(); i++) {
            CollegeStudent s1 = list1.get(i);
            if (s1.getId().equals(id1)) {
                System.out.println("请输入新的学生信息：");
                s1 = (CollegeStudent) addStudent((Student) s1);
                list1.set(i, s1);
                System.out.println("学生信息已修改！");
                return;
            }
        }

        for (int i = 0; i < list2.size(); i++) {
            GraduateStudent s2 = list2.get(i);
            if (s2.getId().equals(id1)) {
                System.out.println("请输入新的学生信息：");
                s2 = (GraduateStudent) addStudent((Student) s2);
                list2.set(i, s2);
                System.out.println("学生信息已修改！");
                return;
            }
        }
        System.out.println("未找到此学生！");
    }

    //定义一个方法，用于统计学生人数
    public static void statisticStudent(ArrayList<CollegeStudent> list1, ArrayList<GraduateStudent> list2) {
        if (list1.size() == 0 && list2.size() == 0) {
            System.out.println("本次共录入0个学生。");
            return;
        }
        //遍历集合，统计学生人数 {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < list1.size(); i++) {
            count1++;
        }
        for (int i = 0; i < list2.size(); i++) {
            count2++;
        }
        System.out.println("本次共录入" + count1 + "名本科生信息。");
        System.out.println("本次共录入" + count2 + "名研究生信息。");
    }

    public static void sutdentSort1(ArrayList<CollegeStudent> list1 ){
        //冒泡排序
        for (int i = 0; i < list1.size()-1; i++) {
            for (int i1 = 0; i1 < list1.size()-i-1; i1++) {
                if(list1.get(i1).getId().compareTo(list1.get(i1 + 1).getId()) > 0 ){
                    CollegeStudent temp;
                    temp = list1.get(i1+1);
                    list1.set((i1+1),list1.get(i1));
                    list1.set(i1,temp);
                }
            }
        }
    }

    public static void studentSort2(ArrayList<GraduateStudent> list2){
        for (int i = 0; i < list2.size()-1; i++) {
            for (int i1 = 0; i1 < list2.size()-i-1; i1++) {
                if(list2.get(i1).getId().compareTo(list2.get(i1 + 1).getId()) > 0 ){
                    GraduateStudent temp;
                    temp = list2.get(i1+1);
                    list2.set((i1+1),list2.get(i1));
                    list2.set(i1,temp);
                }
            }
        }

    }
}