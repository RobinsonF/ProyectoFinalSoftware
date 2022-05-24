$(document).ready(function() {

});


async function registrarZonas() {
    let datos = {};
    datos.nombre = document.getElementById('txtNombre').value;
    datos.limiteNorte = document.getElementById('txtNorte').value;
    datos.limiteOccidente = document.getElementById('txtOccidente').value;
    datos.limiteOriente = document.getElementById('txtOriente').value;
    datos.limiteSur = document.getElementById('txtSur').value;
    nombreCiudad = document.getElementById('ciudad').value;


    if(datos.nombre.length != 0 && nombreCiudad != 'Seleccione la ciudad' && datos.limiteNorte.length != 0
    && datos.limiteOccidente.length != 0 && datos.limiteOriente.length != 0 && datos.limiteSur.length !=0){

        var numero = obtenerIdCiudad(nombreCiudad);
        numero2 = (await numero).toString();

        datos.id_ciudad= numero2;


        const request = await fetch('zona/crearZona', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datos)
        });
        alert("¡La zona fue creada con exito!");
        window.location.href = 'registroZona.html'
    }else{
        alert("Complete todos los campos")
    }
}

async function obtenerIdCiudad(nombre) {
    let datos = {};
    datos.nombre = nombre
    const request = await fetch('ciudad/obtenerId/' + nombre, {
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