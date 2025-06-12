# Proyecto - Examen Final de Programación II

## 🎯 Objetivo
Simular el funcionamiento de una universidad en la que se crean asignaturas, se contratan profesores, se crean exámenes y se asignan profesores vigilantes, respetando todas las reglas de lógica del enunciado del examen.

---

## ✅ Funcionalidades implementadas (EXACTAMENTE según el enunciado)

- Crear una **universidad**.
- Desde la universidad:
  - Crear una **asignatura**.
  - Contratar (crear) un **profesor**.
  - Asignar la asignatura al profesor.
  - Decirle al profesor que cree un **examen para esa asignatura**, que:
    - Contiene **3 preguntas**.
    - Está **asociado a la asignatura** que imparte.
    - **No se puede crear** si el profesor no imparte ninguna asignatura.
  - Contratar (crear) a **otro profesor** para vigilar el examen.
  - Decirle al profesor que imparte que **entregue el examen al profesor que vigila**.
    - **Si el vigilante tiene una asignatura, NO puede vigilar el examen** (se muestra mensaje).
  - Mostrar el **escenario completo** al final:
    - Profesor
    - Asignatura
    - Examen con preguntas
    - Profesor vigilante

---

## 🧱 Clases utilizadas

- `EjecutarUniversidad`: clase con el método `main()` limpio.
- `Universidad`: gestiona el sistema a través de `ejecutarUniversidad()`.
- `GestorUniversidad`: realiza todas las acciones y relaciones entre objetos.
- `Profesor`: puede impartir una asignatura y crear un examen para ella.
- `ProfesorVigilante`: hereda de `Profesor`, se comprueba que **no tenga asignatura para poder vigilar**.
- `Asignatura`: contiene nombre y número de créditos.
- `Examen`: contiene nombre y preguntas.
- `PreguntasExamen`: contiene 3 preguntas fijas.
- `Alumno`: creado según la estructura pedida, aunque no participa activamente en el flujo.

---

## 🧪 Restricciones y control lógico (respetadas)

- Un profesor solo puede crear examen si tiene una asignatura asignada.
- Un profesor **no puede vigilar exámenes si tiene asignaturas**.
- Las preguntas del examen son generadas automáticamente por el profesor.
- No se usa ninguna estructura fuera de lo permitido en Programación I + II:
  - ❌ No `ArrayList`
  - ❌ No métodos fuera de los definidos
  - ❌ No comentarios
  - ❌ No `return` en `if`
  - ✅ Uso de `extends`, `super`, `protected`, `get`, `set`, `toString`

---

## 🧩 Posibles ampliaciones (que no se han hecho por restricción tuya)

Si se permitiese ampliar el diseño, se podrían:
- Usar arrays para gestionar múltiples asignaturas por profesor.
- Añadir una lista de exámenes creados.
- Permitir al vigilante recibir múltiples exámenes.

Pero **no se ha hecho nada de esto**, cumpliendo estrictamente tu estructura de clases y métodos.

---
