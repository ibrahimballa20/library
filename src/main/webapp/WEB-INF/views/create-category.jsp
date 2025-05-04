<%@ page language="java" contentType="text/html; charset=UTF-8"

         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Library Management System</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

<div class="navbar">
    <a href="/">Home</a>
    <div class="dropdown">
        <button class="dropbtn">Book Management
            ▼
        </button>
        <div class="dropdown-content">
            <a href="/books/create">Add Book</a>
            <a href="/books/index">View Books</a>
            <a href="/category/create">Add Book Category</a>
            <a href="/category/index">View Book Category</a>

        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Author Management
            ▼
        </button>
        <div class="dropdown-content">
            <a href="/author/create">Add Author</a>
            <a href="/author/index">View Author</a>
        </div>
    </div>

</div>

<div class="content">
    <h3>Create Book Category</h3>
    <form action="${pageContext.request.contextPath}/category/create" method="post">
        Category Name: <input type="text" name="name"  /> <br/>
        <form:errors path="title" cssClass="error" /><br/>
        Category Code: <input type="text" name="code" /> <br/>
        <form:errors path="code" cssClass="error" /><br/>

        <button type="submit">Create Category</button>
    </form>

</div>

</body>
</html>
