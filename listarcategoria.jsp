<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.util.List" %>
        <%@ page import ="biblio.entidades.Categoria" %>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
                <title>BIBLIOTECA - Categorias</title>

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
<<<<<<< HEAD
            position: fixed;
=======
            position: relative;
>>>>>>> upstream/master
        }
                </style>


            </head>

            <body>
                <div class="container">

                    <!-- import the navbar -->
                    <jsp:directive.include file="nav.html" />

                    <div class="page-header text-center">
                        <h1>
                            <i class="fa fa-tag" aria-hidden="true"></i> Categorias</h1>
                    </div>

                    <table class="table table-inverse" id="myTable">
                        <thead>
                            <tr>
                                <th>Codigo</th>
                                <th>Descrição</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--       Apenas primeiro tr deve ser mantido, os outros serao dinÃ¢micos-->
                            <%
                List<Categoria> lista = (List<Categoria>) request.getAttribute("lista");
                
                for (Categoria cat: lista) {
                
                %>
                                <tr>
                                    <td>
                                        <%= cat.getCodcategoria() %>
                                    </td>
                                    <td>
                                        <%= cat.getDescricao() %>
                                    </td>
                                </tr>
                                <% } %>
                        </tbody>
                    </table>
                    <h2>
                        <i class="fa fa-server" aria-hidden="true"></i> Gerenciar Categorias</h2>

                    <form action="catcontroller.do" method="post">
                        <table class="table" id="myTable">
                            <tbody>
                                <tr>
                                    <th>Código</th>
                                    <th>Descrição</th>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="search" id="dadoCodigoCategoria" onkeyup="buscaCodigoCategoria()" class="form-control" name="altCodigo" placeholder="CODIGO">
                                    </td>
                                    <td>
                                        <input type="search" id="dadoDescricaoCategoria" onkeyup="buscaDescricaoCategoria()" class="form-control" name="altDescricao"
                                            placeholder="DESCRICAO">
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