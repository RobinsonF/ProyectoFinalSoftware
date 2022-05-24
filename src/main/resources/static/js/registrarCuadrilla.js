$(document).ready(function() {

});


async function registrarCuadrilla() {
    let datos = {};
    idUsuario = document.getElementById('proveedor').value;
    idTrabajo = document.getElementById('turnoTrabajo').value;

    datos.nombreCuadrilla = document.getElementById('txtNombre').value;

    var numero = obtenerIdTurno(idTrabajo);
    numero2 = (await numero).toString();

    var numero1 = obtenerIdUsuario(idUsuario);
    numero3 = (await numero1).toString();

    datos.turnotrabajo = numero2;
    datos.usuario = numero3;


    if(datos.nombreCuadrilla.length != 0 && idTrabajo != 'Selecione el turno de trabajo' && idUsuario != 'Seleccione el nombre del proveedor'){
            const request = await fetch('cuadrilla/crearCuadrilla', {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(datos)
            });
            alert("¡La cuadrilla fue creada con exito!");
            window.location.href = 'registroCuadrilla.html'
    }else{
        alert("Complete todos los campos")
    }
}

async function obtenerIdTurno(nombre) {
    let datos = {};
    datos.nombre = nombre
    const request = await fetch('turno/turnoId/' + nombre, {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    const respuesta = await request.text();

    return respuesta;
}

async function obtenerIdUsuario(nombre) {
    let datos = {};
    datos.nombre = nombre
    const request = await fetch('usuario/obtenerId/' + nombre, {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    const respuesta = await request.text();

    return respuesta;
}