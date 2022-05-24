$(document).ready(function() {
    cargarDepartamentos();
});

async function cargarDepartamentos() {
    const request = await fetch('departamento/listaDepartamento', {
        method: 'GET',
        headers: getHeaders()
    });
    const departamentos = await request.json();

    let listadoHtml = '';
    listadoHtml+='<option value="Seleccione el departamento"> Seleccione el departamento </option>';
    for (let departamento of departamentos) {
        let usuariohtml = '<option value= "' + departamento.nombre +'"> ' + departamento.nombre + ' </option>';
        listadoHtml += usuariohtml;
    }

    document.querySelector('#departamento option').outerHTML = listadoHtml;

}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    };
}