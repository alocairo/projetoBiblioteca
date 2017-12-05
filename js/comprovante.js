// Obtém a data/hora atual
var data = new Date();

// Guarda cada pedaço em uma variável
var dia = data.getDate();           // 1-31
var mes = data.getMonth();          // 0-11 (zero=janeiro)
var ano = data.getFullYear();       // 4 dígitos
var mesDevolucao = data.getMonth();

// Formata a data e a hora (note o mês + 1)
//var str_data = dia + '/' + (mes+1) + '/' + ano4;
//var str_hora = hora + ':' + min + ':' + seg;

// Mostra o resultado
//alert('Hoje é ' + str_data + ' às ' + str_hora);

function comprovante() {
    var calc = (dia + 10);
    if((mes == 1 && dia > 31) || (mes == 3 && dia > 31) || (mes == 4 && dia > 31) || (mes == 6 && dia > 31) || (mes == 7 && dia > 31) || (mes == 9 && dia > 31) || (mes == 12 && dia > 31)){
        calc = 31 - dia;
        mesDevolucao++
    }
    else if(dia > 30){
        calc = 30 - dia;
        mesDevolucao++
    }
    else if(mes == 2 && dia > 28){
        calc = 28 - dia;
        mesDevolucao++
    }

    var value = document.getElementsByTagName("select");
    document.getElementById("entrega").innerHTML = "Livro: " + value[0].value;
    document.getElementById("destino").innerHTML = "Usuário: " + value[1].value;
    document.getElementById("data").innerHTML = "Data atual: " + dia + "/" + (mes+1) + "/" + ano;
    document.getElementById("devolucao").innerHTML = "Data da devolução: " + calc + "/" + (mesDevolucao+1) + "/" + ano;
}