//package vcube.dao;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//import vcube.Model.Student;
//import vcube.utility.StudentCon;
//
//public class StudentDAO {
//
//    
//	public void addStudent(Student s) {
//	    String studentSql = "INSERT INTO students(first_name, last_name, username, password, email, mobile, course) VALUES (?,?,?,?,?,?,?)";
//	    String userSql = "INSERT INTO users(username, password, role) VALUES (?,?,?)";
//
//	    Connection con = null;
//	    PreparedStatement ps1 = null;
//	    PreparedStatement ps2 = null;
//
//	    try {
//	        con = StudentCon.DBconnection();
//	        con.setAutoCommit(false); 
//
//	        ps1 = con.prepareStatement(studentSql);
//	        ps1.setString(1, s.getFirstName());
//	        ps1.setString(2, s.getLastName());
//	        ps1.setString(3, s.getUsername());
//	        ps1.setString(4, s.getPassword());
//	        ps1.setString(5, s.getEmail());
//	        ps1.setString(6, s.getMobile());
//	        ps1.setString(7, s.getCourse());
//	        ps1.executeUpdate();
//
//	        ps2 = con.prepareStatement(userSql);
//	        ps2.setString(1, s.getUsername());
//	        ps2.setString(2, s.getPassword());
//	        ps2.setString(3, "student");
//	        ps2.executeUpdate();
//
//	        con.commit(); 
//	        System.out.println("Student and user inserted successfully!");
//
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	        try {
//	            if (con != null) con.rollback(); 
//	        } catch (SQLException ex) {
//	            ex.printStackTrace();
//	        }
//	    } catch (ClassNotFoundException e) {
//			
//			e.printStackTrace();
//		} finally {
//	        try { if (ps1 != null) ps1.close(); } catch(Exception e) {}
//	        try { if (ps2 != null) ps2.close(); } catch(Exception e) {}
//	        try { if (con != null) con.close(); } catch(Exception e) {}
//	    }
//	}
//
//
//
//    
//	public List<Student> getAllStudents() {
//	    List<Student> list = new ArrayList<>();
//	    String sql = "SELECT * FROM students";
//
//	    try (Connection con = StudentCon.DBconnection();
//	         PreparedStatement ps = con.prepareStatement(sql)) {
//
//	        ResultSet rs = ps.executeQuery();
//	        while (rs.next()) {
//	            Student s = new Student();
//	            s.setId(rs.getInt("id"));
//	            s.setFirstName(rs.getString("firstname"));
//	            s.setLastName(rs.getString("lastname"));
//	            s.setUsername(rs.getString("username"));
//	            s.setEmail(rs.getString("email"));
//	            s.setCourse(rs.getString("course"));
//	            list.add(s);
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	    return list;
//	}
//
//
//   
//    public Student getStudentById(int id) {
//        Student s = null;
//        String sql = "SELECT * FROM students WHERE id=?";
//
//        try (Connection con = StudentCon.DBconnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                s = new Student();
//                s.setId(rs.getInt("id"));
//                s.setFirstName(rs.getString("firstname"));
//                s.setLastName(rs.getString("lastname"));
//                s.setEmail(rs.getString("email"));
//                s.setCourse(rs.getString("course"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return s;
//    }
//
//   
//    public void updateStudent(Student s) {
//        String sql = "UPDATE students SET firstname=?, lastname=?, email=?, course=? WHERE id=?";
//
//        try (Connection con = StudentCon.DBconnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setString(1, s.getFirstName());
//            ps.setString(2, s.getLastName());
//            ps.setString(3, s.getEmail());
//            ps.setString(4, s.getCourse());
//            ps.setInt(5, s.getId());
//            ps.executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    
//    public void deleteStudent(int id) {
//        String sql = "DELETE FROM students WHERE id=?";
//
//        try (Connection con = StudentCon.DBconnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setInt(1, id);
//            ps.executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//package vcube.dao;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//import vcube.Model.Student;
//import vcube.utility.StudentCon;
//
//public class StudentDAO {
//
//    public void addStudent(Student s) {
//
//        String sql = "INSERT INTO students(first_name,last_name,username,password,email,mobile,course,role) VALUES(?,?,?,?,?,?,?,?)";
//
//        try (Connection con = StudentCon.DBconnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setString(1, s.getFirstName());
//            ps.setString(2, s.getLastName());
//            ps.setString(3, s.getUsername());
//            ps.setString(4, s.getPassword());
//            ps.setString(5, s.getEmail());
//            ps.setString(6, s.getMobile());
//            ps.setString(7, s.getCourse());
//            ps.setString(8, "student");
//
//            ps.executeUpdate();
//
//            System.out.println("Student inserted successfully");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    
//    public List<Student> getAllStudents() {
//
//        List<Student> list = new ArrayList<>();
//        String sql = "SELECT * FROM students";
//
//        try (Connection con = StudentCon.DBconnection();
//             PreparedStatement ps = con.prepareStatement(sql);
//             ResultSet rs = ps.executeQuery()) {
//
//            while (rs.next()) {
//
//                Student s = new Student();
//
//                s.setId(rs.getInt("id"));
//                s.setFirstName(rs.getString("first_name"));
//                s.setLastName(rs.getString("last_name"));
//                s.setUsername(rs.getString("username"));
//                s.setEmail(rs.getString("email"));
//                s.setCourse(rs.getString("course"));
//
//                list.add(s);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return list;
//    }
//
//    
//    public Student getStudentById(int id) {
//
//        Student s = null;
//
//        String sql = "SELECT * FROM students WHERE id=?";
//
//        try (Connection con = StudentCon.DBconnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setInt(1, id);
//
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//
//                s = new Student();
//
//                s.setId(rs.getInt("id"));
//                s.setFirstName(rs.getString("first_name"));
//                s.setLastName(rs.getString("last_name"));
//                s.setEmail(rs.getString("email"));
//                s.setCourse(rs.getString("course"));
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return s;
//    }
//
//    
//    public void updateStudent(Student s) {
//
//        String sql = "UPDATE students SET first_name=?, last_name=?, email=?, course=? WHERE id=?";
//
//        try (Connection con = StudentCon.DBconnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setString(1, s.getFirstName());
//            ps.setString(2, s.getLastName());
//            ps.setString(3, s.getEmail());
//            ps.setString(4, s.getCourse());
//            ps.setInt(5, s.getId());
//
//            ps.executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    
//    public void deleteStudent(int id) {
//
//        String sql = "DELETE FROM students WHERE id=?";
//
//        try (Connection con = StudentCon.DBconnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setInt(1, id);
//
//            ps.executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

package vcube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vcube.Model.Student;
import vcube.utility.StudentCon;

public class StudentDAO {

    public void addStudent(Student s) {

        String sql = "INSERT INTO students(first_name,last_name,username,password,email,mobile,course,role) VALUES(?,?,?,?,?,?,?,?)";

        try (Connection con = StudentCon.DBconnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getFirstName());
            ps.setString(2, s.getLastName());
            ps.setString(3, s.getUsername());
            ps.setString(4, s.getPassword());
            ps.setString(5, s.getEmail());
            ps.setString(6, s.getMobile());
            ps.setString(7, s.getCourse());
            ps.setString(8, "student");

            ps.executeUpdate();

            System.out.println("Student inserted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {

        List<Student> list = new ArrayList<>();

        String sql = "SELECT * FROM students WHERE role='student'";

        try (Connection con = StudentCon.DBconnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
            	   System.out.println("Student: " + rs.getString("first_name")); 

                Student s = new Student();


                s.setId(rs.getInt("id"));
                s.setFirstName(rs.getString("first_name"));
                s.setLastName(rs.getString("last_name"));
                s.setUsername(rs.getString("username"));
                s.setEmail(rs.getString("email"));
                s.setCourse(rs.getString("course"));

                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Student getStudentById(int id) {

        Student s = null;

        String sql = "SELECT * FROM students WHERE id=?";

        try (Connection con = StudentCon.DBconnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                s = new Student();

                s.setId(rs.getInt("id"));
                s.setFirstName(rs.getString("first_name"));
                s.setLastName(rs.getString("last_name"));
                s.setEmail(rs.getString("email"));
                s.setCourse(rs.getString("course"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }

    public void updateStudent(Student s) {

        String sql = "UPDATE students SET first_name=?, last_name=?, email=?, course=? WHERE id=?";

        try (Connection con = StudentCon.DBconnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getFirstName());
            ps.setString(2, s.getLastName());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getCourse());
            ps.setInt(5, s.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id=?";

        try (Connection con = StudentCon.DBconnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}