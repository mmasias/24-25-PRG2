#  Proyecto Java – Universidad, Profesores y Exámenes

##  Objetivo

Este programa simula un sistema académico donde una universidad crea asignaturas, contrata profesores y gestiona exámenes. Ha sido desarrollado como ejercicio de examen, demostrando el uso completo del temario de Programación II, **sin usar atributos** (ni `private`, ni `public`, ni `protected`).

---

##  Estructura del Proyecto

- `Universidad`: clase orquestadora con métodos estáticos para controlar el flujo general.
- `Profesor`: permite crear y entregar exámenes.
- `Asignatura`: se asigna al profesor.
- `Examen`: agrega preguntas y muestra el contenido.
- `Persona` (abstracta): clase base para practicar **herencia** y **polimorfismo**.
- `Cliente`: contiene el `main()` que ejecuta toda la lógica del sistema.

---

##  Temario Aplicado

| Tema del curso                             | Aplicado |
|--------------------------------------------|----------|
| ✅ Clases y objetos                         | ✔️       |
| ✅ Métodos públicos y estáticos             | ✔️       |
| ✅ Herencia (`extends`)                     | ✔️       |
| ✅ Clases abstractas                        | ✔️       |
| ✅ Polimorfismo / sobrescritura             | ✔️       |
| ✅ Control de flujo (`if`, `else`)          | ✔️       |
| ✅ Modularidad y separación de responsabilidades | ✔️  |
| ✅ Colaboración entre objetos (HOOD)        | ✔️       |
| ✅ Uso del método `main()`                  | ✔️       |
| ✅ Salida por consola (`System.out.println`) | ✔️      |
| ❌ Uso de atributos (`private`, `public`, etc.) | ❌ *intencionadamente omitido* |

---

## ⚙️ Justificación: Sin Atributos

Por decisión deliberada, **no se utilizan atributos en ninguna clase**, siguiendo una posible restricción del examen.  
Todo se realiza mediante variables locales, parámetros, y llamadas entre métodos.  
Aun sin estado interno, se ha conseguido representar correctamente las relaciones entre objetos y aplicar toda la lógica de negocio.

---
