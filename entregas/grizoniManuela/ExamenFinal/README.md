# Diferencias entre tu código y la versión corregida

Este documento resume los cambios y correcciones realizadas respecto a tu implementación original y la versión ajustada.

---

## 1. Corrección de constructores

| Tu código                                              | Versión corregida                                   |
|--------------------------------------------------------|-----------------------------------------------------|
| `public class Examen(String nombre, ...) { … }`        | `public Examen(String nombre, ...) { … }`           |
| `public class Asignatura(String titulo, ...) { … }`    | `public Asignatura(String titulo, ...) { … }`       |
| `public class Pregunta(String enunciado) { … }`        | `public Pregunta(String enunciado) { … }`           |
| `public class Profesor(String nombre, ...) { … }`      | `public Profesor(String nombre, ...) { … }`         |
| `public class Universidad(String nombreUni) { … }`     | `public Universidad(String nombreUni) { … }`        |

> **Cambio clave:** Se reemplazan declaraciones de clase-constructor (`public class X(...)`) por métodos constructores de la forma `public X(...)`.

---

## 2. Nombres y tipos de atributos

| Tu código                           | Versión corregida                          |
|-------------------------------------|--------------------------------------------|
| `private String creditos;`          | `private int credito;`                     |
| `private List<Preguntas> pregunta;` | `private List<Pregunta> preguntas;`        |
| `private String titulo;`            | `private String titulo;` *(sin cambios)*   |

> **Cambio clave:** Ajuste de tipos (`String` → `int`) para créditos, corrección de nombres en singular/plural para la lista de preguntas.

---

## 3. Firmas de getters y setters

| Aspecto                           | Tu código                                                            | Versión corregida                                             |
|-----------------------------------|----------------------------------------------------------------------|---------------------------------------------------------------|
| Setter sin parámetro y mal tipo   | `public void setEnunciado() { this.enunciado = enunciado; }`         | `public void setEnunciado(String enunciado) { … }`            |
| Getter declarado `void`           | `public void getTitulo() { return titulo; }` *(error de tipo)*       | `public String getTitulo() { return titulo; }`                |
| Firma duplicada                   | Dos métodos `setNombre(String Nombre)`                               | Eliminación de duplicados y firma única                       |

> **Cambio clave:** Se ajustan firmas para devolver el tipo correcto y aceptar parámetros donde corresponde.

---

## 4. Inicialización de colecciones

| Tu código                          | Versión corregida                         |
|------------------------------------|-------------------------------------------|
| `this.pregunta = new Array<List>();` | `this.preguntas = new ArrayList<>();`     |

> **Cambio clave:** Uso correcto de `new ArrayList<>()` e import de `java.util.List` y `java.util.ArrayList`.

---

## 5. Inclusión de `toString()` para formateo

| Tu código             | Versión corregida                                               |
|-----------------------|-----------------------------------------------------------------|
| Sin `toString()`      | Sobrescritura de `toString()` en cada clase para salida formateada |

> **Cambio clave:** Con `toString()` personalizado se logra imprimir todo con un único `System.out.println(objeto);` en el formato solicitado.

---

## 6. `main` y orden de impresión

- **Tu código:** `main` vacío, sin instanciaciones ni `System.out.println()`.  
- **Versión corregida:**  
  - Se crea y muestra `Universidad`.  
  - Se crea y muestra `Profesor` titular y vigilante.  
  - Se crea y muestra `Asignatura`.  
  - Se crea `Examen` con preguntas y se muestra.

> **Cambio clave:** Se implementa la lógica de creación, asociación y visualización de objetos según el enunciado.

---

Con estos cambios, tu proyecto:

```text
Universidad: Universidad Europea del Atlántico
Profesor: Ibuprofeno del Jesús Fernández Gomez de la Piedra y Cansado / DNI 244455555X
    Asignatura : Programacion 2 - PRG 2 - 6 créditos
          Examen : Examen Final
               Vigilado por: Dalsy Piedad de los Remedios Albornoz del Campo / DNI 66645666X
                       Pregunta 1: "Vista pública clases"
                       Pregunta 2: "Vista pública de objetos"
                       Pregunta 3: "Vista privada de clases"
