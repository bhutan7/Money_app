<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>

<label for="revenue_amount">金額</label><br />
<input type="number" name="revenue_amount" value="${revenue.revenue_amount+円}" />
<br /><br />

<label for="category">カテゴリー</label><br />
<select name ="category">
    <option value="0"<c:if test="${revenue.category == 0}"> selected</c:if>>給与</option>
    <option value="1"<c:if test="${revenue.category == 1}"> selected</c:if>>雑所得</option>
    <option value="2"<c:if test="${revenue.category == 2}"> selected</c:if>>利子所得</option>
    <option value="3"<c:if test="${revenue.category == 3}"> selected</c:if>>その他</option>

</select>
<br /><br />

<label for="memo">メモ</label><br />
<input type="text" name="memo" value="${revenue.memo}" />
<br /><br />

<label for="income_at">日付</label><br />
<input type="date" name="income_at" value="<fmt:formatDate value='${revenue.income_at}' pattern='yyyy-MM-dd' />" />
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">保存</button>