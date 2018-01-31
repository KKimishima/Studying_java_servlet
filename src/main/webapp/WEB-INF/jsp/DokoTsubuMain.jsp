<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/DokoTsubuHead.jsp" />
<body>
    <jsp:include page="/WEB-INF/jsp/DokoTsubuHeder.jsp" />
    <h1>メインページ</h1>
    <p>
        <c:out value="${user.getName()}" /> さんログイン中
    </p>
    <p><a href="/StudyingServlet/DokoTsubuLogoff">ログアウト</a></p>
    <p><a href="/StudyingServlet/DokoTsubuMain">更新</a></p>
    <h2>つぶやき一覧</h2>
    <ul>
        <c:forEach var="t" items="${tsubu}" >
            <li><c:out value="${t.getUserName()}" />:<c:out value="${t.getTex()}"/></li>
        </c:forEach>
    </ul>
    <h2>つぶやき投稿</h2>
    <form action="/StudyingServlet/DokoTsubuMain" method="post">
        <input type="text" name="text" id="text">
        <input type="submit" value="つぶやく">
    </form>
    <c:if test="${not empty errorMs}" >
        <p>${errorMs}</p>
    </c:if>
    <p>訪問回数:<c:out value="${initTest.getInitTest()}"/> </p>

    <jsp:include page="/WEB-INF/jsp/DokoTsubuFooter.jsp" />
</body>
</html>