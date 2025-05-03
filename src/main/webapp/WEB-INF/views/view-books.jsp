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
            <a href="/books/">View Books</a>
            <a href="#">Add Book Category</a>
            <a href="#">View Book Category</a>

        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Author Management
            ▼
        </button>
        <div class="dropdown-content">
            <a href="#">Add Author</a>
            <a href="#">View Author</a>
        </div>
    </div>

</div>

<div class="content">
  <h3>Books List</h3>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Code</th>
            <th>ISBN</th>
            <th>Publisher</th>
            <th>Publication Date</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.code}</td>
                <td>${book.isbn}</td>
                <td>${book.publisher}</td>
                <td>${book.publicationDate}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/books/edit/${book.id}">Edit</a> |
                    <a href="${pageContext.request.contextPath}/books/delete/${book.id}" onclick="return confirm('Are you sure You want to Delete this Book?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
