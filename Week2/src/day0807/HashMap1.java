package day0807;

import java.util.HashMap;
import java.util.Map;

public class HashMap1 {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("김철수",85);
        map.put("이영희",92);
        map.put("박민수",78);
        
        //이영희 점수 출력
        System.out.println("이영희: " + map.get("이영희"));

        System.out.print("전체 목록: ");
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            System.out.print(entry.getKey() + " = " + entry.getValue()+",");
        }


    }
}
