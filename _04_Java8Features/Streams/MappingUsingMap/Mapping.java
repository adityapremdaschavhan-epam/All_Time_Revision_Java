package MappingUsingMap;


import java.util.*;
import java.util.stream.Collectors;

/*
stream.map(element -> transformedElement)
stream.map(Class::method)
*/


public class Mapping {

// *********************************************
 	//warmup map
	// convert list of integers to square
	
	public static void intToSquare(){
		List<Integer> list = List.of(1,2,3,4,5);
		List<Integer> squares = list.stream().map(n->n*n).toList();
		System.out.print("squares are "+ squares);
	}

// ************************************************
	//Scenario 1 – Student Names
	//Extract only student names
	
	public static void getStudentNames(){
		List<Student> students = new ArrayList<>(
			List.of(
				new Student("Rohan",90,"Nagpur"),
				new Student("Rohani",50,"amravati")
			)
		);
		List<String> names = students.stream().map(Student::getName).collect(Collectors.toList());
		System.out.println(names);
	}

// ***********************************************
	// Real-World Scenario 3 – Convert Entity → DTO (VERY IMPORTANT)
	// ❓ Convert Student → StudentDTO
	
// ************************************************
	// Names of students who scored > 60
	public static void getStudentMarksGreaterThan(){

		List<Student> student = new ArrayList<>(
			List.of(
				new Student("Rohan",90,"Nagpur"),
				new Student("Rohani",50,"amravati"),
				new Student("Reha",80,"Nagpur"),
				new Student("Rihan",60,"amravati")
			)
		);
		List<String> list = student.stream()
						.filter(stu -> stu.getMarks()>60)
						.map(Student::getName)
						.collect(Collectors.toList());
		System.out.println(list);

	}
//************************************************************
	// Sort students by marks, then extract names
	//
	public static void sortStudent(){
		List<Student> student = new ArrayList<>(
				List.of(
					new Student("dohan",90,"Nagpur"),
					new Student("cohani",50,"amravati"),
					new Student("Aeha",100,"Nagpur"),
					new Student("Bihan",60,"amravati")
				)
		);
     		// “First sort by marks.
		// If two students have the same marks, then sort those students by name.”
		List<String> names = student.stream()
					.sorted(Comparator.comparingInt(Student::getMarks).thenComparing(Student::getName))
					.map(Student::getName).collect(Collectors.toList()); 
		System.out.println(names);
	}


// ************************************************
	public static void main(String[] args){
		// intToSquare();
		// getStudentNames();
		//getStudentMarksGreaterThan();
		sortStudent();
	}
    
}

class Student{
	String name;
	Integer marks;
	String city;

	public Student(String name, Integer marks,String city) {
		this.name = name;
		this.marks = marks;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public String getCity(){
		return city;
	}

	public void setCity(String ity) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", marks=" + marks +
				", city=" + city +
				'}';
	}
}
