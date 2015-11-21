<%-- 
    Document   : registration
    Created on : Oct 11, 2015, 7:04:19 AM
    Author     : gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Registration</title>
    </head>
    <body>
        <h1>${message}</h1>
        <table>
            <tr>
                <td><fmt:message key="registration.firstName" /></td>
                <td><c:out value="${registration.firstName}" /></td>
            </tr>
            <tr>
                <td><fmt:message key="registration.lastName" /></td>
                <td><c:out value="${registration.lastName}" /></td>
            </tr>
            <tr>
                <td><fmt:message key="registration.dateOfBirth" /></td>
                <td><fmt:formatDate value="${registration.dateOfBirth}" pattern="dd/MM/yyyy"/></td>
            </tr>
            <tr>
                <td><fmt:message key="registration.gender" /></td>
                <td>${registration.gender}</td>
            </tr>
            <tr>
                <td><fmt:message key="registration.request" /></td>
                <td><pre><c:out value="${registration.request}" /></pre></td>
            </tr>
        </table>
    </body>
</html>

