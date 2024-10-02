public class CallStackDemo {

    public static void a() {b();}
    public static void b() {c();}
    public static void c() {
        System.out.println("In c");
    }

    public static void main(String[] args) {
        a2();
    }


    public static void a2() {
        int i = 10;
        b2();
        System.out.println("i is " + i);
    }

    public static void b2() {
        int i = 20;
        System.out.println("In b2");
        System.out.println("i is " + i);
    }
}
