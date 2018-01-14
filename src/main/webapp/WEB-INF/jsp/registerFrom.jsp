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
        <h1>ユーザ登録登録</h1>
        <p>登録用のフォームを表示</p>
    </header>
    <div>
        <p>登録フォーム</p>
        <form action="/StudyingServlet/RegisterUser" method="post">
            ログインID:<input type="text" name="id"><br>
            パワード:<input type="password" name="pass"><br>
            名前:<input type="text" name="name"><br>
            <input type="submit" value="確認">
        </form>
    </div>
</body>
</html>