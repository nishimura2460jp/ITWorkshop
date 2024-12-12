<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="jakarta.tags.core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>シフト表作成アプリ-希望休の入力</title>
<link rel="stylesheet" href="http://localhost:8080/ShiftCreateApp/css/style.css">
 <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Kiwi+Maru&display=swap" rel="stylesheet">
<script src="js/script.js" defer></script>
</head>

<body>
<h1>希望休の入力</h1>
<% String name = (String) session.getAttribute("name"); %>
<% if(name != null) { %>
<p>ログインに成功しました！</p>
<p>ようこそ！<%= name %> さん</p>
<!-- 年月の表示と前月・翌月ボタン -->
<form action="CalendarServlet" method="get">
    <button type="submit" name="year" value="${prevYear}" >前月</button>
    <span>${year}年 ${month}月</span>
    <button type="submit" name="year" value="${nextYear}" >翌月</button>
    <input type="hidden" id="month" name="month" value="${month}" />
</form>

<!-- カレンダー表示 -->
<table border="1">
    <thead>
        <tr>
            <th>日</th>
            <th>月</th>
            <th>火</th>
            <th>水</th>
            <th>木</th>
            <th>金</th>
            <th>土</th>
        </tr>
    </thead>
    <c:if test="${empty calendar}">
    <p>カレンダーが表示できません。calendarの内容は空です。</p>
</c:if>
    <tbody>
       <c:forEach var="week" items="${calendar}">
    <tr>
        <c:forEach var="day" items="${week}">
            <td>
                <c:if test="${not empty day}">
                    <form action="SetHolidayServlet" method="post">
                        <input type="hidden" name="year" value="${year}" />
                        <input type="hidden" name="month" value="${month}" />
                        <input type="hidden" name="day" value="${day}" />
                        <input type="submit" value="${day}" />
                    </form>
                </c:if>
            </td>
        </c:forEach>
    </tr>
</c:forEach>
    </tbody>
</table>
    
<div class="return-main">
    <button onclick="location.href='WelcomeServlet'" class="return">TOPに戻る</button>
</div>
<%} else { %>
<p>ログインに失敗しました</p> 
<a href="WelcomeServlet">TOPへ戻る</a>
<% } %>  

<jsp:include page="footer.jsp" />
</body>
</html>