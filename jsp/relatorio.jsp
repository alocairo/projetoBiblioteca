<!DOCTYPE html>
<html lang="pt-br">

<head>
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
            position: relative;
        }

        .custom {
            margin-top: 30px;
            margin-bottom: 50px;
        }
    </style>


</head>

<body onload="closeAll()">
    <div class="container">

        <!-- import the navbar -->
        <jsp:directive.include file="nav.html" />

        <div class="page-header text-center custom">
            <h1>
                <i class="fa fa-info-circle" aria-hidden="true"></i> Relatórios</h1>
        </div>

        <div class="row">
            <div class="card col-lg-4 col-md-6 mb-4">
                <button type="button" class="btn btn-info" onclick="toggle('periodo')">EMPRÉSTIMOS POR PERÍODO</button>
            </div>

            <div class="card col-lg-4 col-md-6 mb-4">
                <button type="button" class="btn btn-info" onclick="toggle('movimentacao')">MOVIMENTAÇÃO DE LIVRO</button>
            </div>

            <div class="card col-lg-4 col-md-6 mb-4">
                <button type="button" class="btn btn-info" onclick="toggle('aluno')">HISTÓRICO POR ALUNO</button>
            </div>

            <div class="card col-lg-4 col-md-6 mb-4">
                <button type="button" class="btn btn-info" onclick="toggle('alunoAtivo')">Alunos Ativos/Inativos</button>
            </div>

            <div class="card col-lg-4 col-md-6 mb-4">
                <button type="button" class="btn btn-info" onclick="toggle('livroAtivo')">Livros com Alunos Ativos/Inativos</button>
            </div>

            <div class="card col-lg-4 col-md-6 mb-4">
                <button name="imprimir" value="Imprimir" onclick="window.print()" class="btn btn-primary btn-xs margin-fix">Imprimir</button>
            </div>
        </div>

        <!-- EMPRESTIMOS POR PERIODO -->
        <div id="periodo">
            <button type="button" class="btn btn-info">EMPRÉSTIMOS POR PERÍODO</button>
            <table class="table table-inverse">
                <thead>
                    <tr>
                        <th>Período</th>
                        <th>Empréstimo</th>
                    </tr>
                </thead>
                <tbody>
                    <!--       Apenas primeiro tr deve ser mantido, os outros serao dinâmicos-->
                    <tr>
                        <td>
                            <i class="fa fa-calendar-check-o" aria-hidden="true"></i> 10/12/17</td>
                        <td>O Senhor dos Anéis</td>
                        <td>O Senhor dos Anéis</td>
                        <td>O Senhor dos Anéis</td>
                        <td>O Senhor dos Anéis</td>
                        <td>O Senhor dos Anéis</td>
                        <td>O Senhor dos Anéis</td>
                        <td>O Senhor dos Anéis</td>
                        <td>O Senhor dos Anéis</td>
                    </tr>

                    <tr>
                        <td>
                            <i class="fa fa-calendar-check-o" aria-hidden="true"></i> 11/12/17</td>
                        <td>Harry Potter</td>
                        <td>O Senhor dos Anéis</td>
                        <td>O Senhor dos Anéis</td>
                        <td>O Senhor dos Anéis</td>
                        <td>O Senhor dos Anéis</td>
                        <td>O Senhor dos Anéis</td>
                    </tr>

                    <tr>
                        <td>
                            <i class="fa fa-calendar-check-o" aria-hidden="true"></i> 12/12/17</td>
                        <td>O Cortiço</td>
                        <td>O Senhor dos Anéis</td>
                        <td>O Senhor dos Anéis</td>
                        <td>O Senhor dos Anéis</td>
                        <td>O Senhor dos Anéis</td>
                        <td>O Senhor dos Anéis</td>
                        <td>O Senhor dos Anéis</td>
                    </tr>

                    <tr>
                        <td>
                            <i class="fa fa-calendar-check-o" aria-hidden="true"></i> 10/12/17</td>
                        <td>Aprenda Química</td>
                        <td>O Senhor dos Anéis</td>
                        <td>O Senhor dos Anéis</td>
                        <td>O Senhor dos Anéis</td>
                    </tr>

                    <tr>
                        <td>
                            <i class="fa fa-calendar-check-o" aria-hidden="true"></i> 10/12/17</td>
                        <td>O Outro Lado da Meia Noite</td>
                        <td>O Senhor dos Anéis</td>
                        <td>O Senhor dos Anéis</td>
                        <td>O Senhor dos Anéis</td>
                        <td>O Senhor dos Anéis</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <!-- EMPRESTIMOS POR MOVIMENTAÇÃO DO LIVRO -->

        <div id="movimentacao">
            <button type="button" class="btn btn-info">MOVIMENTAÇÃO DE LIVRO</button>
            <table class="table table-inverse">
                <thead>
                    <tr>
                        <th>Livro</th>
                        <th>Movimentação</th>
                        <th>Data</th>
                    </tr>
                </thead>
                <tbody>
                    <!--       Apenas primeiro tr deve ser mantido, os outros serao dinâmicos-->
                    <tr>
                        <td>O Senhor dos Anéis</td>
                        <td>Emprestado</td>
                        <td>
                            <i class="fa fa-calendar-check-o" aria-hidden="true"></i> 10/12/17</td>
                    </tr>

                    <tr>
                        <td>O Senhor dos ANÕES</td>
                        <td>LIVRE</td>
                        <td>
                            <i class="fa fa-calendar-check-o" aria-hidden="true"></i> 10/12/19</td>
                    </tr>
                    <tr>
                        <td>O Senhor dos ANÕES</td>
                        <td>LIVRE</td>
                        <td>
                            <i class="fa fa-calendar-check-o" aria-hidden="true"></i> 10/12/19</td>
                    </tr>
                    <tr>
                        <td>O Senhor dos ANÕES</td>
                        <td>LIVRE</td>
                        <td>
                            <i class="fa fa-calendar-check-o" aria-hidden="true"></i> 10/12/19</td>
                    </tr>
                    <tr>
                        <td>O Senhor dos ANÕES</td>
                        <td>LIVRE</td>
                        <td>
                            <i class="fa fa-calendar-check-o" aria-hidden="true"></i> 10/12/19</td>
                    </tr>
                    <tr>
                        <td>O Senhor dos ANÕES</td>
                        <td>LIVRE</td>
                        <td>
                            <i class="fa fa-calendar-check-o" aria-hidden="true"></i> 10/12/19</td>
                    </tr>

                </tbody>
            </table>
        </div>

        <!-- HISTÓRICO POR ALUNO -->
        <div id="aluno">
            <button type="button" class="btn btn-info">HISTÓRICO POR ALUNO</button>
            <table class="table table-inverse">
                <thead>
                    <tr>
                        <th>Aluno</th>
                        <th>Livro</th>
                        <th>Data Retirada</th>
                        <th>Data Entrega</th>
                    </tr>
                </thead>
                <tbody>
                    <!--       Apenas primeiro tr deve ser mantido, os outros serao dinâmicos-->
                    <tr>
                        <td>Fulano de Tal</td>
                        <td>O Senhor dos Anéis</td>
                        <td>
                            <i class="fa fa-calendar-check-o" aria-hidden="true"></i> 10/12/17</td>
                        <td>
                            <i class="fa fa-calendar-check-o" aria-hidden="true"></i> 10/12/17</td>
                    </tr>
                    <tr>
                        <td>Fulano de Tal</td>
                        <td>O Senhor dos Anéis</td>
                        <td>
                            <i class="fa fa-calendar-check-o" aria-hidden="true"></i> 10/12/17</td>
                        <td>
                            <i class="fa fa-calendar-check-o" aria-hidden="true"></i> 10/12/17</td>
                    </tr>
                    <tr>
                        <td>Fulano de Tal</td>
                        <td>O Senhor dos Anéis</td>
                        <td>
                            <i class="fa fa-calendar-check-o" aria-hidden="true"></i> 10/12/17</td>
                        <td>
                            <i class="fa fa-calendar-check-o" aria-hidden="true"></i> 10/12/17</td>
                    </tr>
                    <tr>
                        <td>Fulano de Tal</td>
                        <td>O Senhor dos Anéis</td>
                        <td>
                            <i class="fa fa-calendar-check-o" aria-hidden="true"></i> 10/12/17</td>
                        <td>
                            <i class="fa fa-calendar-check-o" aria-hidden="true"></i> 10/12/17</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <!-- Alunos ativos/inativos -->

        <div id="alunoAtivo">
            <button type="button" class="btn btn-info">Alunos Ativos/Inativos</button>
            <table class="table table-inverse">
                <thead>
                    <tr>
                        <th>Total de Alunos</th>
                        <th>Ativos</th>
                        <th>Inativos</th>
                    </tr>
                </thead>
                <tbody>
                    <!--       Apenas primeiro tr deve ser mantido, os outros serao dinâmicos-->
                    <tr>
                        <td>30</td>
                        <td>15</td>
                        <td>15</td>
                    </tr>
                </tbody>
            </table>
        </div>

        <!-- QUANTIDDE DE LIVROS -->
        <div id="livroAtivo">
            <button type="button" class="btn btn-info">Quantiadade de Livros com Alunos Ativos/Inativos</button>
            <table class="table table-inverse">
                <thead>
                    <tr>
                        <th>Total de Livros</th>
                        <th>Livros com Alunos Ativos</th>
                        <th>Livros com Alunos Inativos</th>
                    </tr>
                </thead>
                <tbody>
                    <!--       Apenas primeiro tr deve ser mantido, os outros serao dinâmicos-->
                    <tr>
                        <td>30</td>
                        <td>15</td>
                        <td>15</td>
                    </tr>
                </tbody>
            </table>

            <button name="imprimir" value="Imprimir" onclick="window.print()" class="btn btn-primary btn-xs margin-fix">Imprimir</button>
        </div>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="./Style/vendor/bootstrap/js/bootstrap.min.js"></script>
    <!-- Include custom JS for searchbox -->
    <script src="./js/custom.js"></script>
    <!-- Include js for toggle function -->
    <script src="./js/toggle.js"></script>

    <jsp:directive.include file="footer.html" />
</body>

</html>