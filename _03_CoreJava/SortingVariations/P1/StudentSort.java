package SortingVariations.P1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentSort {
	
	// sorting using stream
	public static List<String> sortStudentUsingStream(List<Student> studentList){
		return studentList.stream()
					.sorted(Comparator.comparingInt(Student::getScore)
							   .reversed().thenComparing(Student::getName))
					.map(Student::getName)
					.toList();
	}

	// sorting using custom comparator
	public static List<String> sortStudentUsingComparator(List<Student> studentList){
		
		Collections.sort(studentList,(a,b)->{
			if(a.getScore() != b.getScore()){
				return b.getScore() - a.getScore();	// desc order
			}
			return a.getName().compareTo(b.getName());	// asce order via names	
		});
		
		List<String> names = new ArrayList<>();
		for(Student student : studentList){
			names.add(student.getName());
		}		
		
		return names;
	}

	// sorting using Comparator.comparing
	public static List<String> sortStudentUsingComparing(List<Student> studentList){
		
		Collections.sort(studentList,Comparator.comparing(Student::getScore)
							.reversed()
							.thenComparing(Student::getName));
		List<String> names = new ArrayList<>();
		for(Student student : studentList){
			names.add(student.getName());
		}
		
		return names;

	}
        /*
		using Comparable<Student>
		class Student implements Comparable<Student>{
			feilds
			construtors
			getters and setters
			
			@Override
			public int compareTo(Student others){
				
				if(this.score != other.score) return other.score - this.score;  // desc
				return this.name.compareTo(others.name);
			}

		}
	*/

	public static void main(String[] args){
	 	List<Student> studentList = new ArrayList<>();
		
		studentList.add(new Student(1,"Alice",88));
		studentList.add(new Student(2,"Bob",90));
		studentList.add(new Student(2,"Charlie",88));
		
		System.out.println(sortStudentUsingStream(studentList));
		System.out.println(sortStudentUsingComparator(studentList));
		System.out.println(sortStudentUsingComparing(studentList));
	}
}

/*
    class Student {
    int id;
    String name;
    int score;

    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }
}

*/