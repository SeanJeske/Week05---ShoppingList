<%-- 
    Document   : shoppingList
    Created on : Oct 10, 2017, 10:03:04 AM
    Author     : Sean Jeske
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello, ${username}
        <br />
        <a href="shoppingList?action=logout">Logout</a>
        <br />
        <h1>Your List</h1>
        <br />
         <form action="shoppingList?action=add" method="post">
            Add item: <input type="text" name="item" value="${toAdd}"/>
            <input type="submit" value="Add item"/>
         </form>
            <c:if test="${fn:length(items) gt 0}">
                <form action="shoppingList?action=delete" method="POST">
                    <c:forEach var="i" items="${items}">
                        <input type="radio" name="listItem" value="${i}"/>${i}
                        <br />
                    </c:forEach>
                        <br />
                    <input type="submit" value="Delete item" />
                 </form>
            </c:if> 
    </body>
</html>
