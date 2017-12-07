<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.List" %>
<%@ page import ="biblio.entidades.Livros" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>BIBLIOTECA - Recebimento</title>

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
                <i class="fa fa-handshake-o" aria-hidden="true"></i> Recebimento</h1>
        </div>
	<form action="devcontroller.do" method="post">
        <table class="table table-inverse" id="myTable">
            <thead>
                <tr>
                    <th>Livro</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <select name="altLivro" class="form-control">

                            <option value="" disabled selected>LIVRO</option>
                       		<% // Scriplet
							List<Livros> lista = (List<Livros>) request.getAttribute("lista");

						    for (Livros liv: lista) {
						    %>
                            <option value="<%= liv.getCodlivro() %>"><%= liv.getTitulo() %></option>
							<% } %>
                        </select>
                    </td>
                </tr>

            </tbody>
        </table>
            <button name="condicao" value="devolver" type="submit" class="btn btn-primary btn-xs margin-fix">Devolver</button>
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