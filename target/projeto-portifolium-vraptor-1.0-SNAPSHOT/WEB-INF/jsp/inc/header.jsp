<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <meta name="author" content="UTFPR - Câmpus Medianeira"/>
        <meta name="reply-to" content="ricardosobjak@utfpr.edu.br"/>
        <meta name="description" content="<fmt:message key="meta.description"/>"/>
        <meta name="keywords" content="educacao, web, desenvolvimento, development, java, opensource"/>

        <title>Portfolium</title>

        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="<c:url value="/css/materialize.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css"/>

        <style>
            #div1{
                width: 300px;
                height: 300px;
                background-color: 009688;
                position: relative;
                -webkit-animation-name: example; /* Safari 4.0 - 8.0 */
                -webkit-animation-duration: 4s; /* Safari 4.0 - 8.0 */
                animation-name: example1;
                animation-duration: 2s;
                animation-fill-mode: forwards;
            }

            #div2{
                width: 200px;
                height: 200px;
                background-color: white;
                position: relative;
                -webkit-animation-name: example5; /* Safari 4.0 - 8.0 */
                -webkit-animation-duration: 4s; /* Safari 4.0 - 8.0 */
                animation-name: example2;
                animation-duration: 2s;
                animation-fill-mode: forwards;
            }

            #div3{
                width: 200px;
                height: 200px;
                background-color: 006355;
                position: relative;
                -webkit-animation-name: example3; /* Safari 4.0 - 8.0 */
                -webkit-animation-duration: 4s; /* Safari 4.0 - 8.0 */
                animation-name: example3;
                animation-duration: 2s;
                animation-fill-mode: forwards;
            }

            #div4{
                width: 100px;
                height: 100px;
                background-color: white;
                position: relative;
                -webkit-animation-name: example4; /* Safari 4.0 - 8.0 */
                -webkit-animation-duration: 4s; /* Safari 4.0 - 8.0 */
                animation-name: example4;
                animation-duration: 2s;
                animation-fill-mode: forwards;
            }

            #div5{
                width: 100px;
                height: 100px;
                background-color: 006355;
                position: relative;
                -webkit-animation-name: example5; /* Safari 4.0 - 8.0 */
                -webkit-animation-duration: 4s; /* Safari 4.0 - 8.0 */
                animation-name: example5;
                animation-duration: 2s;
                animation-fill-mode: forwards;
            }



            /* Standard syntax */
            @keyframes example1 {
                0%   {background-color:black; left:0px; top:0px;}
                100%  {background-color:#009688; left:100px; top:0px;}
            }
            @keyframes example2 {
                0%   {background-color:white; left:0px; top:100px;}
                100%  {background-color:white; left:0px; top:100px;}
            }
            @keyframes example3 {
                0%   {background-color:black; left:0px; top:0px;}
                100%  {background-color:#006355; left:-16px; top:16px;}
            }

            @keyframes example4 {
                0%   {background-color:white; left:0px; top:100px;}
                100%  {background-color:white; left:0px; top:100px;}
            }

            @keyframes example5 {
                0%   {background-color:black; left:0px; top:0px;}
                100%  {background-color:#004A3C; left:-16px; top:16px;}
            }
        </style>


    </head>

    <body>
        <c:set var="path"><c:url value="/"/></c:set>

        <c:if test="${not empty param.language}">
            <c:set var="lang" value="${param.language}" scope="session"/>
            <fmt:setLocale value="${param.language}" scope="session"/>
        </c:if>


        <ul id="entidadesDrop" class="dropdown-content">
            <li><a href="<c:url value="/person" />"><fmt:message key="menu.person"/> REST</a></li>
            <li><a href="<c:url value="/documento/form" />"><fmt:message key="document"/></a></li>

        </ul>

        <ul id="loginDrop" class="dropdown-content">
            <li><a href="<c:url value="/person/${userInfo.person.id}" />">Meu Cadastro</a></li>
            <li class="divider"></li>
            <li><a href="${linkTo[HomeController].logout}"><fmt:message key="logout"/></a></li>
        </ul>

        <ul id="langDrop" class="dropdown-content">
            <li class="${lang eq 'en' ? 'active' : ''}">
                <a href="?language=en">EN</a>
            </li>

            <li class="${lang eq 'pt_BR' ? 'active' : ''}">
                <a href="?language=pt_BR">PT</a>
            </li>
        </ul>


        <nav class="white" role="navigation">
            <div class="nav-wrapper container">
                <a class="brand-logo" href="${path}">Logo</a>
                <ul class="right hide-on-med-and-down">
                    <li><a class="dropdown-button" href="#!" data-activates="langDrop">
                            <i class="material-icons">language arrow_drop_down</i>
                        </a>
                    </li>

                    <li>
                        <a class="dropdown-button" href="#!" data-activates="entidadesDrop">
                            <fmt:message key="entities"/>
                            <i class="material-icons right">arrow_drop_down</i>
                        </a>
                    </li>

                    <li class="${not empty userInfo.person ? '' : 'hidden'}">
                        <a class="dropdown-button" href="#!" data-activates="loginDrop">
                            ${userInfo.person.login}
                            <i class="material-icons right">arrow_drop_down</i>
                        </a>
                    </li>
                </ul>

                <ul id="nav-mobile" class="side-nav">
                    <li><a href="#">Navbar Link</a></li>
                </ul>
            </div>
        </nav>
