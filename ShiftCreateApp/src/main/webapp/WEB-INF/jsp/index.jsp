<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>シフト表作成アプリ</title>
<link rel="stylesheet" href="css/style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Kiwi+Maru&display=swap" rel="stylesheet">

<script src="js/script.js"></script>
</head>

<body>
<header>
<h1>シフト表 作成アプリ</h1>
</header>
 <div class="image-container">
 <img src="images/main.jpeg" alt="可愛いロボット" class="logo">
 </div>
 <main>
   <section id="main-menu">
            <h2>&#9661; メインメニュー &#9661;</h2>
            <h3>管理者&#128221;</h3>
            <button onclick="location.href='setting.jsp'" target="_blank" rel="noopener noreferrer">基本設定</button>
            <button onclick="location.href='shift-creat.jsp'" target="_blank" rel="noopener noreferrer">シフト作成の準備・作成</button>
          <%--  <button onclick="location.href='data-management.jsp'" target="_blank" rel="noopener noreferrer">データ管理</button> --%>
            <h3>スタッフ&#128221;</h3>
            <a>希望休の入力</a><br>
            <button onclick="location.href='LoginServlet'" target="_blank" rel="noopener noreferrer">ログイン</button>
            <button onclick="location.href='LoginServlet'" target="_blank" rel="noopener noreferrer">新規登録</button>
   </section> 
 </main>

<jsp:include page="footer.jsp"/>
</body>
</html>