package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment20250725_10 {
    public static void main(String[] args) throws IOException {
        System.out.println("배열을 오름차순으로 정렬하시오.");
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

        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = 0; j < numbers.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.print("출력: ");
        for(int x : arr){
            System.out.print(x+" ");
        }
    }
}
