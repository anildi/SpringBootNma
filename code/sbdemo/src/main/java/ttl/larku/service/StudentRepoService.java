/*
Copyright 2019-2022 Anil Pal
All rights reserved by The Third Lane, LLC.
*/

package ttl.larku.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ttl.larku.dao.BaseDAO;
import ttl.larku.dao.repo.StudentRepository;
import ttl.larku.domain.Student;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class StudentRepoService {

    @Autowired
    private StudentRepository studentDAO;

    public StudentRepoService() {
    }

    public Student createStudent(String name, String phoneNumber, Student.Status status) {
        Student student = new Student(name, phoneNumber, status);
        student = createStudent(student);

        return student;
    }

    public Student createStudent(String name, String phoneNumber, LocalDate dob, Student.Status status) {
        Student student = new Student(name, phoneNumber, dob, status);
        student = createStudent(student);

        return student;
    }

    public Student createStudent(Student student) {
        student = studentDAO.save(student);

        return student;
    }

    public boolean deleteStudent(int id) {
        Student student = studentDAO.findById(id).orElse(null);
        if (student != null) {
            studentDAO.delete(student);
            return true;
        }
        return false;
    }

    public boolean updateStudent(Student newStudent) {
        Student oldStudent = studentDAO.findById(newStudent.getId()).orElse(null);
        if(oldStudent != null) {
            studentDAO.save(newStudent);
            return true;
        }
        return false;
    }

    public Student getStudent(int id) {
        return studentDAO.findById(id).orElse(null);
    }

    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }

//    public BaseDAO<Student> getStudentDAO() {
//        return studentDAO;
//    }
//
//    public void setStudentDAO(BaseDAO<Student> studentDAO) {
//        this.studentDAO = studentDAO;
//    }
//
//    public void clear() {
//        studentDAO.deleteStore();
//        studentDAO.createStore();
//    }

}
