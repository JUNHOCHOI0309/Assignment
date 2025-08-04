package day0804;

import com.sun.nio.file.SensitivityWatchEventModifier;

import java.util.ArrayList;
import java.util.List;

interface BonusReceivable{
    void setBonus(double bonus);
}

abstract class Employee {
    String name;
    int baseSalary;

    public Employee(String name, int baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public abstract double calculateSalary();

    public void printSalarySlip(){
        System.out.println(name+"님의 급여는 "+baseSalary+" 입니다.");
    }
}
class FullTimeEmployee extends Employee implements BonusReceivable{
    double bonus;
    public FullTimeEmployee(String name, int baseSalary) {
        super(name, baseSalary);
        bonus = 0;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }
    @Override
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void printSalarySlip() {
        System.out.println(name+"님의 급여는 "+calculateSalary()+" 입니다.");
    }
}
class PartTimeEmployee extends Employee implements BonusReceivable{
    double bonus;
    double hourlyRate;
    public PartTimeEmployee(String name, int baseSalary, double hourlyRate) {
        super(name, baseSalary);
        this.hourlyRate = hourlyRate;
        bonus = 0;
    }
    @Override
    public double calculateSalary() {
        return baseSalary * hourlyRate + bonus;
    }
    @Override
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public void printSalarySlip() {
        System.out.println(name+"님의 급여는 "+calculateSalary()+" 입니다.");
    }
}
class Intern extends Employee{
    public Intern(String name, int baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }
}
class HRSystem{
    List<Employee> employeeList = new ArrayList<>();
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public double getSalary(){
        double total = 0;
        for (Employee emp : employeeList) {
            total += emp.calculateSalary();
        }
        return total;
    }

    public void giveBonus(double bonus){
        for(Employee employee : employeeList){
            if(employee instanceof BonusReceivable){
                ((BonusReceivable) employee).setBonus(bonus);
            }
        }
    }
    public void printSalarySlip(){
        System.out.println();
        for(Employee employee : employeeList){
            employee.printSalarySlip();
        }
    }
}
public class Salary {
    public static void main(String[] args) {
        HRSystem hrSystem = new HRSystem();
        hrSystem.addEmployee(new FullTimeEmployee("A", 10000));
        hrSystem.addEmployee(new PartTimeEmployee("B", 1000, 8));
        hrSystem.addEmployee(new Intern("C", 7000));
        System.out.println("급여 전 총 합: " + hrSystem.getSalary());

        hrSystem.giveBonus(2000);
        System.out.println("급여 전 총 합: " + hrSystem.getSalary());
        hrSystem.printSalarySlip();

    }
}
