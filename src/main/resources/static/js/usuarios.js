// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
  $('#usuarios').DataTable();
  actualizarEmailDelUsuario();
});

function actualizarEmailDelUsuario() {
    document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
}


async function cargarUsuarios() {
  const request = await fetch('usuario/listaUsuario', {
    method: 'GET',
    headers: getHeaders()
  });
  const usuarios = await request.json();
  console.log(usuarios);

  let listadoHtml = '';
  for (let usuario of usuarios) {
    let botonEditar = '<a class="">' +
        '<img src="img/editar.png" width="25" height="25" style="float: left;margin-left: 15px">'+
        '</a>';
    let botonEliminar = '<a onclick="eliminarUsuario(' + usuario.id_usuario + ')">' +
        '<img src="img/eliminar.png" width="30" height="30" style="float: left;margin-left: 15px">' +
        '</a>';
    let botonDesbloquear = '<a onclick="desbloquearUsuario('+ usuario.id_usuario + ')">' +
        '<img src="img/desbloquear.png" width="30" height="30" style="float: left;margin-left: 15px">' +
        '</a>';


    let usuarioHtml = '<tr><td>'+usuario.id_usuario+'</td><td>' + usuario.nombre + ' </td><td> ' + usuario.login + '</td><td>'
                    + usuario.direccion+'</td><td>'+usuario.telefono + '</td><td>' + usuario.correo
                    + '</td><td>' + botonEditar + '</td><td>' + botonEliminar +  '</td><td>' + botonDesbloquear + '</td></tr>';
    listadoHtml += usuarioHtml;
  }

document.querySelector('#usuarios tbody').outerHTML = listadoHtml;

}

function getHeaders() {
    return {
     'Accept': 'application/json',
     'Content-Type': 'application/json',
   };
}

async function eliminarUsuario(id) {
    let datos = {};
  if (!confirm('¿Desea eliminar este usuario?')) {
    return;
  }
  datos.id_usuario = id;

 const request = await fetch('usuario/eliminarUsuario/' + id, {
    method: 'POST',
    headers: getHeaders(),
     body: JSON.stringify(datos)
});
    location.reload()
}

async function desbloquearUsuario(id) {
    let datos = {};

    var numero = numeroIntentos(id);

    numero2 = (await numero).toString();

    if(numero2 < 3){
        alert("Este usuario no se encuentra bloqueado.")
    }else{
        if (!confirm('¿Desea desbloquear este usuario?')) {
            return;
        }
        datos.id_usuario = id;

        const request = await fetch('usuario/desbloquearUsuario/' + id, {
            method: 'POST',
            headers: getHeaders(),
            body: JSON.stringify(datos)
        });
        location.reload()
    }
}

async function numeroIntentos(id) {
    let datos = {};
    datos.id_usuario = id
    const request = await fetch('usuario/usuarioNumeroIntento/' + id, {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    var numero = 0;
    const respuesta = await request.text();
    numero = parseInt(respuesta, 10);
    return numero;
}