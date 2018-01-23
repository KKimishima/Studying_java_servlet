<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.github.KKimishima.dokoTsubu.model.Tsubu" %>
<%@ page import="com.github.KKimishima.dokoTsubu.model.User" %>
<%@ page import="java.util.List" %>
<%
    User user = (User)session.getAttribute("user");
    List<Tsubu> tsubuList = (List<Tsubu>)application.getAttribute("tsubu");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>つぶやきメインページ</title>
</head>
<body>
    <h1>メインページ</h1>
</body>
</html>