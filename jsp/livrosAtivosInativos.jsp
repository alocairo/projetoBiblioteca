<!DOCTYPE html>
<html lang="pt-br">

<head>
    <title>BIBLIOTECA - Livros com alunos Ativos / Inativos</title>

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
                <i class="fa fa-tag" aria-hidden="true"></i> Livros com usuários Ativos / Inativos</h1>
        </div>

        <table class="table table-inverse" id="myTable">
            <thead>
                <tr>
                    <th>Livros com Usuários Ativos</th>
                    <th>Livros com Usuários Inativos</th>
                </tr>
            </thead>
            <tbody>
                <!--       Apenas primeiro tr deve ser mantido, os outros serao dinâmicos-->
                <tr>
                    <td>25</td>
                    <td>35</td>
                </tr>

            </tbody>
        </table>
        <div class="container margin-fix">
            <button name="impressao" name="imprimir" value="Imprimir" onclick="window.print()" class="btn btn-primary btn-xs">Imprimir</button>
        </div>

    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="./Style/vendor/bootstrap/js/bootstrap.min.js"></script>
    <!-- Include custom JS for searchbox -->
    <script src="./js/custom.js"></script>

    <jsp:directive.include file="footer.html" />
</body>

</html>
