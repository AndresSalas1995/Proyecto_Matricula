let tiposUsuarios;

window.onload = async () => {
    reglasValidacionFormulario();
    tiposUsuarios = await fnConsultaTipoUsuario();
    
    const estudiante = await fnConsultaEstudiante();
    contruirSelect(estudiante); 
};

const btnRegistro = document.querySelector("#btnRegistro");


btnRegistro.addEventListener('click', () => {
    let formulario = $("#frmRegistroEstudiante");
    formulario.validate();

    if (formulario.valid()) {
        fnCrearEstudiante();
    }
});

const fnConsultaEstudiante = async () => {
    const url = '/EstudiantesServelet';
    const {data} = await serveletApi.get(url, null, null);
    return data; 
};

const fnConsultaTipoUsuario = async () => {
    const url = '/TipoUsuariosServelet';
    const {data} = await serveletApi.get(url, null, null);
    return data;
};


const fnCrearEstudiante = async () => {
    const url = '/EstudiantesServelet'; 
    
    const tipoUsuarioEstudiante = tiposUsuarios.find((tipo) => tipo.nombre === 'Estudiante');

    const params = {
        nombre: document.querySelector('#nombre').value,
        apellidoUno: document.querySelector('#apellidoUno').value,
        apellidoDos: document.querySelector('#apellidoDos').value,
        numeroCedula: document.querySelector('#numeroCedula').value,
        fechaNacimiento: document.querySelector('#fechaNacimiento').value,
        direccionResidencia: document.querySelector('#direccionResidencia').value,
        email: document.querySelector('#email').value,
        numeroTelefono: document.querySelector('#numeroTelefono').value,
        nombreUsuario: document.querySelector('#nombreUsuario').value,
        contrasena: document.querySelector('#contrasena').value,
        tipoUsuario: tipoUsuarioEstudiante.idTipo
    };

    const {data} = await serveletApi.post(url, null, {params});
    
    if (data.estado) {
        Swal.fire({
            title: "Tarea exitosa",
            text: "Estudiante creado exitosamente",
            icon: "success"
        });
    } else {
        Swal.fire({
            title: "Error",
            text: "Error al crear estudiante",
            icon: "error"
        });
    }
};


const reglasValidacionFormulario = () => {
    $("#frmRegistroEstudiante").validate(
        {
            rules: {
                nombre: {
                    required: true,
                    minlength: 2,
                    maxlength: 20
                },
                apellidoUno: {
                    required: true,
                    minlength: 2,
                    maxlength: 20
                },
                apellidoDos: {
                    required: true,
                    minlength: 2,
                    maxlength: 20
                },
                numeroCedula: {
                    required: true,
                    minlength: 2,
                    maxlength: 20
                },
                fechaNacimiento: {
                    required: true,
                    minlength: 2,
                    maxlength: 20
                },
                direccionResidencia: {
                    required: true,
                    minlength: 2,
                    maxlength: 20
                },
                email: {
                    required: true,
                    minlength: 2,
                    maxlength: 20
                },
                numeroTelefono: {
                    required: true,
                    minlength: 2,
                    maxlength: 20
                },                
                nombreUsuario: {
                    required: true,
                    minlength: 2,
                    maxlength: 20
                },
                contrasena: {
                    required: true,
                    minlength: 2,
                    maxlength: 20
                }
            }
        }
    );
};
