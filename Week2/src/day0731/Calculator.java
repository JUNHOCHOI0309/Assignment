package day0731;

public class Calculator { // 과제 2
    public int add(int a, int b){
        return a + b;
    }
    public int subtract(int a, int b){
        return a - b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        int a = 10;
        int b = 5;
        System.out.println(a+ " + " +b + " = " + calc.add(10, 5));
        System.out.println(a+ " - " +b + " = " + calc.subtract(10, 5));
    }
}
