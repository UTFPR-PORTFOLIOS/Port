<%@page contentType="text/html" pageEncoding="UTF-8"%>

﻿<%@ include file="/WEB-INF/jsp/inc/header.jsp" %>

<div class="container">
    <div class="section">
        <div class="row">
            <h2 class="header">
                <h1><fmt:message key="person" /> <small class="text-muted" style="text-transform: lowercase"><fmt:message key="register" /></small></h1>
            </h2>
        </div>
        <div class="row">
            <form action="${linkTo[PersonController].save}" method="POST">
                <c:if test="${not empty pessoa and pessoa.id > 0}">
                    <div class="form-group">
                        <label class="control-label" for="inputId">ID</label>
                        <input class="form-control" id="inputId" type="text" name="pessoa.id" value="${pessoa.id}" readonly="readonly" />
                        <input type="hidden" name="_method" value="PUT" />
                    </div>
                </c:if>

                <div class="row">
                    <div class="input-field col s4 ${not empty errors.from('person.name') ? "has-danger" : ""}">
                        <i class="material-icons prefix">person</i>
                        <input class="validate ${not empty errors.from('person.name') ? "form-control-danger" : ""}" id="inputName" type="text" name="pessoa.nome" value="${pessoa.nome}" />
                        <label for="inputName"><fmt:message key="person.name" /></label>
                    </div>

                    <div class="input-field col s8 ${not empty errors.from('person.surname') ? "has-danger" : ""}">
                        <input class="form-control ${not empty errors.from('person.surname') ? "form-control-danger" : ""}" id="inputName" type="text" name="person.sobrenome" value="${pessoa.nome}" />
                        <label class="form-control-label" for="inputName"><fmt:message key="person.surname" /></label>
                    </div>
                </div>


                <div class="row">
                    <div class="input-field col s8 ${not empty errors.from('person.email') ? "has-danger" : ""}">
                        <i class="material-icons prefix">email</i>
                        <input class="validate ${not empty errors.from('person.email') ? "form-control-danger" : ""}" id="inputName" type="text" name="pessoa.email" value="${pessoa.email}" />
                        <label for="inputName"><fmt:message key="person.email" /></label>
                        <small class="form-control-feedback">${errors.from('person.email')}</small>
                    </div>

                    <div class="input-field col s4 ${not empty errors.from('person.internalRegister') ? "has-danger" : ""}">
                        <i class="material-icons prefix">assignment_ind</i>
                        <input class="form-control ${not empty errors.from('person.internalRegister') ? "form-control-danger" : ""}" id="inputName" type="text" name="pessoa.registroInterno" value="${pessoa.registroInterno}" />
                        <label class="form-control-label" for="inputName"><fmt:message key="person.internalRegister" /></label>
                        <small class="form-control-feedback">${errors.from('person.internalRegister')}</small>
                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s4">
                        <i class="material-icons prefix">business</i>
                        <select>
                            <c:forEach var="item" items="${departamento}" varStatus="row">
                                <option value="${item.idDepartamento}">${item.descDepartamento}</option>
                            </c:forEach>

                        </select>
                        <label>Departamento</label>
                    </div>

                    <div class="input-field col s4">
                        <select>
                            <option value="">Choose your option</option>
                            <option value="1">Professor</option>
                            <option value="2">Chefe Departamento</option>
                        </select>
                        <label>Função</label>
                    </div>

                    <div class="input-field col s4">
                        <i class="material-icons prefix">contact_phone</i>
                        <input class="validate" id="inputRamal" type="text" name="ramal"/>
                        <label for="inputRamal">Ramal</label>
                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s6">
                        <i class="material-icons prefix">add_location</i>
                        <input class="validate" type="text" name="inputEndereco"/>
                        <label for="inputEndereco">Logradouro</label>
                        <small class="form-control-feedback"></small>
                    </div>

                    <div class="input-field col s2">
                        <input class="validate" type="text" name="inputNumero"/>
                        <label for="inputNumero">Número</label>
                        <small class="form-control-feedback"></small>
                    </div>

                    <div class="input-field col s4">
                        <input class="validate" type="text" name="inputBairro"/>
                        <label for="inputBairro">Bairro</label>
                        <small class="form-control-feedback"></small>
                    </div>

                </div>

                <div class="row">
                    <div class="input-field col s4">
                        <i class="material-icons prefix">add_location</i>
                        <input class="validate" type="text" name="inputCep"/>
                        <label for="inputCep">CEP</label>
                        <small class="form-control-feedback"></small>
                    </div>

                    <div class="input-field col s4">
                        <input class="validate" type="text" name="inputNumero"/>
                        <label for="inputNumero">Número</label>
                        <small class="form-control-feedback"></small>
                    </div>

                    <div class="input-field col s4">
                        <input class="validate" type="text" name="inputNumero"/>
                        <label for="inputNumero">Bairro</label>
                        <small class="form-control-feedback"></small>
                    </div>

                </div>

                <div class="row">
                    <div class="input-field col s4 ${not empty errors.from('person.login') ? "has-danger" : ""}">
                        <i class="material-icons prefix">verified_user</i>
                        <input class="form-control ${not empty errors.from('person.login') ? "form-control-danger" : ""}" type="text" name="pessoa.login" value="${pessoa.login}" describedby="inputLoginStatus" />
                        <label><fmt:message key="person.login" /></label>
                        <small class="form-control-feedback">${errors.from('person.login')}</small>
                    </div>

                    <div class="input-field col s4 ${not empty errors.from('person.password') ? "has-danger" : ""}">
                        <input class="form-control ${not empty errors.from('person.password') ? "form-control-danger" : ""}" type="password" name="pessoa.password" value="${pessoa.password}" describedby="inputPasswordStatus" />
                        <label><fmt:message key="person.password" /></label>
                        <small class="form-control-feedback">${errors.from('person.password')}</small>
                    </div>

                    <div class="input-field col s4">
                        <div class="switch">
                            <label>
                                User
                                <input type="checkbox">
                                <span class="lever"></span>
                                Admin
                            </label>
                        </div>
                    </div>
                </div>

                <div class="row align-center">
                    <button class="btn waves-effect waves-light" type="submit">Salvar
                        <i class="material-icons right">save</i>
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>
