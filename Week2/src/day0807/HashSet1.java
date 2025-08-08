package day0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class HashSet1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("입력할 정수의 개수를 적어주세요 :");
        int n = Integer.parseInt(br.readLine());

        HashSet<Integer> set = new HashSet<>();

        while (n-- > 0){
            int num = Integer.parseInt(br.readLine());
            set.add(num);
        }
        System.out.println(set);
    }
}
