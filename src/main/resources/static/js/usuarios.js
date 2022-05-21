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
    let botonEliminar = '<a onclick="eliminarUsuario(' + usuario.id_usuario + ' )" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

    let telefonoTexto = usuario.telefono == null ? '-' : usuario.telefono;
    let usuarioHtml = '<tr><td>'+usuario.id_usuario+'</td><td>' + usuario.nombre + ' </td><td> ' + usuario.login + '</td><td>'
                    + usuario.direccion+'</td><td>'+usuario.telefono + '</td><td>' + usuario.correo
                    + '</td><td>' + botonEliminar + '</td></tr>';
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