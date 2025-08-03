package day0801;

public class Vehicle {//과제 2
    String brand;
    int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public void printInfo(){
        System.out.println("탈 것입니다.");
    }
    public void startEngine(){
        System.out.println("기본 시동");
    }
    public void startEngine(String engine){
        System.out.println("키코드는 "+engine+"입니다.");
    }
    public void startEngine(String engine, int year){
        System.out.println("키 코드는 "+ engine + "이고, 시간은 "+year+"입니다.");
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car("도요타", 3);
        vehicles[1] = new Bus("현대", 5);
        vehicles[2] = new Motorcycle("페라리", 7);


        for(int i = 0; i < vehicles.length; i++){
            vehicles[i].printInfo();
        }
    }
}

class Car extends Vehicle {
    public Car(String brand, int year) {
        super(brand, year);
        startEngine();
    }

    @Override
    public void printInfo() {
        System.out.println("탈 것 중 차 입니다.");
    }
}

class Bus extends Vehicle {
    public Bus(String brand, int year) {
        super(brand, year);
        startEngine(brand);
    }

    @Override
    public void printInfo() {
        System.out.println("탈 것 중 버스 입니다.");
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String brand, int year) {
        super(brand, year);
        startEngine(brand, year);
    }

    @Override
    public void printInfo() {
        System.out.println("탈 것 중 오토바이 입니다.");
    }
}
