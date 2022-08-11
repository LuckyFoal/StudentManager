package com.tyj;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CollegeStudent extends Student {
    //专业
    private String major;

    private String[] sore;

    public String[] getSore() {
        return sore;
    }

    public void setSore(String[] sore) {
        this.sore = sore;
    }

    public CollegeStudent(){}

    public CollegeStudent(String id, String name, String age, String province, String city, String street, String number, String grade) {
        super(id, name, age, province, city, street, number, grade);
        this.major = major;
    }

    public void setMajor(String m) {
        major = m;
    }

    public String getMajor() {
        return major;
    }

    public  void addStudent(){
        super.addStudent();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入专业：");
        String major = sc.next();

        sore = new String[3];
        System.out.println("请输入数学成绩：");
        sore[0] = sc.next();
        System.out.println("请输入英语成绩：");
        sore[1] = sc.next();
        System.out.println("请输入专业课成绩：");
        sore[2] = sc.next();

        setMajor(major);
    }

    public void showSore(){
        System.out.print(super.getName() + "\t");
        for (int i = 0; i < sore.length; i++) {
            System.out.print("\t\t" + (sore[i]));
        }
        System.out.println();
    }

    public static int leadInCollege(ArrayList<CollegeStudent> list1) throws IOException {
        File f = new File("CollegeStudent.txt");
        f.createNewFile();
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        int index = 0;//索引：记录已经导入的本科生的人数
        String regex = "\\s";//正则表达式，以空格为分隔符
        String line;//读取文本的每一行信息
        while ((line = br.readLine()) != null) {
            CollegeStudent stu1 = new CollegeStudent();
            String[] sore = new String[3];
            String[] split = line.split(regex);//将读入的一行信息以空格为分隔符进行分隔，并存入split数组中
            stu1.setId(split[0]);
            stu1.setName(split[1]);
            stu1.setAge(split[2]);
            stu1.setGrade(split[3]);
            stu1.setProvince(split[4]);
            stu1.setCity(split[5]);
            stu1.setStreet(split[6]);
            stu1.setNumber(split[7]);
            stu1.setMajor(split[8]);
//            stu1.sore[0] = split[9];
//            stu1.sore[1] = split[10];
//            stu1.sore[2] = split[11];
            sore[0] = split[9];
            sore[1] = split[10];
            sore[2] = split[11];
            stu1.setSore(sore);
            list1.add(stu1);
            index ++;
        }
        br.close();
        return index;
    }

    public static void saveCollegeData (ArrayList<CollegeStudent> list1) throws IOException {
        File f = new File("CollegeStudent.txt");
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < list1.size(); i++) {
            CollegeStudent stu1 = list1.get(i);
            bw.write(stu1.getId() + "\t" );
            bw.write(stu1.getName() + "\t" );
            bw.write(stu1.getAge() + "\t" );
            bw.write(stu1.getGrade() + "\t" );
            bw.write(stu1.getProvince() + "\t" );
            bw.write(stu1.getCity() + "\t" );
            bw.write(stu1.getStreet() + "\t" );
            bw.write(stu1.getNumber() + "\t" );
            bw.write(stu1.getMajor() + "\t" );
            bw.write(stu1.sore[0] + "\t");
            bw.write(stu1.sore[1] + "\t");
            bw.write(stu1.sore[2] + "\t");
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}
