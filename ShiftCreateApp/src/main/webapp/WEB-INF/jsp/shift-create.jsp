<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>シフト表作成アプリ-シフト作成</title>
<link rel="stylesheet" href="css/style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Kiwi+Maru&display=swap" rel="stylesheet">
<script src="js/script.js"></script>
</head>

<body>
<div class="image-container">
     <img src="images/main.jpeg" alt="可愛いロボット" class="logo2">
</div>
<header>
  <h1>シフト作成の準備</h1>
</header>
  <main>
     <section id="shift-creation">
        <form action="/generate-shift" method="post">
            <label for="shift-period">シフト作成対象期間:</label>
            <input type="date" id="shift-period-start" name="shift-period-start"> 〜
            <input type="date" id="shift-period-end" name="shift-period-end">
            
             <label for="closed-days">休業日:</label>
             <input type="text" id="closed-days" name="closed-days" placeholder="例: 2024-11-03">
            
             <label for="staff-count">必要なスタッフ人数:</label>
             <input type="number" id="staff-count" name="staff-count" min="1">
            
             <label for="staff-conditions">スタッフ別のシフト割当条件:</label>
             <textarea id="staff-conditions" name="staff-conditions" rows="4" placeholder="条件を入力"></textarea>
             <button type="submit" class="creat">シフトを作成</button>
          </form>
            
      </section>
  </main>

<div class="return-main">
   <button onclick="location.href='index.html'" class="return">メインメニューに戻る</button>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>