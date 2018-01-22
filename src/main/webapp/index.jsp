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
        <h1>サーブレットの練習</h1>
        <p>サーブレットのgetやpost名など練習を行う</p>
    </header>
    <div>
    <section>
        <h1>サーブレにgetリクエストを送り文字を表示させる</h1>
        <a href="/StudyingServlet/Hello">リクエスト送る</a>
    </section>
    <section>
        <h1>占いアプリケーション起動</h1>
        <a href="/StudyingServlet/UranaiApp">リクエスト送る</a>
    </section>
    <section>
        <h1>jsp機能だけ使って使って占いアプリ実行</h1>
        <a href="/StudyingServlet/jsp/UranaiJspApp.jsp">リクエスト送る</a>
    </section>
     <section>
         <h1>フォームからpostメソッド送信</h1>
         <a href="/StudyingServlet/jsp/FormSample.jsp">ページを開く</a>
      </section>
      <section>
         <h1>リクエスからのフォアード</h1>
            <a href="/StudyingServlet/Forwarded">ページを開く</a>
       </section>
        <section>
          <h1>リクエスからのリダイレクト練習</h1>
          <p>占いアプリケーションにリダレクト</p>
             <a href="/StudyingServlet/UranaiApp">ページを開く</a>
        </section>
        <section>
           <h1>MVC練習</h1>
            <p>MVCを利用して健康診断アプリ</p>
                <a href="/StudyingServlet/HealthCheck">ページを開く</a>
        </section>
        <section>
            <h1>セッションごとのスコープ</h1>
            <p>ユーザ登録</p>
                <a href="/StudyingServlet/RegisterUser">ページを開く</a>
        </section>
        <section>
            <h1>アプリケーションごとののスコープ</h1>
            <p>いいねシステム</p>
            <a href="/StudyingServlet/RegisterUser">ページを開く</a>
        </section>
    </div>
</body>
</html>