$(document).ready(function() {
    cargarDepartamentos();
    $('#departamentos').DataTable();
});

async function cargarDepartamentos() {
    const request = await fetch('departamento/listaDepartamento', {
        method: 'GET',
        headers: getHeaders()
    });
    const departamentos = await request.json();
    console.log(departamentos);

    let listadoHtml = '';
    for (let departamento of departamentos) {
        let botonEditar = '<a class="">' +
            '<img src="img/editar.png" width="25" height="25" style="float: left;margin-left: 15px">'+
            '</a>';
        let botonEliminar = '<a onclick="eliminarDepartamento(' + departamento.idDepartamento + ')">' +
            '<img src="img/eliminar.png" width="30" height="30" style="float: left;margin-left: 15px">' +
            '</a>';

        let usuarioHtml = '<tr><td>'+ departamento.idDepartamento +'</td><td>' + departamento.nombre + '</td><td>' + botonEditar + '</td><td>' + botonEliminar + '</td></tr>';
        listadoHtml += usuarioHtml;
    }

    document.querySelector('#departamentos tbody').outerHTML = listadoHtml;

}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    };
}

async function eliminarDepartamento(id) {
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

