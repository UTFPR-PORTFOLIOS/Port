<%@page contentType="text/html" pageEncoding="UTF-8"%>

﻿<%@ include file="/WEB-INF/jsp/inc/header.jsp" %> 


<div class="page-header">
    <h1><fmt:message key="person" /> <small class="text-muted" style="text-transform: lowercase"><fmt:message key="list" /></small>
        <a href="<c:url value="/pessoa/form" />" class="btn btn-primary btn-sm"><fmt:message key="add"/></a>
    </h1>
</div>

<div class="row">
    <div class="col-lg-12 mx-auto">


        <table class="table">
            <tr>
                <th><a href="?ordem=id">#</a></th>
                <th><a href="?ordem=name"><fmt:message key="person.name"/></a></th>
                <th><fmt:message key="person.birthday"/></th>
                <th><fmt:message key="person.login"/></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${personList}" varStatus="row">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.login}</td>
                    <td>${item.login}</td>
                    <td>
                        <ul class="navbar-nav">
                            <li class="nav-item dropdown">
                                <a class="dropdown-toggle" id="options${item.id}" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Options</a>
                                <div class="dropdown-menu" aria-labelledby="options${item.id}">
                                    <a class="dropdown-item" href="<c:url value="/pessoa/form?id=" />${item.id}""><fmt:message key="edit"/></a>
                                    <a class="dropdown-item" href="<c:url value="/pessoa/delete?id=" />${item.id}"><fmt:message key="delete"/></a>
                                </div>
                            </li>
                        </ul>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %> 