import java.util.Scanner;
import java.util.function.Supplier;

public class Main {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Supplier<Double> supplier = this::input;
        MyNewCalculator c =
                new MyNewCalculator((v) -> {
                    System.out.println("Output is: " + v + "\n");
                });
        System.out.println("Add--------------");
        c.add(supplier, supplier);
        System.out.println("Subtract---------");
        c.subtract(supplier, supplier);
        System.out.println("Multiply---------");
        c.multiply(supplier, supplier);
    }

    public Double input() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return input();
        }
    }

    public static void main(String[] args) {
        new Main().start();
    }
}

//import java.util.Scanner;
//import java.util.function.Supplier;
//
//public class Main {
//    private Scanner scanner = new Scanner(System.in);
//
//    public void print(Integer value) {
//        System.out.println("Output is: " + value + "\n");
//    }
//
//    public Double getInput() {
//        return scanner.nextDouble();
//    }
//
//    public void start() {
//        MyCalculator c = new MyCalculator((v) -> System.out.println("Output is: " + v + "\n"));
//        Supplier<Double> supplier = scanner::nextDouble;
//        System.out.println("Add--------------");
//        c.add(supplier, supplier);
//        System.out.println("Subtract---------");
//        c.subtract(supplier, supplier);
//        System.out.println("Multiply---------");
//        c.multiply(supplier, supplier);
//    }
//
//    public static void main(String[] args) {
//        new Main().start();
//    }
//}


