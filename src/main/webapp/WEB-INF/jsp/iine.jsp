<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.github.KKimishima.iineModel.SiteI" %>
<%
    SiteI siteI = (SiteI)application.getAttribute("siteI");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>いいねカウントシステム</title>
</head>
<body>
    <h1>いいねカウントシステム</h1>
    <p>
        いいねをカウントするシステムです<br>
        likeかdislikeをクリックしてください
    </p>
    <p>
        <a href="/StudyingServlet/IineIServe?action=like">いいね</a>
        <%= siteI.getLike() %>人
        <a href="/StudyingServlet/IineIServe?action=dislike">わるい</a>
        <%= siteI.getDislike() %>人
    </p>
</body>
</html>