<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/DokotsubuDBHead.jsp" />
<body>
    <jsp:include page="/WEB-INF/jsp/DokotsubuDBHeader.jsp" />
    <h1>つぶやきシステムログイン</h1>

    <c:if test="${not empty user}" >
    <h2>ログイン成功</h2>
    <p>ようこそつぶやきシステム</p>
    <a href="/StudyingServlet/dokoTsubuDB/MainPage"">メインページへ</a>
    </c:if>

    <c:if test="${empty user}" >
    <h2>ログイン失敗</h2>
    <p>正しいユーザ名とパスワードを入力したください!!</p>
        <a href="/StudyingServlet/jsp/TsubuDBIndex.jsp">Topへ</a>
    </c:if>

    <jsp:include page="/WEB-INF/jsp/DokotsubuDBFooter.jsp" />
</body>
</html>