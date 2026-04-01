<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%--     pageEncoding="UTF-8"%> --%>
<!-- <!DOCTYPE html> -->
<!-- <html lang="en"> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"/> -->
<!-- <title>Login</title> -->

<!-- <link rel="stylesheet" -->
<!--  href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"/> -->
<!-- </head> -->

<!-- <body class="bg-light"> -->

<!-- <div class="container mt-5"> -->
<!--   <div class="row justify-content-center"> -->
<!--     <div class="col-md-5"> -->
<!--       <div class="card shadow"> -->
<!--         <div class="card-body"> -->

<!--           <h3 class="text-center mb-4">Login</h3> -->

<%--           <% if (request.getParameter("error") != null) { %> --%>
<!--             <div class="alert alert-danger text-center"> -->
<!--               Invalid Username or Password -->
<!--             </div> -->
<%--           <% } %> --%>

<!--           <form method="post" action="login"> -->

<!--             <div class="form-group"> -->
<!--               <label>Username</label> -->
<!--               <input type="text" name="username" -->
<!--                      class="form-control" required> -->
<!--             </div> -->

<!--             <div class="form-group"> -->
<!--               <label>Password</label> -->
<!--               <input type="password" name="password" -->
<!--                      class="form-control" required> -->
<!--             </div> -->

<!--             <button type="submit" -->
<!--               class="btn btn-success btn-block"> -->
<!--               Login -->
<!--             </button> -->

<!--           </form> -->

<!--           <div class="text-center mt-3"> -->
<!--             <a href="register.jsp">New user? Register</a> -->
<!--           </div> -->

<!--         </div> -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
<!-- </div> -->

<!-- </body> -->
<!-- </html> -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>Login</title>

<link rel="stylesheet"
 href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"/>
</head>

<body class="bg-light">

<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-5">
      <div class="card shadow">
        <div class="card-body">

          <h3 class="text-center mb-4">Login</h3>

          <% if (request.getParameter("error") != null) { %>
            <div class="alert alert-danger text-center">
              Invalid Username or Password
            </div>
          <% } %>

          <form method="post" action="login">

            <div class="form-group">
              <label>Username</label>
              <input type="text" name="username"
                     class="form-control" required>
            </div>

            <div class="form-group">
              <label>Password</label>
              <input type="password" name="password"
                     class="form-control" required>
            </div>

            <button type="submit"
              class="btn btn-success btn-block">
              Login
            </button>

          </form>

          <div class="text-center mt-3">
            <a href="register.jsp">New user? Register</a>
          </div>

        </div>
      </div>
    </div>
  </div>
</div>

</body>
</html>
















