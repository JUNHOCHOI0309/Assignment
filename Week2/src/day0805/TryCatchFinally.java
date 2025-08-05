package day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TryCatchFinally {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("첫 번째 정수 입력 : ");
            int num1 = Integer.parseInt(br.readLine());

            System.out.print("두 번째 정수 입력 : ");
            int num2 = Integer.parseInt(br.readLine());

            int result = num1 / num2;
            System.out.println("나눗셈 결과: " + result);
        } catch (ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니다.");
        } catch (IOException e){
            System.out.println("입력 오류");
        } finally {
            System.out.println("계산 종료");
        }
    }
}
