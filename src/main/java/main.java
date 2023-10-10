
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter name for the school");
        String SchoolName = scanner.nextLine();

        List<Teacher> teacherList = teacherRecord();
        List<Student> studentList = studentRecord();
        List<Course> courseList = courseRecord();
        Scanner commandType = new Scanner(System.in);
        boolean check = true;
        while (check) {


            System.out.print("""Enter number of commend:\n "
                                 1- ENROLL
                                 2- ASSIGN
                                 3-  SHOW COURSES
                                 4- LOOKUP COURSE
                                 5- SHOW STUDENTS
                                 6- LOOKUP STUDENTS
                                 7- SHOW Teachers
                                 8- LOOKUP Teachers
                                 9- SHOW PROFIT
                                 10- Exit""");

            int choice = commandType.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Student ID");
                    System.out.println(studentList.toString());
                    String student_id_enroll = scanner.next();
                    System.out.println("Enter Course ID");
                    System.out.println(courseList.toString());
                    String course_id_enroll = scanner.next();

                    enrollStudent(student_id_enroll, studentList, course_id_enroll, courseList);
                    break;

                case 2:
                    System.out.println("Enter Teacher ID");
                    System.out.println(teacherList.toString());
                    String teacher_id_assign = scanner.next();
                    System.out.println(courseList.toString());
                    System.out.println("Enter Course ID");

                    String course_id_assign = scanner.next();
                    assignTeacher(teacher_id_assign, teacherList, course_id_assign, courseList);
                    break;

                case 3:

                    showCourse(courseList);
                    break;

                case 4:

                    System.out.println("Enter Course ID");
                    String course_id = scanner.next();
                    lookupCourse(course_id, courseList);

                case 5:
                    showStudent(studentList);
                    break;

                case 6:
                    System.out.println("Enter student ID");
                    String student_id = scanner.next();
                    lookupStudent(student_id, studentList);
                    break;

                case 7:
                    showTeacher(teacherList);
                    break;

                case 8:
                    System.out.println("Enter Teacher ID");
                    String teacher_id = scanner.next();
                    lookupTeacher(teacher_id, teacherList);
                    break;

                case 9:
                    showProfit(courseList, teacherList);
                    break;
                case 10 :
                    System.exit(0);
                    check=false;
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
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


    // method to create teacher records
    public static List<Teacher> teacherRecord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("how many teachers do we create");
        int TeacherNum = scanner.nextInt();

        List<Teacher> teacherList = new ArrayList<Teacher>();

        for (int i = 0; i < TeacherNum; i++) {
            System.out.println("enter teacher name" + (i + 1));
            String teacherName = scanner.next();
            System.out.println("enter Salary");
            double teacherSalary = scanner.nextDouble();
            Teacher temp = new Teacher(teacherName, teacherSalary);
            teacherList.add(temp);
        }
        showTeacher(teacherList);
        return teacherList;
    }

    // method to create student records
    public static List<Student> studentRecord() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("student number\n");
        int studentNum = scanner.nextInt();

        List<Student> studentList = new ArrayList<Student>();

        for (int i = 0; i < studentNum; i++) {
            System.out.println("enter student name " + (i + 1));
            String studentName = scanner.next();
            System.out.println("enter student email " + (i + 1));
            String studentEmail = scanner.next();
            System.out.println("enter student address " + (i + 1));
            String studentAddress = scanner.next();
            Student temp = new Student(studentName, studentAddress, studentEmail);
            studentList.add(temp);
        }
        showStudent(studentList);
        return studentList;
    }

    // method to create course records
    public static List<Course> courseRecord() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("course number\n");
        int courseNum = scanner.nextInt();

        List<Course> courseList = new ArrayList<Course>();

        for (int i = 0; i < courseNum; i++) {
            System.out.println("enter course name " + (i + 1));
            String courseName = scanner.next();
            System.out.println("enter course price " + (i + 1));
            double coursePrice = scanner.nextDouble();

            Course temp = new Course(courseName, coursePrice);
            courseList.add(temp);
        }
        showCourse(courseList);
        return courseList;
    }

    //LOOKUP TEACHER method
    public static Teacher lookupTeacher(String id, List<Teacher> teacherList) {
        for (Teacher teacher : teacherList) {
            if (teacher.getTeacherId().equals(id)) {
                return teacher;
            }
        }
        System.out.println("teacher not found!!");
        return null; // teacher not found
    }

    //LOOKUP STUDENT method
    public static Student lookupStudent(String id, List<Student> studentList) {
        for (Student student : studentList) {
            if (student.getStudentId().equals(id)) {
                return student;
            }
        }
        System.out.println("student not found!!");
        return null; // Student not found
    }

    //LOOKUP COURSE method
    public static Course lookupCourse(String id, List<Course> courseList) {
        for (Course course : courseList) {
            if (course.getCourseId().equals(id)) {
                return course;
            }
        }
        System.out.println("course not found!!");
        return null; // course not found
    }


    // SHOW TEACHER method
    public static void showTeacher(List<Teacher> teacherList) {
        System.out.println("teacher list of school\n" + teacherList.toString() + "\n");
    }

    // SHOW STUDENT method
    public static void showStudent(List<Student> studentList) {
        System.out.println("Student list of school\n" + studentList.toString() + "\n");
    }

    //SHOW COURSES method
    public static void showCourse(List<Course> courseList) {
        System.out.println("courses list of school\n" + courseList.toString() + "\n");
    }

    public static void enrollStudent(String studentId, List<Student> studentList, String courseId, List<Course> listCourse) {
        Student student = lookupStudent(studentId, studentList);
        Course course = lookupCourse(courseId, listCourse);

        if (student != null && course != null) {
            if (student.getCourse() == null) {
                student.setCourse(course);
                System.out.println("Enrollment successful. Student " + student.getName() +
                        " has been enrolled in course " + course.getName());
                course.setMoney_earned((course.getMoney_earned()) + course.getPrice());
                System.out.println("the money earn has been update");
            } else {
                System.out.println("Enrollment failed. Student " + student.getName() +
                        " is already enrolled in a course.");
            }
        } else {
            System.out.println("Enrollment failed. Invalid student ID or course ID.");
        }
    }


    public static void assignTeacher(String teacherId, List<Teacher> teacherList, String courseId, List<Course> listCourse) {
        Teacher teacher = lookupTeacher(teacherId, teacherList);
        Course course = lookupCourse(courseId, listCourse);

        if (course != null && teacher!= null) {
            if (course.getTeacher() == null ) {
                course.setTeacher(teacher);
                //   assert teacher != null;
                System.out.println("Assign successful. Teacher " + teacher.getName() +
                        " has been assign to course " + course.getName());
            } else {
                System.out.println("Assign failed. Teacher " + teacher.getName() +
                        " is already assign in a course.");
            }
        } else {
            System.out.println("Assign failed. Invalid teacher ID or course ID.");
        }
    }

}