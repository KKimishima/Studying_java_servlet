<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:include page="/WEB-INF/jsp/DokoTsubuHead.jsp" />
<body>
    <jsp:include page="/WEB-INF/jsp/DokoTsubuHeder.jsp" />
    <h2>つぶやきシステムログイン</h1>
    <p>ユーザ名とパスワード入力してくださう</p>
    <form action="/StudyingServlet/dokoTsubuDB/Login" method="post">
    ユーザ名:<input type="text" name="name" id="name"><br>
    パスワード:<input type="password" name="pass" id="pass"><br>
    <input type="submit" value="ログイン">
    </form>
    <jsp:include page="/WEB-INF/jsp/DokoTsubuFooter.jsp" />
</body>
</html>