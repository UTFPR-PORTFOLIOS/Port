# webapp-vraptor-tomcat-jpa

Projeto exemplo de utilização do framework Vraptor.

Este projeto foi construído com base na seguintes tecnologias:
 -Plataforma: JavaEE
 -Framework: Vraptor
 -Persistência: JPA com Eclipselink e driver para MySQL
 -Páginas: JSP com JSTL

Servidor de aplicação:
 O projeto está preparado para rodar no servidor de aplicação Tomcat 8.
 

Modo de utilização:
 -Inicie um servidor de banco de dados MySQL;
 -Crie um banco de dados vazio denominado "test";
 -Modifique as credenciais de acesso ao banco de dados no arquivo "persistence.xml";
 

Recursos:
A aplicação foi construída exemplifincando 3 conceitos de desenvolvimento: 
 -1º) Páginas (view) seguindo o padrão do framework Vraptor;
 -2º) Páginas (view) seguindo uma arquitetura REST;
 -3º) API RESTful para consumir os dados em formatos JSON/XML.
 

Acessando as páginas seguindo o padrão do Vraptor (br.edu.utfpr.webapp.vraptor.controller.PessoaController):
 --> /<app-name>/pessoa/list: mostra a listagem de pessoas cadastradas;
 --> /<app-name>/pessoa/form: formulário para cadastro e edição de pessoas.
 
 
Acessando as páginas seguindo o padrão REST (br.edu.utfpr.webapp.vraptor.controller.Pessoa2Controller):
 --> /<app-name>/people: mostra a listagem de pessoas cadastradas;
 --> /<app-name>/people/<id>: formulário para edição de pessoas;
 --> /<app-name>/people/new: formulário para cadastro de pessoas.
 

Acessando os dados pela API REST (br.edu.utfpr.webapp.vraptor.controller.api.PessoaController):
 --> /<app-name>/api/pessoa: retorna todas as pessoas cadastradas em formato JSON;
 --> /<app-name>/api/pessoa/<id>: retorna a pessoa identificada pelo id em formato JSON;

 

