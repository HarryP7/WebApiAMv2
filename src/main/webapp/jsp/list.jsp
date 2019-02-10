<%--
  Created by IntelliJ IDEA.
  User: Harry PC
  Date: 10.02.2019
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>AroundMe</title>
</head>
<body>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Список событий</h2></caption>
        <tr>
            <th>Id</th>
            <th>uId</th>
            <th>Дата события</th>
            <th>Стоимость</th>
            <th>Пользователь</th>
            <th>Комментарий</th>
            <th>Статус</th>
            <th>fk_Service</th>
            <th>Широта</th>
            <th>Долгота</th>
            <th>Название</th>
            <th>Дата размещения</th>
            <th>ImageUrl</th>

        </tr>
        <tr>
        <c:forEach var="event" items="${requestScope.listEvents}">
                <td><c:out value="${event.idEvent}" /></td>
                <td><c:out value="${event.uid}" /></td>
                <td><calendar:formatDate value="${event.evDate}" pattern="dd-MM-yyyy HH:mm" /></td>
                <td><c:out value="${event.cost}" /></td>
            <c:forEach var="users" items="${requestScope.listUsers}">
                <td><c:out value="${users.fullName}" /> </td>
            </c:forEach>
                <td><c:out value="${event.comment}" /></td>
                <td><c:out value="${event.status}"/></td>
        </c:forEach>
            <c:forEach var="service" items="${requestScope.listService}">
                <td><c:out value="${service.idService}" /></td>
                <td><c:out value="${service.lat}" /></td>
                <td><c:out value="${service.lng}" /></td>
                <td><c:out value="${service.title}" /></td>
                <td><calendar:formatDate value="${service.datePlace}" pattern="dd-MM-yyyy HH:mm" /></td>
                <td><c:out value="${service.imageUrl}" /></td>
            </c:forEach>
        </tr>
    </table>
    <br/>

</div>
</body>
</html>
