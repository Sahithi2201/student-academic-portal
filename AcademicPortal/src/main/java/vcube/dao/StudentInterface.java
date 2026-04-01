
package vcube.dao;

import vcube.Model.Attendance;
import vcube.Model.LoginModel;
import vcube.Model.Student;

public interface StudentInterface {

    public void addStudent(Student s);

    public String addAttendance(Attendance a);

    public String selectStudentByUsername(LoginModel lm);

}