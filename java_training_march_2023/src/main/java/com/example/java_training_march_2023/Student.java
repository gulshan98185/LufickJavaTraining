package com.example.java_training_march_2023;

public class Student {
    protected String name;
    protected String father;
    protected int id;
    protected int age;
    protected int weight;
    protected int rollNo;
    protected String address;

    public Student(){
        this.name = "Kaushal";
        this.father = "Purushottam";
        this.address = "Delhi";
        this.age = 22;
        this.rollNo = 1;
        this.id = 112233;
        this.weight = 55;
    }

    public Student(String name, String father, int id, int age, int weight, int rollNo, String address) {
        this.name = name;
        this.father = father;
        this.id = id;
        this.age = age;
        this.weight = weight;
        this.rollNo = rollNo;
        this.address = address;
    }

    final void getStudentInfo(){
        System.out.println("Name is "+name+ " father is "+father+" address is "+address+" age is "+age+" roll no is "+rollNo+" id is "+id+" weight is "+weight);
    }

    private void oath(){
        System.out.println("Name is "+name + " address is "+address+" age is "+age);
    }

    protected void getInformation(int password){
        if (password == 112233){
            oath();
        }else {
            getStudentInfo();
        }
    }

    public String getName(){
        return name;
    }

    public String getFather(){
        return father;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name){
        this.name = name;
    }
}

class Teacher extends Student{

    int batchNo;
    int experience;

    public Teacher(String name, String father, int id, int age, int weight, int rollNo, String address, int batchNo, int experience){
        super(name, father, id, age, weight, rollNo, address);
        this.batchNo = batchNo;
        this.experience = experience;
    }

    public void doSomething(){
        father = "Father";
    }

    public void showInfo(){
//        getStudentInfo("xyz");
        getInformation(112233);
    }

    public void getStudentInfo(String name){
        System.out.println("Name is "+name+ " father is "+father+" address is "+address+" age is "+age+" roll no is "+rollNo + " Batch no is " + batchNo + " Experience " + experience);
    }
}
