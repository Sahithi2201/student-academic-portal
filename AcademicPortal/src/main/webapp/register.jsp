<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>

<link rel="stylesheet"
 href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

</head>
<body>


<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-6">

      <div class="card shadow">
        <div class="card-header bg-primary text-white text-center">
          <h4>Student Registration</h4>
        </div>

        <div class="card-body">

          <form action="student" method="post">

            <input type="hidden" name="action" value="register">

            <div class="form-group">
              <label>First Name</label>
              <input type="text" name="firstname" class="form-control" required>
            </div>

            <div class="form-group">
              <label>Last Name</label>
              <input type="text" name="lastname" class="form-control" required>
            </div>

            <div class="form-group">
              <label>Username</label>
              <input type="text" name="username" class="form-control" required>
            </div>

            <div class="form-group">
              <label>Password</label>
              <input type="password" name="password" class="form-control" required>
            </div>

            <div class="form-group">
              <label>Confirm Password</label>
              <input type="password" name="confirmPassword" class="form-control" required>
            </div>

            <div class="form-group">
              <label>Mobile</label>
              <input type="text" name="mobile" class="form-control" required>
            </div>

            <div class="form-group">
              <label>Email</label>
              <input type="email" name="email" class="form-control" required>
            </div>

            <div class="form-group">
              <label>Course</label>
              <select name="course" class="form-control" required>
                <option value="">-- Select Course --</option>
                <option value="CSE">CSE</option>
                <option value="ECE">ECE</option>
                <option value="EEE">EEE</option>
                <option value="IT">IT</option>
              </select>
            </div>

            <div class="text-center">
              <button type="submit" class="btn btn-success">
                Register
              </button>
              <a href="login.jsp" class="btn btn-link">
                Already have an account?
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



<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%--     pageEncoding="UTF-8"%> --%>

<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>Student Registration</title> -->

<!-- <link rel="stylesheet" -->
<!--  href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"> -->

<!-- </head> -->
<!-- <body> -->

<!-- <div class="container mt-5"> -->
<!--   <div class="row justify-content-center"> -->
<!--     <div class="col-md-6"> -->

<!--       <div class="card shadow"> -->
<!--         <div class="card-header bg-primary text-white text-center"> -->
<!--           <h4>Student Registration</h4> -->
<!--         </div> -->

<!--         <div class="card-body"> -->

<!--           ✅ Use dynamic context path -->
<%--           <form action="<%=request.getContextPath()%>/student" method="post"> --%>

<!--             <input type="hidden" name="action" value="register"> -->

<!--             <div class="form-group"> -->
<!--               <label>First Name</label> -->
<!--               <input type="text" name="firstname" class="form-control" required> -->
<!--             </div> -->

<!--             <div class="form-group"> -->
<!--               <label>Last Name</label> -->
<!--               <input type="text" name="lastname" class="form-control" required> -->
<!--             </div> -->

<!--             <div class="form-group"> -->
<!--               <label>Username</label> -->
<!--               <input type="text" name="username" class="form-control" required> -->
<!--             </div> -->

<!--             <div class="form-group"> -->
<!--               <label>Password</label> -->
<!--               <input type="password" name="password" class="form-control" required> -->
<!--             </div> -->

<!--             <div class="form-group"> -->
<!--               <label>Confirm Password</label> -->
<!--               <input type="password" name="confirmPassword" class="form-control" required> -->
<!--             </div> -->

<!--             <div class="form-group"> -->
<!--               <label>Mobile</label> -->
<!--               <input type="text" name="mobile" class="form-control" required> -->
<!--             </div> -->

<!--             <div class="form-group"> -->
<!--               <label>Email</label> -->
<!--               <input type="email" name="email" class="form-control" required> -->
<!--             </div> -->

<!--             <div class="form-group"> -->
<!--               <label>Course</label> -->
<!--               <select name="course" class="form-control" required> -->
<!--                 <option value="">-- Select Course --</option> -->
<!--                 <option value="CSE">CSE</option> -->
<!--                 <option value="ECE">ECE</option> -->
<!--                 <option value="EEE">EEE</option> -->
<!--                 <option value="IT">IT</option> -->
<!--               </select> -->
<!--             </div> -->

<!--             <div class="text-center"> -->
<!--               <button type="submit" class="btn btn-success"> -->
<!--                 Register -->
<!--               </button> -->
<%--               <a href="<%=request.getContextPath()%>/login.jsp" class="btn btn-link"> --%>
<!--                 Already have an account? -->
<!--               </a> -->
<!--             </div> -->

<!--           </form> -->

<!--         </div> -->
<!--       </div> -->

<!--     </div> -->
<!--   </div> -->
<!-- </div> -->

<!-- </body> -->
<!-- </html> -->