package java_study;


public class javaStudy {

    private void f() {
        System.out.println("base class");
    }
    public static void main(String[] argv) {
        javaStudy po = new Derived();
        po.f();
    }
    static class Derived extends javaStudy {
        public void f() {
            System.out.println("sub class");
        }
    }



}
