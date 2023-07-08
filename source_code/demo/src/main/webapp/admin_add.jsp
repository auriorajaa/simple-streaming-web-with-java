<%--
  Created by IntelliJ IDEA.
  User: mraur
  Date: 7/3/2023
  Time: 06:53 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Moviex: Add Movies</title>
    <link rel="stylesheet" href="stylesheet/login.css"/>
    <link rel="icon" href="assets/popcorn.png">
    <style>
        .form-group select {
            padding: 10px;
            font-size: 16px;
            border-radius: 4px;
            border: none;
            width: 100%;
        }
    </style>
</head>
<body>
<div class="background"></div>
<div class="container">
    <div class="content">
        <h1>Add Movies</h1>

        <form action="AddMoviesServlet" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" name="movieTitle" id="title" placeholder="Movie Title" required>
            </div>
            <div class="form-group">
                <label for="genre">Genre</label>
                <select name="movieGenre" id="genre" required>
                    <option value="" disabled selected>Select Genre</option>
                    <option value="Action">Action</option>
                    <option value="Adventure">Adventure</option>
                    <option value="Family">Family</option>
                    <option value="Horror">Horror</option>
                    <option value="Action">Thriller</option>
                </select>
            </div>
            <div class="form-group">
                <label for="year">Year</label>
                <input type="text" name="movieYear" id="year" placeholder="Released Year" required>
            </div>
            <div class="form-group">
                <label for="url">Trailer URL</label>
                <input type="url" name="urlYoutube" id="url" placeholder="Link of trailer" required>
            </div>
            <div class="form-group">
                <label for="photo">Upload Photo</label>
                <input type="file" name="photo" id="photo" required>
            </div>
            <input type="submit" value="Add">
        </form>
    </div>
</div>
</body>
</html>
