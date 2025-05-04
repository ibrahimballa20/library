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
    <h3>Create Book</h3>
    <form action="${pageContext.request.contextPath}/books/create" method="post">
        Book Title: <input type="text" name="title"  /> <br/>
        <form:errors path="title" cssClass="error" /><br/>
        Book Code: <input type="text" name="code" /> <br/>
        <form:errors path="code" cssClass="error" /><br/>
        Book ISBN: <input type="text" name="isbn"  /> <br/>
        <form:errors path="isbn" cssClass="error" /><br/>
        Publication Date: <input type="date" name="publicationDate" required/><br/>
        <form:errors path="publicationDate" cssClass="error" /><br/>
        Book Publisher: <input type="text" name="publisher" required/><br/>
        <form:errors path="publisher" cssClass="error" /><br/>
        Book Category:
        <select id="category" name="category.id" required>
            <option value="">-- Select Category --</option>
            <c:forEach var="category" items="${categories}">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
        <form:errors path="category" cssClass="error" /><br/>
        Book Author/Authors:
        <select id="author" name="authorIds"  multiple required>
            <option value="">-- Select Author --</option>
            <!-- Iterate through the authors list passed from the controller -->
            <c:forEach var="author" items="${authors}">
                <option value="${author.id}">${author.firstname} ${author.lastname}</option>
            </c:forEach>
        </select>
        <br/>
        <button type="submit">Create</button>
    </form>

</div>

</body>
</html>
