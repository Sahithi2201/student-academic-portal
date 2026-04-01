<%@ page import="java.util.*,vcube.Model.Fee" %>
<%
String role = (String) session.getAttribute("role");
%>

<!DOCTYPE html>
<html>
<head>
<title>Fees</title>
<link rel="stylesheet"
 href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">

<h3 class="text-center mb-4">Fee Details</h3>

<% if ("admin".equals(role)) { %>

<div class="card mb-4">
<div class="card-header bg-primary text-white">Add Fee</div>
<div class="card-body">

<form action="fees" method="post">

<div class="form-group">
<label>Student Username</label>
<input type="text" name="username" class="form-control" required>
</div>

<div class="form-group">
<label>Fee Type</label>
<input type="text" name="feeType" class="form-control" required>
</div>

<div class="form-group">
<label>Amount</label>
<input type="number" name="amount" class="form-control" required>
</div>

<div class="form-group">
<label>Status</label>
<select name="status" class="form-control">
<option>Paid</option>
<option>Pending</option>
</select>
</div>

<div class="form-group">
<label>Paid Date</label>
<input type="date" name="paidDate" class="form-control">
</div>

<button class="btn btn-success">Save</button>
</form>

</div>
</div>

<% } %>

<table class="table table-bordered">
<tr>
<th>Username</th>
<th>Fee Type</th>
<th>Amount</th>
<th>Status</th>
<th>Paid Date</th>
</tr>

<%
@SuppressWarnings("unchecked")
List<Fee> list = (List<Fee>) request.getAttribute("feeList");
if (list != null) {
for (Fee f : list) {
%>
<tr>
<td><%= f.getUsername() %></td>
<td><%= f.getFeeType() %></td>
<td><%= f.getAmount() %></td>
<td><%= f.getStatus() %></td>
<td><%= f.getPaidDate() %></td>
</tr>
<% }} %>

</table>

</div>
</body>
</html>









