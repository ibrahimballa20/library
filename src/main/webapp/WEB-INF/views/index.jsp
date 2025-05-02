<%@ page language="java" contentType="text/html; charset=UTF-8"

         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Library Management System</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

<div class="navbar">
    <a href="#home">Home</a>
    <div class="dropdown">
        <button class="dropbtn">Book Management
            ▼
        </button>
        <div class="dropdown-content">
            <a href="#">Add Book</a>
            <a href="#">Edit Book</a>
            <a href="#">View Books</a>
            <a href="#">Add Book Category</a>
            <a href="#">View Book Category</a>
            <a href="#">Edit Book Category</a>

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
    <h1>Welcome to the Library Management System Assignment for Building Database Application Course</h1>
</div>

</body>
</html>
