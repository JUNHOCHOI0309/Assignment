package day0725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment20250725_9 {
    public static void main(String[] args) throws IOException {
        System.out.println("배열의 중간 인덱스에 위치한 값을 출력하시오. (길이는 홀수로 가정)");
        System.out.println("중괄호 안에 정수를 입력해주세요. ex) {1,2,3,4,5}");
        System.out.print("입력 : ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String cleanInput = input.replaceAll("[{}\\s]", "");
        String[] numbers = cleanInput.split(",");

        int length = numbers.length;
        int middle = length / 2;

        System.out.println("출력: " + numbers[middle]);
    }
}
