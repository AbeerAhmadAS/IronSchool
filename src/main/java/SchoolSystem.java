import java.util.ArrayList;
import java.util.List;

public class SchoolSystem {

    private List<Teacher>teachers;

    private List<Course> courses;
    private List<Student> students;

    public SchoolSystem() {
        this.teachers = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }
    public void teacherRecord(Teacher teacher){
        teachers.add(teacher);
    }
    public void studentRecord(Student student){
        students.add(student);
    }
    public void courseRecord(Course course){
        courses.add(course);
    }
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public static void enrollStudent(String studentId, List<Student> studentList, String courseId, List<Course> listCourse) {
        Student student = main.lookupStudent(studentId, studentList);
        Course course = main.lookupCourse(courseId, listCourse);

        if (student != null && course != null) {
            if (student.getCourse() == null) {
                student.setCourse(course);
                System.out.println("Enrollment successful. Student " + student.getName() +
                        " has been enrolled in course " + course.getName());
                course.setMoney_earned((course.getMoney_earned()) + course.getPrice());
                double updateEarned =course.getMoney_earned();
                System.out.println("the money earn has been update  "+ updateEarned);

            } else {
                System.out.println("Enrollment failed. Student  " + student.getName() +
                        " is already enrolled in a course.");
            }
        } else {
            System.out.println("Enrollment failed. Invalid student ID or course ID.");
        }
    }

    // ASSIGN TEACHER TO COURSE METHOD
    public static void assignTeacher(String teacherId, List<Teacher> teacherList, String courseId, List<Course> listCourse) {
        Teacher teacher = main.lookupTeacher(teacherId, teacherList);
        Course course = main.lookupCourse(courseId, listCourse);

        if (course != null && teacher!= null) {
            if (course.getTeacher() == null ) {
                course.setTeacher(teacher);
                //   assert teacher != null;
                System.out.println("Assign successful. Teacher  " + teacher.getName() +
                        " has been assign to course " + course.getName());
            } else {
                System.out.println("Assign failed. Teacher  " + teacher.getName() +
                        " is already assign in a course.");
            }
        } else {
            System.out.println("Assign failed. Invalid teacher ID or course ID.");
        }
    }
    //CONNECT THE STUDENT WITH THE TEACHER TO EVALUATE PERFORMANCE
    public static void connectStudent(String teacherId, List<Teacher> teacherList, String studentId, List<Student> studentList) {
        Teacher teacher = main.lookupTeacher(teacherId, teacherList);
        Student student = main.lookupStudent(studentId, studentList);
        if (student != null && teacher!= null) {
            if (student.getTeacher() == null ) {
                student.setTeacher(teacher);
                //   assert teacher != null;
                System.out.println("connect successful. Teacher  " + teacher.getName() +
                        " has been connect with Student  " + student.getName());
            } else {
                System.out.println("connect failed. Teacher  " + teacher.getName() +
                        " is already connected with Student.");
            }
        } else {
            System.out.println("connect failed. Invalid teacher ID or Student ID.");
        }
    }
    //show profit method
    public static double showProfit(List<Course> courseList, List<Teacher> teachersList) {
        double sumMoney = 0;
        double calculaterSalary = 0;
        for (Course course : courseList) {
            sumMoney += course.getMoney_earned();
        }
        for (Teacher teacher : teachersList) {
            calculaterSalary += teacher.getSalary();
        }
        return sumMoney - calculaterSalary;
    }

}
