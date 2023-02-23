<%-- 
    Document   : login
    Created on : Feb 20, 2023, 11:08:33 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LOGIN PAGE</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Please login</h1>

        <form action="./LoginServlet" name="" method="POST">
            <input name="user" type="text">
            <input name="password" type="password">
            <input value="Login" type="submit">
        </form>
    </body>
</html>
