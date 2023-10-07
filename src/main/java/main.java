
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
 public static void main(String[] args) {

     Scanner scanner = new Scanner(System.in);
     System.out.println("enter name for the school");
     String SchoolName = scanner.nextLine();

     teacherRecord();
     studentRecord();
     courseRecord();

 }


 public static void teacherRecord (){
     Scanner scanner = new Scanner(System.in);
     System.out.println("how many teachers do we create");
     int TeacherNum = scanner.nextInt();

     List<Teacher> teacherList = new ArrayList<Teacher>();

     for(int i =0 ; i < TeacherNum; i++)
     {
         System.out.println("enter teacher name"+ (i+1) );
         String teacherName = scanner.next();
         System.out.println("enter Salary" );
         double teacherSalary= scanner.nextDouble();
         Teacher temp = new Teacher(teacherName,teacherSalary);
         teacherList.add(temp);
     }

     System.out.println("teacher list of school\n"+ teacherList.toString()+"\n");
 }


    public static void studentRecord (){
        Scanner scanner = new Scanner(System.in);

        System.out.println("student number\n");
        int studentNum = scanner.nextInt();

        List<Student> studentList = new ArrayList<Student>();

        for(int i =0 ; i < studentNum; i++)
        {
            System.out.println("enter student name "+ (i+1) );
            String studentName = scanner.next();
            System.out.println("enter student email "+ (i+1) );
            String studentEmail = scanner.next();
            System.out.println("enter student name "+ (i+1) );
            String studentAddress = scanner.next();
            Student temp = new Student(studentName,studentAddress,studentEmail);
            studentList.add(temp);
        }
        System.out.println("Student list of school\n"+ studentList.toString()+"\n");
    }

    public static void courseRecord(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("courses number \n");
        int courseNum = scanner.nextInt();

        List<Course> courseList = new ArrayList<Course>();

        for(int i =0 ; i < courseNum; i++)
        {
            System.out.println("enter course name "+ (i+1) );
            String courseName = scanner.next();
            System.out.println("enter price" );
            double coursePrice= scanner.nextDouble();
            Course temp = new Course(courseName,coursePrice);
            courseList.add(temp);
        }
        System.out.println("courses list of school\n"+ courseList.toString()+"\n");


    }

    }
