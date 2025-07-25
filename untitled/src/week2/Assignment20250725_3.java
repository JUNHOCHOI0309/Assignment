package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment20250725_3 {
    public static void main(String[] args) throws IOException {
        System.out.println("배열에서 특정 정수가 몇 번 나오는지 출력하시오.");
        System.out.println("중괄호 안에 정수를 입력해주세요. ex) {1,2,3,4,5}");
        System.out.print("입력 : ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String cleanInput = input.replaceAll("[{}\\s]", "");
        String[] numbers = cleanInput.split(",");

        System.out.print(", 찾을 값: ");
        int find = Integer.parseInt(br.readLine());

        int[] arr = new int[numbers.length];
        int count = 0;

        for(int i =0; i < numbers.length; i++){
            arr[i] = Integer.parseInt(numbers[i]);
        }

        for(int x : arr){
            if(x == find){
                count++;
            }
        }
        System.out.println("출력: "+ count);
    }
}
