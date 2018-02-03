<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/DokotsubuDBHead.jsp" />
<body>
    <jsp:include page="/WEB-INF/jsp/DokotsubuDBHeader.jsp" />
    <h2>メインページ</h2>
        <p>
            <c:out value="${user.getUserName()}" />さんログイン中
        </p>
        <p> <a href ="/StudyingServlet/dokoTsubuDB/Logoff">ログオフ</a>
        <p><a href  ="/StudyingServlet/dokoTsubuDB/MainPage">更新</a></p>
    <h2>つぶやき一覧</h2>
        <ul>
            <c:forEach var="t" items="${tubuyakiList}" >
                <li>
                    <c:out value="${t.getId()}" />:
                    <c:out value="${t.getUserName()}" />:
                    <c:out value="${t.getTex()}"/>
                </li>
          </c:forEach>
        </ul>
    <h2>つぶやき投稿</h2>
        <form action="/StudyingServlet/dokoTsubuDB/MainPage" method="post">
            <input type="text" name="text" id="text">
            <input type="submit" value="つぶやく">
        </form>
    <c:if test="${not empty errorMs}" >
        <p>${errorMs}</p>
    </c:if>
    <jsp:include page="/WEB-INF/jsp/DokotsubuDBFooter.jsp" />
</body>
