var filter;
function busca(x) {
  var input, table, tr, td, i;
  input = document.getElementById("dado");
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

function buscaCodigo() {
  filter = document.getElementById("dadoCodigo").value.toUpperCase();
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