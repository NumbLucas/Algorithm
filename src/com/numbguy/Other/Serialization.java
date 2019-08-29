package com.numbguy.Other;

import java.io.*;

public class Serialization implements Serializable {
    int name;
    int age;
    int sex;

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Serialization{" +
                "name=" + name +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Serialization s = new Serialization();
        s.setAge(12);
        s.setName(7);
        s.setSex(1);
        //FileOutputStream o = new FileOutputStream(new File("F:\\serialization.txt"));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("F:\\serialization.txt")));
        oos.writeObject(s);
        oos.close();


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("F:\\serialization.txt")));
        Serialization input = (Serialization)ois.readObject();
        System.out.println(input);
    }
}
