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
    <a href="/">Home</a>
    <div class="dropdown">
        <button class="dropbtn">Book Management
            ▼
        </button>
        <div class="dropdown-content">
            <a href="/books/create">Add Book</a>
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
   <h3>Add Book</h3>
    <form action="/books/save" method="post">
        Book Title: <input type="text" name="title" /> <br/>
        Book Code: <input type="text" name="code" /> <br/>
        Book ISBN: <input type="text" name="isbn" /> <br/>
        Publication Date: <input type="date" name="publicationDate" /><br/>
        Book Publisher: <input type="text" name="publisher" /><br/>
        <button type="submit">Create</button>
    </form>
</div>

</body>
</html>
