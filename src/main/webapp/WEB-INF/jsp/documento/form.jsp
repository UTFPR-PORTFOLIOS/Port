
<%@page contentType="text/html" pageEncoding="UTF-8"%>

﻿<%@ include file="/WEB-INF/jsp/inc/header.jsp" %>

<div class="container">
    <div class="section">
        <div class="row">
            <h2 class="header">
                <h1>Cadastro de Documentos <small class="text-muted" style="text-transform: lowercase"></small></h1>
            </h2>
        </div>
        <div class="row">
            <form action="${linkTo[DocumentoController].save}" method="POST">
                <c:if test="${not empty documento and documento.idDocumento > 0}">
                    <div class="form-group">
                        <label class="control-label" for="inputId">ID</label>
                        <input class="form-control" id="inputId" type="text" name="documento.idDocumento" value="${documento.idDocumento}" readonly="readonly" />
                        <input type="hidden" name="_method" value="PUT" />
                    </div>
                </c:if>

                <div class="row">

                    <div class="form-group">
                        <input class="form-control" id="inputId" type="text" name="documento.dataInclusao" value="02/12/2017" />
                    </div>

                    <div class="form-group">
                        <input class="form-control" id="inputId" type="text" name="documento.caminhoArquivo" value="${documento.idDocumento}" />
                    </div>

                    <div class="input-field col s8">
                        <i class="material-icons prefix">insert_drive_file</i>
                        <input class="validate" id="inputName" type="text" name="documento.descDocumento"/>
                        <label for="inputName">Descrição</label>
                    </div>

                    <div class="input-field col s4">
                        <select>
                            <option value="">Choose your option</option>
                            <option value="1">DACOM</option>
                            <option value="2">DAAMB</option>
                            <option value="3">DAALM</option>
                        </select>
                        <label>Tipo de Documento</label>
                    </div>
                </div>

                <div class="row">
                    <div class="file-field input-field">
                        <div class="btn">
                            <span>Upload</span>
                            <input type="file">
                        </div>
                        <div class="file-path-wrapper">
                            <input class="file-path validate" type="text">
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="input-field">
                        <i class="material-icons prefix">label_outline</i>
                        <div class="chips chips-placeholder" data-index="0" data-initialized="true">

                            <div class="chip">ali<i class="material-icons close">close</i>
                            </div>
                            <div class="chip">alala<i class="material-icons close">close</i>
                            </div>
                            <input id=" " class="input" placeholder="">
                        </div>
                    </div>
                </div>

        </div>

        <div class="row align-center">
            <button class="btn waves-effect waves-light" type="submit">Enviar
                <i class="material-icons right">file_upload</i>
            </button>
        </div>

         
    <!--                    
        <form>
            <div id="queue"></div>
            <input id="file_upload" name="file_upload" type="file" multiple="true">
        </form>

        <script type="text/javascript">
            $(function () {
                $('#file_upload').uploadify({
                    'swf': 'uploadify.swf',
                    'uploader': 'minha/url',
                    'onUploadSuccess': function (file, data, response) {
                        alert('The file ' + file.name + ' was successfully uploaded with a response of ' + response + ':' + data);
                    }
                });
            });
        </script> --> 



        </form>
    </div>
</div>
</div>

<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>
