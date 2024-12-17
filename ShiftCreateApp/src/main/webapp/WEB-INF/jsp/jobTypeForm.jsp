<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>シフト表作成－業務の種類登録</title>
<link rel="stylesheet" href="css/style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Kiwi+Maru&display=swap" rel="stylesheet">

<script src="js/script.js"></script>

</head>
<body>
 <h2>業務の種類登録</h2>
    <form action="JobTypeServlet" method="POST">
      <label>業務名: </label><input type="text" name="jobName"><br>
      <label>スタッフ配員数: </label><input type="number" name="staffCount"><br>
      <input type="submit" value="登録">
    </form>

 <!-- 登録済業務の表示 -->
    <h3>登録済み業務リスト</h3>
    <table border="1">
        <thead>
            <tr>
                <th>業務ID</th>
                <th>業務名</th>
                <th>必要スタッフ数</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="jobType" items="${jobTypes}">
                <tr>
                    <td>${jobType.jobId}</td>
                    <td>${jobType.jobName}</td>
                    <td>${jobType.staffRequired}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="return-basicsetting">
        <button onclick="location.href='BasicSettingServlet'" class="return">基本設定に戻る</button>
    </div>
<jsp:include page="footer.jsp" />
</body>
</html>