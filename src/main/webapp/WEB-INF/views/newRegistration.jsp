<%-- 
    Document   : form
    Created on : Oct 10, 2015, 12:04:15 AM
    Author     : gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Registration</title>
    </head>
    <body>
        <h1><fmt:message key="registration.new" /></h1>
        <form:form commandName="registration" action="create" method="POST">
            <table>
                <tr>
                    <td><form:label path="firstName"><fmt:message key="registration.firstName" /></form:label></td>
                    <td><form:input path="firstName" /><form:errors path="firstName" /></td>
                </tr>
                <tr>
                    <td><form:label path="lastName"><fmt:message key="registration.lastName" /></form:label></td>
                    <td><form:input path="lastName" /><form:errors path="lastName" /></td>
                </tr>
                <tr>
                    <td><form:label path="dateOfBirth"><fmt:message key="registration.dateOfBirth" /></form:label></td>
                    <td><form:input path="dateOfBirth" placeholder="dd/mm/yyyy" /><form:errors path="dateOfBirth" /></td>
                </tr>
                <tr>
                    <td><form:label path="gender">Male</form:label></td>
                    <td><form:radiobutton path="gender" value="MALE"/><form:errors path="gender" /></td>
                </tr>
                <tr>
                    <td><form:label path="gender">Female</form:label></td>
                    <td><form:radiobutton path="gender" value="FEMALE"/></td>
                </tr>
                <tr>
                    <td><form:label path="request"><fmt:message key="registration.request" /></form:label></td>
                    <td><form:textarea path="request" /><form:errors path="request" /></td>
                </tr>
                <tr>
                    <fmt:message key="registration.confirm" var="submitMessage" />
                    <td><input type="submit" value="${submitMessage}" ></td>
                </tr>
            </table>            
        </form:form>
    </body>
</html>