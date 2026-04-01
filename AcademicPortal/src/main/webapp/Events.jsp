<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*,vcube.Model.Events" %>

<%
    String role = (String) session.getAttribute("role");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Events</title>

<link rel="stylesheet"
 href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

</head>
<body class="bg-light">

<div class="container mt-5">

    <h3 class="text-center mb-4">College Events</h3>

 
    <% if ("admin".equals(role)) { %>
    <div class="card mb-4 shadow">
        <div class="card-header bg-primary text-white">
            Add New Event
        </div>
        <div class="card-body">
            <form action="events" method="post">

                <div class="form-group">
                    <label>Event Title</label>
                    <input type="text" name="title" class="form-control" required>
                </div>

                <div class="form-group">
                    <label>Event Date</label>
                   <input type="date" name="eventDate" class="form-control" required>
                   
                </div>

                <div class="form-group">
                    <label>Description</label>
                    <textarea name="description"
                              class="form-control"
                              rows="3" required></textarea>
                </div>

                <button class="btn btn-success btn-block">
                    Add Event
                </button>

            </form>
        </div>
    </div>
    <% } %>

    
    <div class="row">

    <%
  @SuppressWarnings("unchecked")
  List<Events> list = (List<Events>) request.getAttribute("eventList");

        if (list != null && !list.isEmpty()) {
            for (Events e : list) {
    %>

        <div class="col-md-4">
            <div class="card mb-4 shadow-sm">
                <div class="card-body">
                    <h5 class="card-title text-primary">
                        <%= e.getTitle() %>
                    </h5>

                    <h6 class="text-muted">
                        <%= e.getEventDate() %>
                    </h6>

                    <p class="card-text mt-2">
                        <%= e.getDescription() %>
                    </p>
                </div>
            </div>
        </div>

    <%
            }
        } else {
    %>

        <div class="col-12 text-center text-danger">
            <h5>No events available</h5>
        </div>

    <%
        }
    %>

    </div>
</div>

</body>
</html>


