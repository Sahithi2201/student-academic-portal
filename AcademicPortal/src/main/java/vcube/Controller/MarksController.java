package vcube.Controller;

import java.io.IOException;

import vcube.Model.Marks;
import vcube.dao.MarksDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/marks")
public class MarksController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Marks m = new Marks();
        m.setUsername(req.getParameter("username"));
        m.setSubject(req.getParameter("subject"));
        m.setMarks(Integer.parseInt(req.getParameter("marks")));

        new MarksDAO().addMarks(m);
        res.sendRedirect("marks");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        String role = (String) session.getAttribute("role");

        MarksDAO dao = new MarksDAO();

        if ("admin".equals(role)) {
            req.setAttribute("marksList", dao.getAllMarks());
        } else {
            String username = (String) session.getAttribute("user");
            req.setAttribute("marksList", dao.getMarksByUsername(username));
        }

        req.getRequestDispatcher("marks.jsp").forward(req, res);
    }
}