let matriculas;
let estudiante;
let usuarios;
let estudiantes;
let carreras;
let cursos;
let detalleMatriculas;

let subtotal = 0;
let iva = 0;
let total = 0;

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
    matriculas = await fnConsultaMatriculas();
    usuarios = await fnConsultaUsuarios();
    estudiantes = await fnConsultaEstudiantes();
    carreras = await fnConsultaCarreras();
    cursos = await fnConsultaCursos();
    detalleMatriculas = await fnConsultaDetalleMatriculas();
    
    let usuarioLogged = getCookie('usuario');
    
    let usuario = usuarios.find((usuario) => usuario.nombreUsuario === usuarioLogged);
    estudiante = estudiantes.find((e) => e.email === usuario.email);
    
    contruirSelectMatricula(matriculas.filter((matricula) => matricula.estudiante === estudiante.idEstudiante));

    let carrera = carreras.find((carrera) => carrera.idCarrera === matriculas[0].carrera);

    let detalleMatriculasFiiltered = detalleMatriculas.filter((detalleMatricula) => detalleMatricula.matricula === matriculas[0].idMatricula);
    detalleMatriculasFiiltered = detalleMatriculasFiiltered.map((detalleMatricula) => detalleMatricula.curso);
    
    let cursosFiltered = cursos.filter((curso) => detalleMatriculasFiiltered.includes(curso.idCurso));

    subtotal = matriculas[0].subtotal;
    iva = matriculas[0].iva;
    total = matriculas[0].total;
    
    document.querySelector('#subtotal').setAttribute('value', subtotal);
    document.querySelector('#iva').setAttribute('value', iva);
    document.querySelector('#total').setAttribute('value', total);
    document.querySelector('#carrera').setAttribute('value', carrera.nombre);
    
    agregarCursos(cursosFiltered);
};

const fnConsultaMatriculas = async () => {
    const url = '/MatriculaServelet';
    const {data} = await serveletApi.get(url, null, null);
    return data;
};

const fnConsultaEstudiantes = async () => {
    const url = '/EstudiantesServelet';
    const {data} = await serveletApi.get(url, null, null);
    return data;
};

const fnConsultaUsuarios = async () => {
    const url = '/UsuariosServelet';
    const {data} = await serveletApi.get(url, null, null);
    return data;
};

const fnConsultaDetalleMatriculas = async () => {
    const url = '/DetalleMatriculaServelet';
    const {data} = await serveletApi.get(url, null, null);
    return data;
};

const fnConsultaCarreras = async () => {
    const url = '/CarrerasServelet';
    const {data} = await serveletApi.get(url, null, null);
    return data;
};

const fnConsultaCursos = async () => {
    const url = '/CursosServelet';
    const {data} = await serveletApi.get(url, null, null);
    return data;
};

const selectMatricula = document.querySelector("#matricula");

selectMatricula.addEventListener('change', () => {
    let selectedMatricula = parseInt(document.querySelector('#matricula').value);
    
    console.log(selectedMatricula);
    let matricula = matriculas.find((matricula) => matricula.idMatricula === selectedMatricula);

    console.log(matricula);
    let carrera = carreras.find((carrera) => carrera.idCarrera === matricula.carrera);

    let detalleMatriculasFiltered = detalleMatriculas.filter((detalleMatricula) => detalleMatricula.matricula === matricula.idMatricula);
    detalleMatriculasFiltered = detalleMatriculasFiltered.map((detalleMatricula) => detalleMatricula.curso);
    
    console.log(detalleMatriculasFiltered);
    console.log(cursos);
    let cursosFiltered = cursos.filter((curso) => detalleMatriculasFiltered.includes(curso.idCurso));
    console.log(cursosFiltered);

    subtotal = matricula.subtotal;
    iva = matricula.iva;
    total = matricula.total;
    
    document.querySelector('#subtotal').setAttribute('value', subtotal);
    document.querySelector('#iva').setAttribute('value', iva);
    document.querySelector('#total').setAttribute('value', total);
    document.querySelector('#carrera').setAttribute('value', carrera.nombre);
    
    agregarCursos(cursosFiltered);
});

