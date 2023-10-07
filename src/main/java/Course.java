import java.util.UUID;

public class Course {
    private  String courseId= UUID.randomUUID().toString();
    private String name;
    private double price;
    private double money_earned;
    private Teacher teacher;

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getCourseId() {
        return courseId;
    }

   /* public void setCourseId() {
        this.courseId = UUID.randomUUID().toString();
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMoney_earned() {
        return money_earned;
    }

    public void setMoney_earned(double money_earned) {
        this.money_earned = money_earned;
    }

    public Teacher getTeacher() {
        return teacher;
    }


    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", teacher=" + teacher +
                '}';
    }

}

