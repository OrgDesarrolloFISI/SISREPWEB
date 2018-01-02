
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
	let codigo = $("#codigo").val().trim();
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
        	 let inicioPer = data.periodoFechaInicio;
        	 let finPer = data.periodoFechaFin;
        	 $('#inicioFec').val(inicioPer);
        	 $('#finFec').val(finPer);     		 
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

function obtenerYmostrarRegistroAsistencia(objDPjson){
	$.ajax({
		 url: '/jsonDP',
         type: 'POST', 
         contentType: "application/json; charset=utf-8",
         dataType: "json",
         data: objDPjson,
         success: function(data){
        	 //console.log(data);        	 
        	 $("#nombre").val(data.nombreDocente); //si esta vacio verificar en el back que no se envie nulo
        	 $("#totalHNL").val(data.totalHNL)
        	 $("#dataTable").dataTable().fnClearTable();
             let nuevaDataTable = data.listaRegistroAsistencia;
             if(nuevaDataTable != null && $.isArray(nuevaDataTable)){
            	 //console.log(nuevaDataTable);
                 $.each(nuevaDataTable, function(index, value){
                	 $('#dataTable').dataTable().fnAddData( [
                		 value.escuela,value.curso,
                		 value.nroGrupo,value.tipo,
                		 value.horaInicio,value.horaFin,
                		 value.marcaEnt,value.marcaSal,
                		 value.fecha,value.horaNL ]
                	     );
                 });
     			$('#btnReporte').attr("disabled",false);
             }else{
            	$('#btnReporte').attr("disabled",true);
             }
         },
         error : function(xhr, status) {
             alert('Disculpe, existio un problema -- '+xhr+" -- "+status);
         },		
	});
}

/**Iniciar dataTable y dateRangePicker
 * Capturar antes la fecha de inicio y fin fuera
 * del dateRangePicker para que no devuelva la fecha de hoy.
 */
$(document).ready(function(){
	
	$('#btnReporte').attr("disabled",true);
	
	//dataTable init	
	$('#dataTable').dataTable({
	    	"searching": false,
	});

	//dateRangePicker init
	let inicioPer = $('#inicioFec').val();
	//console.log(inicioPer);
	let finPer = $('#finFec').val();
	//console.log(finPer);
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
});


	
/** @input periodo
 * @process Consulta las fechas del periodo seleccionado
 * @output Nuevas fechas
 */
$(document).ready(function(){
	$("select").change(function(){
		let periodo = $("#periodo").val()
		updateFechasPeriodo(periodo);		
	});	
});


/** @input codigo
 * @process Consulta las asistencias/inasistencias
 * @output registros en dataTable
 */
$(document).ready(function(){
	$("#codigo").change(function(){
		let codTemp = $("#codigo").val().trim();
		//console.log(codTemp);
		if(codTemp!==""){
			let objDP = getObjectDP();
			let objDPjson = JSON.stringify(objDP);
			//console.log("Se envia:"+objDPjson);
			obtenerYmostrarRegistroAsistencia(objDPjson);
		}else{
			alert("El codigo no puede estar blanco");				
		}
	});	
});

$(document).ready(function(){
	$("#updateButton").click(function(){
		let objDP = getObjectDP();
		let objDPjson = JSON.stringify(objDP);
		//console.log("Se envia:"+objDPjson);
		obtenerYmostrarRegistroAsistencia(objDPjson);		
	});	
});
	
