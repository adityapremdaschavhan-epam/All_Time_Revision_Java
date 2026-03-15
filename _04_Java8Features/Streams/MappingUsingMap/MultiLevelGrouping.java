package MappingUsingMap;

import java.util.*;
import java.util.stream.Collectors;

record Employee(String name, String department, String role,int salary){}

public class MultiLevelGrouping {

	static List<Employee> empList = new ArrayList<>(
		List.of(
			new Employee("Rahul","IT","Developer",60000),
    			new Employee("Priya","IT","Developer",80000),
    			new Employee("Amit","IT","Tester",50000),
    			new Employee("Neha","HR","Recruiter",45000),
    			new Employee("Ravi","HR","Recruiter",55000)
	));

	static void group_Department_Role_Employees(){
		Map<String,Map<String,List<String>>> mpp = empList.stream()
				.collect(Collectors.groupingBy(Employee::department,Collectors
				.groupingBy(Employee::role, Collectors
				.mapping(Employee::name,Collectors.toList()))));
		System.out.println(mpp);
	}

	static void group_Department_Role_CountEmployees(){
		Map<String,Map<String,Long>> mpp = empList.stream()
				.collect(Collectors.groupingBy(Employee::department,Collectors
				.groupingBy(Employee::role,Collectors.counting())
				));
		System.out.println(mpp);
	}

	static void group_Department_Role_HigestSalariedEmployeeName(){
		Map<String,Map<String,String>> mpp = empList.stream()
				.collect(Collectors.groupingBy(Employee::department,Collectors.groupingBy(Employee::role,
				Collectors.collectingAndThen(Collectors.maxBy(
				Comparator.comparingInt(Employee::salary)),emp->emp.get().name()))));
		System.out.println(mpp);
	}

	

	static void main(){
		group_Department_Role_Employees();
		group_Department_Role_CountEmployees();
		group_Department_Role_HigestSalariedEmployeeName();
	}

}


