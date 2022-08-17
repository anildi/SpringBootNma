package ttl.larku.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ttl.larku.domain.Student;

import java.util.List;

/**
 * @author whynot
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public List<Student> findByName(String name);
    public List<Student> findByNameContainingIgnoreCase(String name);
}
