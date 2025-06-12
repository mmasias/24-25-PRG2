# Proyecto: Examen Final de Programación Orientada a Objetos


## Clases utilizadas

| Clase         | Propósito                                                                 |
| ------------- | ------------------------------------------------------------------------- |
| `Universidad` | Coordina profesores y asignaturas. Crea y asigna entidades.               |
| `Profesor`    | Representa al docente. Puede impartir, crear exámenes, entregar exámenes. |
| `Asignatura`  | Representa una materia académica.                                         |
| `Examen`      | Representa un examen vinculado a una asignatura.                          |
| `Pregunta`    | Clase interna dentro de `Examen`. Guarda el enunciado de cada pregunta.   |
| `ExamenFinal` | Clase principal (`main`) que crea y organiza todo el escenario.           |

---

## Vista Pública de Clases (interfaz)

### `Universidad`

* `Universidad(String nombre)`
* `Profesor contratarProfesor(String nombre, String dni)`
* `Asignatura crearAsignatura(String nombre, String codigo, int creditos)`
* `void asignarAsignatura(Profesor p, Asignatura a)`
* `String mostrarEscenario()`

### `Profesor`

* `Profesor(String nombre, String dni)`
* `void impartir(Asignatura a)`
* `Examen crearExamen(String titulo)`
* `void entregarExamen(Profesor vigilante, Examen examen)`
* `String mostrar()`
* `String getNombre()`
* `String getDni()`

### `Asignatura`

* `Asignatura(String nombre, String codigo, int creditos)`
* `String mostrar()`

### `Examen`

* `Examen(String titulo, Asignatura a)`
* `void agregarPregunta(String enunciado)`
* `void asignarVigilante(Profesor vigilante)`
* `String mostrar()`

---

## Vista Pública de Objetos (main)

### Acciones realizadas en `ExamenFinal`

| Acción                        | Tipo            | Ejemplo                                       |
| ----------------------------- | --------------- | --------------------------------------------- |
| Crear universidad             | Crear objeto    | `new Universidad("...")`                      |
| Crear profesor                | Paso de mensaje | `uni.contratarProfesor(...)`                  |
| Crear asignatura              | Paso de mensaje | `uni.crearAsignatura(...)`                    |
| Asignar asignatura a profesor | Paso de mensaje | `uni.asignarAsignatura(profesor, asignatura)` |
| Crear examen                  | Paso de mensaje | `profesor.crearExamen(...)`                   |
| Agregar preguntas al examen   | Paso de mensaje | `examen.agregarPregunta(...)`                 |
| Entregar examen a vigilante   | Paso de mensaje | `profesor.entregarExamen(vigilante, examen)`  |
| Mostrar escenario             | Paso de mensaje | `uni.mostrarEscenario()`                      |

---


