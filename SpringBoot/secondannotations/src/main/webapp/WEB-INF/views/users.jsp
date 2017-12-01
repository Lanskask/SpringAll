<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Список пользователей</title>
</head>
<body>

    <div>
        <h2>Список пользователей</h2>
        <form action="${pageContext.servletContext.contextPath}/users.do" method="post">
            name: <input type="text" name="name"><br/>
            <input type="submit"><br/>
        </form>
        <table border="1">
            <tr>
                <td>Имя</td>
            </tr>
            <c:forEach items="${users}" var="user" varStatus="status">
                <tr valign="top">
                    <td>${user.name}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>