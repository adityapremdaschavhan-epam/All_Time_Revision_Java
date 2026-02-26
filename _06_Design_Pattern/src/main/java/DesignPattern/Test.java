package DesignPattern;

class A {
    {
        System.out.println("class atg");
    }
    static void s() {
        System.out.print("A-s ");
    }

    final void f() {
        System.out.print("A-f ");
    }

    private void p() {
        System.out.print("A-p ");
    }

    void m() {
        System.out.print("A-m ");
        p();
    }
}

class B extends A {
    static void s() {
        System.out.print("B-s ");
    }
    {
        System.out.println("zaxdfsag");
    }
    // final method cannot be overridden

    private void p() {
        System.out.print("B-p ");
    }

    void m() {
        System.out.print("B-m ");
        p();
    }
}

public class Test {
    public static void main(String[] args) {
        A obj = new B();

        obj.s();


    }
}
