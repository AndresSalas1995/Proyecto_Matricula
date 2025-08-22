


const btnActualizar = document.querySelector('#btnActualizar');

btnActualizar.addEventListener('click', async () => {
    fnActualizaCarreras();
});


const fnActualizaCarreras = async () => {

    const url = '/CarrerasServelet';

    const params = {
        id: document.querySelector('#carrera').value,
        carrera: document.querySelector('#nombre').value 
    };

    const {data} = await serveletApi.put(url, null, {params});

    if (data.estado) {
        Swal.fire({
            title: "Tarea exitosa",
            text: "Carrera actualizada con exito",
            icon: "success"
        });
    } else {
        Swal.fire({
            title: "Error",
            text: "Error al actualizar carrera", 
            icon: "error"
        });
    }
};


