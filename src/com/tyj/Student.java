package com.tyj;

import java.util.Scanner;

public class Student {
    //学号
    private String id;
    //姓名
    private String name;
    //年龄
    private String age;
    //省份
    private String province;
    //城市
    private String city;
    //街道
    private String street;
    //门牌号
    private String number;
    //班级
    private String grade;

    public Student() {
    }

    public Student(String id, String name, String age, String province, String city, String street, String number, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.province = province;
        this.city = city;
        this.street = street;
        this.number = number;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public  void addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学号：");
        String id = sc.next();
        System.out.println("请输入姓名：");
        String name = sc.next();
        System.out.println("请输入年龄：");
        String age = sc.next();
        System.out.println("请输入班级：");
        String grade = sc.next();
        System.out.println("请输入省份：");
        String province = sc.next();
        System.out.println("请输入城市：");
        String city = sc.next();
        System.out.println("请输入街道：");
        String street = sc.next();
        System.out.println("请输入门牌号：");
        String number = sc.next();

        setId(id);
        setName(name);
        setAge(age);
        setGrade(grade);
        setCity(city);
        setProvince(province);
        setNumber(number);
        setStreet(street);
    }

    public void showSore(){}

}
