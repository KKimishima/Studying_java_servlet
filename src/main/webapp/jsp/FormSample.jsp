<%@ page contentType="text/html; charset=UTF-8" %>
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
        <h1>フォーム送信</h1>
        <p>サーブレットのgetやpost名など練習を行う</p>
    </header>
    <div>
        <form action="/StudyingServlet/FormSample" method="post">
            名前<input type="text" name="name"><br>
            性別:
            <input type="radio" name="sex" value="0">
            <input type="radio" name="sex" value="1"><br>
            <input type="hidden" name="epoc" value="<%= System.currentTimeMillis() %>">
            <input type="submit" value="送信">
        </form>
    </div>
</body>
</html>