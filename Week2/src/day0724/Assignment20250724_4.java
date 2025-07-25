package day0724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Assignment20250724_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();
        int n = random.nextInt(100) + 1; // 랜덤 숫자 형성
        int count = 0; // 시도한 횟수

        boolean answer = false;

        while (!answer) {
            System.out.print("숫자를 추측해보세요 (1~100): ");
            int k = Integer.parseInt(br.readLine()); // 숫자 입력

            if(n == k){
                answer = true;
                System.out.println("정답입니다. 시도 횟수: "+ count);
            }
            else{
                count++;
                answer = false;
                if(n>k){
                    System.out.println("더 큰 수 입니다.");
                }
                if(n<k){
                    System.out.println("더 작은 수 입니다.");
                }
            }
        }
    }
}
