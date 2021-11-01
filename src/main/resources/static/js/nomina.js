$(document).ready(function () {
	
	$("#cuit").mask("99-99999999-9");

    $("#search-form").submit(function (event) {

        event.preventDefault();

        doAjaxNomina();

    });
    
        
    $("#buttonConfigurarToken").click(function (event) {
        event.preventDefault();
        doAjaxNomina();
    });
    
    var tmp = $("#bloquearPantalla").val();
    var bloquearPantalla = stringToBoolean(tmp);
    if(bloquearPantalla){
    	$.blockUI.defaults.message = '<br><span><img src="/image/atencion.jpg" alt="logo atencion" width="50" height="50"/></span><h4>Atención!!! configure un token.</h4><br><p><input id="buttonConfigurarToken" type="button" value="Configurar token" class="btn btn-warning" onClick="submitConfiguracionForm();"/></p>';
        $.blockUI.defaults.css.border = '5px solid #E0A814'; 
        $.blockUI();
    } else {
    	$.unblockUI();
    }

});

function doAjaxNomina() {

    var nomina = {}
    nomina["cuit"] = $("#cuit").val();

    $("#btn-search").prop("disabled", true);
           
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/nominas/search",
        data: JSON.stringify(nomina),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
           //$("#feedback").removeClass('spinner-border text-primary');	
           var json;
           if(data.result==null){
        	   if(data.msg.includes("Error")){
        		   json = "<br><h5 class='text-danger'>"+data.msg+"</h5>";
        	   } else {
        		   json = "<br><h5>"+data.msg+"</h5>";
        	   }
            	 
            } else {
            	 json = '<br><h5>'+data.msg+'</h5><br><div class="row"><div class="col-3"><p><span><img src="/image/foto.jpg" class="rounded float-left" alt="logo foto perfil" width="200" height="200"/></p></div><div class="col-9"><p><b>Matricula:</b> '+data.result.matricula+'</p><p><b>Apellido:</b> '+data.result.apellido+'</p><p><b>Nombre:</b> '+data.result.nombre+'</p><p><b>Teléfono:</b> '+data.result.telefono+'</p><p><b>Email:</b> '+data.result.email+'</p>'
            	 		+'<p><b>Estado:</b> '+data.result.estado+'</p></div></div>';
            }
                       
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {
            const obj = JSON.parse(e.responseText);
            $('#cuit').tooltip({title: obj.msg}).tooltip('show');
            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}

function submitConfiguracionForm(){
	 $("#configurar-form").submit();
}