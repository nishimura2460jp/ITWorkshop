<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>シフト表作成－希望休登録</title>
<link rel="stylesheet" href="http://localhost:8080/ShiftCreateApp/css/style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Kiwi+Maru&display=swap" rel="stylesheet">
<script src="js/script.js" defer></script>
</head>

<body>
<h1>希望休登録画面</h1>
<form action="SetHolidayServlet" method="post">
    <input type="hidden" name="year" value="${year}">
    <input type="hidden" name="month" value="${month + 1}">
    <input type="hidden" name="day" value="${day}">
    
    <label for="holidayType">休暇の種類を選択:</label>
    <select name="holidayType" id="holidayType">
        <option value="morning">午前休</option>
        <option value="afternoon">午後休</option>
        <option value="full">全休</option>
    </select>
    
    <button type="submit">登録</button>
</form>
<h2>登録した休暇履歴</h2>
<table border="1">
    <thead>
        <tr>
            <th>日付</th>
            <th>休暇の種類</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="entry" items="${holidayHistory}">
            <tr>
                <td>${entry.key}</td>
                <td>${entry.value}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>