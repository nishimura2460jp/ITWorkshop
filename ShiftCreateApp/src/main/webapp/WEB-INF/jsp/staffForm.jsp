<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>スタッフ登録</h1>
    <form action="StaffServlet" method="POST">
      <label>氏名:</label>
      <input type="text" name="staffName" required><br><br>

      <label>スキル（業務の種類）:</label><br>
      <select name="jobTypes" multiple size="5">
        <!-- 業務の種類のデータはサーブレットで取得し表示 -->
        <c:forEach var="job" items="${jobTypes}">
          <option value="${job.id}">${job.job_name}</option>
        </c:forEach>
      </select><br><br>

      <label>勤務形態（週○日勤務）:</label>
      <select name="weeklyWorkDays">
        <option value="1">週1日</option>
        <option value="2">週2日</option>
        <option value="3">週3日</option>
        <option value="4">週4日</option>
        <option value="5">週5日</option>
      </select><br><br>

      <label>シフト種類:</label>
      <select name="shiftType">
        <!-- シフトの種類のデータもサーブレットで取得し表示 -->
        <c:forEach var="shift" items="${shiftTypes}">
          <option value="${shift.id}">${shift.shift_name}</option>
        </c:forEach>
      </select><br><br>

      <input type="submit" value="登録">
    </form>
    
 <jsp:include page="footer.jsp" />
</body>
</html>