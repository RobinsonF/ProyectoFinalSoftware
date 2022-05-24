$(document).ready(function() {
    cargarDepartamentos();
});

async function cargarDepartamentos() {
    const request = await fetch('ciudad/listaCiudad', {
        method: 'GET',
        headers: getHeaders()
    });
    const ciudades = await request.json();

    let listadoHtml = '';
    listadoHtml+='<option value="Seleccione la ciudad"> Seleccione la ciudad </option>';
    for (let ciudad of ciudades) {
        let usuariohtml = '<option value= "' + ciudad.nombre +'"> ' + ciudad.nombre + ' </option>';
        listadoHtml += usuariohtml;
    }

    document.querySelector('#ciudad option').outerHTML = listadoHtml;

}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    };
}