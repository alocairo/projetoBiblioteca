var filter;
function busca(x) {
  var table, tr, td, i;
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  console.log('o filtro é ' + filter)


  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[x];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}

function buscaMatricula() {
  filter = document.getElementById("dadoMatricula").value.toUpperCase();
  busca(0);
}

function buscaNome() {
  filter = document.getElementById("dadoNome").value.toUpperCase();
  busca(1);
}

function buscaEndereco() {
  filter = document.getElementById("dadoEndereco").value.toUpperCase();
  busca(2);
}

function buscaSituacao() {
  filter = document.getElementById("dadoSituacao").value.toUpperCase();
  busca(3);
}

//--------------> functions for biblioteca <---------------------

function buscaCodigoBiblioteca() {
  filter = document.getElementById("dadoCodigoBiblioteca").value.toUpperCase();
  busca(0);
}

function buscaNomeBiblioteca() {
  filter = document.getElementById("dadoNomeBiblioteca").value.toUpperCase();
  busca(1);
}

function buscaEnderecoBiblioteca() {
  filter = document.getElementById("dadoEnderecoBiblioteca").value.toUpperCase();
  busca(2);
}

//-------------> functions for categorias <-----------------------------

function buscaCodigoCategoria() {
  filter = document.getElementById("dadoCodigoCategoria").value.toUpperCase();
  busca(0);
}

function buscaDescricaoCategoria() {
  filter = document.getElementById("dadoDescricaoCategoria").value.toUpperCase();
  busca(1);
}

//-------------> functions for funcionario <-------------------------------------

function buscaCodigoFuncionario() {
  filter = document.getElementById("dadoCodigoFuncionario").value.toUpperCase();
  busca(0);
}

function buscaNomeFuncionario() {
  filter = document.getElementById("dadoNomeFuncionario").value.toUpperCase();
  busca(1);
}

function buscaEnderecoFuncionario() {
  filter = document.getElementById("dadoEnderecoFuncionario").value.toUpperCase();
  busca(2);
}

function buscaTelefoneFuncionario() {
  filter = document.getElementById("dadoTelefoneFuncionario").value.toUpperCase();
  busca(3);
}

function buscaSalarioFuncionario() {
  filter = document.getElementById("dadoSalarioFuncionario").value.toUpperCase();
  busca(4);
}

function buscaBibliotecaFuncionario() {
  filter = document.getElementById("dadoBibliotecaFuncionario").value.toUpperCase();
  busca(5);
}

//-----------------> functions for livros <----------------------------------

function buscaCodigoLivro() {
  filter = document.getElementById("dadoCodigoLivro").value.toUpperCase();
  busca(0);
}

function buscaTituloLivro() {
  filter = document.getElementById("dadoTituloLivro").value.toUpperCase();
  busca(1);
}

function buscaEditoraLivro() {
  filter = document.getElementById("dadoEditoraLivro").value.toUpperCase();
  busca(2);
}

function buscaValorLivro() {
  filter = document.getElementById("dadoValorLivro").value.toUpperCase();
  busca(3);
}

function buscaCategoriaLivro() {
  filter = document.getElementById("dadoCategoriaLivro").value.toUpperCase();
  busca(4);
}

function buscaBibliotecaLivro() {
  filter = document.getElementById("dadoBibliotecaLivro").value.toUpperCase();
  busca(5);
}

function buscaSituacaoLivro() {
  filter = document.getElementById("dadoSituacaoLivro").value.toUpperCase();
  busca(5);
}

//-----------------> Functions for Usuarios <------------------------------

function buscaCodigoUsuario() {
  filter = document.getElementById("dadoCodigoUsuario").value.toUpperCase();
  busca(0);
}

function buscaLoginUsuario() {
  filter = document.getElementById("dadoLoginUsuario").value.toUpperCase();
  busca(1);
}