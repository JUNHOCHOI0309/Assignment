package day0725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment20250725_5 {
    public static void main(String[] args) throws IOException {
        System.out.println("배열 원소의 평균값을 소수점까지 구하시오.");
        System.out.println("중괄호 안에 정수를 입력해주세요. ex) {1,2,3,4,5}");
        System.out.print("입력 : ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String cleanInput = input.replaceAll("[{}\\s]", "");
        String[] numbers = cleanInput.split(",");

        double sum = 0;

        for(String number : numbers){
            sum += Double.parseDouble(number);
        }
        System.out.println("출력: 평균: "+ (sum / numbers.length));
    }
}
