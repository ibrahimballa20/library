<%@ page language="java" contentType="text/html; charset=UTF-8"

         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h3>Book Category List</h3>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Category Name</th>
            <th>Category Code</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="category" items="${categories}">
            <tr>
                <td>${category.id}</td>
                <td>${category.name}</td>
                <td>${category.code}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/category/edit/${category.id}">Edit</a> |
                    <a href="${pageContext.request.contextPath}/category/delete/${category.id}" onclick="return confirm('Are you sure You want to Delete this Book Category?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
