<%@page contentType="text/html" pageEncoding="UTF-8"%>
﻿<%@ include file="/WEB-INF/jsp/inc/header.jsp" %>

<nav class="teal">
    <div class="container">
        <div class="nav-wrapper">
            <div class="col s12">
                <a href="#!" class="breadcrumb">First</a>
                <a href="#!" class="breadcrumb"><fmt:message key="person" /></a>
                <a href="#!" class="breadcrumb"><fmt:message key="list" /></a>
            </div>
            </nav>


            <div class="container">
                <div class="section">
                    <div class="row">
                        <h2 class="header">                
                            <a href="<c:url value="/person/new" />" class="btn btn-primary btn-sm"><fmt:message key="add"/></a>
                        </h2>
                    </div>
                    <div class="row">
                        <form action="#" method="POST">

                            <div class="row">
                                <table class="highlight">
                                    <thead>
                                        <tr>
                                            <th><a href="?ordem=id">#</a></th>
                                            <th><a href="?ordem=name"><fmt:message key="person.name"/></a></th>
                                            <th><fmt:message key="person.email"/></th>
                                            <th><fmt:message key="person.login"/></th>
                                            <th></th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="item" items="${pessoaList}" varStatus="row">
                                            <tr>
                                                <td>${item.id}</td>
                                                <td>${item.nome}</td>
                                                <td>${item.email}</td>
                                                <td>${item.login}</td>
                                                <td>
                                                    <a class="" id="options${item.id}" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Options</a>
                                                    <div class="" aria-labelledby="options${item.id}">
                                                        <form action="<c:url value="/person/${item.id}"/>" method="POST">
                                                            <button class="" name="_method" value="GET"><fmt:message key="edit"/></button>
                                                            <button class="" name="_method" value="DELETE"><fmt:message key="delete"/></button>
                                                        </form>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>

                                </table>

                            </div>
                    </div>
                </div>
            </div>

            <%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>
