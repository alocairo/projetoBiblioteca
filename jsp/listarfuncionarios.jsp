<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
        <%@ page import="biblio.entidades.Funcionario" %>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html lang="pt-br">

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
                <title>BIBLIOTECA - Funcionários</title>

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
                    footer {
            margin: auto;
            width: 100%;
            bottom: 0;
            position: relative;
        }
                </style>


            </head>

            <body>
                <div class="container">

                    <!-- import the navbar -->
                    <jsp:directive.include file="nav.html" />

                    <div class="page-header text-center">
                        <h1>
                            <i class="fa fa-id-card" aria-hidden="true"></i> Funcionário</h1>
                    </div>

                    <table class="table table-inverse" id="myTable">
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Nome</th>
                                <th>Endereço</th>
                                <th>Telefone</th>
                                <th>Salário</th>
                                <th>Biblioteca</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--       Apenas primeiro tr deve ser mantido, os outros serao dinmicos-->
                            <%	List<Funcionario> lista = (List<Funcionario>) request.getAttribute("lista");
	            
	            	for(Funcionario func: lista) {
	            %>
                                <tr>
                                    <td>
                                        <%= func.getCodfunc() %>
                                    </td>
                                    <td>
                                        <%= func.getNomefunc() %>
                                    </td>
                                    <td>
                                        <%= func.getEnderecofunc() %>
                                    </td>
                                    <td>
                                        <%= func.getTelefonefunc() %>
                                    </td>
                                    <td>
                                        <%= func.getSalario() %>
                                    </td>
                                    <td>
                                        <%= func.getCodbib() %>
                                    </td>
                                </tr>
                                <% } %>
                        </tbody>
                    </table>

                    <h2>
                        <i class="fa fa-users" aria-hidden="true"></i> Gerênciar Funcionário</h2>

                    <form action="funccontroller.do" method="post">
                        <table class="table">
                            <tbody>
                                <tr>
                                    <th>Código</th>
                                    <th>Nome</th>
                                    <th>Endereço</th>
                                    <th>Telefone</th>
                                    <th>Salário</th>
                                    <th>Biblioteca</th>
                                </tr>
                                <tr>
                                    <td>
                                        <input name="altCodigoFuncionario" type="search" id="dadoCodigoFuncionario" onkeyup="buscaCodigoFuncionario()" class="form-control"
                                            placeholder="CODIGO">
                                    </td>
                                    <td>
                                        <input name="altNomeFuncionario" type="search" id="dadoNomeFuncionario" onkeyup="buscaNomeFuncionario()" class="form-control"
                                            placeholder="NOME">
                                    </td>
                                    <td>
                                        <input name="altEnderecoFuncionario" type="search" id="dadoEnderecoFuncionario" onkeyup="buscaEnderecoFuncionario()" class="form-control"
                                            placeholder="ENDERECO">
                                    </td>
                                    <td>
                                        <input name="altTelefoneFuncionario" type="search" id="dadoTelefoneFuncionario" onkeyup="buscaTelefoneFuncionario()" class="form-control"
                                            placeholder="TELEFONE">
                                    </td>
                                    <td>
                                        <input name="altSalarioFuncionario" type="search" id="dadoSalarioFuncionario" onkeyup="buscaSalarioFuncionario()" class="form-control"
                                            placeholder="SALARIO">
                                    </td>
                                    <td>
                                        <input name="altBibliotecaFuncionario" type="search" id="dadoBibliotecaFuncionario" onkeyup="buscaBibliotecaFuncionario()"
                                            class="form-control" placeholder="BIBLIOTECA">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="container margin-fix">
                            <button name="condicao" value="inserir" type="submit" class="btn btn-primary btn-xs">Inserir</button>
                            <button name="condicao" value="alterar" type="submit" class="btn btn-primary btn-xs">Alterar</button>
                            <% // Verificar funcao abaixo %>
                                <button type="button" class="btn btn-primary btn-xs">Desativar</button>
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
