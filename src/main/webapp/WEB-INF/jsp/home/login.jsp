<%@page contentType="text/html" pageEncoding="UTF-8"%>
﻿<%@ include file="/WEB-INF/jsp/inc/header.jsp" %> 

<div class="row">
    <div class="col-lg-5 mx-auto">
        <h3>Sign in</h3>
        <form action="${linkTo[HomeController].login}" method="post" class="form-horizontal">
            <div class="form-group">
                <label class="sr-only" for="login"><fmt:message key="person.login"/></label>
                <input type="text" class="form-control" id="login" name="login" placeholder="<fmt:message key="person.login"/>"/>
            </div>
            <div class="form-group">
                <label class="sr-only" for="password"><fmt:message key="person.password"/></label>
                <input type="password" class="form-control" name="password" placeholder="<fmt:message key="person.password"/>" />
                <small class="text-muted"><fmt:message key="user.default"/></small>
            </div>
            <div class="form-group pull-right">	
                <button type="submit" id="submit" class="btn btn-large btn-primary">
                    <fmt:message key="send"/>
                </button>
            </div>	
        </form>
    </div>	
</div>
<br/>
<div class="row">
    <div class="col-lg-5 mx-auto">
        <h3>Sign Up</h3>
        <form action="${linkTo[UsuarioController].add}" method="post" class="form-horizontal">
            <div class="form-group">
                <label class="sr-only" for="newname"><fmt:message key="person.name"/></label>
                <input type="text" class="form-control" id="newname" name="pessoa.nome" value="${pessoa.name}" placeholder="<fmt:message key="person.name"/>" />
            </div>
            
            <div class="form-group">
                <label class="sr-only" for="newemail"><new fmt:message key="person.email"/></label>
                <input type="text" class="form-control" id="newemail" name="pessoa.email" value="${pessoa.email}" placeholder="<fmt:message key="person.email"/>" />
            </div>
            
            <div class="form-group">
                <label class="sr-only" for="newlogin"><fmt:message key="person.login"/></label>
                <input type="text" class="form-control" id="newlogin" name="pessoa.login" value="${pessoa.login}" placeholder="<fmt:message key="person.login"/>" />
            </div>
            <div class="form-group">
                <label class="sr-only" for="newpassword"><fmt:message key="person.password"/></label>
                <input type="password" class="form-control" id="newpassword" name="pessoa.password" value="${pessoa.password}" placeholder="<fmt:message key="person.password"/>" />
            </div>
            <div class="form-group pull-right">					
                <button type="submit" class="btn btn-large btn-primary">
                    <fmt:message key="send"/>
                </button>
            </div>
        </form>
    </div>
</div>		
<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %> 