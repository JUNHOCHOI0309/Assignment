package day0806;

//과제 1,2
class Calculator{
    // 문제점 : 함수가 호출이 되는 순간 오토 언박싱이 진행이 됨. (a.intValue(), b.intValue()이 호출됨)
    // 하지만 x나 y가 null 인 순간 NullPointerException 문제점이 발생.
    public int add(Integer a, Integer b){
        //해결 방법
//        if(a==null || b== null){
//            throw new NullPointerException("입력값이 Null값은 불가합니다.")
//        }
        return a + b;
    }
}

public class Wrapper {
    public static void main(String[] args) {

        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;

        // == : 두 객체의 메모리 주소가 동일한지 비교를 진행.
        // equals() : 두 객체의 실제 내부 데이터 값이 같은지 비교를 진행.

        System.out.println(a == b); // True
        System.out.println(c == d); // False, False 인 이유 : Integer이 담을 수 있는 범위의 값은 -128~127 이기 때문에 127이 넘어가면 c,d 각각 Integer 200이라는 새로운 메모리 주소에 객체가 생성된다.
        System.out.println(a.equals(b)); // True
        System.out.println(c.equals(d)); // True


        System.out.println("a: " + System.identityHashCode(a));
        System.out.println("b: " + System.identityHashCode(b));
        System.out.println("c: " + System.identityHashCode(c));
        System.out.println("d: " + System.identityHashCode(d));
    }
}
