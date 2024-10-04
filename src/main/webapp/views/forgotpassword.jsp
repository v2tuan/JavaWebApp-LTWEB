<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 10/4/2024
  Time: 9:32 AM
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
    display: flex;
    align-items: center;
    justify-content: center;
    padding: 15rem 0;
  }

  .card {
    text-align: center;
    border: 1px solid black;
    padding: 30px 40px;
    border-radius: 12px;
  }

  h2 {
    font-size: 1.5rem;
    margin-top: 10px;
    text-transform: uppercase;
  }

  .passInput {
    margin-top: 15px;
    width: 80%;
    background: transparent;
    border: none;
    border-bottom: 2px solid deepskyblue;
    font-size: 15px;
    outline: none;
  }

  button {
    margin-top: 15px;
    width: 80%;
    background-color: deepskyblue;
    color: white;
    padding: 10px;
    text-transform: uppercase;
  }
</style>
<body>
<div class="card">
  <h2>Forgot Password?</h2>
  <p>You can reset your Password here</p>
  <form action="${pageContext.request.contextPath}/forgotpassword" method="post">
    <input type="text" class="passInput" placeholder="User Name" name = "username">
    <button>Send My Password</button>
  </form>
  <c:if test="${alert !=null}">
    <h3 class="alert alertdanger">${alert}</h3>
  </c:if>
</div>
</body>
</html>
