$(document).ready(function() {
    cargarCuadrillas();
    $('#cudrillas').DataTable();
});

async function cargarCuadrillas() {
    const request = await fetch('cuadrilla/listaCuadrilla', {
        method: 'GET',
        headers: getHeaders()
    });
    const cuadrillas = await request.json();
    console.log(cuadrillas);

    let listadoHtml = '';
    for (let cuadrilla of cuadrillas) {
        let botonEditar = '<a class="">' +
            '<img src="img/editar.png" width="25" height="25" style="float: left;margin-left: 15px">'+
            '</a>';
        let botonEliminar = '<a onclick="eliminarCuadrilla(' + cuadrilla.idCuadrilla + ')">' +
            '<img src="img/eliminar.png" width="30" height="30" style="float: left;margin-left: 15px">' +
            '</a>';

        let usuarioHtml = '<tr><td>'+cuadrilla.idCuadrilla+'</td><td>' + cuadrilla.nombreCuadrilla + ' </td><td> ' + cuadrilla.nombreProveedor + '</td><td>'
            + cuadrilla.nombreTurno + '</td><td>' + botonEditar + '</td><td>' + botonEliminar + '</td></tr>';
        listadoHtml += usuarioHtml;
    }

    document.querySelector('#cudrillas tbody').outerHTML = listadoHtml;

}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    };
}

async function eliminarCuadrilla(id) {
    let datos = {};
    if (!confirm('¿Desea eliminar esta cuadrilla?')) {
        return;
    }
    datos.id_usuario = id;

    const request = await fetch('usuario/eliminarUsuario/' + id, {
        method: 'POST',
        headers: getHeaders(),
        body: JSON.stringify(datos)
    });
    location.reload()
}

