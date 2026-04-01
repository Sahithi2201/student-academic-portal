package vcube.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import vcube.dao.StudentDAO;
import vcube.Model.Student;

@WebServlet("/student")
public class StudentController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private StudentDAO dao = new StudentDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null || "dashboard".equals(action)) {

            req.getRequestDispatcher("studentDashboard.jsp").forward(req, res);

        } 
        else if ("list".equals(action)) {

            req.setAttribute("students", dao.getAllStudents());
            req.getRequestDispatcher("listStudents.jsp").forward(req, res);

        } 
        else if ("edit".equals(action)) {

            int id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("student", dao.getStudentById(id));
            req.getRequestDispatcher("editStudent.jsp").forward(req, res);

        } 
        else if ("delete".equals(action)) {

            int id = Integer.parseInt(req.getParameter("id"));
            dao.deleteStudent(id);

            res.sendRedirect("student?action=list");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("register".equals(action)) {

            System.out.println("REGISTER METHOD CALLED");

            Student s = new Student();

            s.setFirstName(req.getParameter("firstname"));
            s.setLastName(req.getParameter("lastname"));
            s.setUsername(req.getParameter("username"));
            s.setPassword(req.getParameter("password"));
            s.setEmail(req.getParameter("email"));
            s.setMobile(req.getParameter("mobile"));
            s.setCourse(req.getParameter("course"));

            dao.addStudent(s);

            res.sendRedirect("login.jsp");

        } 
        else if ("update".equals(action)) {

            Student s = new Student();

            s.setId(Integer.parseInt(req.getParameter("id")));
            s.setFirstName(req.getParameter("firstname"));
            s.setLastName(req.getParameter("lastname"));
            s.setEmail(req.getParameter("email"));
            s.setCourse(req.getParameter("course"));

            dao.updateStudent(s);

            res.sendRedirect("student?action=list");
        }
    }
}
//
////package vcube.Controller;
////
////import jakarta.servlet.ServletException;
////import jakarta.servlet.annotation.WebServlet;
////import jakarta.servlet.http.*;
////import java.io.IOException;
////import vcube.dao.StudentDAO;
////import vcube.Model.Student;
////
////@WebServlet("/student")
////public class StudentController extends HttpServlet {
////
////    private static final long serialVersionUID = 1L;
////
////    protected void doGet(HttpServletRequest req, HttpServletResponse res)
////            throws ServletException, IOException {
////
////        String action = req.getParameter("action");
////        StudentDAO dao = new StudentDAO();
////
////        if (action == null || action.equals("dashboard")) {
////            req.getRequestDispatcher("studentDashboard.jsp").forward(req, res);
////        } 
////        else if ("list".equals(action)) {
////            req.setAttribute("students", dao.getAllStudents());
////            req.getRequestDispatcher("listStudents.jsp").forward(req, res);
////        } 
////        else if ("edit".equals(action)) {
////            int id = Integer.parseInt(req.getParameter("id"));
////            req.setAttribute("student", dao.getStudentById(id));
////            req.getRequestDispatcher("editStudent.jsp").forward(req, res);
////        } 
////        else if ("delete".equals(action)) {
////            int id = Integer.parseInt(req.getParameter("id"));
////            dao.deleteStudent(id);
////            res.sendRedirect(req.getContextPath() + "/student?action=list");
////        }
////    }
////
////    protected void doPost(HttpServletRequest req, HttpServletResponse res)
////            throws ServletException, IOException {
////
////        String action = req.getParameter("action");
////        StudentDAO dao = new StudentDAO();
////
////        if ("register".equals(action)) {
////            try {
////                Student s = new Student();
////                s.setFirstName(req.getParameter("firstname"));
////                s.setLastName(req.getParameter("lastname"));
////                s.setUsername(req.getParameter("username"));
////                s.setPassword(req.getParameter("password"));
////                s.setEmail(req.getParameter("email"));
////                s.setMobile(req.getParameter("mobile"));
////                s.setCourse(req.getParameter("course"));
////
////                dao.addStudent(s);
////
////                // ✅ Redirect with context path
////                res.sendRedirect(req.getContextPath() + "/login.jsp");
////
////            } catch (Exception e) {
////                e.printStackTrace();
////                req.setAttribute("errorMessage", "Registration Failed");
////                req.getRequestDispatcher("register.jsp").forward(req, res);
////            }
////        } 
////        else if ("update".equals(action)) {
////            Student s = new Student();
////            s.setId(Integer.parseInt(req.getParameter("id")));
////            s.setFirstName(req.getParameter("firstname"));
////            s.setLastName(req.getParameter("lastname"));
////            s.setEmail(req.getParameter("email"));
////            s.setCourse(req.getParameter("course"));
////
////            dao.updateStudent(s);
////
////            res.sendRedirect(req.getContextPath() + "/student?action=list");
////        }
////    }
////}

