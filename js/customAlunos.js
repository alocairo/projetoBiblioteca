function myFunction() {
    var input, filter, table, tr, td, i;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");
    
//fazer percorrer os td, e verificar em todos os dados daa tabela os dados digitado
//e nao so no primeiro td[0]

    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[0];
      if (td) {
        if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
          tr[i].style.display = ""; 
        } else {
          tr[i].style.display = "none";
        }
      }       
    }
  }
  