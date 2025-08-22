

const btnLogout = document.querySelector("#logoutBtn");
const btnCarreras = document.querySelector("#carrerasBtn");
const btnCursos = document.querySelector("#cursosBtn");
const btnEstudiantes = document.querySelector("#estudiantesBtn");
const btnMatricula = document.querySelector("#matriculaBtn");
const btnConsultarMatricula = document.querySelector("#consultarMatriculaBtn");

function getCookie(cname) {
  let name = cname + "=";
  let decodedCookie = decodeURIComponent(document.cookie);
  let ca = decodedCookie.split(';');
  for(let i = 0; i <ca.length; i++) {
    let c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}

window.onload = async () => {
    let usuarioLogged = getCookie('usuario');
    const urlServelet = '/AuthenticationServelet';

    const {data} = await serveletApi.get(urlServelet, null, null);
    
    console.log(data.tipoUsuario);
    
    if (data.tipoUsuario === 1) {
        btnCarreras.style.visibility = 'visible';
        btnCursos.style.visibility = 'visible';
        btnEstudiantes.style.visibility = 'visible';
        btnMatricula.style.visibility = 'visible';
        btnConsultarMatricula.style.visibility = 'hidden';
    } else {
        btnCarreras.style.visibility = 'hidden';
        btnCursos.style.visibility = 'hidden';
        btnEstudiantes.style.visibility = 'hidden';
        btnMatricula.style.visibility = 'hidden';
        btnConsultarMatricula.style.visibility = 'visible';
    }
};

btnLogout.addEventListener('click', () => {
    document.cookie = 'usuario=;expires=Thu, 01 Jan 1970 00:00:01 GMT;';
    Swal.fire({
        position: "top-end",
        icon: "success",
        title: "Sesion finalizada satisfactoriamente",
        showConfirmButton: false,
        timer: 1500
    });

    setTimeout(() => {
        location.href = "index.html";
    }, 2000);
});
