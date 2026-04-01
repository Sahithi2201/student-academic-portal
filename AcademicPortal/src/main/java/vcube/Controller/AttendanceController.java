

package vcube.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import vcube.dao.AttendanceDAO;
import vcube.Model.Attendance;

@WebServlet("/attendance")
public class AttendanceController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Add Attendance
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Attendance a = new Attendance();

        a.setUsername(req.getParameter("username"));
        a.setSubject(req.getParameter("subject"));
        a.setPresent(Integer.parseInt(req.getParameter("present")));
        a.setTotal(Integer.parseInt(req.getParameter("total")));

        AttendanceDAO dao = new AttendanceDAO();
        dao.addAttendance(a);

        res.sendRedirect("attendance");
    }

    // View Attendance
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        String role = (String) session.getAttribute("role");
        AttendanceDAO dao = new AttendanceDAO();

        if ("admin".equals(role)) {

            req.setAttribute("attendanceList", dao.getAllAttendance());

        } else {

            String username = (String) session.getAttribute("user");

            req.setAttribute("attendanceList",
                    dao.getAttendanceByUsername(username));
        }

        req.getRequestDispatcher("attendance.jsp").forward(req, res);
    }
}
