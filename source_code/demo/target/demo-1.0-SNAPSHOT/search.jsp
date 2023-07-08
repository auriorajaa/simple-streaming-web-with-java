<%--
  Created by IntelliJ IDEA.
  User: mraurio
  Date: 7/5/2023
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.dao.MovieDAOImpl" %>
<%@ page import="com.db.DBConnect" %>
<%@ page import="java.util.List" %>
<%@ page import="com.entity.MoviesDetails" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Moviex: Search</title>
    <link rel="stylesheet" href="stylesheet/main.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Inter:100,200,300,regular,500,600,700,800,900">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="icon" href="assets/popcorn.png">
</head>

<body>

<!-- Main Container -->
<div class="container">

    <br>

    <!-- MAIN SECTION START -->
    <main>

        <!-- MOVIES SECTION START -->
        <section class="movies">
            <div class="filter-bar">
                <div class="filter-dropdowns">
                    <h1>MOVIEX</h1>
                </div>
                <div class="search-bar">
                    <form action="search.jsp" method="post">
                        <input type="search" placeholder="Search movies..." name="ch">
                        <button type="submit"><i class="fas fa-search"></i></button>
                    </form>
                </div>
                <div class="filter-radios">
                    <input type="radio" name="grade" id="newest">
                    <a href="homepage.jsp">Home</a>
                </div>
            </div>


            <!-- ACTION SECTION -->
            <h1 style="margin-bottom: 20px">Search</h1>
            <div class="movies-grid">

                <%
                    String ch = request.getParameter("ch");

                    MovieDAOImpl dao = new MovieDAOImpl(DBConnect.getConn());
                    List<MoviesDetails> list = dao.getMovieBySearch(ch);

                    for (MoviesDetails b : list) {
                %>
                <div class="movie-card">
                    <div class="card-head">
                        <img src="assets/images/<%=b.getImageName()%>" alt="" class="card-img">
                        <a href="<%=b.getUrlYoutube()%>">
                            <div class="play-icon">
                                <i class="fa-solid fa-play"></i>
                            </div>
                        </a>
                    </div>
                    <div class="card-body">
                        <a href="<%=b.getUrlYoutube()%>"><h3 class="card-title"><%=b.getMovieTitle()%>
                        </h3></a>
                        <div class="card-info">
                            <span class="genre"><%=b.getMovieGenre()%></span> <span
                                class="year"><%=b.getMovieYear()%></span>
                        </div>
                    </div>
                </div>
                <%
                    }

                %>
            </div>
        </section>
        <!-- MOVIES SECTION END -->

    </main>
    <!-- MAIN SECTION END -->

</div>
<script>/* Toggle between adding and removing the "responsive" class to topnav when the user clicks on the icon */
function myFunction() {
    var x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }


}

function goBack() {
    window.location.href = "login.jsp";
    window.history.pushState({}, '', 'login.jsp');

}</script>
<script src="https://kit.fontawesome.com/7c7f68c3e5.js"
        crossorigin="anonymous"></script>
</body>

</html>
