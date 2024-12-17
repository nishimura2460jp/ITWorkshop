<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="com.example.Shift" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>シフト一覧</h1>
    <table border="1">
        <tr>
            <th>シフトID</th>
            <th>スタッフID</th>
            <th>シフトタイプID</th>
            <th>シフト日付</th>
        </tr>
        <%
            List<Shift> listShift = (List<Shift>) request.getAttribute("listShift");
            for (Shift shift : listShift) {
        %>
        <tr>
            <td><%= shift.getShiftId() %></td>
            <td><%= shift.getStaffId() %></td>
            <td><%= shift.getShiftTypeId() %></td>
            <td><%= shift.getShiftDate() %></td>
        </tr>
        <% } %>
    </table>
    <div class="return-main">
    <button onclick="location.href='WelcomeServlet'" class="return">TOPに戻る</button>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>