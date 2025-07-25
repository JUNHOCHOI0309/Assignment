package day0725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment20250725_8 {
    public static void main(String[] args) throws IOException{
        System.out.println("배열에서 짝수만 골라 출력하시오.");
        System.out.println("중괄호 안에 정수를 입력해주세요. ex) {1,2,3,4,5}");
        System.out.print("입력 : ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String cleanInput = input.replaceAll("[{}\\s]", "");
        String[] numbers = cleanInput.split(",");

        System.out.print("출력: ");
        for(String number : numbers){
            int n = Integer.parseInt(number);
            if(n % 2 == 0){
                System.out.print(n + " ");
            }
        }
    }
}
