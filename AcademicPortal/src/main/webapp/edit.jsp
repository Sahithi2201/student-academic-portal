
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="vcube.Model.Student" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
 href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

</head>
<body>

<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-6">

      <div class="card shadow">
        <div class="card-header bg-primary text-white text-center">
          <h4>Edit Student Details</h4>
        </div>

        <div class="card-body">

          <%
            Student s = (Student) request.getAttribute("student");
          %>

          <form action="student" method="post">

            <!-- Hidden ID -->
            <input type="hidden" name="id" value="<%=s.getId()%>">

            <div class="form-group">
              <label>First Name</label>
              <input type="text" name="firstname"
                     class="form-control"
                     value="<%=s.getFirstName()%>" required>
            </div>

            <div class="form-group">
              <label>Last Name</label>
              <input type="text" name="lastname"
                     class="form-control"
                     value="<%=s.getLastName()%>" required>
            </div>

            <div class="form-group">
              <label>Email</label>
              <input type="email" name="email"
                     class="form-control"
                     value="<%=s.getEmail()%>" required>
            </div>

            <div class="form-group">
              <label>Course</label>
              <input type="text" name="course"
                     class="form-control"
                     value="<%=s.getCourse()%>" required>
            </div>

            <div class="text-center">
              <button type="submit" class="btn btn-success">
                Update Student
              </button>
              <a href="student?action=list" class="btn btn-secondary">
                Cancel
              </a>
            </div>

          </form>

        </div>
      </div>

    </div>
  </div>
</div>

</body>
</html>




