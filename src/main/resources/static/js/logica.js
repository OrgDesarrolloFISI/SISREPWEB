
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
	$("input").change(function(){
		let objDP = getObjectDP();
		//console.log(objDP);
		let objDPjson = JSON.stringify(objDP);
		console.log(objDPjson);
	});	
});


$(document).ready(function(){
	$("select").change(function(){
		$("#inicioFec").val("2017-09-25");
		$("#finFec").val("2017-11-25");
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


	
	
	
	