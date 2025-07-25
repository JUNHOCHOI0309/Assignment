package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment20250724_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("점수를 입력하세요: ");
        int n = Integer.parseInt(br.readLine());
        String grade = n >= 90 ? "A" : n >= 80 ? "B" : n >= 70 ? "C" : n >= 60 ? "D" : "F";

        System.out.println("당신의 등급은 "+ grade +"입니다.");

    }
}
