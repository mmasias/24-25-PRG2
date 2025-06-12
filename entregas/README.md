# 🎓 Examen Final (Java)

Este proyecto simula una estructura académica utilizando **Programación Orientada a Objetos (POO)** en Java. Incluye clases como `Universidad`, `Profesor`, `Asignatura` y `Examen`, con relaciones basadas en **herencia** y **composición**, además de validaciones específicas para crear y vigilar exámenes.

---

## 🗂️ Estructura del Proyecto

entregas/
└── alejandroDeLaPeña/
└── ExamenFinal/
├── Universidad.java
├── Profesor.java
├── Asignatura.java
├── Examen.java
└── ConsolaUniversidad.java


## 📚 Clases y Funcionalidades

### `Universidad`
- Contiene el nombre de la universidad.
- Gestiona arrays de `Profesor` y `Asignatura`.
- Método `mostrarContenido()` imprime el estado de la universidad.

### `Profesor`
- Atributos personales: nombre, apellidos, DNI.
- Contiene la asignatura que imparte (si la tiene) he añadido este atributo que se me olvido asignarle antes.
- Métodos:
  - `entregarExamenA(Profesor vigilante, Asignatura[] asignaturas)`: valida si puede entregar un examen para ser vigilado.
  - `mostrarProfesor()`: imprime la información del profesor.

### `Asignatura`
- Nombre, créditos, y profesor que la imparte.
- Al instanciarse, se vincula automáticamente con el profesor.
- Método `imparteProfesor(Profesor profesor)` verifica si un profesor imparte esta asignatura.

### `Examen`
- Tiene nombre, preguntas, puntos, creador y vigilante.
- Método `asignarVigilante(Profesor)` asocia un profesor como vigilante. Este atributo tambien es añadido a lo que tenia principalmente.
- Método `mostrarExamen()` imprime todos los detalles del examen.

### `ConsolaUniversidad`
- Clase principal con el método `main`.
- Simula la creación de profesores, asignaturas y exámenes.
- Incluye todas las validaciones requeridas:
  - Un profesor solo puede crear un examen si imparte la asignatura.
  - Un profesor no puede vigilar si imparte alguna asignatura.
  - El examen se entrega correctamente al vigilante si todo es válido.

---

## Validaciones Implementadas

- ✔️ Un profesor no puede crear exámenes si no imparte una asignatura.
- ✔️ Un profesor no puede vigilar exámenes si ya imparte alguna asignatura.
- ✔️ Al crear una asignatura, se vincula automáticamente al profesor correspondiente.

