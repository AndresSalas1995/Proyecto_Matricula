


const btnActualizar = document.querySelector('#btnActualizar');

btnActualizar.addEventListener('click', async () => {
    fnActualizaCursos();
});


const fnActualizaCursos = async () => {

    const url = '/CursosServelet';

    const params = {
        id: document.querySelector('#curso').value,
        nombre: document.querySelector('#nombre').value,
        codigo: document.querySelector('#codigo').value,
        creditos: document.querySelector('#creditos').value,
        precio: document.querySelector('#precio').value,
        carrera: document.querySelector('#carrera').value
    };

    const {data} = await serveletApi.put(url, null, {params});

    if (data.estado) {
        Swal.fire({
            title: "Tarea exitosa",
            text: "Curso actualizado exitosamente",
            icon: "success"
        });
    } else {
        Swal.fire({
            title: "Error",
            text: "Error al actualizar curso",
            icon: "error"
        });
    }
};


