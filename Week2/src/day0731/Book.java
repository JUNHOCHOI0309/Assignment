package day0731;

public class Book {//과제 3
    private String title;
    private String author;
    private int price;

    public Book() {}

    public Book(String title) {
        this.title = title;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public void printInfo(){
        System.out.println("제목: " + this.title + ", 저자: "+ this.author +", 가격: "+this.price+"원");
    }

    public static void main(String[] args) {
        Book b = new Book("자바의 정석","남궁성",30000);
        b.printInfo();
    }
}
