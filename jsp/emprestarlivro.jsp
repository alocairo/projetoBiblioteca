<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.List" %>
<%@ page import ="biblio.entidades.Livros" %>
<%@ page import ="biblio.entidades.Alunos" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>BIBLIOTECA - Empr�stimo</title>

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
                <i class="fa fa-handshake-o" aria-hidden="true"></i> Empr�stimo</h1>
        </div>
		<form action="empcontroller.do" method="post">
	        <table class="table table-inverse" id="myTable">
	            <thead>
	                <tr>
	                    <th>Livro</th>
	                    <th>Aluno Destino</th>
	                </tr>
	            </thead>
	            <tbody>
	                <!--       Apenas primeiro tr deve ser mantido, os outros serao din�micos-->
	                <tr>
	                    <td>
	
	                        <select name="altLivro" class="form-control" onchange="comprovante()">
	                            <option value="" disabled selected>LIVRO</option>
				<% // Scriplet
				List<Livros> listaliv = (List<Livros>) request.getAttribute("listaliv");
			    
			    for (Livros liv: listaliv) { %>
	                            <option value="<%= liv.getCodlivro() %>"><%= liv.getTitulo() %></option>
				<% } %>
	                        </select>
	                    </td>
	                    <td>
	                        <select name="altAluno" class="form-control" onchange="comprovante()">
	                            <option value="" disabled selected>ALUNO</option>
				<%
				//Scriplet
	            List<Alunos> lista = (List<Alunos>) request.getAttribute("listaalu");
	            
	            for(Alunos alu: lista) {
	
	            %>                            
	                            <option value="<%= alu.getCodmatricula() %>"><%= alu.getNomealu() %></option>
				<% } %>
	                        </select>
	                    </td>
	                </tr>
	
	            </tbody>
	        </table>
	
	                <div class="card col-lg-4 col-md-6 mb-4 h-100">
	                        <h3 class="card-header primary-color white-text" id="entrega"></h3>
	                        <div class="card-body">
	                            <h4 class="card-title">
	                                <i class="fa fa-file-text" aria-hidden="true"></i>
	                            </h4>
	                            <p class="card-text" id="destino"></p>
	                            <p id="data"></p>
	                            <p id="devolucao"></p>
	                        </div>
	                    </div>
	
	            <button name="condicao" value="emprestar" type="submit" class="btn btn-primary btn-xs">Emprestar</button>
	            <button name="impressao" name="imprimir" value="Imprimir" onclick="window.print()" class="btn btn-primary btn-xs">Imprimir</button>
            </form>
        </div>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="./Style/vendor/bootstrap/js/bootstrap.min.js"></script>
    <!-- Include custom JS for searchbox -->
    <script src="./js/custom.js"></script>

    <!-- include custom JS for Date -->
    <script src="./js/comprovante.js"></script>


                <!-- import footer -->
                <jsp:directive.include file="footer.html" />
</body>

</html>