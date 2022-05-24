$(document).ready(function() {

});


async function registrarEmpleado() {
    let datos = {};
    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.cedula = document.getElementById('txtCedula').value;
    nombreCuadrilla = document.getElementById('cuadrilla').value;


    if(datos.nombre.length != 0 && nombreCuadrilla != 'Seleccione la cuadrilla' && datos.cedula.length != 0
        && datos.apellido.length != 0){

        var numero = obtenerIdCuadrilla(nombreCuadrilla);
        numero2 = (await numero).toString();

        datos.id_cuadrilla= numero2;

        const request = await fetch('empleado/crearEmpleado', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datos)
        });
        alert("¡El empleado fue creado con exito!");
        window.location.href = 'registroEmpleado.html'
    }else{
        alert("Complete todos los campos")
    }
}

async function obtenerIdCuadrilla(nombre) {
    let datos = {};
    datos.nombreCuadrilla = nombre
    const request = await fetch('cuadrilla/obtenerId/' + nombre, {
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