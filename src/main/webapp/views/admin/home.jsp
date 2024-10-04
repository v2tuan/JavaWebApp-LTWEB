<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 10/4/2024
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>

<!DOCTYPE html>
<html>
<head>
    <title>W3.CSS Template</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <style>
        body,h1 {font-family: "Raleway", sans-serif}
        body, html {height: 100%}
        .bgimg {
            background-image: url('https://powerbloom.com/wp-content/uploads/2023/05/unsplash_nick-scheerbart-xFjAftU8lMY-2.jpg');
            min-height: 100%;
            background-position: center;
            background-size: cover;
        }

        /* Căn chỉnh logo và form */
        .w3-display-topleft {
            display: flex;
            justify-content: space-between;
            width: 100%;
            align-items: center;
        }

        button {
            background-color: transparent; /* Nền trong suốt */
            color: white;
            border: 1px solid white; /* Đường viền */
            border-radius: 30px;
            padding: 10px 20px;
            cursor: pointer;
            font-size: 16px;
            transition: transform 0.2s ease, background-color 0.2s ease;
        }

        /* Hiệu ứng hover: phóng to */
        button:hover {
            transform: scale(1.05);
            background-color: rgba(255, 255, 255, 0.1); /* Nền mờ khi hover */
        }

        /* Hiệu ứng click: thu nhỏ */
        button:active {
            transform: scale(0.95); /* Thu nhỏ nút khi nhấn */
        }
    </style>
</head>
<body>

<div class="bgimg -container w3-animate-opacity w3-text-white">
    <div class="w3-display-topleft w3-padding-large w3-xlarge" style="width: 100%">
        <div>Logo</div>
        <form id="logout-form" action="/logout" method="POST">
            <button type="submit" id="logout-btn">Log out</button>
        </form>
    </div>
    <div class="w3-display-middle">
        <h1 class="w3-jumbo w3-animate-top">COMING SOON</h1>
        <hr class="w3-border-grey" style="margin:auto;width:40%">
        <p class="w3-large w3-center">35 days left</p>
    </div>
    <div class="w3-display-bottomleft w3-padding-large">
        Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a>
    </div>
</div>

</body>
</html>
