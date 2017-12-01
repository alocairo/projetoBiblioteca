// Obtém a data/hora atual
var data = new Date();

// Guarda cada pedaço em uma variável
var dia = data.getDate();           // 1-31
var mes = data.getMonth();          // 0-11 (zero=janeiro)
var ano = data.getFullYear();       // 4 dígitos

// Formata a data e a hora (note o mês + 1)
var str_data = dia + '/' + (mes+1) + '/' + ano4;
var str_hora = hora + ':' + min + ':' + seg;

// Mostra o resultado
alert('Hoje é ' + str_data + ' às ' + str_hora);