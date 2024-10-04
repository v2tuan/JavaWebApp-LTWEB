<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 10/4/2024
  Time: 9:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<style>
    body {
        font-family: Arial, Helvetica, sans-serif;
        /*   background-color: black; */
    }

    body{
        font-family: Arial, Helvetica, sans-serif;
        min-height: 100vh;
        display: flex;
        align-items: center;/* Căn giữa theo chiều dọc phải sử dụng chung với display: flex*/
        justify-content: center;/* Căn giữa theo chiều ngang phải sử dụng chung với display: flex*/
        /* padding: 20px; */
        /* background: rgb(255, 255, 255); */
    }

    form {
        width: 700px;
        height: 700px;
        background-color: white; /* Màu nền của div */
    }

    * {
        box-sizing: border-box;
    }

    /* Add padding to containers */
    .container {
        padding: 16px;
        background-color: white;
    }

    /* Full-width input fields */
    input[type=text], input[type=password] {
        width: 100%;
        padding: 15px;
        margin: 5px 0 22px 0;
        display: inline-block;
        border: none;
        background: #f1f1f1;
    }

    input[type=text]:focus, input[type=password]:focus {
        background-color: #ddd;
        outline: none;
    }

    /* Overwrite default styles of hr */
    hr {
        border: 1px solid #f1f1f1;
        margin-bottom: 25px;
    }

    /* Set a style for the submit button */
    .registerbtn {
        background-color: #04AA6D;
        color: white;
        padding: 16px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
        opacity: 0.9;
    }

    .registerbtn:hover {
        opacity: 1;
    }

    /* Add a blue text color to links */
    a {
        color: dodgerblue;
    }

    /* Set a grey background color and center the text of the "sign in" section */
    .signin {
        background-color: #f1f1f1;
        text-align: center;
    }
</style>
</head>
<body>

<form action="/LTWEB_C2/register" method="post">
    <div class="container">
        <h1>Register</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>
        <label for="username"><b>User Name</b></label>
        <input type="text" placeholder="Enter User Name" name="username" id="username" required>

        <label for="fullname"><b>Name</b></label>
        <input type="text" placeholder="Enter Your Name" name="fullname" id="fullname" required>

        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Enter Email" name="email" id="email" required>

        <label for="phone"><b>Phone</b></label>
        <input type="text" placeholder="Enter Phone" name="phone" id="phone" required>

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" id="password" required>

        <label for="psw-repeat"><b>Repeat Password</b></label>
        <input type="password" placeholder="Repeat Password" name="psw-repeat" id="psw-repeat" required>
        <hr>
        <p>By creating an account you agree to our <a href="#">Terms and Privacy</a>.</p>

        <button type="submit" class="registerbtn">Register</button>
    </div>

    <div class="container signin">
        <p>Already have an account? <a href="/LTWEB_C2/login">Sign in</a>.</p>
    </div>
</form>

</body>
</html>
