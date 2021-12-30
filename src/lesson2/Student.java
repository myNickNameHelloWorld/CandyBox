package lesson2;

public class Student implements Comparable<Student>{
    private String name;
    private String surname;
    private int age;
    private int courseNumber;

    public Student(String name, String surname, int age, int courseNumber) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.courseNumber = courseNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", courseNumber=" + courseNumber +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.age, o.age);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public int getCourseNumber() {
        return courseNumber;
    }
}
