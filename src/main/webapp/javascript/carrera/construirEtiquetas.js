const contruirSelect = (data) => {
    let selectCarrera = document.querySelector('#carrera');
    for (var item in data) {
        let option = document.createElement('option');

        option.setAttribute('value', data[item].idCarrera);
        option.textContent = data[item].nombre;

        selectCarrera.append(option);
    }
}; 


