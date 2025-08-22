window.onload = async () => {
    reglasValidacionFormulario();
    const carreras = await fnConsultaCarreras();
    contruirSelect(carreras);
    const cursos = await fnConsultaCursos();
    contruirSelectCursos(cursos); 
    };

const btnRegistro = document.querySelector("#btnRegistro");

btnRegistro.addEventListener('click', () => {
    let formulario = $("#frmRegistroCurso");
    formulario.validate();

    if (formulario.valid()) {
        fnCrearCurso();
    }
});

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


const fnCrearCurso = async () => {
    const url = '/CursosServelet';

    const params = {
        nombre: document.querySelector('#nombre').value,
        codigo: document.querySelector('#codigo').value,
        creditos: document.querySelector('#creditos').value,
        precio: document.querySelector('#precio').value,
        carrera: document.querySelector('#carrera').value
    };

    const {data} = await serveletApi.post(url, null, {params});
    
    if (data.estado) {
        Swal.fire({
            title: "Tarea exitosa",
            text: "Curso creado exitosamente",
            icon: "success"
        });
    } else {
        Swal.fire({
            title: "Error",
            text: "Error al crear curso",
            icon: "error"
        });
    }
};


const reglasValidacionFormulario = () => {
    $("#frmRegistroUsuario").validate(
        {
            rules: {
                nombre: {
                    required: true,
                    minlength: 2,
                    maxlength: 20
                },
                codigo: {
                    required: true,
                    minlength: 2,
                    maxlength: 20
                },
                creditos: {
                    required: true,
                    minlength: 2,
                    maxlength: 20
                },
                precio: {
                    required: true,
                    minlength: 2,
                    maxlength: 20
                },
                carreras: {
                    required: true
                }
            }
        }
    );
};
