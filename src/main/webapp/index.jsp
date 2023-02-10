<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Todo List</title>
</head>
<body>
<div class="container">
    <h1 class="text-center my-5">Todo List</h1>
    <form action="todo" method="post">
        <div class="form-group">
            <input type="text" class="form-control" name="todo" placeholder="Enter Todo">
        </div>
        <button type="submit" class="btn btn-primary">Add Todo</button>
    </form>
    <%
        List<String> todoList = (List<String>) session.getAttribute("todoList");
        if (todoList != null) {
    %>
    <ol class="my-5">
        <%
            for (String todo : todoList) {
        %>
        <li><%= todo %></li>
        <%
            }
        %>
    </ol>
    <%
        }
    %>
</div>
</body>
</html>
