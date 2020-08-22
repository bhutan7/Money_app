<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>収入　一覧</h2>
        <table id="revenue_list">
            <tbody>
                <tr>
                    <th>日付</th>
                    <th>カテゴリ</th>
                    <th>メモ</th>
                    <th>金額</th>
                    <th>編集 </th>
                </tr>
                <c:forEach var="revenue" items="${revenue}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td><c:out value="${revenue.income_at}" /></td>
                        <td>
                        <c:if test="${revenue.category == 0}"> 給与</c:if>
                        <c:if test="${revenue.category == 1}"> 雑所得</c:if>
                        <c:if test="${revenue.category == 2}"> 利子所得</c:if>

                        <c:if test="${revenue.category == 3}"> その他</c:if>
                        </td>
                        <td><c:out value="${revenue.memo}" /></td>
                        <td><c:out value="${revenue.revenue_amount}"/>円</td>

                        <td>

                                    <a href="<c:url value='/revenue/show?id=${revenue.id}' />">詳細を表示</a>


                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${revenue_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((revenue_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/revenue/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='/revenue/new' />">収入入力画面へ</a></p>

    </c:param>
</c:import>