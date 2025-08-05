package day0805;

public class Throws {
    public static void level1() throws Exception{
        level2();
    }
    public static void level2() throws Exception {
        throw new Exception("문제 발생!");
    }
    public static void main(String[] args) {
        try{
            level1();
        } catch (Exception e){
            System.out.print("예외 처리:" + e.getMessage());
        }
    }
}
