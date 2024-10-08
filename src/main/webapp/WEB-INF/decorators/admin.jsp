<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 10/4/2024
  Time: 9:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/commons/taglib.jsp" %>
<c:url value="/" var="URL"></c:url>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%@ include file="/commons/admin/header.jsp" %>
<sitemesh:write property= "body" />
<script src="${URL}assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script>
    function chooseFile(fileInput){
        if (fileInput.files && fileInput.files[0]){
            var reader = new FileReader();
            reader.onload = function (e){
                $('#images').attr('src', e.target.result);
            }
            reader.readAsDataURL(fileInput.files[0])
        }
    }
</script>

<%@ include file="/commons/admin/footer.jsp" %>
</body>
</html>
