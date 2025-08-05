package day0805;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class InvalidAgeException extends Exception{
    public InvalidAgeException(int age){
        super("유효하지 않은 나이입니다: " + age);
    }
}

public class Throw {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.print("나이 입력:");
            int age = Integer.parseInt(br.readLine());

            if(age < 0){
                throw new InvalidAgeException(age);
            }
            System.out.println("입력한 나이: "+ age);
        } catch (InvalidAgeException e){
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println("입력 오류");
        }
    }
}
