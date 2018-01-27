<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.github.KKimishima.dokoTsubu.model.Tsubu" %>
<%@ page import="com.github.KKimishima.dokoTsubu.model.User" %>
<%@ page import="java.util.List" %>
<%
    User user = (User)session.getAttribute("user");
    List<Tsubu> tsubuList = (List<Tsubu>)application.getAttribute("tsubu");
    String error = (String)request.getAttribute("errorMs");
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
    <p>
        <%= user.getName()%>さんログイン中
    </p>
    <p><a href="/StudyingServlet/DokoTsubuLogoff">ログアウト</a></p>
    <p><a href="/StudyingServlet/DokoTsubuMain">更新</a></p>
    <h2>つぶやき一覧</h2>
    <ul>
        <% for(Tsubu tb: tsubuList){ %>
            <li><%=tb.getUserName()%>:<%= tb.getTex() %></li>
        <% }%>
    </ul>
    <h2>つぶやき投稿</h2>
    <form action="/StudyingServlet/DokoTsubuMain" method="post">
        <input type="text" name="text" id="text">
        <input type="submit" value="つぶやく">
    </form>
    <% if(error != null){ %>
        <p><%= error%></p>
    <% }%>

</body>
</html>