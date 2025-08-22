


const btnActualizar = document.querySelector('#btnActualizar');

btnActualizar.addEventListener('click', async () => {
    fnActualizaEstudiante();
});


const fnActualizaEstudiante = async () => {

    const url = '/EstudiantesServelet';

    const params = {

        id: document.querySelector('#estudiante').value,
        nombre: document.querySelector('#nombre').value,
        apellidoUno: document.querySelector('#apellidoUno').value,
        apellidoDos: document.querySelector('#apellidoDos').value,
        numeroCedula: document.querySelector('#numeroCedula').value,
        fechaNacimiento: document.querySelector('#fechaNacimiento').value,
        direccionResidencia: document.querySelector('#direccionResidencia').value,
        numeroTelefono: document.querySelector('#numeroTelefono').value,
        nombreUsuario: document.querySelector('#nombreUsuario').value,
        contrasena: document.querySelector('#contrasena').value,
        
    };

    const {data} = await serveletApi.put(url, null, {params});

    if (data.estado) {
        Swal.fire({
            title: "Tarea exitosa",
            text: "Estudiante Actualizado correctamente",
            icon: "success"
        });
    } else {
        Swal.fire({
            title: "Error",
            text: "Error al actualizar estudiante",
            icon: "error"
        });
    }
};


