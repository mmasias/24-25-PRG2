# Escenario Universidad – POO (rama Final)

## 🎯 Consigna

Una universidad contrata dos profesores: uno imparte una asignatura y, como parte de ella, prepara un examen con tres preguntas. El otro recibe el examen y lo vigila.

### Requisitos:
- Crear una universidad.
- Desde universidad:
  - Crear una asignatura.
  - Contratar un profesor.
  - Asignarle la asignatura.
  - Indicarle que cree un examen con 3 preguntas.
    - Si el profesor no imparte asignatura, no puede crear el examen.
  - Contratar otro profesor para vigilar el examen.
  - Pedirle al primer profesor que entregue el examen al que vigila.
    - Si un profesor imparte asignatura, no puede vigilar.
- Mostrar el escenario completo con este formato:

Universidad: Universidad Europea del Atlántico
Profesor: Nombre Apellido / DNI
Asignatura: Nombre - créditos
Examen: Examen Final
Vigilado por: Nombre Apellido / DNI
Pregunta 1: "..."
Pregunta 2: "..."
Pregunta 3: "..."

## 📁 Archivos fuente (rama `Final`)

Todos están en `src/` en la rama [`Final`](https://github.com/GabrielMBP/24-25-PRG2/tree/Final/src):

- [`EscenarioUniversidad.java`](src_GabrielBéjar/EscenarioUniversidad.java) – Clase principal.
- [`Universidad.java`](src_GabrielBéjar/Universidad.java) – Crea clases y ejecuta el escenario.
- [`Asignatura.java`](src_GabrielBéjar/Asignatura.java) – Define asignatura y créditos.
- [`Profesor.java`](src_GabrielBéjar/Profesor.java) – Clase base de profesor.
- [`ProfesorAsignatura.java`](src_GabrielBéjar/ProfesorAsignatura.java) – Profesor que imparte y crea examen.
- [`ProfesorVigila.java`](src_GabrielBéjar/ProfesorVigila.java) – Profesor que vigila exámenes.
- [`Examen.java`](src_GabrielBéjar/Examen.java) – Contiene preguntas.
- [`Alumno.java`](src_GabrielBéjar/Alumno.java) – Interactúa en vigilancia.

- Olvide incluir Escenario Universidad en la hoja, corrección hecha en código.

