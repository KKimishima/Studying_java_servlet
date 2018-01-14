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
        <h1>健康診断診断アプリ</h1>
        <p>MVCの練習</p>
    </header>
    <div>
        <p>診断フォーム</p>
        <form action="/StudyingServlet/HealthCheck" method="post">
            身長:<input type="text" name="height">(cm)<br>
            体重:<input type="text" name="weight">(kg)<br>
            <input type="submit" value="診断">
        </form>
    </div>
</body>
</html>