<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.github.KKimishima.model.Health" %>
<%
    Health health = (Health) request.getAttribute("health");
%>
<!DOCTYPE html>
<html lang="jp">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Servletの練習</title>
</head>
<body>
    <header>
        <h1>健康診断診断の結果</h1>
        <p>MVCの練習の表示</p>
    </header>
    <div>
        <p>結果</p>
        <p>
            身長:<%= health.getHeight() %><br>
            体重:<%= health.getWeight() %><br>
            BMI:<%= health.getBmi() %><br>
            体型:<%= health.getBodyType() %><br>
        </p>
        <p><a href="/StudyingServlet/HealthCheck">戻る</a></p>
    </div>
</body>
</html>