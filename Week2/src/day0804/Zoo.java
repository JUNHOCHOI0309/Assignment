package day0804;

import java.util.*;

interface Walkable{
    void walk();
}
interface Swimmable{
    void swim();
}

abstract class Animal{
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public abstract void makeSound();

    public void eat(){
        System.out.println("먹이를 먹는다.");
    }
}

class Lion extends Animal implements Walkable{
    public Lion(String name, int age) {
        super(name, age);
    }
    @Override
    public void walk() {
        System.out.println(name+"은 걸을 수 있습니다.");
    }
    @Override
    public void makeSound() {
        System.out.println(name+ "하고 웁니다.");
    }
}
class Penguin extends Animal implements Walkable,Swimmable{
    public Penguin(String name, int age) {
        super(name, age);
    }

    @Override
    public void walk() {
        System.out.println(name+"은 걸을 수 있습니다.");
    }

    @Override
    public void swim() {
        System.out.println(name+ "은 수영할 수 있습니다.");
    }
    @Override
    public void makeSound() {
        System.out.println(name+ "하고 웁니다.");
    }
}
class Dolphin extends Animal implements Swimmable{
    public Dolphin(String name, int age) {
        super(name, age);
    }
    @Override
    public void swim() {
        System.out.println(name+"은 수영할 수 있습니다.");
    }
    @Override
    public void makeSound() {
        System.out.println(name+ "하고 웁니다.");
    }
}

class Zookeeper {
    List<Animal> animalList = new ArrayList<>();

    public void addAnimal(Animal animal){
        animalList.add(animal);
    }
    public void printAnimals(){
        for(Animal animal : animalList){
            System.out.println(animal.getName());
        }
    }
    public void makeSound(){
        for(Animal animal : animalList){
            animal.makeSound();
        }
    }
    public void walkALL(){
        for(Animal animal : animalList){
            if(animal instanceof Walkable){
                ((Walkable)animal).walk();
            }
        }
    }
    public void swimALL() {
        for (Animal animal : animalList) {
            if (animal instanceof Swimmable) {
                ((Swimmable) animal).swim();
            }
        }
    }
}

public class Zoo {
    public static void main(String[] args) {
        Zookeeper zookeeper = new Zookeeper();

        zookeeper.addAnimal(new Lion("Animal A", 5));
        zookeeper.addAnimal(new Penguin("Animal B", 6));
        zookeeper.addAnimal(new Dolphin("Animal C", 7));

        zookeeper.printAnimals();
        zookeeper.makeSound();

        zookeeper.walkALL();
        zookeeper.swimALL();
    }
}
