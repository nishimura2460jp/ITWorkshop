<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>シフト表作成－ユーザー登録確認</title>
<link rel="stylesheet" href="http://localhost:8080/ShiftCreateApp/css/style.css">
 <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Kiwi+Maru&display=swap" rel="stylesheet">
<script src="js/script.js" defer></script>
</head>
<body>
<h1>ユーザー登録確認</h1>
<h2>登録内容は以下の通りです。</h2>
<p>名前: ${sessionScope.name}</p>
<p>パスワード: ${sessionScope.pass}</p>
<form action="RegisterConfirmServlet" method="post">
    <button type="submit" name="action" value="confirm">OK</button>
    <button type="submit" name="action" value="edit">編集</button>
</form>

</body>
</html>