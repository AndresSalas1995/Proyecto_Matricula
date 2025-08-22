const btnLogin = document.querySelector('#btnLogin');

btnLogin.addEventListener('click', () => {
    let formulario = $("#frmLogin");
    formulario.validate();

    if (formulario.valid()) {
        validarSesion();
    }
});

const validarSesion = async () => {
    const urlServelet = '/AuthenticationServelet';

    const params = {
        usuario: document.querySelector('#usuario').value,
        contrasena: document.querySelector('#contrasena').value
    };

    const {data} = await serveletApi.post(urlServelet, null, {params});
    
    if (data.estado) {
        Swal.fire({
            position: "top-end",
            icon: "success",
            title: "Inicio de sesion satisfactorio",
            showConfirmButton: false,
            timer: 1500
        });
        
        setTimeout(() => {
            location.href = "principal.html";
        }, 2000);
    } else {
        Swal.fire({
            position: "top-end",
            icon: "error",
            title: "Usuario o contraseña incorrectos",
            showConfirmButton: false,
            timer: 1500
        });
    }
};
