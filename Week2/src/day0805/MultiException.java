package day0805;

public class MultiException {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};

        try {
            int result = arr[5] / 0;
            System.out.println("결과: " + result);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("배열 인덱스 오류");
        } catch (ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니다.");
        }
    }
}
