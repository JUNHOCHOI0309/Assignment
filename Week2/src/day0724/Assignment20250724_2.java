package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment20250724_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("첫 번째 숫자를 입력하세요 : ");
        int a = Integer.parseInt(br.readLine());
        System.out.print("두 번째 숫자를 입력하세요 : ");
        int b = Integer.parseInt(br.readLine());

        while (true) {
            System.out.println(
                    "1. 덧셈 \n2. 뺄셈 \n3. 곱셈 \n4. 나눗셈 \n5. 종료"
            );
            System.out.print("연산을 진행할 방식을 선택해주세요 : ");
            int choose = Integer.parseInt(br.readLine());

            if (choose > 5) {
                System.out.println("잘못된 선택입니다.");
            } else {
                switch (choose) {
                    case 1:
                        System.out.println(a + " + " + b + " = " + (a + b));
                        break;
                    case 2:
                        System.out.println(a + " - " + b + " = " + (a - b));
                        break;
                    case 3:
                        System.out.println(a + " * " + b + " = " + (a * b));
                        break;
                    case 4:
                        if(b == 0){
                            System.out.println("0으로 나눌 수 없습니다.");
                            break;
                        }
                        System.out.println(a + " / " + b + " = " + (a / b));
                        break;
                    default:
                        System.exit(0);
                        break;
                }
            }
        }

    }
}
