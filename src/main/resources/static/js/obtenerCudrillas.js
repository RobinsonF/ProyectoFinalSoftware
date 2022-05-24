$(document).ready(function() {
    cargarCuadrillas();
});

async function cargarCuadrillas() {
    const request = await fetch('cuadrilla/listaCuadrilla', {
        method: 'GET',
        headers: getHeaders()
    });
    const cuadrillas = await request.json();

    let listadoHtml = '';
    listadoHtml+='<option value="Seleccione la cuadrilla"> Seleccione la cuadrilla </option>';
    for (let cuadrilla of cuadrillas) {
        let usuariohtml = '<option value= "' + cuadrilla.nombreCuadrilla +'"> ' + cuadrilla.nombreCuadrilla + ' </option>';
        listadoHtml += usuariohtml;
    }

    document.querySelector('#cuadrilla option').outerHTML = listadoHtml;

}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    };
}