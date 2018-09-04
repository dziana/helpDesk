<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>user</title>
    <jsp:include page="../jsp/fragments/header.jsp"/>
</head>

<body>
<jsp:include page="../jsp/fragments/nav.jsp"/>
<c:if test="${not empty pageContext.request.userPrincipal}">
    User: <c:out value="${pageContext.request.userPrincipal.name}"/>
</c:if>
<br>
<br>
<div class="grid-container">
    <div class="grid-x grid-padding-x">
        <div class="medium-3 cell">
        </div>
        <div class="medium-6 cell">
            ${requestScope.myName}
            <select name="problems" id="problems">
                <c:forEach items="${requestScope.problems}" var="problems">
                    <option value="${problems.id}">${problems.name} </option>
                </c:forEach>
            </select>
        </div>
        <div class="medium-3 cell">
        </div>
    </div>
</div>

<form name="textform" id="textform" action="${pageContext.request.contextPath}/user" method="post">

    <div class="grid-container">
        <div class="grid-x grid-padding-x">
            <div class="medium-3 cell">
            </div>
            <div class="medium-6 cell">
                <label>Краткое наименование заявки
                    <input type="text" name="nameTask" placeholder="Введите краткое описание проблемы">
                </label>
            </div>
            <div class="medium-3 cell">
            </div>
        </div>
    </div>

    <div class="grid-container">
        <div class="grid-x grid-padding-x">
            <div class="medium-3 cell">
            </div>
            <div class="medium-6 cell">

                <label> Опишите возникшую проблему
                    <textarea name="textUser" placeholder="Подробно опишите возникшую проблему" cols="40"
                              rows="3"></textarea>
                    <div class="expanded button-group">
                        <button type="submit" class="button success"><b>Отправить заявку</b></button>
                    </div>
                </label>

            </div>
            <div class="medium-3 cell">
            </div>
        </div>
    </div>
</form>
<script>

    $(document).foundation();
</script>
</body>

</html>