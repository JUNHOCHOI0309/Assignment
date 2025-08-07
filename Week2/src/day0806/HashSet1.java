package day0806;

//과제 7, 8
import java.util.*;

class Member{
    String name;
    int age;

    public Member(String name, int age){
        this.name = name;
        this.age = age;
    }

    //해결 방법
    public boolean equals(Object o){
        if(this == o) return true; //동일한 객체면 true 반환
        if(o== null || getClass() != o.getClass()) return false; // 타입이 다르고, null 이면 false

        Member member = (Member) o;
        return age == member.age && Objects.equals(name, member.name);
    }

    public int hashCode(){
        return Objects.hash(name, age); // 멤버 변수들의 해시값을 이용해서 생성
    }
}

public class HashSet1 {
    public static void main(String[] args) {
        // 7
        Set<Member> members = new HashSet<>();
        members.add(new Member("Tom", 10));
        members.add(new Member("Tom", 10));

        //HashSet에서 중복을 제거하는 방법은 hashCode()를 호출해서 해시 버킷을 찾고, 버킷 내의 객체들을 equals()를 통하여 동등성을 비교하여 중복 여부를 결정
        //new Member("Tom", 10) 동일한 내용의 객체를 넣어서 같아보이지만 서로 다른 참조를 가지고 있어서 Hashset에서 다르다고 판단
        //따라서 hashCode()와 equals()를 일관되게 재정의가 필요함.

        System.out.println(members.size());

        // 8
        Map<Integer, String> treeMap = new TreeMap<>(Collections.reverseOrder());
        treeMap.put(85, "Kim");
        treeMap.put(95, "Lee");
        treeMap.put(90, "Park");

        for(Map.Entry<Integer, String> entry : treeMap.entrySet()){
            System.out.println(entry.getValue() + " : " + entry.getKey());
        }
        //TreeSet 사용시, 키값인 점수가 중복이 되면 Value 값이 덮어씌워진다는 단점을 유의해야한다.
    }
}
