<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${expenditure != null}">
                <h2>支出　詳細ページ</h2>

                <table>
                    <tbody>
                        <tr>
                            <th>金額</th>
                            <td><c:out value="${expenditure.purchase_amount}" /></td>
                        </tr>
                        <tr>
                            <th>カテゴリ</th>
                            <td>
                                <c:if test="${expenditure.category == 0}"> 食費</c:if>
                                 <c:if test="${expenditure.category == 1}"> 外食費</c:if>
                                <c:if test="${expenditure.category == 2}"> 日用品</c:if>
                                <c:if test="${expenditure.category == 3}"> 交通費</c:if>
                                <c:if test="${expenditure.category == 4}"> 衣服</c:if>
                                <c:if test="${expenditure.category == 5}"> 交際費</c:if>
                                <c:if test="${expenditure.category == 6}"> 趣味</c:if>
                                <c:if test="${expenditure.category == 7}"> その他</c:if>
                             </td>
                        </tr>
                        <tr>
                            <th>メモ</th>
                            <td>
                                <pre><c:out value="${expenditure.memo}" /></pre>
                            </td>
                        </tr>
                        <tr>
                            <th>日付</th>
                            <td>
                                <c:out value="${expenditure.purchase_at}" />
                            </td>
                        </tr>

                    </tbody>
                </table>


                    <p><a href="<c:url value="/expenditure/edit?id=${expenditure.id}" />">編集する</a></p>

            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value="/expenditure/index" />">一覧に戻る</a></p>
    </c:param>
</c:import>
