package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment20250724_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("정수를 입력해주세요 : ");
        int n = Integer.parseInt(br.readLine());

        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            int spaceCount = Math.abs(mid - i);
            int starCount = n - 2 * spaceCount;
            for (int j = 0; j < spaceCount; j++) System.out.print(" ");
            for (int j = 0; j < starCount; j++) System.out.print("*");
            System.out.println();
        }

    }



}
