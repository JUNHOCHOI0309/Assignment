package day0807;

import java.util.Vector;

public class Vector1 {
    public static void main(String[] args) {
        Vector<String> v = new Vector<>();
        v.add("공지사항");
        v.add("Q&A");
        v.add("자유게시판");

        System.out.println("전체 게시글 목록");
        for(int i=0; i< v.size(); i++){
            System.out.println((i+1)+"."+ v.get(i));
        }
    }
}
