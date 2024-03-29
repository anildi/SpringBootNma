package ttl.larku.dao;

import java.util.ResourceBundle;

import ttl.larku.dao.inmemory.InMemoryStudentDAO;
import ttl.larku.dao.inmemory.StudentDAO;
import ttl.larku.dao.jpa.JpaStudentDAO;

public class DaoFactory {

	public static StudentDAO studentDAO() {
		ResourceBundle bundle = ResourceBundle.getBundle("larkUContext");
		String profile = bundle.getString("larku.profile.active");
		switch (profile) {
		case "dev":
			return new InMemoryStudentDAO();
		case "prod":
			return new JpaStudentDAO();
		default:
			throw new RuntimeException("Unknown profile: " + profile);
		}
	}

}
