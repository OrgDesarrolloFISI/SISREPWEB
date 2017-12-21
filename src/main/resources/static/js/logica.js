
class DocentePeriodo {
	
	constructor(codigo,nombre,periodo,inicio,fin)
	{
		this.codigoDocente = codigo;
		this.nombreDocente = nombre;
		this.periodoNombre = periodo;
		this.inicioFecha = inicio;
		this.finFecha = fin;
	}
	
}


function getObjectDP(){
	let codigo = $("#codigo").val();
	let nombre = $("#nombre").val();
	let periodo = $("#periodo").val();
	let inicio = $("#inicioFec").val();
	let fin = $("#finFec").val();
	let docentePeriodo = new DocentePeriodo(
			codigo,nombre,periodo,inicio,fin);
	return docentePeriodo;
}

$(document).ready(function(){
	$("#codigo").change(function(){
		let objDP = getObjectDP();
		//console.log(objDP);
		let objDPjson = JSON.stringify(objDP);
		//llamada a la ruta de registros de asistencia
		console.log(objDPjson);
	});	
});

function obtenerFechasPeriodo(periodo){
	let resultado = [];
	$.ajax({
         url: '/getFechaPeriodo/'+periodo,
         type: 'GET', 
         contentType: "application/json; charset=utf-8",
         // el tipo de información que se espera de respuesta
         dataType: "json",
         success: function(data) {   
        	 resultado = data;
        	 console.log(resultado);
        	 $('#inicioFec').val(data[0]);
        	 $('#finFec').val(data[1]);
        	 let inicioPer = $('#inicioFec').val();
     		 let finPer = $('#finFec').val();
     		 $('#inicioFec').daterangepicker({
     		    singleDatePicker: true,
     		    locale: {
     		        format: 'YYYY-MM-DD'
     		      },
     		    minDate: inicioPer,
     		    maxDate: finPer
     		 });
     		 $('#finFec').daterangepicker({
     		    singleDatePicker: true,
     		    locale: {
     		        format: 'YYYY-MM-DD'
     		      },
     		    minDate: inicioPer,
     		    maxDate: finPer
     		 });
         },
         error : function(xhr, status) {
             alert('Disculpe, existio un problema -- '+xhr+" -- "+status);
             resultado = xhr;
         },         
	});
	return resultado;
}
	
	
$(document).ready(function(){
	$("select").change(function(){
		/*$("#inicioFec").val("2017-09-25");
		$("#finFec").val("2017-11-25");*/
		let periodo = $("#periodo").val()
		obtenerFechasPeriodo(periodo);		
	});	
});

/*
var Producto = function(codigo, unidades) {
	this.codigo = codigo;
	this.unidades = unidades;
}
var Pedido = function(codigo, descripcion) {
	this.codigo = codigo;
	this.descripcion = descripcion;
	this.productos = new Array();
}

var prod = new Producto(123,5);
console.log(prod);
*/


	
	
	
	