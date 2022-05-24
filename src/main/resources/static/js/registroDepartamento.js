$(document).ready(function() {

});


async function registrarDepartamento() {
    let datos = {};
    datos.nombre = document.getElementById('txtNombre').value;

    if(datos.nombre.length != 0){
        const request = await fetch('departamento/crearDepartamento', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datos)
        });
        alert("¡El departamento fue creada con exito!");
        window.location.href = 'registroDepartamento.html'
    }else{
        alert("Complete todos los campos")
    }
}