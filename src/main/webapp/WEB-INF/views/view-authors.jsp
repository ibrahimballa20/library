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
    <h3>Author List</h3>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Email</th>
            <th>Birth Date</th>
            <th>Death Date</th>
            <th>Biography</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="author" items="${authors}">
            <tr>
                <td>${author.id}</td>
                <td>${author.firstname}</td>
                <td>${author.lastname}</td>
                <td>${author.email}</td>
                <td>${author.birthDate}</td>
                <td>${author.deathDate}</td>
                <td>${author.biography}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/author/edit/${author.id}">Edit</a> |
                    <a href="${pageContext.request.contextPath}/author/delete/${author.id}" onclick="return confirm('Are you sure You want to Delete this Book Category?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
