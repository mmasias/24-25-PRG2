# 📘 Proyecto Final - Programación II

## 🎯 Objetivo

Simular el funcionamiento de una universidad en la que se crean asignaturas, se contratan profesores, se crean exámenes y se asignan profesores vigilantes, respetando todas las reglas de lógica definidas en el enunciado del examen de Programación II.

---

## ✅ Funcionalidades implementadas (EXACTAMENTE como pide el enunciado)

- Crear una **universidad**.
- Desde la universidad:
  - Crear una **asignatura**.
  - Contratar (crear) un **profesor**.
  - Asignarle al profesor la asignatura.
  - Decirle al profesor que cree un **examen para la asignatura que imparte**, que:
    - Contiene exactamente **3 preguntas**.
    - Está **asociado a la asignatura**.
    - **No se puede crear** si el profesor **no imparte ninguna asignatura**.
  - Contratar a **otro profesor** para que vigile el examen.
  - El profesor que imparte el examen **le entrega el examen al profesor que lo va a vigilar**.
    - **Si el vigilante tiene asignatura, no puede vigilar el examen**.
  - Mostrar en consola el **escenario completo**, incluyendo:
    - El profesor que imparte.
    - La asignatura.
    - El examen con sus 3 preguntas.
    - El profesor que vigila.

---

## 🧱 Clases utilizadas (según estructura obligatoria del examen)

- `EjecutarUniversidad`: contiene el `main()` limpio y solo ejecuta la universidad.
- `Universidad`: contiene el método `ejecutarUniversidad()` que realiza toda la lógica.
- `GestorUniversidad`: ejecuta las acciones:
  - Crear asignatura
  - Crear profesor
  - Asignar asignatura
  - Crear examen
  - Crear preguntas
  - Contratar profesor vigilante
  - Entregar examen al vigilante
  - Mostrar escenario completo
- `Profesor`: puede impartir una asignatura y crear examen para ella.
- `ProfesorVigilante`: hereda de `Profesor`, pero **solo puede vigilar si no tiene asignatura**.
- `Asignatura`: representa una materia con nombre y créditos.
- `Examen`: contiene nombre y las preguntas.
- `PreguntasExamen`: crea 3 preguntas fijas relacionadas con POO.
- `Alumno`: clase implementada según estructura base, no participa en esta ejecución.

---

## 🔐 Restricciones cumplidas (según examen)

- ✅ No hay comentarios en el código.
- ✅ Variables descriptivas (no hay nombres de una letra).
- ✅ No se usa `return` dentro de estructuras de control (`if/else`).
- ✅ No se usa `break` fuera de `switch`.
- ✅ Uso de `extends`, `super`, `protected`, `get`, `set`, `toString`.
- ✅ No se usa `ArrayList`, ni estructuras avanzadas no vistas en clase.
- ✅ Declaración y asignación de variables separadas.
- ✅ Uso de `Scanner` solo si se necesitara entrada, pero no se usa aquí (por enunciado).
- ✅ Package correcto en todos los archivos: `package entregas.cotareloDaniel.src;`

---

## 🚧 Mejoras posibles (respetando o ampliando la estructura si se permitiera)

> ⚠️ Estas mejoras NO se han hecho porque el enunciado no las permite. Pero podrían aplicarse para mejorar escalabilidad si se levantaran las restricciones.

### 🔹 1. Gestionar múltiples asignaturas por profesor
- Actualmente, un profesor solo puede tener **una asignatura**.
- Si se permitiera, se podría usar un array de `Asignatura[]` y crear múltiples exámenes, uno por asignatura.

### 🔹 2. Registrar exámenes por asignatura
- Actualmente, los exámenes se crean y se muestran directamente.
- No hay una lista o mapa de exámenes por asignatura.
- Esto permitiría consultar más adelante qué exámenes hay por materia.

### 🔹 3. Controlar múltiples profesores y vigilantes
- Solo se puede usar **un profesor** y **un vigilante**.
- Si se pudiera tener un array de profesores y elegir roles (imparte / vigila), se flexibilizaría mucho más.

---

## ✅ Verificación final contra el enunciado (Parte 1 y Parte 2)

| Requisito del enunciado | ¿Implementado? |
|--------------------------|----------------|
| Crear universidad        | ✅ Sí           |
| Crear asignatura         | ✅ Sí           |
| Crear profesor           | ✅ Sí           |
| Asignar asignatura       | ✅ Sí           |
| Crear examen con 3 preguntas | ✅ Sí      |
| Asociar examen a asignatura  | ✅ Sí      |
| No crear examen si no tiene asignatura | ✅ Sí |
| Crear vigilante          | ✅ Sí           |
| Solo puede vigilar si no imparte        | ✅ Sí |
| Entrega de examen del profesor al vigilante | ✅ Sí |
| Mostrar escenario completo             | ✅ Sí |

---