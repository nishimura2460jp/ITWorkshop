<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="jakarta.tags.core" %>
   
   <%-- <%@ page import="model.User" %>
   <%   //セッションスコープからユーザー情報を取得
    Name name = (Name)session.getAttribute("name");%>  --%>
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
<%-- <main>
<div id="calendar-container">
<div id="calendar-header">
 <button id="prev-month">&lt; 前の月</button>
 <span id="current-month"></span>
 <button id="next-month">次の月 &gt;</button>
</div>
<table id="calendar">
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
  <tbody id="calendar-body"></tbody>
</table>
</div>
 </main> --%>
    
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