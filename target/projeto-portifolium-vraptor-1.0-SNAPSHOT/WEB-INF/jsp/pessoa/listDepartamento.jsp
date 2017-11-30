

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:forEach var="item" items="${departamentoList}" varStatus="row">
    ${item.idDepartamento}

</c:forEach>
