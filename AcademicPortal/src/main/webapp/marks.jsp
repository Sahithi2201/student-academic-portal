


<%@ page import="java.util.*,vcube.Model.Marks" %>
<%
String role = (String) session.getAttribute("role");
%>

<html>
<head>
<title>Marks</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-4">
<h3 class="text-center">Marks</h3>

<% if ("admin".equals(role)) { %>
<form method="post" action="marks" class="card p-3 mb-4">
<input name="username" class="form-control mb-2" placeholder="Student Username" required>
<input name="subject" class="form-control mb-2" placeholder="Subject" required>
<input name="marks" type="number" class="form-control mb-2" placeholder="Marks" required>
<button class="btn btn-success">Add Marks</button>
</form>
<% } %>

<table class="table table-bordered">
<tr>
<th>Username</th><th>Subject</th><th>Marks</th>
</tr>

<%
@SuppressWarnings("unchecked")
List<Marks> list = (List<Marks>) request.getAttribute("marksList");
if(list != null){
for(Marks m : list){
%>
<tr>
<td><%= m.getUsername() %></td>
<td><%= m.getSubject() %></td>
<td><%= m.getMarks() %></td>
</tr>
<% }} %>

</table>
</div>
</body>
</html>











