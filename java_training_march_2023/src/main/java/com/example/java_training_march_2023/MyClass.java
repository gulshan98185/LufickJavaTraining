package com.example.java_training_march_2023;

public class MyClass {
    public static void main(String[] args) {
        Student student = new Student("Kaushal", "Purushottam", 112233, 22, 55, 1,  "Delhi");
        student.father = "Raghav";
        Student student2 = new Student("Aushal", "Purushottam", 112244, 20, 59, 15,  "Delhi");
        student2.setName("Sunil");
//        student.name = "Kaushal";
//        student.father = "Purushottam";
//        student.address = "Delhi";
//        student.age = 22;
//        student.rollNo = 1;
//        student.id = 112233;
//        student.weight = 55;
//        System.out.println("Name is "+student.getName()+ " father is "+student.getFather()+" address is "+student.getAddress()+" age is "+student.getAge()+" roll no is "+student.getRollNo()+" id is "+student.getId()+" weight is "+student.getWeight());
//        student.getStudentInfo();
//        student2.getStudentInfo();

        Teacher teacher = new Teacher("Kaushal", "Purushottam", 112233, 22, 55, 1,  "Delhi", 222, 5);
//        teacher.getStudentInfo();
        teacher.getStudentInfo("Vishal");

    }
}