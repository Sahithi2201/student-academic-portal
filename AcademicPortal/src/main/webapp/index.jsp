<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>VFSTR Portal | Home</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

</head>
<body>


<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="index.jsp">VFSTR Portal</a>

    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarNav">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">

            <li class="nav-item">
                <a class="nav-link" href="index.jsp">Home</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="register.jsp">Student Registration</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="login.jsp">Login</a>
            </li>

        </ul>
    </div>
</nav>


<div id="carouselExampleIndicators" class="carousel slide mt-3"
     data-ride="carousel">

    <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0"
            class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>

    <div class="carousel-inner">
        <div class="carousel-item active">
            <img class="d-block w-100" src="image5.jpeg" height="400">
        </div>
        <div class="carousel-item">
            <img class="d-block w-100" src="image2.jpeg" height="400">
        </div>
        <div class="carousel-item">
            <img class="d-block w-100" src="image4.jpeg" height="400">
        </div>
    </div>

    <a class="carousel-control-prev" href="#carouselExampleIndicators"
       role="button" data-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </a>

    <a class="carousel-control-next" href="#carouselExampleIndicators"
       role="button" data-slide="next">
        <span class="carousel-control-next-icon"></span>
    </a>
</div>


<div class="jumbotron text-center mt-4">
    <h1 class="display-4">Welcome to Vignan's Foundation for Science,Technology and Research</h1>
    <p class="lead">
        Attendance | Marks | Timetable | Events | Faculty
    </p>
    <hr class="my-4">
    <p>
        Please register or login to continue
    </p>

    <a class="btn btn-success btn-lg" href="register.jsp">Register</a>
    <a class="btn btn-warning btn-lg" href="login.jsp">Login</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"></script>

</body>
</html>
