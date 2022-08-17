package ttl.larku.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentRepoService;
import ttl.larku.service.StudentService;

import java.net.URI;
import java.util.List;

/**
 * @author whynot
 * REST - Representational State Transfer
 */
@RestController
@RequestMapping("/repostudent")
public class StudentRepoController {

    private StudentRepoService studentService;
    private UriCreator uriCreator;

    public StudentRepoController(StudentRepoService studentService, UriCreator uriCreator) {
        this.studentService = studentService;
        this.uriCreator = uriCreator;
    }

//    @GetMapping
//    public String getAll() {
//        List<Student> students = studentService.getAllStudents();
//        return "allStudents";
//    }

    @GetMapping
    public List<Student> getAll() {
        List<Student> students = studentService.getAllStudents();
        return students;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") int id) {
        Student s = studentService.getStudent(id);
        if(s == null) {
            return ResponseEntity.status(404).body("No student with id: " + id);
        }
        return ResponseEntity.ok(s);
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        Student newStudent = studentService.createStudent(student);

        //http://localhost:8080/student/newStudent.getId()
//        URI newResource = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(newStudent.getId())
//                .toUri();
        URI newResource = uriCreator.createUri(newStudent.getId());

        //return ResponseEntity.created(newResource).body(newStudent);
        return ResponseEntity.created(newResource).build();
    }

    @PostMapping("/many")
    public ResponseEntity<?> addManyStudents(@RequestBody List<Student> students) {
        for(Student student : students) {
            Student newStudent = studentService.createStudent(student);

            //http://localhost:8080/student/newStudent.getId()
//        URI newResource = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(newStudent.getId())
//                .toUri();
//            URI newResource = uriCreator.createUri(newStudent.getId());

            //return ResponseEntity.created(newResource).body(newStudent);
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) {
        boolean result = studentService.deleteStudent(id);
        if(!result) {
            return ResponseEntity.status(404).body("No student with id: " + id);
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        boolean result = studentService.updateStudent(student);
        if(!result) {
            return ResponseEntity.status(404).body("No student with id: " + student.getId());
        }
        return ResponseEntity.noContent().build();
    }
}
