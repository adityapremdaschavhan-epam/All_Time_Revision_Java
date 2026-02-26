package Strings.Hashcode;

import java.util.HashSet;
import java.util.Set;

//class Student {
////        final int rollNo; // final because hashcode key can never be mutable(silent errro)
//        String name;
//
//        @Override
//        public boolean equals(Object obj) {
//            if (this == obj)
//                return true;
//            if (obj == null)
//                return false;
//            if (this.getClass() != obj.getClass())
//                return false;
//
//            Student other = (Student) obj;
////            return this.rollNo == other.rollNo;
//        }
//
////        @Override
////        public int hashCode() {
////            return rollNo;
////        }
//}



public class OverridingEqual {
    static void main() {
//        Student s1 = new Student();
//        s1.rollNo = 101;
//
//        Student s2 = new Student();
//        s2.rollNo = 101;
//
//        Set<Student> st = new HashSet<>();
//        st.add(s1);
//        st.add(s2);
//        System.out.println(s1.hashCode());
//        System.out.println("as the hashcode is now roll no for students s1 and s2 are equal hascode so duplicates ->"+st.size());
//
//        System.out.println(s1 == s2);        // false
//        System.out.println(s1.equals(s2));   // true 🎉


        String s1 = "Hi";
        String s2 = "Hi";

        System.out.println(s1.equals(s2));
        Integer i1 = 234;
        Integer i2 = 234;

//        System.out.println(i1.equals(i2));
    }
}
