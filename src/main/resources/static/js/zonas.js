$(document).ready(function() {
    cargarZonas();
    $('#zonas').DataTable();
});

async function cargarZonas() {
    const request = await fetch('zona/listaZona', {
        method: 'GET',
        headers: getHeaders()
    });
    const zonas = await request.json();
    console.log(zonas);

    let listadoHtml = '';
    for (let zona of zonas) {
        let botonEditar = '<a class="">' +
            '<img src="img/editar.png" width="25" height="25" style="float: left;margin-left: 15px">'+
            '</a>';
        let botonEliminar = '<a onclick="eliminarZona(' + zona.idZona + ')">' +
            '<img src="img/eliminar.png" width="30" height="30" style="float: left;margin-left: 15px">' +
            '</a>';

        let usuarioHtml = '<tr><td>'+zona.idZona+'</td><td>' + zona.nombre + ' </td><td> ' + zona.nombreCiudad
            + '</td><td>' + botonEditar + '</td><td>' + botonEliminar + '</td></tr>';
        listadoHtml += usuarioHtml;
    }

    document.querySelector('#zonas tbody').outerHTML = listadoHtml;

}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    };
}

async function eliminarZona(id) {
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

