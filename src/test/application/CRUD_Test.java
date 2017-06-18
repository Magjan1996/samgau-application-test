package test.application;

import application.control.ControlImpl;
import application.entity.Student;
import org.junit.Test;

public class CRUD_Test {

    private ControlImpl controlImpl = new ControlImpl(Student.class);

    public Student add(){
        Student newStudent = new Student();
        newStudent.setName("TEST_NAME");
        newStudent.setSurname("TEST_SURNAME");
        newStudent.setFathername("TEST_FATHERNAME");
        newStudent.setFaculty("TEST_FACULTY");
        Student added = controlImpl.add(newStudent);
        System.out.println("\nTEST ADD() result:\n" +added);
        return added;
    }
    public void delete(){
        Student added = add();
        controlImpl.delete(added.getId());
        System.out.println("\nTEST DELETE() Student :\n"+added);
    }
    public void update(){
        Student added = add();
        added.setName("NEW_TEST_NAME");
        added.setSurname("NEW_TEST_SURNAME");
        added.setFaculty("NEW_TEST_FACULTY");
        added.setFathername("NEW_TEST_FATHERNAME");
        Student updetedStudent = controlImpl.update(added);
        System.out.println("\nTEST UPDATE() Student :\n"+added +"\nis "+updetedStudent);
    }
    public void get(){
        Student newStudent = add();
        Student gettedStudent = controlImpl.get(newStudent.getId());
        System.out.println("\nTEST GET() Student for id:"+gettedStudent.getId()+"\n"+gettedStudent);
    }

    @Test
    public void test(){
        add();
        delete();
        update();
        get();
    }
}
