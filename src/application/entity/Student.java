package application.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "students")
@NamedQuery(name = "Student.getAll", query = "select s from Student s")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String fathername;

    @Column(name = "surname")
    private String surname;

    public Student() {
    }

    public Student(Long id) {
        this.id = id;
    }

    public Student(String faculty, String name, String surname) {
        this.faculty = faculty;
        this.name = name;
        this.fathername = fathername;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String patronymic) {
        this.fathername = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFullname(){
        return String.format("%s %s %s",surname,name, fathername);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", faculty='" + faculty + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + fathername + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
