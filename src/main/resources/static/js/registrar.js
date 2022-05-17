$(document).ready(function() {

});


async function registrarUsuario() {
  let datos = {};
  datos.login = document.getElementById('txtlogin').value;
  datos.nombre = document.getElementById('txtNombre').value;
  datos.telefono = document.getElementById('txtTelefono').value;
  datos.direccion = document.getElementById('txtDireccion').value;
  datos.email = document.getElementById('txtEmail').value;
  datos.password = document.getElementById('txtPassword').value;
  datos.id_rol = 2;

  let repetirPassword = document.getElementById('txtRepetirPassword').value;

  if (repetirPassword != datos.password) {
    alert('La contraseña que escribiste es diferente.');
    return;
  }

  const request = await fetch('api/usuarios', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  console.log(datos);
  alert(datos);
  alert("La cuenta fue creada con exito!");
  //window.location.href = 'login.html'

}
