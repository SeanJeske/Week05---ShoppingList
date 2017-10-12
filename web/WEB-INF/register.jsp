<%-- 
    Document   : register
    Created on : Oct 10, 2017, 10:02:44 AM
    Author     : Sean Jeske
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <form action="shoppingList?action=register" method="POST">
        Username:
        <input type="text" name="username"/>
        <br />
        <br />
        <input type="submit" value="Register Name"/>
        </form>
    </body>
</html>
