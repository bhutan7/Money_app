<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>MoneyApp</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <div id="header_menu">
                    <h1><a href="<c:url value='/' />">家計簿app</a></h1>&nbsp;&nbsp;&nbsp;
                    <c:if test="${sessionScope.login_users != null}">
                       <c:if test="${sessionScope.login_users.admin_flag == 1}">
                            <a href="<c:url value='/expenditure/index' />">支出管理</a>&nbsp;
                        </c:if>
                        <a href="<c:url value='/revenue/index' />">収入管理</a>&nbsp;
                    </c:if>
                </div>
                <c:if test="${sessionScope.login_users != null}">
                    <div id="user_name">
                        <c:out value="${sessionScope.login_users.name}" />&nbsp;さん&nbsp;&nbsp;&nbsp;
                        <a href="<c:url value='/logout' />">ログアウト</a>
                    </div>
                </c:if>

            </div>
            <div id="content">
                ${param.content}
            </div>
            <div id="footer">
                by Hiro Kuwa.
            </div>
        </div>
    </body>
</html>