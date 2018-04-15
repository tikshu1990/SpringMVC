<%--
  Created by IntelliJ IDEA.
  User: z013t46
  Date: 12/14/17
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee Details JSP</title>
</head>
<body>
<table bgcolor="#f0f8ff" border="1" width="100%">
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>
    </th>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td bgcolor="#add8e6"><c:out value="${employee.firstName}"/></td>
            <td bgcolor="#add8e6"><c:out value="${employee.lastName}"/></td>
            <td bgcolor="#add8e6"><c:out value="${employee.emailId}"/></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
