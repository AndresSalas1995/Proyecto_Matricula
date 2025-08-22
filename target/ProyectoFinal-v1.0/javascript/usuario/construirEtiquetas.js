const contruirSelect = (data) => {
    let selectTipoUsuario = document.querySelector('#tipoUsuario');
    for (var item in data) {
        let option = document.createElement('option');

        option.setAttribute('value', data[item].idTipo);
        option.textContent = data[item].nombre;

        selectTipoUsuario.append(option);
    }
};