package ExceptionHandling;

import java.io.FileInputStream;
import java.io.IOException;
/*
*
👉 Compiler forces you to handle it

One-Line Revision Summary (Last Minute)
Checked → compiler forces handling
Unchecked → runtime, programmer mistake
try-catch-finally → safe execution
throw → explicitly throw exception
throws → delegate handling
Throwable → root class (avoid catching)
* */

public class ExceptionHandlingRevision {

    // ===============================
    // 1️⃣ Checked Exception Example
    // ===============================
    static void checkedExceptionDemo() throws IOException {
        // Compiler forces handling
        FileInputStream fis = new FileInputStream("demo.txt");
        fis.close();
    }

    // ===============================
    // 2️⃣ Unchecked Exception Example
    // ===============================
    static void uncheckedExceptionDemo() {
        int a = 10;
        int b = 0;
        System.out.println(a / b); // ArithmeticException
    }

    // ===============================
    // 3️⃣ Handling Unchecked Exception
    // ===============================
    static void handleUnchecked() {
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Handled array index issue");
        }
    }

    // ===============================
    // 4️⃣ throw Example
    // ===============================
    static void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18+");
        }
        System.out.println("Valid age");
    }

    // ===============================
    // 5️⃣ throws Example
    // ===============================
    static void readFile() throws IOException {
        FileInputStream fis = new FileInputStream("test.txt");
        fis.close();
    }

    // ===============================
    // 6️⃣ try-catch-finally Demo
    // ===============================
    static void tryCatchFinallyDemo() {
        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("Null value found");
        } finally {
            System.out.println("Finally block always runs");
        }
    }

    // ===============================
    // 7️⃣ Throwable Demo (Not Recommended)
    // ===============================
    static void throwableDemo() {
        try {
            int x = 10 / 0;
        } catch (Throwable t) {
            System.out.println("Caught using Throwable");
        }
    }

    public static void main(String[] args) {

        // Unchecked exception handling
        handleUnchecked();

        // try-catch-finally
        tryCatchFinallyDemo();

        // throw example
        try {
            validateAge(16);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // throws example
        try {
            readFile();
        } catch (IOException e) {
            System.out.println("File not found");
        }

        // Throwable demo
        throwableDemo();
    }
}
