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

    if(numero2 < 3){
      const respuesta = await request.text();
      if (respuesta != 'FAIL') {
        setearCero(datos.correo);
        localStorage.token = respuesta;
        localStorage.correo = datos.correo;
        window.location.href = 'menu.html'
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

