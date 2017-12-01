<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.util.List" %>
        <%@ page import ="biblio.entidades.Livros" %>
            <%@ page import ="biblio.entidades.Biblioteca" %>
                <%@ page import ="biblio.entidades.Categoria" %>
                    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
                    <html>

                    <head>
                        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
                        <title>BIBLIOTECA - Livros</title>

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
            position: fixed;
        }
                        </style>


                    </head>

                    <body>
                        <div class="container">

                            <!-- import the navbar -->
                            <jsp:directive.include file="nav.html" />

                            <div class="page-header text-center">
                                <h1>
                                    <i class="fa fa-book" aria-hidden="true"></i> Livros</h1>
                            </div>

                            <table class="table table-inverse" id="myTable">
                                <thead>
                                    <tr>
                                        <th>C�digo</th>
                                        <th>T�tulo</th>
                                        <th>Editora</th>
                                        <th>Valor</th>
                                        <th>Categoria</th>
                                        <th>Biblioteca</th>
                                        <th>Situa��o</th>
                                        <th>Pr�xima Disponibilidade</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!--       Apenas primeiro tr deve ser mantido, os outros serao din�micos-->
                                    <%
                List<Livros> listaliv = (List<Livros>) request.getAttribute("listaliv");
                
                for (Livros liv: listaliv) {
                %>
                                        <tr>
                                            <td>
                                                <%= liv.getCodlivro() %>
                                            </td>
                                            <td>
                                                <%= liv.getTitulo() %>
                                            </td>
                                            <td>
                                                <%= liv.getEditora() %>
                                            </td>
                                            <td>
                                                <%= liv.getValor() %>
                                            </td>
                                            <td>
                                                <%= liv.getCodcategoria() %>
                                            </td>
                                            <td>
                                                <%= liv.getCodbib() %>
                                            </td>
                                            <td>
                                                <%= liv.getSituacaoliv() %>
                                            </td>
                                        </tr>
                                        <% } %>
                                </tbody>
                            </table>

                            <h2>
                                <i class="fa fa-exclamation-circle" aria-hidden="true"></i> Livros</h2>

                            <form action="livcontroller.do" method="post">
                                <table class="table">
                                    <tbody>
                                        <tr>
                                            <th>C�DIGO</th>
                                            <th>T�TULO</th>
                                            <th>EDITORA</th>
                                            <th>VALOR</th>
                                            <th>CATEGORIA</th>
                                            <th>BIBLIOTECA</th>
                                            <th>SITUA��O</th>
                                        </tr>
                                        <tr>
                                            <td>
                                                <input name="altCodigoLivro" type="search" id="dadoCodigoLivro" onkeyup="buscaCodigoLivro()" class="form-control" placeholder="CODIGO">
                                            </td>
                                            <td>
                                                <input name="altTituloLivro" type="search" id="dadoTituloLivro" onkeyup="buscaTituloLivro()" class="form-control" placeholder="TITULO">
                                            </td>
                                            <td>
                                                <input name="altEditoraLivro" type="search" id="dadoEditoraLivro" onkeyup="buscaEditoraLivro()" class="form-control" placeholder="EDITORA">
                                            </td>
                                            <td>
                                                <input name="altValorLivro" type="search" id="dadoValorLivro" onkeyup="buscaValorLivro()" class="form-control" placeholder="VALOR">
                                            </td>
                                            <td>
                                                <select name="altCategoria" class="form-control" id="dadoCategoriaLivro" onchange="buscaCategoriaLivro()">
                                                    <option value="" disabled selected>CATEGORIA</option>
                                                    <%	List<Categoria> listacat = (List<Categoria>) request.getAttribute("listacat");
								
                                	for (Categoria cat: listacat) {
								%>
                                                        <option value="<%= cat.getCodcategoria() %>">
                                                            <%= cat.getDescricao() %>
                                                        </option>
                                                        <%	} %>
                                                            <option value="">Limpa Filtro</option>
                                                </select>
                                            </td>
                                            <td>
                                                <select name="altBiblioteca" class="form-control" id="dadoBibliotecaLivro" onchange="buscaBibliotecaLivro()">
                                                    <option value="" disabled selected>BIBLIOTECA</option>

                                                    <%	List<Biblioteca> listabib = (List<Biblioteca>) request.getAttribute("listabib");
			                
			                	for (Biblioteca bib: listabib) {
			               	%>
                                                        <option value="<%= bib.getCodbib() %>">
                                                            <%= bib.getNomebib() %>
                                                        </option>
                                                        <%	} %>
                                                            <option value="">Limpa Filtro</option>
                                                </select>
                                            </td>
                                            <td>
                                                <select name="altSituacao" class="form-control" id="dadoSituacaoLivro" onchange="buscaSituacaoLivro()">
                                                    <option value="" disabled selected>SITUA��O</option>
                                                    <option value="Livre">Livre</option>
                                                    <option value="Indisponivel">Indisponivel</option>
                                                    <option value="">Limpa Filtro</option>
                                                </select>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                                <div class="container margin-fix">
                                    <button name="condicao" value="inserir" type="submit" class="btn btn-primary btn-xs">Inserir</button>
                                    <button name="condicao" value="alterar" type="submit" class="btn btn-primary btn-xs">Alterar</button>
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