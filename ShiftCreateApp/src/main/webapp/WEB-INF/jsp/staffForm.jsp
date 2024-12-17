<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>シフト表作成-スタッフ登録</title>
 <link rel="stylesheet" href="css/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kiwi+Maru&display=swap" rel="stylesheet">
    <script src="js/script.js"></script>
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
          <option value="${job.jobId}">${job.jobName}</option>
        </c:forEach>
      </select><br><br>
      <p>複数選択可能(Ctrl)</p>

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
          <option value="${shift.shiftId}">${shift.shiftName}</option>
        </c:forEach>
      </select><br><br>

      <input type="submit" value="登録">
    </form><br>
    
    <h3>登録済みスタッフ一覧</h3>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>名前</th>
            <th>勤務日数 (週)</th>
            <th>シフト種類</th>
        </tr>
        <c:forEach var="staff" items="${staffList}">
            <tr>
                <td>${staff.staffId}</td>
                <td>${staff.staffName}</td>
                <td>${staff.weeklyWorkDays}</td>
                <td>${staff.shiftName}</td>
            </tr>
        </c:forEach>
    </table>
    <div class="return-basicsetting">
        <button onclick="location.href='BasicSettingServlet'" class="return">基本設定に戻る</button>
    </div>
 <jsp:include page="footer.jsp" />
</body>
</html>