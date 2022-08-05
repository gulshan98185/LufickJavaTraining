package com.lufick.training.collections;

import java.util.Objects;

public class Student {
    String name;
    String fatherName;
    int rollNO;

    public Student(String name, String fatherName, int rollNO) {
        this.name = name;
        this.fatherName = fatherName;
        this.rollNO = rollNO;
    }

    public String getName() {
        return name;
    }

    public int getRollNO() {
        return rollNO;
    }

    public String getFatherName() {
        return fatherName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getRollNO() == student.getRollNO() && Objects.equals(getName(), student.getName()) && Objects.equals(getFatherName(), student.getFatherName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFatherName(), getRollNO());
    }
}
