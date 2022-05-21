$(document).ready(function() {

});


async function registrarUsuario() {
  let datos = {};
  datos.login = document.getElementById('txtlogin').value;
  datos.nombre = document.getElementById('txtNombre').value;
  datos.telefono = document.getElementById('txtTelefono').value;
  datos.direccion = document.getElementById('txtDireccion').value;
  datos.correo = document.getElementById('txtEmail').value;
  datos.password = document.getElementById('txtPassword').value;
  password2 = document.getElementById('txtRepetirPassword').value;
  datos.id_rol = 2;
  datos.intento = 0;

  if(datos.login.length != 0 && datos.nombre.length != 0 && datos.telefono.length != 0 && datos.direccion.length != 0 && datos.correo.length != 0
  && datos.password.length != 0 && password2.length != 0){
    let repetirPassword = document.getElementById('txtRepetirPassword').value;

    if (repetirPassword != datos.password) {
      alert('La contraseña que escribiste es diferente.');
      return;
    }

    const request = await fetch('usuario/crearUsuario', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(datos)
    });

    eviarCorreo("Bienvenido a electricidad NFS", datos.correo, datos.correo, "Url: http://localhost:8080/index.html\ncorreo: " + datos.correo + "\npassword: " + datos.password);
    console.log(datos);
    alert("La cuenta fue creada con exito!");
    window.location.href = 'index.html'
  }
}

async function eviarCorreo(subject, to, from, text) {
  let datos = {};

  datos.subject = subject;
  datos.to = to;
  datos.from = from;
  datos.text = text;


  const request = await fetch('correo/enviarCorreo', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  console.log(datos);

}


