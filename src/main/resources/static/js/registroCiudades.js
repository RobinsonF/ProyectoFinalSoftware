$(document).ready(function() {

});


async function registrarCiudades() {
    let datos = {};
    datos.nombre = document.getElementById('nombreCiudad').value;

    nombreDepartamento = document.getElementById('departamento').value;


    if(datos.nombre.length != 0 && nombreDepartamento != 'Seleccione el departamento'){

        var numero = obtenerIdDepartamento(nombreDepartamento);
        numero2 = (await numero).toString();

        alert(numero2);

        datos.id_departamento = numero2;

        const request = await fetch('ciudad/crearCiudad', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datos)
        });
        alert("¡La ciudad fue creada con exito!");
        window.location.href = 'registroCiudad.html'
    }else{
        alert("Complete todos los campos")
    }
}

async function obtenerIdDepartamento(nombre) {
    let datos = {};
    datos.nombre = nombre
    const request = await fetch('departamento/obtenerId/' + nombre, {
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