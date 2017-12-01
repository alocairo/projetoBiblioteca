<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.util.List" %>
        <%@ page import ="biblio.entidades.Alunos" %>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
                <title>BIBLIOTECA - Alunos</title>

                <link rel="stylesheet" href="./Style/font-awesome-4.7.0/css/font-awesome.min.css">
                <link href="./Style/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
                <!--    <link href="/css/shop-homepage.css" rel="stylesheet" type="text/css">-->

                <link href="./img/favicon.ico" rel="shortcut icon" type="image/x-icon" />

                <style>
                    body {
                        padding-top: 80px;
                        word-wrap: break-word;
                    }

                    .margin-fix {
                        margin-bottom: 20px;
                    }
                </style>


            </head>

            <body>
                <div class="container">

                    <!-- import the navbar -->
                    <jsp:directive.include file="nav.html" />

                    <div class="page-header text-center">
                        <h1>
                            <i class="fa fa-id-card" aria-hidden="true"></i> Alunos</h1>
                    </div>

                    <table class="table table-inverse" id="myTable">
                        <thead>
                            <tr>
                                <th>Matricula</th>
                                <th>Nome</th>
                                <th>Endere�o</th>
                                <th>Situa��o</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--       Apenas primeiro tr deve ser mantido, os outros serao din�micos-->
                            <%
			//Scriplet
            List<Alunos> lista = (List<Alunos>) request.getAttribute("lista");
            
            for(Alunos alu: lista) {

            %>
                                <tr>
                                    <td>
                                        <%= alu.getCodmatricula() %>
                                    </td>
                                    <td>
                                        <%= alu.getNomealu() %>
                                    </td>
                                    <td>
                                        <%= alu.getEnderecoalu() %>
                                    </td>
                                    <td>
                                        <%= alu.getSituacaoalu() %>
                                    </td>
                                </tr>
                                <%
            }
			%>
                        </tbody>
                    </table>

                    <h2>
                        <i class="fa fa-users" aria-hidden="true"></i> Gerenciar Alunos</h2>

                    <form action="alucontroller.do" method="post">
                        <table class="table">
                            <tbody>
                                <tr>
                                    <th>MATRICULA</th>
                                    <th>NOME</th>
                                    <th>ENDERE�O</th>
                                    <th>SITUA��O</th>
                                </tr>
                                <tr>
                                    <td>
                                        <input name="altMatricula" type="search" id="dadoMatricula" onkeyup="buscaMatricula()" class="form-control" placeholder="MATRICULA">
                                    </td>
                                    <td>
                                        <input name="altNome" type="search" id="dadoNome" onkeyup="buscaNome()" class="form-control" placeholder="NOME">
                                    </td>
                                    <td>
                                        <input name="altEndereco" type="search" id="dadoEndereco" onkeyup="buscaEndereco()" class="form-control" placeholder="NOME">
                                    </td>
                                    <td>
                                        <select name="altSituacao" class="form-control" id="dadoSituacao" onchange="buscaSituacao()">
                                            <option value="" disabled selected>SITUA��O</option>
                                            <option value="Ativo">Ativo</option>
                                            <option value="Desabilitado">Desabilitado</option>
                                            <option value="">Limpa Filtro</option>
                                        </select>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="container margin-fix">
                            <button name="condicao" value="inserir" type="submit" class="btn btn-primary btn-xs">Inserir</button>
                            <button name="condicao" value="alterar" type="submit" class="btn btn-primary btn-xs">Alterar</button>
                            <% //  Verificar se � necessario este bot�o, se sim, criar funcao desativar aluno %>
                                <button name="condicao" value="desativar" type="button" class="btn btn-primary btn-xs">Desativar</button>
                                <button name="impressao" name="imprimir" value="Imprimir" onclick="window.print()" class="btn btn-primary btn-xs">Imprimir</button>
                        </div>
                    </form>
                </div>

                <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
                <!-- Include all compiled plugins (below), or include individual files as needed -->
                <script src="./Style/vendor/bootstrap/js/bootstrap.min.js"></script>
                <!-- Include custom JS for searchbox -->
                <script src="./js/custom.js"></script>

                <!-- import footer -->
                <jsp:directive.include file="footer.html" />
            </body>

            </html>