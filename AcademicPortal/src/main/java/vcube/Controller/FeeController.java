package vcube.Controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import vcube.dao.FeeDAO;
import vcube.Model.Fee;

@WebServlet("/fees")
public class FeeController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Fee f = new Fee();

        f.setUsername(req.getParameter("username"));
        f.setFeeType(req.getParameter("feeType"));
        f.setAmount(Integer.parseInt(req.getParameter("amount")));
        f.setStatus(req.getParameter("status"));
        f.setPaidDate(req.getParameter("paidDate"));

        FeeDAO dao = new FeeDAO();
        dao.addFee(f);

        res.sendRedirect("fees");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        String role = (String) session.getAttribute("role");
        String username = (String) session.getAttribute("user");

        FeeDAO dao = new FeeDAO();

        if ("admin".equals(role)) {
            req.setAttribute("feeList", dao.getAllFees());
        } else {
            req.setAttribute("feeList", dao.getFeesByUsername(username));
        }

        req.getRequestDispatcher("fee.jsp").forward(req, res);
    }
}