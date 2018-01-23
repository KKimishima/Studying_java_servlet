<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>つぶやきシステム</title>
</head>
<body>
    <h1>つぶやきシステムログイン</h1>
    <p>ユーザ名とパスワード入力してくださう</p>
    <form action="/StudyingServlet/dokoTsubLogin" method="post">
    ユーザ名:<input type="text" name="name" id="name"><br>
    パスワード:<input type="password" name="pass" id="pass"><br>
    <input type="submit" value="ログイン">
    </form>
</body>
</html>