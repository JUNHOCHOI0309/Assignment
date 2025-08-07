package day0806;

import java.util.*;

//과제 6, 9, 10
class User{
    private String name;
    private int age;

    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + "(" + age + ")";
    }
}
public class Collection {
    public static void main(String[] args) {
        List<String> data = Arrays.asList("apple", "banana", "apple","cherry","banana","apple");

        //6
        TreeSet<String> set = new TreeSet<>(data);
        System.out.println(set);

        Map<String, Integer> map = new HashMap<>();
        for(String s : data){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        System.out.println(map);

        //10
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2)-> e2.getValue().compareTo(e1.getValue()));

        for(Map.Entry<String, Integer> entry : list){
            System.out.println(entry.getKey() + ": "+ entry.getValue());
        }


        //9
        List<User> users = new ArrayList<>();
        users.add(new User("Kim", 30));
        users.add(new User("Lee", 25));
        users.add(new User("Park", 28));

        users.sort(Comparator.comparing(User::getName).thenComparing(Comparator.comparingInt(User::getAge).reversed()));
        System.out.println(users);
    }
}
