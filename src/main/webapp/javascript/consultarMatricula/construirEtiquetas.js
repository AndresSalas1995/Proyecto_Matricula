const contruirSelectMatricula = (data) => {
    let selectMatriculas = document.querySelector('#matricula');
    for (var item in data) {
        let option = document.createElement('option');
        
        option.setAttribute('value', data[item].idMatricula);
        option.textContent = 'Matricula ' + data[item].idMatricula + ', carrera ' + data[item].carrera;

        selectMatriculas.append(option);
    }
};

const limpiarCursos = () => {
    let cursosAgregadosItems = document.querySelector('#cursosAgregados').getElementsByTagName("li");
    for (let i = 0; i < cursosAgregadosItems.length; i++) {
        cursosAgregadosItems[0].remove();
    }
};

const agregarCursos = (cursos) => {
    limpiarCursos();
    
    let cursosAgregados = document.querySelector('#cursosAgregados');
    
    for (let i = 0; i < cursos.length; i++) {
        let linea = document.createElement('li');

        linea.setAttribute('value', cursos[i].idCurso);
        linea.textContent = cursos[i].nombre;

        cursosAgregados.append(linea);
    }
};