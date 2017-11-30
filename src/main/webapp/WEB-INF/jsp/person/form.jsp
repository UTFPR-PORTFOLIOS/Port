<%@page contentType="text/html" pageEncoding="UTF-8"%>

﻿<%@ include file="/WEB-INF/jsp/inc/header.jsp" %> 

<div class="page-header">
    <h1><fmt:message key="person" /> <small class="text-muted" style="text-transform: lowercase"><fmt:message key="register" /></small></h1>
</div>

<section>
    <form action="${linkTo[PersonController].save}" method="POST">
        <c:if test="${not empty person and person.id > 0}">
            <div class="form-group">
                <label class="control-label" for="inputId">ID</label>
                <input class="form-control" id="inputId" type="text" name="person.id" value="${person.id}" readonly="readonly" />
                <input type="hidden" name="_method" value="PUT" />
            </div>
        </c:if>
        <div class="form-group ${not empty errors.from('person.name') ? "has-danger" : ""}">
            <label class="form-control-label" for="inputName"><fmt:message key="person.name" /></label>
            <input class="form-control ${not empty errors.from('person.name') ? "form-control-danger" : ""}" id="inputName" type="text" placeholder="<fmt:message key="person.name" />" name="person.name" value="${person.name}" />
            <small class="form-control-feedback">${errors.from('person.name')}</small>
        </div>

        <div class="form-group ${not empty errors.from('person.birthday') ? "has-danger" : ""}">
            <label class="form-control-label"><fmt:message key="person.birthday" /></label>
            <input class="form-control ${not empty errors.from('person.birthday') ? "form-control-danger" : ""}" type="text" placeholder="<fmt:message key="person.birthday" />" name="person.birthday" value="<fmt:formatDate value="${person.birthday}" pattern="dd/MM/yyyy"/>" describedby="inputBirthdayStatus" />
            <small class="form-control-feedback">${errors.from('person.birthday')}</small>
        </div>

        <div class="form-group ${not empty errors.from('person.login') ? "has-danger" : ""}">
            <label class="form-control-label"><fmt:message key="person.login" /></label>
            <input class="form-control ${not empty errors.from('person.login') ? "form-control-danger" : ""}" type="text" placeholder="<fmt:message key="person.login" />" name="person.login" value="${person.login}" describedby="inputLoginStatus" />
            <small class="form-control-feedback">${errors.from('person.login')}</small>
        </div>

        <div class="form-group ${not empty errors.from('person.password') ? "has-danger" : ""}">
            <label class="form-control-label"><fmt:message key="person.password" /></label>
            <input class="form-control ${not empty errors.from('person.password') ? "form-control-danger" : ""}" type="password" placeholder="<fmt:message key="person.password" />" name="person.password" value="${person.password}" describedby="inputPasswordStatus" />
            <small class="form-control-feedback">${errors.from('person.password')}</small>
        </div>

        <button type="submit" class="btn btn-primary">Salvar</button>
        <button type="reset" class="btn btn-default">Resetar</button>
    </form>
</section>

<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %> 