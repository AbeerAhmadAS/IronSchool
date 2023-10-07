import java.util.UUID;

import static java.util.UUID.randomUUID;

public class Teacher {
    private String teacherId= UUID.randomUUID().toString();
    private  String name;
    private double salary;


    public Teacher(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getTeacherId() {
        return teacherId;
    }

  /*  public void setTeacherId() {
        this.teacherId = teacherId;
    }
*/


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
