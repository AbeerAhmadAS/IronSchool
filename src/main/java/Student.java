import java.util.UUID;

public class Student {
    private final String studentId= UUID.randomUUID().toString().substring(0,5);
    private String name;
    private String address;
    private String email;
    private Course course;

    public Student(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public String getStudentId() {
        return studentId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "\nStudent {" +
                  "studentId='" + studentId + '\'' +
                  ",name='" + name + '\'' +
                  ",address='" + address + '\'' +
                  ",email='" + email + '\'' +
                  ",course=" + course +
                  '}'+'\n';
    }
}

