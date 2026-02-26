package codility2;

import java.util.*;
import java.util.stream.Collectors;

public class Codility2{

    public static List<String> sortStudentStream(List<StudentScore> studentScores){
        int n = studentScores.size();
        return studentScores.stream()
                .sorted(Comparator.comparingInt(StudentScore::getScore).reversed().thenComparing(StudentScore::getName))
                .map(StudentScore::getName)
                .collect(Collectors.toList());
    }

    public static List<String> sortStudentCollections(List<StudentScore> studentScores){
        int n = studentScores.size();
        Collections.sort(studentScores,(a,b)->{
            if(a.getScore() > b.getScore()){
                return a.getName();
            }
            else{

            }
        });
    }

    static void main() {
        List<StudentScore> studentList = new ArrayList<>();
        studentList.add(new StudentScore(1,"Alice",88));
        studentList.add(new StudentScore(2,"Bob",90));
        studentList.add(new StudentScore(3,"Charlie",88));
        System.out.println(sortStudent(studentList));
    }
}
