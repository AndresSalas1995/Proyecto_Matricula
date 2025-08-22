const contruirSelect = (data) => {
    let selectCarrera = document.querySelector('#carrera');
    for (var item in data) {
        let option = document.createElement('option');

        option.setAttribute('value', data[item].idCarrera);
        option.textContent = data[item].nombre;

        selectCarrera.append(option);
    }
};

const contruirSelectCursos = (data) => {
    let selectCurso = document.querySelector('#curso');
    for (var item in data) {
        let option = document.createElement('option');

        option.setAttribute('value', data[item].idCurso);
        option.textContent = data[item].nombre + ' ' + data[item].codigoCurso; 

        selectCurso.append(option);
    }
};

