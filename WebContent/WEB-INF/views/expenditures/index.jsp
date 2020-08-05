<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>支出　一覧</h2>
        <table id="expenditure_list">
            <tbody>
                <tr>
                    <th>日付</th>
                    <th>カテゴリ</th>
                    <th>メモ</th>
                    <th>金額</th>
                    <th>編集 </th>
                </tr>
                <c:forEach var="expenditure" items="${expenditures}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td><c:out value="${expenditure.purchase_at}" /></td>
                        <td><c:out value="${expenditure.category}" /></td>
                        <td><c:out value="${expenditure.memo}" /></td>
                        <td><c:out value="${expenditure.purchase_amount}" /></td>

                        <td>
                            <c:choose>
                                <c:when test="${expenditure.delete_flag == 1}">
                                    （削除済み）
                                </c:when>
                                <c:otherwise>
                                    <a href="<c:url value='/expenditures/show?id=${expenditure.id}' />">詳細を表示</a>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${expenditures_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((expenditures_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/expenditures/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='/expenditures/new' />">支出入力画面へ</a></p>

    </c:param>
</c:import>