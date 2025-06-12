# README - Examen de Programación II

### Cambios respecto a la vista pública

Los dos cambios importantes que decidí hacer para que el código fuera más eficiente fueron:

1. Añadí `getNombre()` en `Asignatura` para poder comprobar y vincular asignaturas al crear exámenes desde `Profesor`.
2. Añadí `mostrar()` en `Pregunta` que directamente imprime la pregunta.

También he puesto constructores con parámetro en `ProfesorImparte` y `ProfesorVigila`, pero eso es porque Java lo exige si `Profesor` ya tiene un constructor con argumentos. Sin eso no compila, así que es obligatorio aunque no aparezca en la vista pública.

Y además he tenido que añadir en la clase Universidad.java unos métodos para poder imprimir por pantalla el resultado.

### Qué hace el código

- `Universidad` se encarga de crear profesores y asignaturas, y los guarda en arrays simples.
- `ProfesorImparte` crea exámenes, añade una pregunta y los entrega a un `ProfesorVigila`.
- `ProfesorVigila` recibe el examen y lo muestra por pantalla (vigilarlo).
- Los exámenes se pueden registrar en la asignatura correspondiente y tener hasta 3 preguntas.

