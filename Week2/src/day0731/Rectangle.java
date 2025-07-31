package day0731;

public class Rectangle {//과제 5
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea(){
        return this.width * this.height;
    }
    public void printInfo(){
        System.out.println("가로: " + this.width + ", 세로: "+ this.height +", 넓이: "+ getArea());
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(10, 5);
        r.printInfo();
    }
}
