package day0731;

public class Person {// 과제 1
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce(){
        System.out.println("이름 : "+ this.name + ", 나이 : "+ this.age + "살");
    }

    public static void main(String[] args) {
        Person p1 = new Person("홍길동", 20);
        p1.introduce();
    }
}
