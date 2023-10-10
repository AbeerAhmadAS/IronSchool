
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

public class MyTest  {
private main st;
/*
     Teacher t1 = new Teacher("ali",200);
     Teacher t2 = new Teacher("ahmed",300);
     Student s1= new Student("mohammed","Makkah","moh@mail.com");
     Student s2= new Student("sara","Riyadh","sara@mail.com");
     Course c1= new Course("programming",50);
     Course c2= new Course("language",70);

     List<Teacher> teacherTest = new ArrayList<Teacher>( ){{add(t1);add(t2);} };
     List<Student> studentTest = new ArrayList<Student>( ){{add(s1);add(s2);}} ;
     List<Course> courseTest = new ArrayList<Course>( ){{add(c1);add(c2);}} ;

     */

    @BeforeEach
    public void setup()
    {st  = new main();}

        @Test
        public void testEnrollStudentValidIds() {
            Course c1= new Course("programming",50);
            Student s1= new Student("mohammed","Makkah","moh@mail.com");
            st.g.add(c1);
            st.getStudents().add(s1);

            st.enrollStudent(s1.getStudentId(), c1.getCourseId());

            assertEquals(c1, s1.getCourse());
            assertEquals(100.0, c1.getMoney_earned(), 0.0);
        }

        @Test
        public void testEnrollStudentInvalidIds() {
            Student student = new Student("John Doe", "123 Main St", "john@example.com");
            st.getStudents().add(student);

            System.setOut(new PrintStream(outputStream));
            sms.enrollStudent("1234", "5678");
            String output = outputStream.toString().trim();
            System.setOut(System.out);

            assertNull(student.getCourse());
            assertEquals("Invalid student ID or course ID.", output);
        }

        @Test
        public void testAssignTeacherValidIds() {
            Course course = new Course("Math", 100.0);
            Teacher teacher = new Teacher("Jane Smith", 5000.0);
            sms.getCourses().add(course);
            sms.getTeachers().add(teacher);

            sms.assignTeacher(teacher.getTeacherId(), course.getCourseId());

            assertEquals(teacher, course.getTeacher());
        }

        @Test
        public void testAssignTeacherInvalidIds() {
            Teacher teacher = new Teacher("Jane Smith", 5000.0);
            sms.getTeachers().add(teacher);

            System.setOut(new PrintStream(outputStream));
            sms.assignTeacher("1234", "5678");
            String output = outputStream.toString().trim();
            System.setOut(System.out);

            assertNull(course.getTeacher());
            assertEquals("Invalid teacher ID or course ID.", output);
        }
    }
/*

@Test
    public void testMoneyUpdate() {
  //  Student s2= new Student("sara","Riyadh","sara@mail.com");
  //  Course c1= new Course("programming",50);


        assertEquals(50.0, c1.getMoney_earned());
    }

    public void testEnrollStudentValidIds() {

        assertEquals(c1,s1.getCourse());

    }





    public void testAssignTeacher() {
    }
}

/*
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SchoolManagementSystemTest {
    private SchoolManagementSystem sms;

    @Before
    public void setUp() {
        sms = new SchoolManagementSystem();
    }

    @Test
    public void testEnrollStudentValidIds() {
        Course course = new Course("Math", 100.0);
        Student student = new Student("John Doe", "123 Main St", "john@example.com");
        sms.getCourses().add(course);
        sms.getStudents().add(student);

        sms.enrollStudent(student.getStudentId(), course.getCourseId());

        assertEquals(course, student.getCourse());
        assertEquals(100.0, course.getMoneyEarned(), 0.0);
    }
/*
    @Test
    public void testEnrollStudentInvalidIds() {
        Student student = new Student("John Doe", "123 Main St", "john@example.com");
        sms.getStudents().add(student);

        System.setOut(new PrintStream(outputStream));
        sms.enrollStudent("1234", "5678");
        String output = outputStream.toString().trim();
        System.setOut(System.out);

        assertNull(student.getCourse());
        assertEquals("Invalid student ID or course ID.", output);
    }

    @Test
    public void testAssignTeacherValidIds() {
        Course course = new Course("Math", 100.0);
        Teacher teacher = new Teacher("Jane Smith", 5000.0);
        sms.getCourses().add(course);
        sms.getTeachers().add(teacher);

        sms.assignTeacher(teacher.getTeacherId(), course.getCourseId());

        assertEquals(teacher, course.getTeacher());
    }

    @Test
    public void testAssignTeacherInvalidIds() {
        Teacher teacher = new Teacher("Jane Smith", 5000.0);
        sms.getTeachers().add(teacher);

        System.setOut(new PrintStream(outputStream));
        sms.assignTeacher("1234", "5678");
        String output = outputStream.toString().trim();
        System.setOut(System.out);

        assertNull(course.getTeacher());
        assertEquals("Invalid teacher ID or course ID.", output);
    }
}
 */