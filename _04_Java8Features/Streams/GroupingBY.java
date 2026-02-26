package Streams;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBY {
    public static void main() {
        List<Student> students = List.of(
                new Student(50, "CS", "a", 80),
                new Student(60, "CS", "b", 80),
                new Student(70, "IT", "c", 60),
                new Student(80, "IT", "d", 70),
                new Student(90, "DATA", "e", 90)
        );

        // groups student by their department
        Map<String,List<String>> mpp1 = students.stream().collect(Collectors.groupingBy(Student::getDept,Collectors.mapping(Student::getName,Collectors.toList())));
        for(Map.Entry<String,List<String>> entry : mpp1.entrySet()){
            System.out.print(entry.getKey()+"->");
            System.out.println(entry.getValue());
        }

//        Group by Dept → then by Pass/Fail
        Map<String,Map<String,List<String>>> mpp2 = students.stream()
                .collect(Collectors
                        .groupingBy(Student::getDept, Collectors
                                .groupingBy(stu->stu.getMarks() > 60 ? "Pass" : "Fail",Collectors
                                        .mapping(Student::getName,Collectors.toList()))));

        for(Map.Entry<String,Map<String,List<String>>> deptMap : mpp2.entrySet()){
            System.out.println("department ->"+deptMap.getKey());
            for(Map.Entry<String,List<String>> resultMap : deptMap.getValue().entrySet()){
                System.out.println("result->"+resultMap.getKey());
                System.out.println(resultMap.getValue());
            }
        }
    }
}

class Student {
    int id;
    String name;
    String dept;
    int marks;

    public Student(int marks, String dept, String name, int id) {
        this.marks = marks;
        this.dept = dept;
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", marks=" + marks +
                '}';
    }
    // getters
}