<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>

<%
HttpSession s = request.getSession(false);

if (s == null || s.getAttribute("user") == null) {
    response.sendRedirect("login.jsp");
    return;
}

String studentName = (String) s.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Dashboard</title>

<link rel="stylesheet" 
href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="#">VFSTR PORTAL</a>

  <button class="navbar-toggler" type="button" 
          data-toggle="collapse" data-target="#navbarNav">
      <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav ml-auto">

      <li class="nav-item">
        <span class="nav-link text-white">
            Welcome, <b><%= studentName %></b>
        </span>
      </li>

      <li class="nav-item">
        <a class="nav-link text-warning" href="logout.jsp">
            Logout
        </a>
      </li>

    </ul>
  </div>
</nav>

<div class="container mt-4">
  <div class="row">

    <div class="col-md-6 col-lg-4 mb-4">
      <div class="card shadow h-100 text-center">
        <div class="card-body">
          <h5 class="card-title">Attendance</h5>
          <p class="card-text">View your attendance details</p>
          <a href="attendance" class="btn btn-primary">Open</a>
        </div>
      </div>
    </div>

    <div class="col-md-6 col-lg-4 mb-4">
      <div class="card shadow h-100 text-center">
        <div class="card-body">
          <h5 class="card-title">Marks</h5>
          <p class="card-text">Check performance and results</p>
          <a href="marks" class="btn btn-success">Open</a>
        </div>
      </div>
    </div>

    <div class="col-md-6 col-lg-4 mb-4">
      <div class="card shadow h-100 text-center">
        <div class="card-body">
          <h5 class="card-title">Timetable</h5>
          <p class="card-text">View your daily schedule</p>
          <a href="timetable" class="btn btn-info">Open</a>
        </div>
      </div>
    </div>

    <div class="col-md-6 col-lg-4 mb-4">
      <div class="card shadow h-100 text-center">
        <div class="card-body">
          <h5 class="card-title">Events</h5>
          <p class="card-text">Holidays and college events</p>
          <a href="events" class="btn btn-warning">Open</a>
        </div>
      </div>
    </div>

    <div class="col-md-6 col-lg-4 mb-4">
      <div class="card shadow h-100 text-center">
        <div class="card-body">
          <h5 class="card-title">Fee Details</h5>
          <p class="card-text">Amount to be pay</p>
          <a href="fees" class="btn btn-warning">Open</a>
        </div>
      </div>
    </div>

  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>