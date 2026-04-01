package vcube.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import vcube.Model.Timetable;
import vcube.dao.TimetableDAO;

@WebServlet("/timetable")
public class TimetableController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        TimetableDAO dao = new TimetableDAO();
        req.setAttribute("timetableList", dao.getAllTimetable());
        req.getRequestDispatcher("Timetable.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String day = req.getParameter("day");
        String period = req.getParameter("period");
        String subject = req.getParameter("subject");

        Timetable t = new Timetable();
        t.setDay(day);
        t.setPeriod(period);
        t.setSubject(subject);

        TimetableDAO dao = new TimetableDAO();
        dao.addTimetable(t);

        res.sendRedirect("timetable");
    }
}