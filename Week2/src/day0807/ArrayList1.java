package day0807;

import java.util.ArrayList;

public class ArrayList1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("홍길동");
        list.add("김영희");
        list.add("이철수");

        list.remove(1);
        System.out.println("회원목록: "+ list);
    }
}
