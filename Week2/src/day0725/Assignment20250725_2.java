package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment20250725_2 {
    public static void main(String[] args) throws IOException {
        System.out.println("배열의 최댓값과 최솟값을 구하시오.");
        System.out.println("중괄호 안에 정수를 입력해주세요. ex) {1,2,3,4,5}");
        System.out.print("입력 : ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String cleanInput = input.replaceAll("[{}\\s]", "");
        String[] numbers = cleanInput.split(",");

        int max = Integer.parseInt(numbers[0]);
        int min = Integer.parseInt(numbers[0]);

        for(String number : numbers){
            int n = Integer.parseInt(number);
            if(n > max){
                max = n;
            }
        }
        for(String number : numbers){
            int n = Integer.parseInt(number);
            if(n < min){
                min = n;
            }
        }

        System.out.println("출력: 최댓값: " + max + ", 최솟값: "+ min);



    }
}
