$(document).ready(function() {
    cargarTurnoTrabajo();
    cargarProveedores();
});

async function cargarTurnoTrabajo() {
    const request = await fetch('turno/listaTurno', {
        method: 'GET',
        headers: getHeaders()
    });
    const turnoTrabajos = await request.json();

    let listadoHtml = '';
    listadoHtml+='<option value="Selecione el turno de trabajo"> Selecione el turno de trabajo </option>';
    for (let turno of turnoTrabajos) {
        let usuariohtml = '<option value= "' + turno.nombre +'"> ' + turno.nombre + ' </option>';
        listadoHtml += usuariohtml;
    }

    document.querySelector('#turnoTrabajo option').outerHTML = listadoHtml;

}

async function cargarProveedores() {
    const request = await fetch('usuario/listaUsuario', {
        method: 'GET',
        headers: getHeaders()
    });
    const proveedores = await request.json();
    console.log(proveedores);

    let listadoHtml = '';
    listadoHtml+=' <option value="Seleccione el nombre del proveedor">Seleccione el nombre del proveedor</option>';
    for (let proveedor of proveedores) {
        let usuariohtml = '<option value= "' + proveedor.nombre +'"> ' + proveedor.nombre + ' </option>';
        listadoHtml += usuariohtml;
    }

    document.querySelector('#proveedor option').outerHTML = listadoHtml;

}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    };
}