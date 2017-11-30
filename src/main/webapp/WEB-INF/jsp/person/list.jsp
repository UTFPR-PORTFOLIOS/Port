<%@page contentType="text/html" pageEncoding="UTF-8"%>

﻿<%@ include file="/WEB-INF/jsp/inc/header.jsp" %> 


<div class="page-header">
    <h1><fmt:message key="person" /> <small class="text-muted" style="text-transform: lowercase"><fmt:message key="list" /></small>
        <a href="<c:url value="/person/new" />" class="btn btn-primary btn-sm"><fmt:message key="add"/></a>
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
                    <td>${item.name}</td>
                    <td><fmt:formatDate value="${item.birthday}" pattern="dd/MM/yyyy"/></td>
                    <td>${item.login}</td>
                    <td>
                        <ul class="navbar-nav">
                            <li class="nav-item dropdown">
                                <a class="dropdown-toggle" id="options${item.id}" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Options</a>
                                <div class="dropdown-menu" aria-labelledby="options${item.id}">
                                    <form action="<c:url value="/person/${item.id}"/>" method="POST">
                                        <button class="dropdown-item btn btn-link" name="_method" value="GET"><fmt:message key="edit"/></button> 
                                        <button class="dropdown-item btn btn-link" name="_method" value="DELETE"><fmt:message key="delete"/></button> 
                                    </form>
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