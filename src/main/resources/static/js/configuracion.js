$(document).ready(function () {
	
	$("#save-form").submit(function (event) {

        event.preventDefault();

        doAjaxConfiguracion();

    });

});

function doAjaxConfiguracion() {

    var configuracion = {}
    configuracion["token"] = $("#token").val();

    $("#btn-save").prop("disabled", true);
           
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/configuraciones/save",
        data: JSON.stringify(configuracion),
        dataType: 'json',
        cache: false,
        timeout: 600000,
		success : function(data) {
			var json;
			if (data.msg.includes("Error")) {
				json = "<br><h5 class='text-danger'>" + data.msg + "</h5>";
			} else {
				json = "<br><h5>" + data.msg + "</h5>";
			}

			$('#feedback').html(json);

			console.log("SUCCESS : ", data);
			$("#btn-save").prop("disabled", false);

		},
        error: function (e) {
        	const obj = JSON.parse(e.responseText);
            $('#token').tooltip({title: obj.msg}).tooltip('show');
            console.log("ERROR : ", e);
            $("#btn-save").prop("disabled", false);

        }
    });

}

function submitNominaForm(){
	 $("#nomina-form").submit();
}