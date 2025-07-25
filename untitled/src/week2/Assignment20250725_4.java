package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment20250725_4 {
    public static void main(String[] args) throws IOException {
        System.out.println("배열을 거꾸로 출력하시오. (실제 배열은 변경하지 않아도 됨)");
        System.out.println("중괄호 안에 정수를 입력해주세요. ex) {1,2,3,4,5}");
        System.out.print("입력 : ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String cleanInput = input.replaceAll("[{}\\s]", "");
        String[] numbers = cleanInput.split(",");

        System.out.print("출력: ");
        for(int i = numbers.length - 1; i >= 0; i--){
            System.out.print(numbers[i] + " ");
        }
    }
}
