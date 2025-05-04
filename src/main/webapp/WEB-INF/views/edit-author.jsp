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
    <h3>Update Author</h3>
    <form action="${pageContext.request.contextPath}/author/create" method="post">
        Firstname: <input type="text" name="firstname"  value="${author.firstname}" required /> <br/>
        <form:errors path="firstname" cssClass="error" /><br/>
        Lastname: <input type="text" name="lastname" value="${author.lastname}" required/> <br/>
        <form:errors path="lastname" cssClass="error" /><br/>
        Email: <input type="text" name="email" value="${author.email}" /> <br/>
        <form:errors path="email" cssClass="error" /><br/>
        Birth Date: <input type="date" name="birthDate" value="<fmt:formatDate value='${author.birthDate}' pattern='yyyy-MM-dd' />"   required/><br/>
        <form:errors path="birthDate" cssClass="error" /><br/>
        Death Date: <input type="date" name="deathDate" value="<fmt:formatDate value='${author.deathDate}' pattern='yyyy-MM-dd' />"/><br/>
        <form:errors path="deathDate" cssClass="error" /><br/>
        Biography: <textarea name="biography">${author.biography}</textarea><br/>
        <form:errors path="biography" cssClass="error" /><br/>

        <button type="submit">Update Author</button>
    </form>

</div>

</body>
</html>
