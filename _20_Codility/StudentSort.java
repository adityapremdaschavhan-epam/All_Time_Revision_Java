package Codility;

import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors.*;

public class StudentSort{
	
	// sorting using stream
	public static List<String> sortStudentUsingStream(List<StudentScore> studentList){
		return studentList.stream()
					.sorted(Comparator.comparingInt(StudentScore::getScore)
							   .reversed().thenComparing(StudentScore::getName))
					.map(StudentScore::getName)
					.toList();
	}


	// sorting using custom comparator
	public static List<String> sortStudentUsingComparator(List<StudentScore> studentList){
		
		Collections.sort(studentList,(a,b)->{
			if(a.getScore() != b.getScore()){
				return b.getScore() - a.getScore();	// desc order
			}
			return a.getName().compareTo(b.getName());	// asce order via names	
		});
		
		List<String> names = new ArrayList<>();
		for(StudentScore student : studentList){
			names.add(student.getName());
		}		
		
		return names;
	}

	// sorting using Comparator.comparing
	public static List<String> sortStudentUsingComparing(List<StudentScore> studentList){
		
		Collections.sort(studentList,Comparator.comparing(StudentScore::getScore)
							.reversed()
							.thenComparing(StudentScore::getName));
		List<String> names = new ArrayList<>();
		for(StudentScore student : studentList){
			names.add(student.getName());
		}
		
		return names;

	}
        /*
		using Comparable<StudentScore>
		class StudentScore implements Comparable<Student>{
			feilds
			construtors
			getters and setters
			
			@Override
			public int compareTo(StudentScore others){
				
				if(this.score != other.score) return other.score - this.score;  // desc
				return this.name.compareTo(others.name);
			}

		}
	*/

	public static void main(String[] args){
	 	List<StudentScore> studentList = new ArrayList<>();
		
		studentList.add(new StudentScore(1,"Alice",88));
		studentList.add(new StudentScore(2,"Bob",90));
		studentList.add(new StudentScore(2,"Charlie",88));
		
		System.out.println(sortStudentUsingStream(studentList));
		System.out.println(sortStudentUsingComparator(studentList));
		System.out.println(sortStudentUsingComparing(studentList));

				
	}

}

/*
    class StudentScore {
    int id;
    String name;
    int score;

    public StudentScore(int id, String name, int score) {
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