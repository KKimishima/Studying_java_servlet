<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.github.KKimishima.dokoTsubu.model.User" %>
<%
   User user = (User) session.getAttribute("user");
%>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>つぶやきシステムログイン結果</title>
</head>
<body>
    <h1>つぶやきシステムログイン</h1>
    <%if(user != null){%>
    <h2>ログイン成功</h2>
    <p>ようこそつぶやきシステム</p>
    <% }else{ %>
    <h2>ログイン失敗</h2>
    <p>正しいユーザ名とパスワードを入力したください!!</p>
    <%}%>
</body>
</html>