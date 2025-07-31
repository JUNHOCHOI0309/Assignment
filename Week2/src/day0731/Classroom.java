package day0731;

public class Classroom {//과제 9
    Student[] students;

    public Classroom(Student[] students){
        this.students = students;
    }

    public void printStudents(){
        System.out.print("학생 목록:");
        for(Student s : students){
            System.out.print(s.name + ",");
        }
    }

    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("민수");
        students[1] = new Student("지영");
        students[2] = new Student("철수");

        Classroom c = new Classroom(students);
        c.printStudents();
    }
}
