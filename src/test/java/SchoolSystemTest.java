import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SchoolSystemTest {
    private static SchoolSystem schoolSystem;
    private static List<Teacher> teacherList;
    private static List<Student> studentList;
    private static List<Course> courseList;

    @BeforeAll
    static void init() {
        Teacher t1 = new Teacher("ali", 200);
        Teacher t2 = new Teacher("ahmed", 300);
        Student s1 = new Student("mohammed", "Makkah", "moh@mail.com");
        Student s2 = new Student("sara", "Riyadh", "sara@mail.com");
        Course c1 = new Course("programming", 50);
        Course c2 = new Course("language", 70);
        List<Teacher> teacherTest = new ArrayList<Teacher>() {
            {
                add(t1);
                add(t2);
            } };
        List<Student> studentTest = new ArrayList<Student>() {{
            add(s1);
            add(s2);
        }};
        List<Course> courseTest = new ArrayList<Course>() {{
            add(c1);
            add(c2);
        }};

        schoolSystem = new SchoolSystem();
    }

    @Test
    void testShowProfit() {
        Teacher t1 = new Teacher("ali", 200);
        Teacher t2 = new Teacher("ahmed", 300);
        Course c1 = new Course("programming", 50);
        Course c2 = new Course("language", 70);
        List<Teacher> teacherTest = new ArrayList<Teacher>() {
            {
                add(t1);
                add(t2);
            } };
        List<Course> courseTest = new ArrayList<Course>() {{
            add(c1);
            add(c2);
        }};

        double profit = schoolSystem.showProfit(courseTest, teacherTest);
        assertEquals(-500.0, profit);
    }

    @Test
    void testEnrollStudent() {
        Student s1 = new Student("mohammed", "Makkah", "moh@mail.com");
        Course c1 = new Course("programming", 50);
        List<Student> studentTest = new ArrayList<Student>() {{
            add(s1);
        }};
        List<Course> courseTest = new ArrayList<Course>() {{
            add(c1);
        }};


        schoolSystem.enrollStudent(s1.getStudentId(), studentTest, c1.getCourseId(), courseTest);
        assertEquals(courseTest.get(0), studentTest.get(0).getCourse());
    }

    @Test
    void testAssignTeacher() {
        Teacher t1 = new Teacher("ali", 200);
        List<Teacher> teacherTest = new ArrayList<Teacher>() {
            {
                add(t1);
            } };

        Course c1 = new Course("programming", 50);
        List<Course> courseTest = new ArrayList<Course>() {{
            add(c1);
        }};
        schoolSystem.assignTeacher(t1.getTeacherId(), teacherTest, c1.getCourseId(), courseTest);
        assertEquals(teacherTest.get(0), courseTest.get(0).getTeacher());
    }

    @Test
    void connectTest() {

        Teacher t1 = new Teacher("omar", 200);
        List<Teacher> teacherTest = new ArrayList<Teacher>() {
            {
                add(t1);
            } };


        Student s1 = new Student("Ahmad", "KSA","Ahmad@gmai.com");
        List<Student> studentTest = new ArrayList<Student>() {{
            add(s1);
        }};

        schoolSystem.connectStudent( t1.getTeacherId(), teacherTest, s1.getStudentId(), studentTest );
        assertEquals(teacherTest.get(0), studentTest.get(0).getTeacher());
    }
}