package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment20250725_7 {
    public static void main(String[] args) throws IOException {
        System.out.println("배열을 오른쪽으로 한 칸 회전하시오.");
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
        int temp = arr[numbers.length - 1];
        for(int i = numbers.length-2; i >= 0; i--){
            arr[i+1] = arr[i];
        }
        arr[0] = temp;
        System.out.print("출력: {");
        for(int x : arr){
            System.out.print(x + ", ");
        }
        System.out.println("}");
    }
}
