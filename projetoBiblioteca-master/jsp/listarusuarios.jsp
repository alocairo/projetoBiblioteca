<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ page import ="java.util.List" %>
	<%@ page import ="biblio.entidades.Login" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>BIBLIOTECA - Usuarios</title>

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
                <i class="fa fa-id-card" aria-hidden="true"></i> Usuarios</h1>
        </div>

        <table class="table table-inverse" id="myTable">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Login</th>
                </tr>
            </thead>
            <tbody>
                <!--       Apenas primeiro tr deve ser mantido, os outros serao dinâmicos-->
                <!-- Pensar e vincular usuario com funcionario, ou alun0 -->
                                            <%
			//Scriplet
            List<Login> lista = (List<Login>) request.getAttribute("lista");
            
            for(Login log: lista) {

            %>
                <tr>
                    <td><%= log.getCodlogin() %></td>
                    <td><%= log.getUsuario() %></td>
                </tr>
            
            <% } %>
            </tbody>
        </table>

        <h2>
            <i class="fa fa-users" aria-hidden="true"></i> Gerenciar Usuarios</h2>

        <form>
            <table class="table">
                <tbody>
                    <tr>
                        <th>Codigo</th>
                        <th>Login</th>
                    </tr>
                    <tr>
                        <td>
                            <input name="altCodigo" type="search" id="dadoCodigoUsuario" onkeyup="buscaCodigoUsuario()" class="form-control" placeholder="CODIGO">
                        </td>
                        <td>
                            <input name="altLogin" type="search" id="dadoLoginUsuario" onkeyup="buscaLoginUsuario()" class="form-control" placeholder="NOME">
                        </td>
                    </tr>
                </tbody>
            </table>
            <div class="container margin-fix">
                <button type="button" class="btn btn-primary btn-xs">Inserir</button>
                <button type="button" class="btn btn-primary btn-xs">Alterar</button>
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