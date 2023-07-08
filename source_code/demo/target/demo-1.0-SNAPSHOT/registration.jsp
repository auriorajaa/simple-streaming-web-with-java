<%--
  Created by IntelliJ IDEA.
  User: mraurio
  Date: 7/3/2023
  Time: 07:14 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Moviex: Signup</title>
    <link rel="stylesheet" href="stylesheet/login.css"/>
    <link rel="icon" href="assets/popcorn.png">
</head>
<body>
<div class="background"></div>
<div class="container">
    <div class="content">
        <h1>Signup Form</h1>
        <form action="Register" method="post" onsubmit="return validateEmail()">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" name="email" id="email" placeholder="email@mail.com" required>
            </div>
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" name="username" id="username" placeholder="username" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" name="password" id="password" placeholder="password" required>
            </div>
            <div class="form-group">
                <label for="subscription">Subscription</label>
                <select name="subscription" id="subscription" required>
                    <option value="" disabled selected>Select Subscription</option>
                    <option value="Bronze">Bronze</option>
                    <option value="Silver">Silver</option>
                    <option value="Gold">Gold</option>
                </select>
            </div>
            <input type="submit" value="Register">
        </form>
        <p style="font-size: 14px">
            Already have an account? <a href="login.jsp">Login</a><br>
            Subscription Plan? Click <a href="subscription_plan.jsp">Here</a>
        </p>
    </div>
</div>
<script>
    function validateEmail() {
        var emailInput = document.getElementById("email");
        var email = emailInput.value;
        var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        if (!emailRegex.test(email)) {
            alert("Please enter a valid email address (e.g., email@mail.com)");
            return false;
        }
        return true;
    }
</script>
</body>
</html>
