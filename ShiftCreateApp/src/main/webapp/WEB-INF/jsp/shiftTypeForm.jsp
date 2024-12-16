<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>シフト表作成－シフトの種類登録</title>
<link rel="stylesheet" href="css/style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Kiwi+Maru&display=swap" rel="stylesheet">

<script src="js/script.js"></script>
</head>
<body>
<form action="ShiftTypeServlet" method="POST">
        <label>シフト名: </label><input type="text" name="shiftName"><br>
        <input type="submit" value="登録">
    </form>

    <h2>登録済みのシフトの種類</h2>
    <!-- shiftTypes が空でない場合のみ表示 -->
    <select>
        <c:if test="${not empty shiftTypes}">
         <ul>
            <c:forEach var="shift" items="${shiftTypes}">
                <li>${shift.shiftName}</li>
            </c:forEach>
        </ul>
            </c:forEach>
        </c:if>
        <!-- shiftTypes が空の場合のメッセージ -->
        <c:if test="${empty shiftTypes}">
            <option disabled>シフトの種類は登録されていません。</option>
        </c:if>
    </select>

<jsp:include page="footer.jsp" />
</body>
</html>