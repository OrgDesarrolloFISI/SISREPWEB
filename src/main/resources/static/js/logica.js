
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

function setInputsDP(codigo,nombre,periodo,inicio,fin){
	$("#codigo").val(codigo);
	$("#nombre").val();
	$("#periodo").val();
	$("#inicioFec").val();
	$("#finFec").val();
}


function updateFechasPeriodo(periodo){
	$.ajax({
         url: '/getFechaPeriodo/'+periodo,
         type: 'GET', 
         contentType: "application/json; charset=utf-8",
         // el tipo de información que se espera de respuesta
         dataType: "json",
         success: function(data) {
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
         },         
	});
}

function obtenerRegistroAsistencia(objDPjson){
	$.ajax({
		 url: '/jsonDP',
         type: 'POST', 
         contentType: "application/json; charset=utf-8",
         dataType: "json",
         data: objDPjson,
         success: function(data){
        	 console.log(data);
        	 $("#nombre").val(data.nombreDocente); //si esta vacio verificar en el back que no se envie nulo
        	 /* Inicializamos tu tabla */
        	 $("#dataTable").html('');
             //let table = $("#dataTable").dataTable();
             let nuevaData = data.listaRegistroAsistencia;
             /* Vemos que la respuesta no este vacía y sea una arreglo */
             if(data != null && $.isArray(nuevaData)){            	 
            	 console.log(data.listaRegistroAsistencia);
            	 console.log(nuevaData);
                 /* Recorremos tu respuesta con each */
                 $.each(nuevaData, function(index, value){
                     /* Vamos agregando a nuestra tabla las filas necesarias */
                     $("#dataTable").append("<tr><td>" + value.escuela + "</td><td>" + value.curso
                    		 + "</td><td>" +  value.nroGrupo + "</td><td>" + value.tipo
                    		 + "</td><td>" +  value.horaInicio + "</td><td>" + value.horaFin
                    		 + "</td><td>" +  value.marcaEnt + "</td><td>" + value.marcaSal
                    		 + "</td><td>" +  value.fecha + "</td><td>" +  value.horaNL + "</td></tr>");
                	/* table.row.add( {
                	        "escuela":      value.escuela,
                	        "curso":   		value.curso,
                	        "nroGrupo":     value.nroGrupo,
                	        "tipo": 		value.tipo,
                	        "horaInicio":   value.horaInicio,
                	        "horaFin":      value.horaFin,
                	        "marcaEnt":     value.marcaEnt,
                	        "marcaSal":     value.marcaSal,
                	        "fecha":       	value.fecha,
                	        "horaNL":       value.horaNL
                	    } ).draw();*/
                 });
                 $("#dataTable").dataTable();
             }
         },
         error : function(xhr, status) {
             alert('Disculpe, existio un problema -- '+xhr+" -- "+status);
         },		
	});
}
	
	
$(document).ready(function(){
	$("select").change(function(){
		let periodo = $("#periodo").val()
		updateFechasPeriodo(periodo);		
	});	
});


$(document).ready(function(){
	$("#codigo").change(function(){
		let objDP = getObjectDP();
		let objDPjson = JSON.stringify(objDP);
		console.log("Se envia:"+objDPjson);
		//llamada a la ruta de registros de asistencia
		obtenerRegistroAsistencia(objDPjson);
		
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


	
	
	
	