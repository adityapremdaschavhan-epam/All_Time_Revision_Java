package StreamsJava;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsByAditya {
    // Find the longest string in a list of strings using Java streams:
    public static void findLongestStrings(){
        List<String> list = Arrays.asList("apple", "banana", "cherry", "date", "grapefruit");

        //using reduce
        System.out.println(list.stream().
                reduce((a,b)->(a.length()>b.length()) ? a : b).get());

        // using sorted
        System.out.println(list.stream()
                .sorted(Comparator.comparingInt((String::length)).reversed())
                .findFirst().get());

        // using max()
        System.out.println(list.stream().max(Comparator.comparingInt(String::length)).get());
    }
    //    Check if a List Contains a Specific Element/
    public static void checkList(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int element1 = 4;
        int element2 = 8;
        System.out.println(numbers.stream().anyMatch(n->n==element1));
        System.out.println(numbers.stream().anyMatch(n->n==element2));
    }
    //      Find the Last Element in a List
    public static void findLast(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int last = numbers.stream().reduce((a,b)->b).get();
        System.out.println(last);
    }

//    Check if All Elements in a List Satisfy a Condition
//    public static void checkAllElement(){
//        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
//        int allElement = numbers.stream().allMatch(n->n%2==0);
//        System.out.println(allElement);
//    }



    //    Q1. Given a List<String>, return a list of strings that: have length > 5
//    are converted to uppercase
//    sorted alphabetically
    public static void stringMauplation(){
        List<String> words = Arrays.asList("apple", "banana", "Avocado", "cherry", "apricot", "Berry");
        System.out.println(words.stream().filter(n->n.length()>5).map(String::toUpperCase).sorted().collect(Collectors.toList()));
    }

    // Find the Sum of Digits of a Number

    public static void findSumDigit(){
        int number = 1234;
        int sum = String.valueOf(number).chars().map(c->c-'0').sum();
        int sum2 = String.valueOf(number).chars().map(Character::getNumericValue).reduce(0,(a,b)->a+b);
        System.out.println(sum2);
    }
    // Find the Second-Largest Element in a List
    public static void findSecondLargest(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println(numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());
        List<String> words = List.of("apple", "banana", "kiwi");
        System.out.println("second largetst element is "+words.stream().sorted(Comparator.comparingInt(String::length).reversed()).findFirst().get());
    }
//    Find the Sum of Digits of a Number

    public static void integerToStringOperations(){

//        String.valueOf(12345)  →  "12345"
//        "12345".chars() = This converts the string into an IntStream of character ASCII/Unicode values.
//        IntStream → [49, 50, 51, 52, 53]
//          .map(Character::getNumericValue) = It converts each character code into its actual numeric digit.

        int number = 12345;
        System.out.println("Sum of digit "+String.valueOf(number).chars().
                map(Character::getNumericValue).sum());

        System.out.println("product of digit "+ String.valueOf(number).chars().
                map(Character::getNumericValue).
                reduce(1,(a,b)->a*b));

//        Count how many even digits exist in a number.
        System.out.println("Counting even numbers " + String.valueOf(number).chars().
                map(Character::getNumericValue).filter(n->n%2==0).count() );

        System.out.println(" max digit is " + String.valueOf(number).chars().map(Character::getNumericValue).
                boxed().sorted(Comparator.reverseOrder()).findFirst().get());

        System.out.println(" max digit is " + String.valueOf(number).chars().map(Character::getNumericValue).
                max().getAsInt());

    }


//    String ↔ chars ↔ digits ↔ streams ↔ processing
     public static void  StringPipeline(){
        String str = "Hello";
         str.chars().mapToObj(c->(char)c).forEach(n-> System.out.println(n));
         System.out.println("character count is as follow " + str.chars().count());

         Predicate<Character> vowelCheck =
                 c -> c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
         Predicate<Character> vowelCheck1 =
                 c -> "aeiou".indexOf(Character.toLowerCase(c)) != -1;

         System.out.println("Vowels is as follow " + str.chars().
                 mapToObj(c->(char)c).
                 filter(vowelCheck).count());

     }


    static void main(String[] args) {
//        findLongestStrings();
        //        29-01-26
//        checkList();
//        findLast();
//        checkAllElement();
//        30 jan
//          stringMauplation();
//        1 feb
//            findSumDigit();
//            findSecondLargest();
//        integerToStringOperations();
//        String ↔ chars ↔ digits ↔ streams ↔ processing
           StringPipeline();


    }
}
