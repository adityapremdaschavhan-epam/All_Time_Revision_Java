package org.example;

public class StringPoolDemo {
    public static String demoLiterals1() {
        return "Bharath";
    }

    public static String demoLiterals2() {
        return "Bharath";
    }

    public static String demoNewObj1(){
        return new String("Bharat");
    }
    public static String demoNewObj2(){
        return new String("Bharat");
    }

    public void StringComparisonImpl() {

        // String literals (pooled)
        String s1 = "Bharath";
        String s2 = "Bharath";

        // New String objects (heap)
        String s3 = new String("Bharath");
        String s4 = new String("Bharath");

        // String returned  from a function (literal, pooled)
        String s5 = demoLiterals1();

        // Comparisons

        // 1. String literals
        System.out.println("s1 == s2: " + (s1 == s2));           // true (same pool object)
        System.out.println("s1.equals(s2): " + s1.equals(s2));   // true (same content)

        // 2. Literal vs new String
        System.out.println("s1 == s3: " + (s1 == s3));           // false (pool vs heap)
        System.out.println("s1.equals(s3): " + s1.equals(s3));   // true (same content)

        // 3. New String vs New String
        System.out.println("s3 == s4: " + (s3 == s4));           // false (different heap objects)
        System.out.println("s3.equals(s4): " + s3.equals(s4));   // true (same content)

        // 4. Literal vs function return (both pooled)
        System.out.println("s1 == s5: " + (s1 == s5));           // true (both pooled)
        System.out.println("s1.equals(s5): " + s1.equals(s5));   // true (same content)

        // 5. New String vs function return
        System.out.println("s3 == s5: " + (s3 == s5));           // false (heap vs pool)
        System.out.println("s3.equals(s5): " + s3.equals(s5));   // true (same content)

        // 6. Function return literals vs function return literals.
        String s6 = demoLiterals2();
        System.out.println("s5 == s6: " + (s5 == s6));           // true (both pooled)
        System.out.println("s5.equals(s6): " + s5.equals(s6));   // true (same content)

        // 7. Function return literals vs function return new obj.
        String s7 = demoNewObj1();
        System.out.println("s5 == s6: " + (s1 == s6));           // true (both pooled)
        System.out.println("s5.equals(s6): " + s5.equals(s6));   // true (same content)
    }
}
