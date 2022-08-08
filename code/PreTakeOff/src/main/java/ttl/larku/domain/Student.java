package ttl.larku.domain;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author whynot
 */
public class Student {

    public enum Status{
        FULL_TIME,
        PART_TIME,
        HIBERNATING
    }

    private int id;
    private String name;
    private String phoneNumber;
    private LocalDate dob;
    private Status status;

//    public Student(int id, String name, String phoneNumber, LocalDate dob, Status status) {
//        this.id = id;
//        this.name = name;
//        this.phoneNumber = phoneNumber;
//        this.dob = dob;
//        this.status = status;
//    }

    public Student(String name, String phoneNumber, LocalDate dob, Status status) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.status = status;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dob=" + dob +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name) && Objects.equals(phoneNumber, student.phoneNumber) && Objects.equals(dob, student.dob) && status == student.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, dob, status);
    }
}
