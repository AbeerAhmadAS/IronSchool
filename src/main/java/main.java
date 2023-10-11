import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        System.out.println("********************** Welcome to School System!! **********************");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name for the school");
        String SchoolName = scanner.nextLine();

        while (!SchoolName.matches("[A-Za-z\\s]+") || SchoolName.length() <= 3) {
            System.out.println("Please enter valid name");
            System.out.println("Enter name for the school");
            SchoolName = scanner.next();
        }

        List<Teacher> teacherList = teacherRecord();
        List<Student> studentList = studentRecord();
        List<Course> courseList = courseRecord();

        boolean check = true;
        while (check) {

            //start the commands
            System.out.println( """
                                 Enter number of commend:
                                 1- ENROLL
                                 2- ASSIGN
                                 3- SHOW COURSES
                                 4- LOOKUP COURSE
                                 5- SHOW STUDENTS
                                 6- LOOKUP STUDENTS
                                 7- SHOW Teachers
                                 8- LOOKUP Teachers
                                 9- SHOW PROFIT
                                 10-Connect
                                 11- Exit""");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    //ENROLL STUDENT TO COURSE
                    System.out.println("Enter Student ID: ");
                    System.out.println(studentList.toString());
                    String student_id_enroll = scanner.next();
                    System.out.println("Enter Course ID: ");
                    System.out.println(courseList.toString());
                    String course_id_enroll = scanner.next();
                    SchoolSystem.enrollStudent(student_id_enroll, studentList, course_id_enroll, courseList);
                    break;

                case 2:
                    //ASSIGN TEACHER TO THE COURSE
                    System.out.println("Enter Teacher ID: ");
                    System.out.println(teacherList.toString());
                    String teacher_id_assign = scanner.next();
                    System.out.println("Enter Course ID: ");
                    System.out.println(courseList.toString());
                    String course_id_assign = scanner.next();
                    SchoolSystem.assignTeacher(teacher_id_assign, teacherList, course_id_assign, courseList);
                    break;

                case 3:
                    //SHOW COURSE
                    showCourse(courseList);
                    break;

                case 4:
                    //LOOKUP THE COURSE
                    System.out.println("Enter Course ID: ");
                    System.out.println(courseList.toString());
                    String course_id = scanner.next();
                    System.out.println(lookupCourse(course_id, courseList));
                    break;

                case 5:
                    //SHOW STUDENT
                    showStudent(studentList);
                    break;

                case 6:
                    //LOOKUP THE STUDENT
                    System.out.println("Enter student ID: ");
                    System.out.println(studentList.toString());
                    String student_id = scanner.next();
                    System.out.println(lookupStudent(student_id, studentList));
                    break;

                case 7:
                    //SHOW TEACHER
                    showTeacher(teacherList);
                    break;

                case 8:
                    //LOOKUP TEACHER
                    System.out.println("Enter Teacher ID: ");
                    System.out.println(teacherList.toString());
                    String teacher_id = scanner.next();
                    System.out.println(lookupTeacher(teacher_id, teacherList));
                    break;

                case 9:
                    //SHOW THE PROFIT
                    System.out.println(SchoolSystem.showProfit(courseList, teacherList));
                    break;
                case 10:
                    //CONNECT THE STUDENT WITH THE TEACHER TO EVALUATE PERFORMANCE
                    System.out.println("Enter Student ID: ");
                    System.out.println(studentList.toString());
                    String student_id_connect = scanner.next();
                    System.out.println("Enter Teacher ID: ");
                    System.out.println(teacherList.toString());
                    String teacher_id_connect = scanner.next();
                    SchoolSystem.connectStudent( teacher_id_connect, teacherList, student_id_connect, studentList);
                    break;
                case 11 :
                    //EXIT THE SYSTEM
                    System.out.println("********************** THE END! Thank you for using our System **********************");
                    System.out.println("********************** Regards, Abeer, Hadeel, Amal, Jawaher, Jehan ********************** ");
                    check=false;
                    System.exit(0);
                    break;

                default:
                    System.out.println("Unexpected value! Enter Number between 1-10: " + choice + "\n");
            }
        }
    }

    // method to create teacher records
    public static List<Teacher> teacherRecord() {
        Scanner scanner = new Scanner(System.in);
        int teacherNum= 0;
        double teacherSalary = 0 ;
        boolean checkInput = true;
        while (checkInput){
            System.out.println("How many teachers in your School ? ");
            String teacherNumber = scanner.next();
            try {
                teacherNum = Integer.parseInt(teacherNumber);
            }catch (NumberFormatException e){}

            if (teacherNum < 0 ){
                System.out.println("The number must be positive");
            } else if (teacherNum >= 0) {
                checkInput = false;
            } else {
                System.out.println("Invalid input! Try again");
            }
        }
        checkInput = true;

        List<Teacher> teacherList = new ArrayList<Teacher>();

        for (int i = 0; i < teacherNum; i++) {
            System.out.println("Enter name of teacher " + (i + 1));
            String teacherName = scanner.next();
            while (!teacherName.matches("[A-Za-z\\s]+") || teacherName.length() <= 3) {
                System.out.println("Please enter valid name");
                System.out.println("Enter name of teacher " + (i + 1));
                teacherName = scanner.next();
            }

            while (checkInput){
                System.out.println("Enter Salary of the teacher:  ");
                String inputTeacherSalary = scanner.next();
                try {
                    teacherSalary = Double.parseDouble(inputTeacherSalary);
                }catch (NumberFormatException e){}

                if (teacherSalary < 0 ){
                    System.out.println("The salary must be positive");
                } else if (teacherSalary > 0) {
                    checkInput = false;
                } else {
                    System.out.println("Invalid input! Try again");
                }
            }

            Teacher temp = new Teacher(teacherName, teacherSalary);
            teacherList.add(temp);
            checkInput = true;
        }
        showTeacher(teacherList);
        return teacherList;
    }

    // method to create student records
    public static List<Student> studentRecord() {
        Scanner scanner = new Scanner(System.in);
        int studentNum= 0;
        boolean checkInput = true;
        while (checkInput){
            System.out.println("How many students in your School ? ");
            String studentNumber = scanner.next();
            try {
                studentNum = Integer.parseInt(studentNumber);
            }catch (NumberFormatException e){}

            if (studentNum < 0 ){
                System.out.println("The number must be positive");
            } else if (studentNum >= 0) {
                checkInput = false;
            } else {
                System.out.println("Invalid input! Try again");
            }
        }
        List<Student> studentList = new ArrayList<Student>();

        for (int i = 0; i < studentNum; i++) {
            System.out.println("Enter the name of Student " + (i + 1));
            String studentName = scanner.next();
            while (!studentName.matches("[A-Za-z\\s]+") || studentName.length() <= 3) {
                System.out.println("Please enter valid name");
                System.out.println("Enter name of Student " + (i + 1));
                studentName = scanner.next();
            }

            System.out.println("Enter Email of Student " + (i + 1));
            String studentEmail = scanner.next();
            while (!studentEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
                System.out.println("Invalid email ! Try again");
                System.out.println("Enter Email of Student " + (i + 1));
                studentEmail = scanner.next();
            }
            System.out.println("Enter the address of Student " + (i + 1));
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
        int courseNum= 0;
        double coursePrice = 0;
        boolean checkInput = true;
        while (checkInput){
            System.out.println("How many courses in your School ? ");
            String courseNumber = scanner.next();
            try {
                courseNum = Integer.parseInt(courseNumber);
            }catch (NumberFormatException e){}

            if (courseNum < 0 ){
                System.out.println("The number must be positive");
            } else if (courseNum >= 0) {
                checkInput = false;
            } else {
                System.out.println("Invalid input");
            }
        }
        checkInput = true;

        List<Course> courseList = new ArrayList<Course>();

        for (int i = 0; i < courseNum; i++) {
            System.out.println("Enter the name of Course " + (i + 1));
            String courseName = scanner.next();

            while (!courseName.matches("[A-Za-z\\s]+") || courseName.length() < 3) {
                System.out.println("Please enter valid name");
                System.out.println("Enter the name of Course " + (i + 1));
                courseName = scanner.next();
            }

            while (checkInput){
                System.out.println("Enter the price of Course " + (i + 1));
                String inputCoursePrice = scanner.next();
                try {
                    coursePrice = Double.parseDouble(inputCoursePrice);
                }catch (NumberFormatException e){}

                if (coursePrice < 0 ){
                    System.out.println("The price must be positive");
                } else if (coursePrice > 0) {
                    checkInput = false;
                } else {
                    System.out.println("Invalid input");
                }
            }

            Course temp = new Course(courseName, coursePrice);
            courseList.add(temp);
            checkInput = true;
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
        System.out.println("The Teacher is not found!!");
        return null; // teacher not found
    }

    //LOOKUP STUDENT method
    public static Student lookupStudent(String id, List<Student> studentList) {
        for (Student student : studentList) {
            if (student.getStudentId().equals(id)) {
                return student;
            }
        }
        System.out.println("The Student is not found!!");
        return null; // Student not found
    }

    //LOOKUP COURSE method
    public static Course lookupCourse(String id, List<Course> courseList) {
        for (Course course : courseList) {
            if (course.getCourseId().equals(id)) {
                return course;
            }
        }
        System.out.println("The Course is not found!!");
        return null; // course not found
    }


    // SHOW TEACHER method
    public static void showTeacher(List<Teacher> teacherList) {
        System.out.println("Teachers list of school\n" + teacherList.toString() + "\n");
    }

    // SHOW STUDENT method
    public static void showStudent(List<Student> studentList) {
        System.out.println("Students list of school\n" + studentList.toString() + "\n");
    }

    //SHOW COURSES method
    public static void showCourse(List<Course> courseList) {
        System.out.println("Courses list of school\n" + courseList.toString() + "\n");
    }
}