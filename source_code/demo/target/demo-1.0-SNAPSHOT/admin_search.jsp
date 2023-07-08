<%--
  Created by IntelliJ IDEA.
  User: mraur
  Date: 7/2/2023
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.dao.MovieDAOImpl" %>
<%@ page import="com.db.DBConnect" %>
<%@ page import="com.entity.MoviesDetails" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Moviex: Admin</title>
    <link rel="icon" href="assets/popcorn.png">
    <style>
        @font-face {
            font-family: "Poppins", sans-serif;
            src: url("assets/fonts/Poppins-Regular.ttf");
        }

        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: "Poppins", sans-serif;
        }
        a {
            text-decoration: none;
            color: #fff;
        }

        h1 {
            text-align: center;
            margin-bottom: 10px;
        }

        .container {
            display: flex;
        }

        .sidenav {
            height: 100vh;
            width: 160px;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: #111;
            overflow-x: hidden;
            padding-top: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }

        .sidenav a {
            padding: 10px 8px 6px 16px;
            text-decoration: none;
            font-size: 18px;
            color: #818181;
            display: block;
        }

        .sidenav a:hover {
            color: #f1f1f1;
        }

        .main {
            margin-left: 160px; /* Same as the width of the sidenav */
            padding: 20px;
            width: calc(100% - 160px); /* Adjust the width based on the sidebar */
        }

        .table-container {
            overflow-x: auto;
        }

        .custom-table {
            width: 100%;
            border-collapse: collapse;
            table-layout: fixed; /* Menentukan lebar kolom secara tetap */
        }

        .custom-table th,
        .custom-table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
            width: 20%; /* Setiap kolom memiliki lebar 20% dari tabel */
        }

        .btn {
            display: inline-block;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            font-size: 14px;
            font-weight: bold;
            color: #fff;
            cursor: pointer;
        }

        .blue {
            background-color: #007aff;
            text-decoration: none;
            color: #fff;
            /* Warna Cupertino biru */
        }

        .red {
            background-color: #ff3b30;
            text-decoration: none;
            color: #fff;
            /* Warna Cupertino merah */
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
        }

        .logout {
            background-color: #e50914;
            display: inline-block;
            margin: 8px;
            padding: 12px 14px;
            border-radius: 4px;
            font-size: 15px;
            font-weight: bold;
            text-decoration: none;
            color: #fff;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .logout:hover {
            background-color: rgb(229, 9, 20, 0.7);
        }

        .custom-table td:nth-child(6) {
            max-width: 200px;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
        }

        /* SEARCH BAR STYLE */
        .search-bar {
            display: flex;
            align-items: center;
            border-radius: 4px;
        }

        .search-bar input[type="search"] {
            width: 250px;
            padding: 10px;
            border: none;
            border-radius: 5px;
            font-size: 14px;
            background-color: #fff;
            color: #fff;
            outline: none;
            transition: background-color 0.3s ease;
        }

        .search-bar input[type="search"]::placeholder {
            color: #999;
        }

        .search-bar input[type="search"]:focus {
            background-color: #fff;
            color: #333;
        }

        .search-bar button {
            border: none;
            background-color: transparent;
            cursor: pointer;
            margin-left: 10px;
        }

        .search-bar button i {
            color: #1a1a1a;
            font-size: 18px;
            transition: color 0.3s ease;
        }

        .search-bar button:hover i {
            color: #999;
        }

        .header-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            text-align: center;
            margin-bottom: 20px;
        }

    </style>
</head>
<body>
<div class="container">
    <div class="sidenav">
        <button class="logout" onclick="goBack()">Back</button>
    </div>
    <div class="main">
        <div class="header-container">
            <h1>Search</h1>
            <div class="search-bar">
                <form action="admin_search.jsp" method="post">
                    <input type="search" placeholder="Search movies..." name="ch">
                    <button type="submit"><i class="fas fa-search"></i></button>
                </form>
            </div>
        </div>
        <div class="table-container">
            <table class="custom-table">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Image</th>
                    <th>Title</th>
                    <th>Genre</th>
                    <th>Year</th>
                    <th>Trailer URL</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <%
                    String ch = request.getParameter("ch");

                    MovieDAOImpl dao = new MovieDAOImpl(DBConnect.getConn());
                    List<MoviesDetails> list = dao.getMovieBySearch(ch);

                    for (MoviesDetails b : list) {
                %>
                <tr>
                    <td><%=b.getMovieId()%>
                    </td>
                    <td><img src="assets/images/<%=b.getImageName()%>" alt="" style="width: 40%;"></td>
                    <td><%=b.getMovieTitle()%>
                    </td>
                    <td><%=b.getMovieGenre()%>
                    </td>
                    <td><%=b.getMovieYear()%>
                    </td>
                    <td><%=b.getUrlYoutube()%>
                    </td>
                    <td>
                        <button class="btn blue"><a href="edit_movies.jsp?id=<%=b.getMovieId()%>">Edit</a></button>
                        <button class="btn red"><a href="MoviesDeleteServlet?id=<%=b.getMovieId()%>">Delete</a></button>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script>
    function goBack() {
        window.location.href = "admin.jsp";
        window.history.pushState({}, '', 'admin.jsp');
    }
</script>
<script src="https://kit.fontawesome.com/7c7f68c3e5.js" crossorigin="anonymous"></script>

</body>
</html>
