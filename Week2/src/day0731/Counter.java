package day0731;

public class Counter {//과제 6
    private static int count = 0;

    public Counter() {
        count++;
    }

    public static int getCount(){
        return count;
    }

    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();

        System.out.println("총 객체 수: "+ Counter.getCount());
    }
}
