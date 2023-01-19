package com.example.table;

import java.util.Comparator;

public class Students {
    private String first_name;
    private String second_name;
    private Integer age;

    public Students(String first_name, String second_name, Integer age) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.age = age;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Students{" +
                "first name'" + first_name + '\'' +
                ", second name'" + second_name + '\'' +
                ", age=" + age +
                '}';
    }

    public Students(){};

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    static class StudentsComparatorName implements Comparator<Students> {

        public int compare(Students n1, Students n2) {

            return n1.first_name.compareTo(n2.first_name);
        }

    }
    static class StudentsComparatorAge implements Comparator<Students> {

        public int compare(Students n1, Students n2) {
            return n1.age.compareTo(n2.age);
        }
    }
}
