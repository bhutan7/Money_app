<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${revenue != null}">
                <h2>収入　詳細ページ</h2>

                <table>
                    <tbody>
                        <tr>
                            <th>金額</th>
                            <td><c:out value="${revenue.revenue_amount}" /></td>
                        </tr>
                        <tr>
                            <th>カテゴリ</th>
                            <td>
                                <c:if test="${revenue.category == 0}">給与</c:if>
                                 <c:if test="${revenue.category == 1}"> 雑所得</c:if>
                                <c:if test="${revenue.category == 2}"> 利子所得</c:if>
                                <c:if test="${revenue.category == 3}"> その他</c:if>

                             </td>
                        </tr>
                        <tr>
                            <th>メモ</th>
                            <td>
                                <pre><c:out value="${revenue.memo}" /></pre>
                            </td>
                        </tr>
                        <tr>
                            <th>日付</th>
                            <td>
                                <c:out value="${revenue.income_at}" />
                            </td>
                        </tr>

                    </tbody>
                </table>


                    <p><a href="<c:url value="/revenue/edit?id=${revenue.id}" />">編集する</a></p>

            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value="/revenue/index" />">一覧に戻る</a></p>
    </c:param>
</c:import>
