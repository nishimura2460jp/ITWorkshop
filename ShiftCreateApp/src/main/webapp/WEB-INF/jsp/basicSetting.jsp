<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>シフト表作成アプリ-基本設定</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kiwi+Maru&display=swap" rel="stylesheet">
    <script src="js/script.js"></script>
</head>

<body>
 <div class="image-container">
        <img src="images/main.jpeg" alt="ペンを持ったロボット" class="logo2">
    </div>
    <header>
        <h1>基本設定</h1>
    </header>
    <a href="JobTypeServlet">業務の種類登録</a><br>
    <a href="ShiftTypeServlet">シフトの種類登録</a><br>
    <a href="StaffServlet">スタッフ登録</a><br>
    
    <div class="return-main">
        <button onclick="location.href='WelcomeServlet'" class="return">TOPに戻る</button>
    </div>

    <jsp:include page="footer.jsp" />
</body>
</html>