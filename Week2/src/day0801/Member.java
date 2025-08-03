package day0801;

public class Member {
    String name;
    int point;
    public Member(String name, int point){
       this.name = name;
       this.point = point;
    }

    public void welcomeMessage(){
        System.out.println("어서오세요.");
    }
    public int getDiscountedPrice(int price){
        return price - point;
    }
    public void upgradePoint(){
        point += 1;
        System.out.println(name + "님의 포인트가 1점 증가하여 총 " + point + "점이 되었습니다.");
    }
    public void upgradePoint(String Eventname){
        point += 2;
        System.out.println(name + " 님이 "+ Eventname +" 이벤트로 포인트 2점 증가하여 총 " + point + "점이 되었습니다.");
    }

    public static void main(String[] args) {
        Member[] members = new Member[3];
        members[0] = new SilverMember("A", 0);
        members[1] = new GoldMember("B", 0);
        members[2] = new PlatinumMember("C", 0);

        for ( Member member : members){
            member.welcomeMessage();
        }

        members[0].upgradePoint();
        members[1].upgradePoint();
        members[2].upgradePoint("문화상품권");
    }
}
class SilverMember extends Member{
    public SilverMember(String name, int point){
        super(name, point);
    }
    public int getDiscountedPrice(int price){
        return price - point * 2;
    }

    @Override
    public void welcomeMessage() {
        System.out.println("어서오세요. 실버 고객님.");
    }
}
class GoldMember extends Member{
    public GoldMember(String name, int point){
        super(name, point);
    }
    public int getDiscountedPrice(int price){
        return price - point * 3;
    }

    @Override
    public void welcomeMessage() {
        System.out.println("어서오세요. 골드 고객님.");
    }
}
class PlatinumMember extends Member{
    public PlatinumMember(String name, int point){
        super(name, point);
    }
    public int getDiscountedPrice(int price){
        return price - point * 4;
    }

    @Override
    public void welcomeMessage() {
        System.out.println("어서오세요. 플래티넘 고객님.");
    }
}
