let estudiantes;
let carreras;
let carrerasCursos;
let cursos;

let subtotal = 0;
let iva = 0;
let total = 0;

window.onload = async () => {
    reglasValidacionFormulario();
    estudiantes = await fnConsultaEstudiantes();
    carreras = await fnConsultaCarreras();
    carrerasCursos = await fnConsultaCarrerasCursos();
    cursos = await fnConsultaCursos();
    contruirSelectEstudiante(estudiantes);
    contruirSelectCarrera(carreras);
    let carrerasCursosOfCarrera = carrerasCursos.filter((carreraCurso) => carreraCurso.carrera === carreras[0].idCarrera);
    carrerasCursosOfCarrera = carrerasCursosOfCarrera.map((carreraCurso) => carreraCurso.idCarreraCurso);
    contruirSelectCurso(cursos.filter((curso) => carrerasCursosOfCarrera.includes(curso.idCurso)));
    
    document.querySelector('#subtotal').setAttribute('value', subtotal);
    document.querySelector('#iva').setAttribute('value', iva);
    document.querySelector('#total').setAttribute('value', total);
    
    btnRemoverCurso.setAttribute('disabled', true);
};

const btnRegistro = document.querySelector("#btnRegistro");

btnRegistro.addEventListener('click', () => {
    let formulario = $("#frmRegistroMatricula");
    formulario.validate();

    if (formulario.valid()) {
        fnCrearMatricula();
    }
});

const selectCarrera = document.querySelector("#carrera");

selectCarrera.addEventListener('change', () => {
    let carrerasCursosOfCarrera = carrerasCursos.filter((carreraCurso) => carreraCurso.carrera === parseInt(document.querySelector('#carrera').value));
    carrerasCursosOfCarrera = carrerasCursosOfCarrera.map((carreraCurso) => carreraCurso.idCarreraCurso);
    contruirSelectCurso(cursos.filter((curso) => carrerasCursosOfCarrera.includes(curso.idCurso)));
});

const selectCurso = document.querySelector("#curso");

selectCurso.addEventListener('change', () => {
    let selectedCurso = parseInt(document.querySelector('#curso').value);
    
    let cursosAgregados = document.querySelector('#cursosAgregados').getElementsByTagName("li");
    let selectedCursoEsAgregado = false;
    for (let i = 0; i < cursosAgregados.length; i++) {
        if (selectedCurso === parseInt(cursosAgregados[i].value)) {
            selectedCursoEsAgregado = true;
        }
    }
    if (selectedCursoEsAgregado) {
        btnAgregarCurso.setAttribute('disabled', true);
        btnRemoverCurso.removeAttribute('disabled');
    } else {
        btnAgregarCurso.removeAttribute('disabled');
        btnRemoverCurso.setAttribute('disabled', true);
    }
});

const btnAgregarCurso = document.querySelector("#btnAgregarCurso");

btnAgregarCurso.addEventListener('click', () => {
    let cursoSelected = cursos.find((curso) => curso.idCurso === parseInt(document.querySelector('#curso').value));

    if (cursoSelected) {
        agregarCurso(cursoSelected);
        
        btnAgregarCurso.setAttribute('disabled', true);
        btnRemoverCurso.removeAttribute('disabled');
        
        subtotal = subtotal + cursoSelected.precio;
        iva = subtotal * 0.13;
        total = subtotal + iva;
        
        document.querySelector('#subtotal').setAttribute('value', subtotal);
        document.querySelector('#iva').setAttribute('value', iva);
        document.querySelector('#total').setAttribute('value', total);
    }
});

const btnRemoverCurso = document.querySelector("#btnRemoverCurso");

btnRemoverCurso.addEventListener('click', () => {
    let cursoSelected = cursos.find((curso) => curso.idCurso === parseInt(document.querySelector('#curso').value));

    if (cursoSelected) {
        removerCurso(cursoSelected);
        
        btnAgregarCurso.removeAttribute('disabled');
        btnRemoverCurso.setAttribute('disabled', true);
        
        subtotal = subtotal - cursoSelected.precio;
        iva = subtotal * 0.13;
        total = subtotal + iva;
        
        document.querySelector('#subtotal').setAttribute('value', subtotal);
        document.querySelector('#iva').setAttribute('value', iva);
        document.querySelector('#total').setAttribute('value', total);
    }
});

const fnConsultaEstudiantes = async () => {
    const url = '/EstudiantesServelet';
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

const fnConsultaCarrerasCursos = async () => {
    const url = '/CarrerasCursosServelet';
    const {data} = await serveletApi.get(url, null, null);
    return data;
};


const fnCrearMatricula = async () => {
    const url = '/MatriculaServelet';
    
    let cursosAgregados = document.querySelector('#cursosAgregados').getElementsByTagName("li");
    let cursosAgregadosIds = [];
    
    for (let i = 0; i < cursosAgregados.length; i++) {
        cursosAgregadosIds.push(cursosAgregados[i].value);
    }

    const params = {
        estudiante: document.querySelector('#estudiante').value,
        carrera: document.querySelector('#carrera').value,
        cursos: cursosAgregadosIds.toString(),
        subtotal: subtotal,
        iva: iva,
        total: total
    };

    const {data} = await serveletApi.post(url, null, {params});
    
    if (data.estado) {
        Swal.fire({
            title: "Tarea exitosa",
            text: "Matricula creada exitosamente",
            icon: "success"
        });
    } else {
        Swal.fire({
            title: "Error",
            text: "Error al crear matricula",
            icon: "error"
        });
    }
};


const reglasValidacionFormulario = () => {
    $("#frmRegistroUsuario").validate(
        {
            rules: {
                estudiante: {
                    required: true
                },
                carrera: {
                    required: true
                },
                curso: {
                    required: true
                },
                subtotal: {
                    required: true
                },
                iva: {
                    required: true
                },
                total: {
                    required: true
                }
            }
        }
    );
};
