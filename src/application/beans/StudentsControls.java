package application.beans;

import application.control.ControlImpl;
import application.entity.Student;
import javax.ejb.EJB;
import javax.faces.bean.*;
import java.util.List;


@ManagedBean
@SessionScoped
public class StudentsControls {

    @EJB
    public ControlImpl controlImpl;

    /**
     * Instance of a class {@link AddStudentController
     */
    public AddStudentController addStudentController = new AddStudentController();

    /**
     * Instance of a class {@link DeleteStudents
     */
    public DeleteStudents deleteStudents = new DeleteStudents();

    /**
     * Instance of a class {@link GetStudentsController
     */
    public GetStudentsController allStudentsController = new GetStudentsController();

    /**
     * Instance of a class {@link EditStudents
     */
    public EditStudents editStudents = new EditStudents();



    public AddStudentController getAddStudentController() {
        return addStudentController;
    }

    public void setAddStudentController(AddStudentController addStudentController) {
        this.addStudentController = addStudentController;
    }

    public DeleteStudents getDeleteStudents() {
        return deleteStudents;
    }

    public void setDeleteStudents(DeleteStudents deleteStudents) {
        this.deleteStudents = deleteStudents;
    }

    public GetStudentsController getAllStudentsController() {
        return allStudentsController;
    }

    public void setAllStudentsController(GetStudentsController allStudentsController) {
        this.allStudentsController = allStudentsController;
    }

    public EditStudents getEditStudents() {
        return editStudents;
    }

    public void setEditStudents(EditStudents editStudents) {
        this.editStudents = editStudents;
    }


    /**
     * This control class for add entityes in database
     */
    public class AddStudentController{

        private String name;
        private String surname;
        private String fathername;
        private String faculty;

        public void addStudent(){
            Student s = new Student();
            s.setName(name);
            s.setSurname(surname);
            s.setFathername(fathername);
            s.setFaculty(faculty);
            name = "";
            surname = "";
            fathername = "";
            faculty = "";
            controlImpl.add(s);

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getFathername() {
            return fathername;
        }

        public void setFathername(String fathername) {
            this.fathername = fathername;
        }

        public String getFaculty() {
            return faculty;
        }

        public void setFaculty(String faculty) {
            this.faculty = faculty;
        }
    }

    /**
     * This control class for geted all and get by id entity in database
     */
    public class GetStudentsController{
        /**
         * Get All Entity as List
         * @return
         */
        public List<Student> getList(){
            return controlImpl.getAll();
        }

        /**
         * Get one Entity byID
         * @return
         */
        public Student getById(Long id){
            return controlImpl.get(id);
        }
    }

    /**
     * This control class for delete entityes in database
     */
    public class DeleteStudents{
        public void delete(Long id){
            controlImpl.delete(id);
        }
    }

    /**
     * This control class for update entityes in database
     */
    public class EditStudents{


        public void edit(Long id,String name,String surname,String fathername,String faculty){
            Student afterStudent = controlImpl.get(id);
            afterStudent.setName(name);
            afterStudent.setSurname(surname);
            afterStudent.setFathername(fathername);
            afterStudent.setFaculty(faculty);
            controlImpl.update(afterStudent);
        }
        public List<Student> getAll(){
            return controlImpl.getAll();
        }

    }
}
