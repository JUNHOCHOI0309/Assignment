package day0804;

import java.util.HashMap;
import java.util.Map;

interface OnlineReservable{
    void reserveOnline(String userId);
}

abstract class Transport{
    String id;
    int capacity;

    public Transport(String id, int capacity){
        this.id = id;
        this.capacity = capacity;
    }
    abstract void reserveSeat();
    public void printStatus(){// 남은 좌석 수 출력
        System.out.println("남은 좌석 수 :" + this.capacity);
    }
}

class Bus extends Transport{
    private int reservedCount;
    public Bus(String id, int capacity, int reservedCount) {
        super(id, capacity);
        this.reservedCount = reservedCount;
    }

    @Override
    void reserveSeat() {
        if(reservedCount < capacity){
            System.out.println("버스 좌석이 예약 되었습니다.");
            capacity--;
            reservedCount++;
        }else{
            System.out.println("버스 좌석이 모두 매진 되었습니다.");
        }
    }

    @Override
    public void printStatus() {
        System.out.println(id + " -버스 남은 좌석 수 :" + (capacity-reservedCount));
    }
}
class Train extends Transport{
    private int reservedCount;
    public Train(String id, int capacity, int reservedCount) {
        super(id, capacity);
        this.reservedCount = reservedCount;
    }
    void reserveSeat() {
        if(reservedCount < capacity){
            System.out.println("기차 좌석이 예약 되었습니다.");
            reservedCount++;
            capacity--;
        }else{
            System.out.println("기차 좌석이 모두 매진 되었습니다.");
        }
    }

    @Override
    public void printStatus() {
        System.out.println(id + " -기차 남은 좌석 수 :" + (capacity-reservedCount));
    }
}
class Flight extends Transport implements OnlineReservable{
    private int reservedCount;
    public Flight(String id, int capacity) {
        super(id, capacity);
        this.reservedCount = 0;
    }

    @Override
    void reserveSeat() {
        if(reservedCount < capacity){
            System.out.println("비행기 좌석이 예약 되었습니다.");
            reservedCount++;
            capacity--;
        }else{
            System.out.println("비행기 좌석이 모두 매진 되었습니다.");
        }
    }

    @Override
    public void reserveOnline(String userId) {
        System.out.println(userId +"님이 온라인으로 예약을 진행중입니다.");
        reserveSeat();
    }
    public void printStatus(){
        System.out.println(id + " -비행기 남은 좌석 수 :" + capacity);
    }
}

class ReservationSystem{
    private Map<String, Transport> transportMap = new HashMap<>();

    public void registerTransport(Transport t){
        transportMap.put(t.id, t);
    }

    public void reserveFlightOnline(String userId, String flightId){
        Transport flight = transportMap.get(flightId);
        if(flight == null){
            System.out.println("해당되는 ID의 교통수단이 존재하지 않습니다.");
            return;
        }
        if(flight instanceof OnlineReservable){
            ((OnlineReservable) flight).reserveOnline(userId);
        } else {
            System.out.println(flightId+"는 예약이 불가한 교통수단입니다.");
        }
    }
    public void reserveSeatDirectly(String transportId){
        Transport transport = transportMap.get(transportId);
        if(transport == null){
            System.out.println("해당되는 ID의 교통수단이 존재하지 않습니다.");
            return;
        }
        transport.reserveSeat();
    }

    public void printAllStatus(){
        for(Transport transport : transportMap.values()){
            transport.printStatus();
        }
    }
}
public class Transportation {
    public static void main(String[] args) {
        ReservationSystem rs = new ReservationSystem();
        Bus bus = new Bus("1", 50, 35);
        Train train = new Train("2", 100, 100);
        Flight flight = new Flight("3", 300);

        rs.registerTransport(bus);
        rs.registerTransport(train);
        rs.registerTransport(flight);

        rs.reserveFlightOnline("user1", "3");
        rs.reserveFlightOnline("user2", "3");

        rs.reserveSeatDirectly("1");
        rs.reserveSeatDirectly("2");
        rs.reserveSeatDirectly("3");

        rs.printAllStatus();

    }
}
