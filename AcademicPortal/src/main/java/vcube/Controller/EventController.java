//package vcube.Controller;
//
//import java.io.IOException;
//import java.time.LocalDate;
//
//import com.vcube.Model.Events;
//import com.vcube.dao.EventDAO;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//@WebServlet("/events")
//public class EventController extends HttpServlet {
//
//    protected void doGet(HttpServletRequest req, HttpServletResponse res)
//            throws ServletException, IOException {
//
//        EventDAO dao = new EventDAO();
//        req.setAttribute("eventList", dao.getAllEvents());
//
//        req.getRequestDispatcher("Events.jsp").forward(req, res);
//    }
//
//    protected void doPost(HttpServletRequest req, HttpServletResponse res)
//            throws ServletException, IOException {
//
//        String title = req.getParameter("title");
//        String eventDate = req.getParameter("eventDate");
//        String description = req.getParameter("description");
//
//        Events e = new Events();
//        e.setTitle(title);
//        e.setEventDate(eventDate);
//        e.setDescription(description);
//
//        new EventDAO().addEvent(e);
//
//        // IMPORTANT
//        res.sendRedirect("events");
//    }
//}

package vcube.Controller;

import java.io.IOException;

import vcube.Model.Events;
import vcube.dao.EventDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/events")
public class EventController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        EventDAO dao = new EventDAO();

        req.setAttribute("eventList", dao.getAllEvents());

        req.getRequestDispatcher("Events.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String title = req.getParameter("title");
        String eventDate = req.getParameter("eventDate");
        String description = req.getParameter("description");

        Events e = new Events();

        e.setTitle(title);
        e.setEventDate(eventDate);
        e.setDescription(description);

        EventDAO dao = new EventDAO();
        dao.addEvent(e);

        res.sendRedirect("events");
    }
}
