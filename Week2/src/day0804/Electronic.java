package day0804;

import java.util.ArrayList;
import java.util.List;

interface RemoteControllable{
    void turnOn();
    void turnOff();
    void setVolume(int level);
}
abstract class ElectronicDevice{
    String brand;
    boolean power;

    public ElectronicDevice(String brand) {
        this.brand = brand;
        this.power = false;
    }

    public boolean isPower() {
        return power;
    }

    void displayInfo(){
        if(power){
            System.out.println(brand+"기기가 켜져 있습니다.");
        }else {
            System.out.println(brand+"기기가 꺼져있습니다.");
        }
    }
}

class TV extends ElectronicDevice implements RemoteControllable{
    private int volume;
    public TV(String brand){
        super(brand);
        volume = 20;
    }

    @Override
    public void turnOn() {
        power = true;
        System.out.println("TV를 킵니다.");
    }

    @Override
    public void turnOff() {
        power = false;
        System.out.println("TV를 끕니다.");
    }

    @Override
    public void setVolume(int level) {
        if(!power){
            System.out.println("전원이 꺼져있음.");
            return;
        }
        if(level < 0 || level > 100){
            System.out.println("올바른 볼륨 레벨이 아닙니다.");
            return;
        }
        volume = level;
        System.out.println("TV의 볼륨 레벨이 "+ volume +"으로 설정 되었습니다.");
    }
}
class Speaker extends ElectronicDevice implements RemoteControllable{
    private int volume;

    Speaker(String brand){
        super(brand);
        volume = 20;
    }
    @Override
    public void turnOn() {
        power = true;
        System.out.println("Speaker를 킵니다.");
    }

    @Override
    public void turnOff() {
        power = false;
        System.out.println("Speaker를 끕니다.");
    }

    @Override
    public void setVolume(int level) {
        if(!power){
            System.out.println("전원이 꺼져있음.");
            return;
        }
        if(level < 0 || level > 100){
            System.out.println("올바른 볼륨 레벨이 아닙니다.");
            return;
        }
        volume = level;
        System.out.println("Speaker의 볼륨 레벨이 "+ volume +"으로 설정 되었습니다.");

    }
}
class Refrigerator extends ElectronicDevice{
    Refrigerator(String brand){
        super(brand);
    }
    public void turnOn(){
        power = true;
        System.out.println(brand +"를 켭니다.");
    }
    public void turnOff(){
        power = false;
        System.out.println(brand+"를 끕니다.");
    }

}

public class Electronic {
    private List<ElectronicDevice> devices = new ArrayList<>();

    public void addDevice(ElectronicDevice device){
        devices.add(device);
    }

    public void turnOnAll(){
        for(ElectronicDevice device: devices){
            if(device instanceof RemoteControllable){
                ((RemoteControllable) device).turnOn();
            } else if (device instanceof Refrigerator) {
                ((Refrigerator) device).turnOn();
            }
        }
    }
    public void turnOffAll(){
        for(ElectronicDevice device: devices){
            if(device instanceof RemoteControllable){
                ((RemoteControllable) device).turnOff();
            } else if (device instanceof Refrigerator) {
                ((Refrigerator) device).turnOff();
            }
        }
    }
    public void setVolume(int level){
        for(ElectronicDevice device: devices){
            if(device instanceof RemoteControllable){
                ((RemoteControllable) device).setVolume(level);
            }
        }
    }
    public void displayInfo(){
        for(ElectronicDevice device: devices){
            device.displayInfo();
        }
    }
    public static void main(String[] args) {
        Electronic electronic = new Electronic();

        electronic.addDevice(new TV("Samsung"));
        electronic.addDevice(new Speaker("Sony"));
        electronic.addDevice(new Refrigerator("LG"));

        electronic.turnOnAll();
        electronic.setVolume(50);
        electronic.displayInfo();
        electronic.setVolume(100);

        electronic.turnOffAll();
        electronic.displayInfo();


    }
}
