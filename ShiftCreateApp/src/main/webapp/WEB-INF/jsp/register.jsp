<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>シフト表作成－新規ユーザー登録(希望休の入力)</title>
<link rel="stylesheet" href="http://localhost:8080/ShiftCreateApp/css/style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Fredericka+the+Great&family=Stick&family=Yusei+Magic&display=swap" rel="stylesheet">
</head>

<body>
<h1>新規ユーザー登録画面</h1>
<form action="RegisterUserServlet" method="post">
    <label for="name">名前:</label>
    <input type="text" id="name" name="name" required><br>
    <label for="pass">パスワード:</label>
    <input type="password" id="pass" name="pass" required><br>
    <button type="submit">登録確認</button>
</form>
<jsp:include page="footer.jsp" />
</body>
</html>