<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
     <img src="images/main.jpeg" alt="ペンを持ったロボット" class="logo2">
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
            
            <label for="closed-days">休業日(曜日指定):</label>
<!-- 曜日指定チェックボックス -->
<div class="weekdays-checkboxes">
    <input type="checkbox" id="sunday" name="closed-weekdays" value="sunday">
    <label for="sunday">日曜</label>

    <input type="checkbox" id="monday" name="closed-weekdays" value="monday">
    <label for="monday">月曜</label>

    <input type="checkbox" id="tuesday" name="closed-weekdays" value="tuesday">
    <label for="tuesday">火曜</label>

    <input type="checkbox" id="wednesday" name="closed-weekdays" value="wednesday">
    <label for="wednesday">水曜</label>

    <input type="checkbox" id="thursday" name="closed-weekdays" value="thursday">
    <label for="thursday">木曜</label>

    <input type="checkbox" id="friday" name="closed-weekdays" value="friday">
    <label for="friday">金曜</label>

    <input type="checkbox" id="saturday" name="closed-weekdays" value="saturday">
    <label for="saturday">土曜</label>
</div>

<!-- その他、手入力による日付 -->
<label for="additional-closed-days">その他、休業日 (カンマ区切りで入力):</label>
<textarea id="additional-closed-days" name="additional-closed-days" placeholder="例: 2024-11-03,2024-11-04" rows="2"></textarea>

<label for="staff-conditions">シフト割当条件:</label>
<div>
    <input type="checkbox" id="consecutive" name="staff-conditions" value="consecutive">
    <label for="consecutive">連続して同じ業務設定不可</label>
</div>

            <button type="submit" class="creat">シフトを作成</button>
          </form>
      </section>
  </main>

<div class="return-main">
    <button onclick="location.href='WelcomeServlet'" class="return">TOPに戻る</button>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>