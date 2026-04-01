<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Registration</title>
    <link rel="stylesheet"
     href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-primary text-white">
            Student Registration
        </div>

        <div class="card-body">
            <form action="student" method="post">

                <input type="hidden" name="action" value="add">

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>First Name</label>
                        <input type="text" name="firstName" class="form-control" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label>Last Name</label>
                        <input type="text" name="lastName" class="form-control" required>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>Username</label>
                        <input type="text" name="username" class="form-control" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label>Mobile</label>
                        <input type="text" name="mobile" class="form-control" required>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>Password</label>
                        <input type="password" name="password" class="form-control" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label>Email</label>
                        <input type="email" name="email" class="form-control" required>
                    </div>
                </div>

                <div class="form-group">
                    <label>Course</label>
                    <input type="text" name="course" class="form-control" required>
                </div>

                <button type="submit" class="btn btn-success btn-block">
                    Register Student
                </button>

            </form>
        </div>
    </div>
</div>
</body>
</html>












