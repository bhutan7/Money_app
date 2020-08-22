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

<label for="purchase_amount">金額</label><br />
<input type="number" name="purchase_amount" value="${expenditure.purchase_amount+円}" />
<br /><br />

<label for="category">カテゴリー</label><br />
<select name ="category">
    <option value="0"<c:if test="${expenditure.category == 0}"> selected</c:if>>食費</option>
    <option value="1"<c:if test="${expenditure.category == 1}"> selected</c:if>>外食費</option>
    <option value="2"<c:if test="${expenditure.category == 2}"> selected</c:if>>日用品</option>
    <option value="3"<c:if test="${expenditure.category == 3}"> selected</c:if>>交通費</option>
    <option value="4"<c:if test="${expenditure.category == 4}"> selected</c:if>>衣服</option>
    <option value="5"<c:if test="${expenditure.category == 5}"> selected</c:if>>交際費</option>
    <option value="6"<c:if test="${expenditure.category == 6}"> selected</c:if>>趣味</option>
    <option value="7"<c:if test="${expenditure.category == 7}"> selected</c:if>>その他</option>
</select>
<br /><br />

<label for="memo">メモ</label><br />
<input type="text" name="memo" value="${expenditure.memo}" />
<br /><br />

<label for="purchase_at">日付</label><br />
<input type="date" name="purchase_at" value="<fmt:formatDate value='${expenditure.purchase_at}' pattern='yyyy-MM-dd' />" />
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">保存</button>