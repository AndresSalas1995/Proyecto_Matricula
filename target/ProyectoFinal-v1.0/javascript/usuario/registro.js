window.onload = async () => {
    reglasValidacionFormulario();
    const tiposUsuarios = await fnConsultaTipoUsuario();
    contruirSelect(tiposUsuarios);
};

const btnRegistro = document.querySelector("#btnRegistro");

btnRegistro.addEventListener('click', () => {
    let formulario = $("#frmRegistroUsuario");
    formulario.validate();

    if (formulario.valid()) {
        fnCrearUsuario();
    }
});

const fnConsultaTipoUsuario = async () => {
    const url = '/TipoUsuariosServelet';
    const {data} = await serveletApi.get(url, null, null);
    return data;
};


const fnCrearUsuario = async () => {
    const url = '/UsuariosServelet';

    const params = {
        nombre: document.querySelector('#nombre').value,
        apellidoUno: document.querySelector('#apellidoUno').value,
        apellidoDos: document.querySelector('#apellidoDos').value,
        nombreUsuario: document.querySelector('#nombreUsuario').value,
        email: document.querySelector('#email').value,
        contrasena: document.querySelector('#contrasena').value,
        tipoUsuario: document.querySelector('#tipoUsuario').value
    };

    const {data} = await serveletApi.post(url, null, {params});
    
    if (data.estado) {
        Swal.fire({
            title: "Tarea exitosa",
            text: "Usuario creado exitosamente",
            icon: "success"
        });
    } else {
        Swal.fire({
            title: "Error",
            text: "Error al crear usuario",
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
                nombreUsuario: {
                    required: true,
                    minlength: 2,
                    maxlength: 20
                },
                email: {
                    required: true,
                    minlength: 2,
                    maxlength: 20
                },
                contrasena: {
                    required: true,
                    minlength: 2,
                    maxlength: 20
                },
                tipoUsuario: {
                    required: true
                }
            }
        }
    );
};
