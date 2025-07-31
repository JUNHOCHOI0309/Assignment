package day0731;

public class Student {// 과제 7
    public String name;
    private int score;

    public Student(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static void main(String[] args) {
        Student s = new Student("민수");
        s.setScore(90);

        System.out.println("이름: "+ s.name + ", 점수: " + s.getScore());
    }
}
