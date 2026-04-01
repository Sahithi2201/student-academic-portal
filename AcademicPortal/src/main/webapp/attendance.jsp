<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*,vcube.Model.Attendance" %>

<%
    String role = (String) session.getAttribute("role");
    String username = (String) session.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attendance</title>

<link rel="stylesheet"
 href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

</head>
<body class="bg-light">

<div class="container mt-5">

    <h3 class="text-center mb-4">Attendance Details</h3>

    <% if ("admin".equals(role)) { %>

    <div class="card mb-4 shadow">
        <div class="card-header bg-primary text-white">
            Add Attendance
        </div>
        <div class="card-body">

            <form action="attendance" method="post">

                <div class="form-group">
                    <label>Student Username</label>
                    <input type="text" name="username"
                           class="form-control" required>
                </div>

                <div class="form-group">
                    <label>Subject</label>
                    <input type="text" name="subject"
                           class="form-control" required>
                </div>

                <div class="form-group">
                    <label>Present Classes</label>
                    <input type="number" name="present"
                           class="form-control" required>
                </div>

                <div class="form-group">
                    <label>Total Classes</label>
                    <input type="number" name="total"
                           class="form-control" required>
                </div>

                <button class="btn btn-success btn-block">
                    Save Attendance
                </button>

            </form>

        </div>
    </div>

    <% } %>

    <div class="card shadow">
        <div class="card-header bg-dark text-white">
            Attendance Records
        </div>

        <div class="card-body">

            <table class="table table-bordered table-striped text-center">
                <thead class="thead-dark">
                    <tr>
                        <th>Subject</th>
                        <th>Present</th>
                        <th>Total</th>
                        <th>Percentage</th>
                    </tr>
                </thead>
                <tbody>

                <%
                @SuppressWarnings("unchecked")
                List<Attendance> list =
                        (List<Attendance>) request.getAttribute("attendanceList");

                if (list != null && !list.isEmpty()) {
                    for (Attendance a : list) {
                %>
                    <tr>
                        <td><%= a.getSubject() %></td>
                        <td><%= a.getPresent() %></td>
                        <td><%= a.getTotal() %></td>
                        <td><%= a.getPercentage() %> %</td>
                    </tr>
                <%
                    }
                } else {
                %>
                    <tr>
                        <td colspan="4" class="text-danger font-weight-bold">
                            No attendance records found
                        </td>
                    </tr>
                <%
                }
                %>

                </tbody>
            </table>

        </div>
    </div>

</div>

</body>
</html>