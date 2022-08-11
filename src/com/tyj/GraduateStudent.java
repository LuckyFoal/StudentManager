package com.tyj;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GraduateStudent extends Student {
    //导师
    private String tutor;
    //研究领域
    private String area;

    private String[] sore ;

    public String[] getSore() {
        return sore;
    }

    public void setSore(String[] sore) {
        this.sore = sore;
    }

    public GraduateStudent() {
    }

    public GraduateStudent(String id, String name, String age, String province, String city, String street, String number, String grade, String area, String tutor) {
        super(id, name, age, province, city, street, number, grade);
        this.area = area;
        this.tutor = tutor;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void addStudent() {
        super.addStudent();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入导师：");
        String tutor = sc.next();
        System.out.println("请输入研究领域：");
        String area = sc.next();

        sore = new String[3];
        System.out.println("请输入数学成绩：");
        sore[0] = sc.next();
        System.out.println("请输入英语成绩：");
        sore[1] = sc.next();
        System.out.println("请输入专业课成绩：");
        sore[2] = sc.next();

//        setSore(sore);
        setTutor(tutor);
        setArea(area);
    }

    public void showSore(){
//        System.out.println(super.getName() + "的各科成绩：" + "\t\t数学" + "\t\t英语" + "\t\t专业课成绩");
//        System.out.print("\t\t\t\t");
//        System.out.println("学生姓名" + "\t\t数学" + "\t\t英语" + "\t\t专业课成绩");
        System.out.print(super.getName() + "\t");
        for (int i = 0; i < sore.length; i++) {
            System.out.print("\t\t" + (sore[i]));
        }
        System.out.println();
    }

    public static int leadInGraduate(ArrayList<GraduateStudent> list2) throws IOException {
        File f = new File("GraduateStudent.txt");
        f.createNewFile();
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        int index = 0;//索引：记录已经导入的研究生的人数
        String regex = "\\s";//正则表达式，以空格为分隔符
        String line;//读取文本的每一行信息
        while ((line = br.readLine()) != null) {
            GraduateStudent stu2 = new GraduateStudent();
            String[] sore = new String[3];
            String[] split = line.split(regex);//将读入的一行信息以空格为分隔符进行分隔，并存入split数组中
            stu2.setId(split[0]);
            stu2.setName(split[1]);
            stu2.setAge(split[2]);
            stu2.setGrade(split[3]);
            stu2.setProvince(split[4]);
            stu2.setCity(split[5]);
            stu2.setStreet(split[6]);
            stu2.setNumber(split[7]);
            stu2.setArea(split[8]);
            stu2.setTutor(split[9]);
//            stu2.sore[0] = split[10];
//            stu2.sore[1] = split[11];
//            stu2.sore[2] = split[12];
            sore[0] = split[10];
            sore[1] = split[11];
            sore[2] = split[12];
            stu2.setSore(sore);
            list2.add(stu2);
            index ++;
        }
        br.close();
        return index;
    }

    public static void saveGraduateData (ArrayList<GraduateStudent> list2 ) throws IOException {
        File f = new File("GraduateStudent.txt");
        FileWriter fw = new FileWriter(f );
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < list2.size(); i++) {
            GraduateStudent stu2 = list2.get(i);
            bw.write(stu2.getId() + "\t" );
            bw.write(stu2.getName() + "\t" );
            bw.write(stu2.getAge() + "\t" );
            bw.write(stu2.getGrade() + "\t" );
            bw.write(stu2.getProvince() + "\t" );
            bw.write(stu2.getCity() + "\t" );
            bw.write(stu2.getStreet() + "\t" );
            bw.write(stu2.getNumber() + "\t" );
            bw.write(stu2.getArea() + "\t" );
            bw.write(stu2.getTutor() + "\t" );
            bw.write(stu2.sore[0] + "\t");
            bw.write(stu2.sore[1] + "\t");
            bw.write(stu2.sore[2] + "\t");
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}
