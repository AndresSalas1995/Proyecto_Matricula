window.onload = async () => {
    reglasValidacionFormulario();
    const carreras = await fnConsultaCarreras();
    contruirSelect(carreras); 
};

const btnRegistro = document.querySelector("#btnRegistro");

btnRegistro.addEventListener('click', () => {
    let formulario = $("#frmRegistroCarrera");
    formulario.validate();

    if (formulario.valid()) {
        fnCrearCarrera();
    }
});

const fnConsultaCarreras = async () => {
    const url = '/CarrerasServelet';
    const {data} = await serveletApi.get(url, null, null);
    return data;
};

const fnCrearCarrera = async () => {
    const url = '/CarrerasServelet';

    const params = {
        nombre: document.querySelector('#nombre').value
    };

    const {data} = await serveletApi.post(url, null, {params});
    
    if (data.estado) {
        Swal.fire({
            title: "Tarea exitosa",
            text: "Carrera creada exitosamente",
            icon: "success"
        });
    } else {
        Swal.fire({
            title: "Error",
            text: "Error al crear carrera",
            icon: "error"
        });
    }
};


const reglasValidacionFormulario = () => {
    $("#frmRegistroCarrera").validate(
        {
            rules: {
                nombre: {
                    required: true,
                    minlength: 2,
                    maxlength: 20
                }
            }
        }
    );
};
