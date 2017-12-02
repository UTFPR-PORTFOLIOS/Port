<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/inc/header.jsp" %>

<div class="container">
    <div class="section">
        <div class="row">
            <div class="col s3"> &nbsp;</div>
            <form action="${linkTo[HomeController].login}" method="post" class="col s6">

                <div class="row">
                    <div class="input-field col s12"><h3>Sign in</h3></div>
                
                    <div class="input-field col s12">
                        <input type="text" class="validate" id="login" name="login"/>
                        <label for="login"><fmt:message key="person.login"/></label>
                    </div>

                    <div class="input-field col s12">
                        <input type="password" class="validate" name="password"/>
                        <label for="password"><fmt:message key="person.password"/></label>
                    </div>

                    <div class="input-field col s12">
                        <button class="btn waves-effect waves-light" id="submit" type="submit" name="action">
                            <fmt:message key="send"/> <i class="material-icons right">send</i>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="divider"></div>

    <div class="section">
        <div class="row">
            <div class="col s3">&nbsp;</div>
            <form action="${linkTo[UsuarioController].add}" method="post" class="col s6">
                <div class="row">
                    <div class="input-field col s12"><h3>Sign up</h3></div>

                    <div class="input-field col s12">
                        <input type="text" class="validate" id="newname" name="pessoa.nome" value="${pessoa.nome}" />
                        <label for="newname"><fmt:message key="person.name"/></label>

                    </div>

                    <div class="input-field col s12">
                        <input type="text" class="validate" id="newemail" name="pessoa.email" value="${pessoa.email}" />
                        <label for="newemail"><fmt:message key="person.email"/></label>
                    </div>

                    <div class="input-field col s12">
                        <input type="text" class="validate" id="newlogin" name="pessoa.login" value="${pessoa.login}" />
                        <label for="newlogin"><fmt:message key="person.login"/></label>
                    </div>

                    <div class="input-field col s12">
                        <input type="password" id="newpassword" class="validate" name="pessoa.password" value="${pessoa.password}" />
                        <label for="password"><fmt:message key="person.password"/></label>
                    </div>

                    <div class="input-field col s12">
                        <button class="btn waves-effect waves-light" type="submit" name="action">
                            <fmt:message key="send"/><i class="material-icons right">send</i>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>
