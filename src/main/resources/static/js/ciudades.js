$(document).ready(function() {
    cargarCiudades();
    $('#ciudades').DataTable();
});

async function cargarCiudades() {
    const request = await fetch('ciudad/listaCiudad', {
        method: 'GET',
        headers: getHeaders()
    });
    const ciudades = await request.json();
    console.log(ciudades);

    let listadoHtml = '';
    for (let ciudad of ciudades) {
        let botonEditar = '<a class="">' +
            '<img src="img/editar.png" width="25" height="25" style="float: left;margin-left: 15px">'+
            '</a>';
        let botonEliminar = '<a onclick="eliminarCiudad(' + ciudad.idCiudad + ')">' +
            '<img src="img/eliminar.png" width="30" height="30" style="float: left;margin-left: 15px">' +
            '</a>';

        let usuarioHtml = '<tr><td>'+ciudad.idCiudad+'</td><td>' + ciudad.nombre + ' </td><td> ' + ciudad.nombreDepartamento
            + '</td><td>' + botonEditar + '</td><td>' + botonEliminar + '</td></tr>';
        listadoHtml += usuarioHtml;
    }

    document.querySelector('#ciudades tbody').outerHTML = listadoHtml;

}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    };
}

async function eliminarCiudad(id) {
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

