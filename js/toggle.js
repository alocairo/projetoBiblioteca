function toggle(param) {
    var x = document.getElementById(param);
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}

function closeAll(){
    toggle('periodo');
    toggle('movimentacao');
    toggle('aluno');
    toggle('alunoAtivo');
    toggle('livroAtivo')
}