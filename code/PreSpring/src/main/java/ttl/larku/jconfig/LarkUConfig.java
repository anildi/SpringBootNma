/*
Copyright 2019-2022 Anil Pal
All rights reserved by The Third Lane, LLC.
*/

package ttl.larku.jconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ttl.larku.dao.BaseDAO;
import ttl.larku.dao.inmemory.InMemoryStudentDAO;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

@Configuration
@ComponentScan(basePackages = {"ttl.larku.service", "ttl.larku.dao"})
public class LarkUConfig {

/*
	<bean id="inMemoryStudentDAO"
		class="ttl.larku.dao.inmemory.InMemoryStudentDAO" />
		*/
	
	@Bean
	public BaseDAO<Student> studentDAO() {
		BaseDAO<Student> dao = new InMemoryStudentDAO();
		return dao;
	}

	/*
	<bean id="studentService" class="ttl.larku.service.StudentServie" >
		<property name="studentDAO" ref="inMemoryStudentDAO" />
	</bean>
	*/
	@Bean
	public StudentService studentService() {
		StudentService ss = new StudentService();
		
		BaseDAO<Student> dao = studentDAO();
		
		ss.setStudentDAO(dao);
		
		return ss;
	}
}