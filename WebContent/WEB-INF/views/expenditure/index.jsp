<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>あなたの収支総額</h2>
        <table id="money_list">
            <tbody>
                <tr>
                    <th>支出</th>
                    <th>収入</th>
                    <th>日付</th>
                </tr>
                        <td><c:out value="${users.expenditure}"></c:out>
                        <td><c:out value="${users.revenue}" /></td>
                        <td><fmt:formatDate  value="${users.updated_at}" /></td>
                        
                    </tr>
            </tbody>
        </table>
    </c:param>
 </c:import>