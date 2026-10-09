
public class Principal {

    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;

        Integer c = 1000;
        Integer d = 1000;

        System.out.println("\n1. Comparando valores pequenos");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a == b: " + (a == b));
        System.out.println("a.equals(b): " + a.equals(b));

        System.out.println("\n2. Comparando valores maiores");
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("c == d: " + (c == d));
        System.out.println("c.equals(d): " + c.equals(d));

    }
}
