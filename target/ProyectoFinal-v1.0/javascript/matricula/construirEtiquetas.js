const contruirSelectEstudiante = (data) => {
    let selectEstudiante = document.querySelector('#estudiante');
    for (var item in data) {
        let option = document.createElement('option');

        option.setAttribute('value', data[item].idEstudiante);
        option.textContent = data[item].nombre + ' ' + data[item].primerApellido + ' ' + data[item].segundoApellido;

        selectEstudiante.append(option);
    }
};

const contruirSelectCarrera = (data) => {
    let selectCarrera = document.querySelector('#carrera');
    for (var item in data) {
        let option = document.createElement('option');

        option.setAttribute('value', data[item].idCarrera);
        option.textContent = data[item].nombre;

        selectCarrera.append(option);
    }
};

const contruirSelectCurso = (data) => {
    let selectCurso = document.querySelector('#curso');
    for (let i = 0; i < selectCurso.options.length; i++) {
        selectCurso.remove(i);
    }
    for (var item in data) {
        let option = document.createElement('option');

        option.setAttribute('value', data[item].idCurso);
        option.textContent = data[item].nombre;

        selectCurso.append(option);
    }
};

const agregarCurso = (curso) => {
    let cursosAgregados = document.querySelector('#cursosAgregados');
    let linea = document.createElement('li');

    linea.setAttribute('value', curso.idCurso);
    linea.textContent = curso.nombre;

    cursosAgregados.append(linea);
};

const removerCurso = (curso) => {
    let selectedCurso = parseInt(document.querySelector('#curso').value);
    
    let cursosAgregados = document.querySelector('#cursosAgregados').getElementsByTagName("li");
    for (let i = 0; i < cursosAgregados.length; i++) {
        if (selectedCurso === parseInt(cursosAgregados[i].value)) {
            cursosAgregados[i].remove();
        }
    }
};