$(document).ready(function() {
   // on ready
});


async function iniciarSesion() {
  let datos = {};
  datos.correo = document.getElementById('txtCorreo').value;
  datos.password = document.getElementById('txtPassword23').value;

  if(datos.correo == 0 || datos.password == 0){
    alert("Complete todos los campos")
  }else{
    const request = await fetch('login/usuario', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(datos)
    });

    var numero = numeroIntentos(datos.correo);

    numero2 = (await numero).toString();

    rol = usuarioRol(datos.correo);

    rol2 = (await rol).toString();

    if(numero2 < 3){
      const respuesta = await request.text();
      if (respuesta != 'FAIL') {
        setearCero(datos.correo);
        if(rol2 == 'Proveedor'){
          localStorage.token = respuesta;
          localStorage.correo = datos.correo;
          window.location.href = 'menuProveedor.html?correo='+datos.correo
        }else{
          localStorage.token = respuesta;
          localStorage.correo = datos.correo;
          window.location.href = 'menu.html?correo='+datos.correo
        }

      } else {
        aumentarIntento(datos.correo);
        alert("Las credenciales son incorrectas. Por favor intente nuevamente");
      }
    }else{
      alert("La cuenta del usuario " + datos.correo + " se encuentra bloqueda");
    }
  }
}

async function aumentarIntento(correo) {
  let datos = {};
  datos.correo = correo
  const request = await fetch('login/usuarioIntento/' + correo, {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
}

async function numeroIntentos(correo) {
  let datos = {};
  datos.correo = correo
  const request = await fetch('login/usuarioNumeroIntentos/' + correo, {
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

async function setearCero(correo) {
  let datos = {};
  datos.correo = correo
  const request = await fetch('login/usuarioCeroIntentos/' + correo, {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
}

async function usuarioRol(correo) {
  let datos = {};
  datos.correo = correo
  const request = await fetch('usuario/usuarioRol/' + correo, {
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

