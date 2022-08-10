package ttl.larku.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ttl.larku.domain.Course;
import ttl.larku.domain.Student;
import ttl.larku.jconfig.LarkUConfig;
import ttl.larku.service.CourseService;
import ttl.larku.service.StudentService;

public class SpringDemo {
	
	public static void main(String [] arg) {
		SpringDemo sd = new SpringDemo();
//		sd.go();
		sd.goCourse();
	}
	
	public void go() {
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(LarkUConfig.class);
		
		StudentService ss = context.getBean("studentService", StudentService.class);
		
		List<Student> students = ss.getAllStudents();
		System.out.println("student: " + students.size());
		System.out.println(students);
	}
	
	public void goCourse() {
		ApplicationContext context = new AnnotationConfigApplicationContext(LarkUConfig.class);

		CourseService ss = context.getBean("courseService", CourseService.class);
		
		List<Course> courses = ss.getAllCourses();
		System.out.println("student: " + courses.size());
		System.out.println(courses);
		
	}

}
