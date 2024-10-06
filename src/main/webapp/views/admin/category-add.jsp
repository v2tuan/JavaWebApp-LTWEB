<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 10/6/2024
  Time: 11:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="${pageContext.request.contextPath}/admin/category/insert" method="post">
  <label for="categoryname">Category name:</label><br>
  <input type="text" id="categoryname" name="categoryname"><br>
  <label for="image">Image:</label><br>
  <input type="file" id="image" name="image"><br><br>
  <label for="status">Status:</label><br>
  <input type="text" id="status" name="status"><br><br>
  <input type="submit" value="Submit">
</form>
