package day0806;

import java.util.List;

//과제 4,5
public class StrTrans {
    // 4
    public static String transform(String input){
        if (input == null) return null;

        String trimmed = input.trim();

        StringBuilder reversed = new StringBuilder(trimmed).reverse();

        StringBuilder result = new StringBuilder();
        boolean[] seen = new boolean[128];

        for(int i = 0; i < reversed.length(); i++){
            char c = reversed.charAt(i);
            if(!seen[c]){
                result.append(c);
                seen[c] = true;
            }
        }

        return result.toString();
    }

    // 5
    //문제점: 문자열 덧셈(+=) 연산, 매번 새로운 String 객체 생성
    public static String joinWords(List<String> words) {
        String result = "";
        for(String word : words) {
            result += word;
        }
        return result;
    }

    //개선안
    public static String joinWords2(List<String> words) {
        StringBuilder result = new StringBuilder();
        for(String word: words){
            result.append(word);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(transform("banana"));
    }
}
