



<%@ page import="java.util.*,vcube.Model.Timetable" %>

<%
    String role = (String) session.getAttribute("role");
%>

<!DOCTYPE html>
<html>
<head>
<title>Timetable</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
 href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">

<div class="container mt-5">

<h3 class="text-center mb-4">Class Timetable</h3>


<% if ("admin".equals(role)) { %>

<div class="card mb-4 shadow">
<div class="card-header bg-primary text-white">Add Timetable</div>
<div class="card-body">

<form action="timetable" method="post">

<div class="form-group">
<label>Day</label>
<select name="day" class="form-control" required>
<option>Monday</option>
<option>Tuesday</option>
<option>Wednesday</option>
<option>Thursday</option>
<option>Friday</option>
<option>Saturday</option>
</select>
</div>

<div class="form-group">
<label>Period</label>
<input type="text" name="period" class="form-control"
       placeholder="Period 1 / 10:00 - 11:00" required>
</div>

<div class="form-group">
<label>Subject</label>
<input type="text" name="subject" class="form-control" required>
</div>

<button class="btn btn-success btn-block">Save</button>

</form>
</div>
</div>

<% } %>

<!-- 🔹 VIEW TIMETABLE -->
<table class="table table-bordered table-striped">
<thead class="thead-dark">
<tr>
<th>Day</th>
<th>Period</th>
<th>Subject</th>
</tr>
</thead>

<tbody>
<%
@SuppressWarnings("unchecked")
List<Timetable> list = (List<Timetable>) request.getAttribute("timetableList");

if (list != null && !list.isEmpty()) {
    for (Timetable t : list) {
%>
<tr>
<td><%= t.getDay() %></td>
<td><%= t.getPeriod() %></td>
<td><%= t.getSubject() %></td>
</tr>
<%
    }
} else {
%>
<tr>
<td colspan="3" class="text-center text-danger">
No timetable available
</td>
</tr>
<% } %>
</tbody>

</table>

</div>
</body>
</html>
