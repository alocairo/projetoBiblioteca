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
    </style>


</head>

<body>
    <div class="container">

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand" href="http://localhost:8080/">BIBLIOTECA</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Home
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Logout</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Login</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="page-header text-center">
            <h1>
                <i class="fa fa-tag" aria-hidden="true"></i> Categorias</h1>
        </div>

        <table class="table table-inverse" id="myTable">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Descri��o</th>
                </tr>
            </thead>
            <tbody>
                <!--       Apenas primeiro tr deve ser mantido, os outros serao dinâmicos-->
                <%
                List<Categoria> lista = (List<Categoria>) request.getAttribute("lista");
                
                for (Categoria cat: lista) {
                
                %>
                <tr>
                    <td><%= cat.getCodcategoria() %></td>
                    <td><%= cat.getDescricao() %></td>
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
                        <th>C�digo</th>
                        <th>Descri��o</th>
                    </tr>
                    <tr>
                        <td>
                            <input type="search" id="dadoCodigoCategoria" onkeyup="buscaCodigoCategoria()" class="form-control" name="altCodigo" placeholder="CODIGO">
                        </td>
                        <td>
                            <input type="search" id="dadoDescricaoCategoria" onkeyup="buscaDescricaoCategoria()" class="form-control" name="altDescricao" placeholder="DESCRICAO">
                        </td>
                    </tr>
                </tbody>
            </table>
            <div class="container margin-fix">
                <button name="condicao" value="inserir" type="submit" class="btn btn-primary btn-xs">Inserir</button>
                <button name="condicao" value="alterar" type="submit" class="btn btn-primary btn-xs">Alterar</button>
            </div>
        </form>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="./Style/vendor/bootstrap/js/bootstrap.min.js"></script>
    <!-- Include custom JS for searchbox -->
    <script src="./js/custom.js"></script>

    <footer class="py-5 bg-dark">
        <div class="container">
            <p class="m-0 text-center">
                <a href="https://github.com/AdrianoCh">
                    <i class="fa fa-github-alt" aria-hidden="true"></i> AdrianoCh</a>
            </p>
            <p class="m-0 text-center">
                <a href="https://github.com/alocairo">
                    <i class="fa fa-github-alt" aria-hidden="true"></i> alocairo</a>
            </p>
            <p class="m-0 text-center text-white">
                <a href="https://github.com/AdrianoCh/projetoBiblioteca">Project Avaliable Here
                    <i class="fa fa-github-square" aria-hidden="true"></i>
                </a>
            </p>

        </div>
    </footer>
</body>

</html>