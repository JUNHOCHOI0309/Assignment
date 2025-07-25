package day0725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Assignment20250725_6 {
    public static void main(String[] args) throws IOException {
        System.out.println("배열에서 중복된 숫자를 제거한 뒤 오름차순으로 정렬하여 출력하시오.");
        System.out.println("중괄호 안에 정수를 입력해주세요. ex) {1,2,3,4,5}");
        System.out.print("입력 : ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String cleanInput = input.replaceAll("[{}\\s]", "");
        String[] numbers = cleanInput.split(",");

        int[] arr = new int[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            arr[i] = Integer.parseInt(numbers[i]);
        }

        int[] result = Arrays.stream(arr).distinct().sorted().toArray();

        System.out.print("출력: ");
        for(int x : result){
            System.out.print(x + " ");
        }
    }
}
