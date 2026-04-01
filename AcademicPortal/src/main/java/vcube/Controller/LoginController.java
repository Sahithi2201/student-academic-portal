//package vcube.Controller;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.*;
//
//import java.io.IOException;
//import java.sql.*;
//
//import vcube.utility.StudentCon;
//
//@WebServlet("/login")
//public class LoginController extends HttpServlet {
//
//    private static final long serialVersionUID = 1L;
//
//    protected void doPost(HttpServletRequest req, HttpServletResponse res)
//            throws ServletException, IOException {
//
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//
//        try (Connection con = StudentCon.DBconnection()) {
//
//            String sql = "SELECT * FROM students WHERE username=? AND password=?";
//            PreparedStatement ps = con.prepareStatement(sql);
//
//            ps.setString(1, username);
//            ps.setString(2, password);
//
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//
//                HttpSession session = req.getSession(true);
//                session.setAttribute("user", username);
//
//                System.out.println("Student Login Success: " + username);
//
//                res.sendRedirect("studentDashboard.jsp");
//
//            } else {
//
//                res.sendRedirect("login.jsp?error=invalid");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            res.sendRedirect("login.jsp?error=server");
//        }
//    }
//}

//package vcube.Controller;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.*;
//
//import java.io.IOException;
//import java.sql.*;
//
//import vcube.utility.StudentCon;
//
//
//@WebServlet("/login")
//public class LoginController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
// protected void doPost(HttpServletRequest req, HttpServletResponse res)
// throws ServletException, IOException {
//
//  String username = req.getParameter("username");
//  String password = req.getParameter("password");
//
//  try(Connection con = StudentCon.DBconnection()){
//
//   String sql="SELECT * FROM students WHERE username=? AND password=?";
//   PreparedStatement ps=con.prepareStatement(sql);
//
//   ps.setString(1,username);
//   ps.setString(2,password);
//
//   ResultSet rs=ps.executeQuery();
//
//   if(rs.next()){
//
//    HttpSession session=req.getSession();
//
//    session.setAttribute("studentId",rs.getInt("id"));
//    session.setAttribute("user",rs.getString("username"));
//    session.setAttribute("role",rs.getString("role"));
//
//    String role=rs.getString("role");
//
//    if("admin".equalsIgnoreCase(role)){
//     res.sendRedirect("adminDashboard.jsp");
//    }else{
//     res.sendRedirect("studentDashboard.jsp");
//    }
//
//   }else{
//
//    res.sendRedirect("login.jsp?error=invalid");
//
//   }
//
//  }catch(Exception e){
//   e.printStackTrace();
//  }
// }
//}
////@WebServlet("/login")
////public class LoginController extends HttpServlet {
////	private static final long serialVersionUID = 1L;
////
////  protected void doPost(HttpServletRequest req, HttpServletResponse res)
////          throws ServletException, IOException {
////
////  	String username = req.getParameter("username").trim();
////  	String password = req.getParameter("password").trim();
////
////      try (Connection con = StudentCon.DBconnection()) {
////
////        
////      	String sql = "SELECT * FROM students WHERE username=? AND password=?";
////          PreparedStatement ps = con.prepareStatement(sql);
////          ps.setString(1, username);
////          ps.setString(2, password);
////
////          ResultSet rs = ps.executeQuery();
////
////          if (!rs.next()) {
////              
////              res.sendRedirect("login.jsp?error=invalid");
////              return;
////          }
////
////          String role = rs.getString("role").trim().toLowerCase();
////
////        
////          HttpSession session = req.getSession(true);
////          session.setAttribute("user", username);
////          session.setAttribute("role", role);
////          session.setMaxInactiveInterval(30 * 60); 
////
////      
////          if ("student".equals(role)) {
////
////              String studentSql = "SELECT id FROM students WHERE username=?";
////              PreparedStatement ps2 = con.prepareStatement(studentSql);
////              ps2.setString(1, username);
////
////              ResultSet rs2 = ps2.executeQuery();
////
////              if (rs2.next()) {
////                  int studentId = rs2.getInt("id");
////                  session.setAttribute("studentId", studentId);
////
////                  System.out.println("✅ Student Login | ID: " + studentId);
////                  res.sendRedirect("studentDashboard.jsp");
////              } else {
////               
////                  session.invalidate();
////                  res.sendRedirect("login.jsp?error=student");
////              }
////
////              rs2.close();
////              ps2.close();
////          }
////
////        
////          else if ("admin".equals(role)) {
////              System.out.println("✅ Admin Login");
////              res.sendRedirect("adminDashboard.jsp");
////          }
////
////        
////          else {
////              session.invalidate();
////              res.sendRedirect("login.jsp?error=role");
////          }
////
////          rs.close();
////          ps.close();
////
////      } catch (Exception e) {
////          e.printStackTrace();
////          res.sendRedirect("login.jsp?error=server");
////      }
////  }
////}
////


package vcube.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.*;

import vcube.utility.StudentCon;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try(Connection con = StudentCon.DBconnection()){

            String sql = "SELECT role FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String role = rs.getString("role");

                HttpSession session = req.getSession();
                session.setAttribute("user", username);
                session.setAttribute("role", role);

                if ("admin".equalsIgnoreCase(role)) {

                    res.sendRedirect("adminDashboard.jsp");

                } else if ("student".equalsIgnoreCase(role)) {

                    res.sendRedirect("studentDashboard.jsp");

                }

            } else {

                res.sendRedirect("login.jsp?error=invalid");

            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}