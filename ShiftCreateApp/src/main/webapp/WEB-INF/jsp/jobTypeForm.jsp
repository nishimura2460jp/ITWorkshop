<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<jsp:include page="footer.jsp" />
</body>
</html>