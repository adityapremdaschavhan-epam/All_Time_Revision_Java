public class Strings_revision_methods {

    public static void main(String[] args) {

        System.out.println("=========== JAVA STRING FULL REVISION ===========");

        /* ==================================================
           1️⃣ WHAT IS STRING
           ================================================== */

        System.out.println("\n--- STRING BASICS ---");
        System.out.println("String is a sequence of characters");
        System.out.println("String is IMMUTABLE (cannot be changed)");

        String s1 = "Java";
        String s2 = new String("Java");

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        /*
         Internal:
         - String literals stored in String Constant Pool (SCP)
         - new String() creates object in Heap
        */

        /* ==================================================
           2️⃣ STRING CONSTANT POOL
           ================================================== */

        System.out.println("\n--- STRING CONSTANT POOL ---");

        String a = "Hello";
        String b = "Hello";
        String c = new String("Hello");

        System.out.println("a == b : " + (a == b));
        // true (same SCP object)

        System.out.println("a == c : " + (a == c));
        // false (heap vs SCP)

        System.out.println("a.equals(c) : " + a.equals(c));
        // true (content comparison)

        /*
         ==  -> reference comparison
         equals() -> content comparison
        */

        /* ==================================================
           3️⃣ IMMUTABILITY
           ================================================== */

        System.out.println("\n--- STRING IMMUTABILITY ---");

        String str = "Hello";
        str.concat(" World");

        System.out.println("After concat without reassignment: " + str);
        // Hello

        str = str.concat(" World");
        System.out.println("After concat with reassignment: " + str);
        // Hello World

        /*
         Internal:
         - concat() creates NEW object
         - old object remains unchanged
        */

        /* ==================================================
           4️⃣ IMPORTANT STRING METHODS
           ================================================== */

        System.out.println("\n--- IMPORTANT STRING METHODS ---");

        String text = "  Java Programming  ";

        System.out.println("length(): " + text.length());
        System.out.println("charAt(2): " + text.charAt(2));
        System.out.println("toUpperCase(): " + text.toUpperCase());
        System.out.println("toLowerCase(): " + text.toLowerCase());
        System.out.println("trim(): '" + text.trim() + "'");
        System.out.println("substring(2,6): " + text.substring(2, 6));
        System.out.println("contains('Java'): " + text.contains("Java"));
        System.out.println("startsWith('  Java'): " + text.startsWith("  Java"));
        System.out.println("endsWith('  '): " + text.endsWith("  "));

        /*
         substring():
         - start index inclusive
         - end index exclusive
        */

        /* ==================================================
           5️⃣ STRING COMPARISON
           ================================================== */

        System.out.println("\n--- STRING COMPARISON ---");

        String x = "apple";
        String y = "banana";

        System.out.println("compareTo(): " + x.compareTo(y));
        // negative (apple < banana)

        System.out.println("equalsIgnoreCase(): " + "JAVA".equalsIgnoreCase("java"));
        // true

        /*
         compareTo():
         - 0  -> equal
         - +ve -> first > second
         - -ve -> first < second
        */

        /* ==================================================
           6️⃣ STRING SPLIT & JOIN
           ================================================== */

        System.out.println("\n--- SPLIT & JOIN ---");

        String sentence = "Java is easy";

        String[] words = sentence.split(" ");

        for (String word : words) {
            System.out.println(word);
        }

        /*
         Output:
         Java
         is
         easy
        */

        String joined = String.join("-", words);
        System.out.println("Joined string: " + joined);
        // Java-is-easy

        /* ==================================================
           7️⃣ STRINGBUFFER (MUTABLE + THREAD SAFE)
           ================================================== */

        System.out.println("\n--- STRINGBUFFER ---");

        StringBuffer sb = new StringBuffer("Hello");

        sb.append(" World");
        sb.insert(5, " Java");
        sb.delete(5, 10);
        sb.reverse();

        System.out.println("StringBuffer result: " + sb);

        /*
         Internal:
         - Mutable
         - Synchronized (Thread-safe)
         - Slower than StringBuilder
         - sb return object so use toString() while returning
        */

        /* ==================================================
           8️⃣ STRINGBUILDER (MUTABLE + FAST)
           ================================================== */

        System.out.println("\n--- STRINGBUILDER ---");

        StringBuilder sbu = new StringBuilder("Hello");

        sbu.append(" World").append(" hi");
        sbu.replace(0, 5, "Hi");

        sb.reverse();

        System.out.println("StringBuilder result: " + sbu);

        /*
         Internal:
         - Mutable
         - NOT thread-safe
         - Faster than StringBuffer
         - sb return object so use toString() while returning
        */

        /* ==================================================
           9️⃣ STRING vs STRINGBUFFER vs STRINGBUILDER
           ================================================== */

        System.out.println("\n--- COMPARISON SUMMARY ---");

        System.out.println("String       : Immutable, Thread-safe");
        System.out.println("StringBuffer : Mutable, Thread-safe, Slow");
        System.out.println("StringBuilder: Mutable, NOT Thread-safe, Fast");

        /* ==================================================
           🔟 PERFORMANCE SCENARIO
           ================================================== */

        System.out.println("\n--- PERFORMANCE SCENARIO ---");

        String slow = "";
        for (int i = 0; i < 5; i++) {
            slow = slow + i;
        }
        System.out.println("Using String (creates many objects)");

        StringBuilder fast = new StringBuilder();
//        for (int i = 0; i < 5; i++) {
//            fast.append(i);
//        }
        for (int i = 0; i < 5; i++) {
            fast.append(i);
            System.out.println(fast.charAt(i));
//            fast.deleteCharAt(i);
        }
        System.out.println("Using StringBuilder (efficient)");

        /*
         Interview Rule:
         - Use String for constants
         - Use StringBuilder for loops
         - Use StringBuffer for multi-threading
        */

        System.out.println("\n=========== END OF STRING REVISION ===========");
    }
}