
<%@ page import="java.util.*,vcube.Model.Student" %>

<%
String role = (String) session.getAttribute("role");
if(role == null || !"admin".equals(role)){
    response.sendRedirect("login.jsp");
    return;
}
@SuppressWarnings("unchecked")
List<Student> list = (List<Student>) request.getAttribute("students");
if(list == null){
    list = new ArrayList<>();
}
%>

<!DOCTYPE html>
<html>
<head>
<title>Students List</title>

<link rel="stylesheet"
 href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<style>
body {
    background-color: #f5f7fa;
}

.container-box {
    background: white;
    padding: 25px;
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
}
</style>

</head>

<body>

<div class="container mt-5">
<div class="container-box">

<h3 class="text-center mb-4">Registered Students</h3>

<h5 class="mb-3">Total Students: <%= list.size() %></h5>

<table class="table table-bordered table-hover text-center">
<thead class="thead-dark">
<tr>
<th>ID</th>
<th>Name</th>
<th>Username</th>
<th>Email</th>
<th>Course</th>
</tr>
</thead>

<tbody>
<%
if(!list.isEmpty()){
    for(Student s : list){
%>
<tr>
<td><%= s.getId() %></td>
<td><%= s.getFirstName() %> <%= s.getLastName() %></td>
<td><%= s.getUsername() %></td>
<td><%= s.getEmail() %></td>
<td><%= s.getCourse() %></td>
</tr>
<%
    }
} else {
%>
<tr>
<td colspan="5" class="text-danger">
No students found
</td>
</tr>
<%
}
%>
</tbody>
</table>

</div>
</div>

</body>
</html>