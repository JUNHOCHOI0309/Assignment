package day0805;

public class NullPointer {
    public static void main(String[] args) {
        String str = null;
        try{
            int length = str.length();
            System.out.println("문자열 길이: "+ length);
        } catch (NullPointerException e){
            System.out.println("문자열이 null입니다.");
        }
    }
}
