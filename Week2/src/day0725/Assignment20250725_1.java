package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment20250725_1 {
    public static void main(String[] args) throws IOException {
        System.out.println("정수 배열이 주어졌을 때 모든 원소의 총합을 구하시오.");
        System.out.println("중괄호 안에 정수를 입력해주세요. ex) {1,2,3,4,5}");
        System.out.print("입력 : ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String cleanInput = input.replaceAll("[{}\\s]", "");
        String[] numbers = cleanInput.split(",");

        int sum = 0;

        for(String number : numbers){
            sum += Integer.parseInt(number);
        }
        System.out.println("출력 : "+ sum);
    }
}
