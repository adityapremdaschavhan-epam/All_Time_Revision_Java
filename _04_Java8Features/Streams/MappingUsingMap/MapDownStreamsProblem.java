package Streams.MappingUsingMap;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

class Employee {
    String name;
    String department;
    int salary;

    public Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public int getSalary() { return salary; }
}

/*
📌 Problem Statement
From the list of employees:
1️⃣ Filter employees whose salary > 50,000
2️⃣ Group them by department
3️⃣ Map the employees to their names
4️⃣ Collect the result into
Map<String, List<String>>
* */

public class MapDownStreamsProblem {

    static List<Employee> employees = List.of(
            new Employee("Aditya", "IT", 60000),
            new Employee("Rahul", "IT", 65000),
            new Employee("Sneha", "HR", 70000),
            new Employee("Priya", "HR", 40000),
            new Employee("Amit", "Finance", 80000),
            new Employee("Amita", "Finance", 90000)

    );

    static void filterEmployess(){
        Map<String,List<String>> empName = employees.stream().filter(emp-> emp.getSalary() > 50)
                .collect(groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName,Collectors.toList())));
        System.out.println(empName);
    }

    static void filterEmployees1(){
        Map<String,List<String>>  empNames = employees.stream().filter(employee -> employee.getSalary()>50000)
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName,Collectors.toList())));
        System.out.println(empNames);
    }

    static void CountEmployeesPerDepartment(){
        Map<String,Long> empCount = employees.stream().collect(groupingBy(Employee::getDepartment,Collectors.counting()));
        System.out.println(empCount);
    }

    static void CountEmployeesPerDepartment1(){
        Map<String,Long> empCount = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        System.out.println(empCount);
    }
 
  static void CountEmployeesPerDepartmentBasedOnName(){
	Map<String,Long> empCount = employees.stream()
			.collect(groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName,Collectors.counting())));
	Map<String,List<String>> empcount2 = employees.stream()
			.collect(groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName,Collectors.toList())));
	System.out.println(empcount2);
	System.out.println(empCount);
  }

  static  void highestSalaryPerDepartment(){
      Map<String,String> higestSalriedEmpPerDept_1 = employees.stream()
              .collect(Collectors.groupingBy(Employee::getDepartment,
                      Collectors.collectingAndThen(
                              Collectors.maxBy((a,b)-> a.getSalary()-b.getSalary()),
                              emp->emp.get().getName()
                      )
              )
              );

      Map<String, String> hse2 = employees.stream()
              .collect(Collectors.groupingBy(Employee::getDepartment,
                      Collectors.collectingAndThen(Collectors
                              .maxBy(Comparator.comparing(Employee::getSalary)), emp->emp.get().getName() )
                        )
              );

      System.out.println(hse2);
  }

  static void department_ListOfEmployeesSortedBySalary(){
        // we want all the names of employees per department in sorted order according to thier salary
      System.out.println("Original employees list " + employees);

      Map<String,List<String>> empPerDeptSorted = employees.stream().collect(
              Collectors.groupingBy(Employee::getDepartment ,
                      Collectors.collectingAndThen(
                              Collectors.toList(),
                              list->list.stream()
                                      .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                                      .map(Employee::getName).toList()
                      )
              )
      );

      System.out.println(empPerDeptSorted);
  }

    public static void main(String[] args){

//       filterEmployees1();
//       CountEmployeesPerDepartment1();
//       CountEmployeesPerDepartmentBasedOnName();
//       highestSalaryPerDepartment();                  // -> medium
//        department_ListOfEmployeesSortedBySalary();




    }

}