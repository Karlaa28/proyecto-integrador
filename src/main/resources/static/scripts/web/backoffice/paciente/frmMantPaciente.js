$(document).on("click", "#btnagregar", function(){
    $("#hddcodpaciente").val("0");
    $("#txtdni").val("");
    $("#txtnombres").val("");
    $("#txtapellidospa").val("");
    $("#txtapellidosma").val("");
    $("#txttelefono").val("");
    $("#txtfechanacimiento").val("");
    $("#txtsexo").val("");
    $("#txtpeso").val("");
    $("#txtaltura").val("");
    $("#cbotipodesangre").empty();
    $("#cbosede").empty();

    listarCboTiposDeSangre(0);
    listarCboSedes(0);

    // Mostrar el modal
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    var fechaParts = $(this).attr("data-fechanacimientopa").substring(0,10).split('-');
    var fechaNacimiento = new Date(fechaParts[0], fechaParts[1] - 1, fechaParts[2]);
    var dia = ('0' + fechaNacimiento.getDate()).slice(-2);
    var mes = ('0' + (fechaNacimiento.getMonth() + 1)).slice(-2);
    var ano = fechaNacimiento.getFullYear();
    var fechaFormateada = ano + "-" + mes + "-" + dia;

    $("#hddcodpaciente").val($(this).attr("data-idpaciente"));
    $("#txtdni").val($(this).attr("data-dni"));
    $("#txtnombres").val($(this).attr("data-nombres"));
    $("#txtapellidospa").val($(this).attr("data-apellidospa"));
    $("#txtapellidosma").val($(this).attr("data-apellidosma"));
    $("#txttelefono").val($(this).attr("data-telefono"));
    $("#txtfechanacimiento").val(fechaFormateada);
    $("#txtsexo").val($(this).attr("data-sexo"));
    $("#txtpeso").val($(this).attr("data-peso"));
    $("#txtaltura").val($(this).attr("data-altura"));
    $("#cbotipodesangre").empty();
    $("#cbosede").empty();

    // Cargar las sedes en el combo
    listarCboTiposDeSangre($(this).attr("data-idtipodesangre"));

    // Cargar las sedes en el combo
    listarCboSedes($(this).attr("data-idsede"));

    // Mostrar el modal de actualización de paciente
    $("#modalNuevo").modal("show");
});



$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/paciente/guardar",  // Asegúrate de que la ruta sea la correcta en tu aplicación
        contentType: "application/json",
        data: JSON.stringify({
            idpaciente: $("#hddcodpaciente").val(),
            dnipa: $("#txtdni").val(),
            nombrespa: $("#txtnombres").val(),
            apellidospa: $("#txtapellidospa").val(),
            apellidosmapa: $("#txtapellidosma").val(),
            telefonopa: $("#txttelefono").val(),
            fechanacimientopa: $("#txtfechanacimiento").val(),
            sexopa: $("#txtsexo").val(),
            pesopa: $("#txtpeso").val(),
            alturapa: $("#txtaltura").val(),
            tipodesangre: $("#cbotipodesangre").val(),
            sede: $("#cbosede").val(),
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarPacientes();  // Asegúrate de tener una función para listar pacientes
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});


function listarCboSedes(idsede) {
    $.ajax({
        type: "GET",
        url: "/sede/listar", // Asegúrate de que la ruta sea la correcta en tu aplicación
        dataType: "json",
        success: function (resultado) {
            $.each(resultado, function (index, value) {
                $("#cbosede").append(
                    `<option value="${value.idsede}">${value.nombresede}</option>`
                );
            });
            if (idsede > 0) {
                $("#cbosede").val(idsede);
            }
        }
    });
}


function listarCboTiposDeSangre(idtipodesangre) {
    $.ajax({
        type: "GET",
        url: "/tipodesangre/listars",
        dataType: "json",
        success: function (resultado) {
            $.each(resultado, function (index, value) {
                $("#cbotipodesangre").append(
                    `<option value="${value.idtipodesangre}">${value.nomsangre}</option>`
                );
            });
            if (idtipodesangre > 0) {
                $("#cbotipodesangre").val(idtipodesangre);
            }
        }
    });
}


function listarPacientes() {
    $.ajax({
        type: "GET",
        url: "/paciente/listar",
        dataType: "json",
        success: function (resultado) {
            $("#tblpaciente > tbody").html("");
            $.each(resultado, function(index, value) {
                var fechaNacimiento = new Date(value.fechanacimientopa);
                var dia = ('0' + fechaNacimiento.getDate()).slice(-2);
                var mes = ('0' + (fechaNacimiento.getMonth() + 1)).slice(-2);
                var ano = fechaNacimiento.getFullYear();
                var fechaFormateada = ano + "-" + mes + "-" + dia;
                $("#tblpaciente > tbody").append("<tr>" +
                    "<td>" + value.idpaciente + "</td>" +
                    "<td>" + value.dnipa + "</td>" +
                    "<td>" + value.nombrespa + "</td>" +
                    "<td>" + value.apellidospa + "</td>" +
                    "<td>" + value.apellidosmapa + "</td>" +
                    "<td>" + value.telefonopa + "</td>" +
                    "<td>" + fechaFormateada + "</td>" +
                    "<td>" + value.sexopa + "</td>" +
                    "<td>" + value.pesopa + "</td>" +
                    "<td>" + value.alturapa + "</td>" +
                    "<td>" + value.tipodesangre.nomsangre  + "</td>" +
                    "<td>" + value.sede.nombresede + "</td>" +
                    "<td>" +
                    "<button type='button' class='btn btn-info btnactualizar'" +
                    "data-idpaciente='" + value.idpaciente + "'" +
                    "data-dni='" + value.dnipa + "'" +
                    "data-nombres='" + value.nombrespa + "'" +
                    "data-apellidospa='" + value.apellidospa + "'" +
                    "data-apellidosma='" + value.apellidosmapa + "'" +
                    "data-telefono='" + value.telefonopa + "'" +
                    "data-fechanacimientopa='" + fechaFormateada + "'" +
                    "data-sexo='" + value.sexopa + "'" +
                    "data-peso='" + value.pesopa + "'" +
                    "data-altura='" + value.alturapa + "'" +
                    "data-tipodesangre='" + value.tipodesangre.idtipodesangre + "'" +
                    "data-sede='" + value.sede.idsede + "'>" +
                    "<i class='fas fa-edit'></i></button>" +
                    "</td></tr>");
            });
        }
    });
}
