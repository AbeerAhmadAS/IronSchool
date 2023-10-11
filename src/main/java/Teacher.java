import java.util.UUID;

import static java.util.UUID.randomUUID;

public class Teacher {

    private final String teacherId= UUID.randomUUID().toString().substring(0,5);
    private  String name;
    private double salary;


    public Teacher(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getTeacherId() {
        return teacherId;
    }


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
        return "\n Teacher {" +
                  "teacherId='" + teacherId + '\'' +
                  ",name='" + name + '\'' +
                  ",salary=" + salary +
                  '}'+'\n';
    }
}
