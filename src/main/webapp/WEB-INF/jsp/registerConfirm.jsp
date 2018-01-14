<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.github.KKimishima.LoginModel.User" %>
<%
    User user = (User)session.getAttribute("registerUser");
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
        <h1>登録内容の内容の確認</h1>
        <p>先程入力した内容の確認</p>
    </header>
    <div>
        <p>確認</p>
        <p>
            ログインID:<%= user.getId() %><br>
            名前:<%= user.getName() %><br>
        </p>
        <p><a href="/StudyingServlet/RegisterUser">戻る</a></p>
        <p><a href="/StudyingServlet/RegisterUser?aciton=done">登録</a></p>
    </div>
</body>
</html>