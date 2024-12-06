<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
 <%-- デフォルトページ --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン－希望休の入力へ</title>
<link rel="stylesheet" href="http://localhost:8080/ShiftCreateApp/css/style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Fredericka+the+Great&family=Stick&family=Yusei+Magic&display=swap" rel="stylesheet">
</head>

<body>
<h1>ログイン画面</h1>
<form action="Login" method="post">
ユーザー名：<input type="text" name="name" class="login"><br>
パスワード：<input type="password" name="pass" class="login"><br>
<input type="submit" value="ログイン" class="btn">
</form>
<jsp:include page="footer.jsp" />
</body>
</html>