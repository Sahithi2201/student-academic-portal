<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>

<%
HttpSession s = request.getSession(false);

if (s == null || s.getAttribute("user") == null || 
    !"admin".equals(s.getAttribute("role"))) {
    response.sendRedirect("login.jsp");
    return;
}

String admin = (String) s.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>

<link rel="stylesheet" 
href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

</head>

<body class="bg-light">

<nav class="navbar navbar-dark bg-dark">
  <span class="navbar-brand">Admin Panel</span>

  <span class="text-white mr-3">
      Welcome, <b><%= admin %></b>
  </span>

  <a href="logout.jsp" class="btn btn-warning btn-sm">
      Logout
  </a>
</nav>

<div class="container mt-4">

<div class="jumbotron text-center">
  <h2>Admin Dashboard</h2>
  <p class="lead">
    Manage Students, Attendance, Marks, Timetable and Events
  </p>
</div>

<div class="row text-center">

<div class="col-md-3 mb-3">
  <a href="student?action=list" 
     class="btn btn-primary btn-block">
     Students
  </a>
</div>

<div class="col-md-3 mb-3">
  <a href="attendance.jsp" 
     class="btn btn-success btn-block">
     Attendance
  </a>
</div>

<div class="col-md-3 mb-3">
  <a href="marks.jsp" 
     class="btn btn-info btn-block">
     Marks
  </a>
</div>

<div class="col-md-3 mb-3">
  <a href="Events.jsp" 
     class="btn btn-warning btn-block">
     Events
  </a>
</div>

<div class="col-md-3 mb-3">
  <a href="fee.jsp" 
     class="btn btn-warning btn-block">
     Fee Details
  </a>
</div>

<div class="col-md-3 mb-3">
  <a href="Timetable.jsp" 
     class="btn btn-warning btn-block">
     Timetable
  </a>
</div>

</div>

</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>