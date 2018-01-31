<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.github.KKimishima.dokoTsubu.model.User" %>
<%
   User user = (User) session.getAttribute("user");
%>

<jsp:include page="/WEB-INF/jsp/DokoTsubuHead.jsp" />
<body>
    <jsp:include page="/WEB-INF/jsp/DokoTsubuHeder.jsp" />
    <h1>つぶやきシステムログイン</h1>
    <%if(user != null){%>
    <h2>ログイン成功</h2>
    <p>ようこそつぶやきシステム</p>
    <a href="/StudyingServlet/DokoTsubuMain">メインページへ</a>
    <% }else{ %>
    <h2>ログイン失敗</h2>
    <p>正しいユーザ名とパスワードを入力したください!!</p>
        <a href="/StudyingServlet/jsp/TsubuIndex.jsp">Topへ</a>
    <%}%>

    <jsp:include page="/WEB-INF/jsp/DokoTsubuFooter.jsp" />
</body>
</html>