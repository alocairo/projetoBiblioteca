var filter = "Disponível".toUpperCase();
function buscaDisponibilidade() {
    var table, tr, td, i, change;
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");
    console.log('o filtro é ' + filter)

    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[6];
        if (td) {
            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                //tr[i].style.display = "";
                change = tr[i].getElementsByTagName("td")[6];
                change.innerHTML = '<a href="./emprestimo.html"><td>Disponível</td></a>';
            }
        }
    }
}