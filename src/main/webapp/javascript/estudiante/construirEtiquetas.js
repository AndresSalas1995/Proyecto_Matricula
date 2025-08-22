const contruirSelect = (data) => {
    let selectEstudiante = document.querySelector('#estudiante');
    for (var item in data) {
        let option = document.createElement('option');

        option.setAttribute('value', data[item].idEstudiante);
        option.textContent = data[item].nombre + ' ' + data[item].primerApellido + ' ' + data[item].segundoApellido;

        selectEstudiante.append(option);
    }
}; 


