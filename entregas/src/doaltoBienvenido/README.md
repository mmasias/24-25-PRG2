# Examen Final 

## Descripción del problema

- El codigo necesitaba

    - Crear una universidad

    - Crear una asignatura desde la universidad

    - Contratar profesores

    - Asignar asignaturas a profesores

    - El profesor que imparte la asignatura debe poder crear un examen con 3 preguntas

    - Contratar otro profesor para vigilar el examen

    - El profesor que imparte la asignatura entrega el examen al profesor vigilante

    - Mostrar un resumen con la universidad, profesor que imparte, asignatura, examen, profesor vigilante y las preguntas del examen

## Reflexion

Durante la implementacion me di cuenta al final que los atributos de las clases Asignatura y Profesor los puse publicos en vez de ser privados para respetar el encapsulamiento

Sin embargo, al principio no inclui metodos get y set en la parte 1 y 2 para esos atributos, por lo que al intentar acceder o modificar los valores desde otras clases me daba errores

Al no tener los metodos get y set no podia utilizar directamente los atributos privados fuera de su clase, lo que me confundio

## Solución aplicada

Para finalizarlo añadi metodos [getter](https://github.com/Bienvee3/24-25-PRG2-fork-bienve/blob/3f4a896d808f31775c68c8a0019602098af007aa/entregas/src/doaltoBienvenido/Profesor.java#L16) y [setter](https://github.com/Bienvee3/24-25-PRG2-fork-bienve/blob/3f4a896d808f31775c68c8a0019602098af007aa/entregas/src/doaltoBienvenido/Profesor.java#L20) solo para los atributos que realmente necesitaba acceder o modificar desde otras clases

Asi pude:

- Obtener el nombre de la asignatura y las preguntas para mostrarlas

- Asignar la asignatura al profesor

- Modificar el título del examen y las preguntas desde el profesor

