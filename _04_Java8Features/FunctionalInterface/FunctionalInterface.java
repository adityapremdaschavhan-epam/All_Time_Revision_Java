package FunctionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class FunctionalInterface {
    static void usingFunction(){
        // like a map uses function Functon<t,r>

        // 1) converting string to its length
        Function<String,Integer> lengthFinder = String::length;
        System.out.println("length of string is " + lengthFinder.apply("abcdefg")); // r apply

        // 2) converting employee to its name
    }

    static void usingPredicate(){
        // like a filter ->
        // boolean test()
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        Predicate<Integer> filterEvenNum = num -> num%2==0;
        System.out.println("10 is a even number " + filterEvenNum.test(10));  //boolean test
    }

    static void usingSupplier(){
        // like random number generator -> Supplier<T>

        // T get();

        Supplier<Double> randomNumberGenerator = () -> Math.random();
        System.out.println(randomNumberGenerator.get());
    }

    static void usingConsumer(){
        // takes a input -> perform operation but returns nothing.
        Consumer<String> print = name-> System.out.println("name");
        print.accept("Aditya");
    }


    static void main() {
        usingFunction();
        usingPredicate();
        usingSupplier();
        usingConsumer();
    }
}
