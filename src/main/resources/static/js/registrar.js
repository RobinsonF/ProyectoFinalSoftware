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
  var numero = validarCorreo(datos.correo);

  numero2 = (await numero).toString();

  var numero1 = validarLogin(datos.login);

  numero3 = (await numero1).toString();

  emailRegex = /^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
  contraRegex = /^(?=\w*\d)(?=\w*[A-Z])(?=\w*[a-z])\S{1,8}$/

  if(datos.login.length != 0 && datos.nombre.length != 0 && datos.telefono.length != 0 && datos.direccion.length != 0 && datos.correo.length != 0
  && datos.password.length != 0 && password2.length != 0){
    if(!emailRegex.test(datos.correo)){
      alert("El correo no cumple con un formato valido.");
    }else if(!contraRegex.test(datos.password)){
      alert("La contraseña debe contener mínimo un número una letra mayúscula y una letra minúscula.");
    }else if (numero2==1){
      alert("El correo que intenta registrar ya se encuentra registrado");
    }else if (numero3 == 1) {
      alert("El login que intenta registrar ya se encuentra registrado");
    }else{
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
  }else{
    alert("Complete todos los campos")
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

async function validarCorreo(correo) {
  let datos = {};
  datos.correo = correo
  const request = await fetch('usuario/validarCorreo/' + correo, {
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

async function validarLogin(login) {
  let datos = {};
  datos.login = login
  const request = await fetch('usuario/validarLogin/' + login, {
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


