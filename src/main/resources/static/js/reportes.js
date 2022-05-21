$(document).ready(function() {

});

async function reporteUsuario() {
    const request = await fetch('reporte/usuarios/download?tipo=PDF', {
        method: 'GET',
        headers: getHeaders()
    });

    window.location.href = 'http://localhost:8080/reporte/usuarios/download?tipo=PDF';

}

async function reporteUsuarioExcel() {
    const request = await fetch('reporte/usuarios/download?tipo=EXCEL', {
        method: 'GET',
        headers: getHeaders()
    });

    window.location.href = 'http://localhost:8080/reporte/usuarios/download?tipo=EXCEL';

}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    };
}
