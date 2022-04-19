package com.lufick.training;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class CollectionActivity extends AppCompatActivity {
    public static final String TAG = "CollectionActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        //hashsetImpTest();
        sortingTest();
        if (true)
            return;
        //int []rollNo =  new int[10];
        HashSet<Student> studentsList = new HashSet<>();

        //The differences between ArrayList and HashSet is that ArrayList is an ordered
        //collection and maintains insertion order of elements
        //while HashSet is an unordered collection and doesn't maintain any order.


        //rollNo.add(10);
        //rollNo.add(100);
//        studentsList.add("A List");
//        studentsList.add("B List");
//        studentsList.add("C List");

        studentsList.add(new Student(1, "A", 10));
        studentsList.add(new Student(2, "B", 11));
        studentsList.add(new Student(3, "C", 15));
        studentsList.add(new Student(4, "D", 18));

        //studentsList.remove(new Student(4,"4",18));

        ArrayList<Integer> rollNoList = new ArrayList<>();
        rollNoList.add(2);
        rollNoList.add(23);
        rollNoList.add(3);

        ArrayList<Integer> foundList = new ArrayList<>();
        for (Integer rollNo : rollNoList) {
            if (studentsList.contains(rollNo)) {
                foundList.add(rollNo);
            }
        }
        //foundList.remove(0);

        /*Student findStudent = new Student(4,"D",18);
        for (Student s : studentsList) {
            //Log.d(TAG, s);
            if(s.name == findStudent.name){

            }
        }*/
        //boolean found = studentsList.contains();

        //int index = studentsList.indexOf(new Student(4, "D", 18));
        //Log.d(TAG, "Found in list Index-" + index);

    }


    public void hashsetImpTest() {

        HashSet<Animal> animalsList = new HashSet<>();
        animalsList.add(new Animal("Dog"));
        animalsList.add(new Animal("Cat"));
        animalsList.add(new Animal("Dog"));

        for (Animal animal : animalsList) {
            Log.d(TAG, "hashsetImpTest:" + animal.name);
        }
    }


    public void sortingTest() {
        ArrayList<Student> studentsList = new ArrayList<>();
        studentsList.add(new Student(4, "A", 18));
        studentsList.add(new Student(1, "A", 10));
        studentsList.add(new Student(2, "Eric", 11));
        studentsList.add(new Student(3, "C", 15));

        Collections.sort(studentsList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //Compares its two arguments for order. Returns a negative integer,
                // zero, or a positive integer as the first argument is less than,
                // equal to, or greater than the second.
                if (o1.rollNo == o2.rollNo) {
                    return 0;
                } else if (o1.rollNo < o2.rollNo) {
                    return 1;
                } else if (o1.rollNo > o2.rollNo) {
                    return -1;
                }

                return 0;



                /*int result = o2.name.compareTo(o1.name);
                if (result == 0) {
                    return o1.rollNo - o2.rollNo;
                }
                return result;*/

                //return 0;
            }
        });

        for (Student student : studentsList) {
            Log.e(TAG, "sortingTest:" + student);
        }
    }

    public void stackTest() {
        Stack<File> browsingHistoryStack = new Stack<>();
        //Last In First Out
        browsingHistoryStack.push(new File("storage/emulated/0"));
        browsingHistoryStack.push(new File("storage/emulated/0/Download"));
        browsingHistoryStack.push(new File("storage/emulated/0/Download/Photos"));
        browsingHistoryStack.push(new File("storage/emulated/0/Download/Photos/MyPhotos"));


        File file = browsingHistoryStack.pop(); //"storage/emulated/0/Download/Photos/MyPhotos"
        File file1 = browsingHistoryStack.pop(); //"storage/emulated/0/Download/Photos"
        File file2 = browsingHistoryStack.pop(); //"storage/emulated/0/Download"
        File file3 = browsingHistoryStack.pop();//"storage/emulated/0"

    }

    public void hashMapTest(){
        HashMap<String,Student> studentHashMap = new HashMap<>();
        studentHashMap.put("101", new Student(101,"A",10));
    }


    class Animal {
        String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Animal animal = (Animal) o;

            return name.equals(animal.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }


    class Student {
        int rollNo;
        String name;
        float age;

        public Student(int rollNo, String name, float age) {
            this.rollNo = rollNo;
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Student student = (Student) o;

            return rollNo == student.rollNo;
        }

        @Override
        public int hashCode() {
            return rollNo;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "rollNo=" + rollNo +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}