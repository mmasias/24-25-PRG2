Mi diseño en papel fue un buen punto de partida para definir los datos. Para que se traduzca de forma mas directa a un codigo funcional y robusto, podria haber mejorado estos tres puntos clave:

### 1. Especificar Relaciones en lugar de Listar Atributos Aislados

* **En el Papel:** Anote los campos de la `Universidad` como si todos fueran simples `String`, sin indicar que `profesor_examen` era en realidad un objeto de tipo `Profesor`.
    ```
    // Mi diseño en papel para Universidad:
    - String nombre_universidad
    - String profesor_vigilante
    - String profesor_examen
    ```

* **Propuesta de Mejora:** Indicar el **tipo de objeto** directamente. Esto define la relacion de "composicion" (una Universidad *tiene* Profesores).
    ```
    // Diseño en papel mas explicito:
    class Universidad {
      nombre_universidad: String
      profesor_examen: Profesor   // <-- Clave: Especificar la clase
      profesor_vigilante: Profesor
      datos_asignatura: Asignatura
    }
    ```

* **Comparacion con Codigo Final:** Esta mejora se traduce directamente en la declaracion de atributos en la clase `Universidad`, que es la base de todo el programa.
    ```java
    public class Universidad {
        private Profesores profesor_examen;
        private Asignaturas datos_asignatura;
    }
    ```

### 2. Definir Comportamiento (Metodos), no solo Datos (Atributos)

* **En el Papel:** Mis notas se centraron 100% en los datos (sustantivos), pero una clase tambien necesita comportamiento (verbos o metodos). No especifique como se crearian los objetos o como se accederia a su informacion.

* **Propuesta de Mejora:** Añadir una seccion de "Metodos" en el papel, usando una notacion simple como `+` para `public` y `()` para indicar que es una accion.
    ```
    // Diseño en papel mas explicito:
    class Profesores {
      // Atributos
      nombre_profesor: String
      dni_profesor: String

      // Metodos
      + crearProfesorParaExamen(): Profesores // Devuelve un objeto Profesores
      + getNombre_profesor(): String        // Devuelve un String
    }
    ```
* **Comparacion con Codigo Final:** Esta especificacion nos llevo a crear las "Factorias Estaticas", que fue la solucion de diseño mas limpia.
    ```java
    public class Profesores {
        public static Profesores crearProfesorParaExamen() {
            return new Profesores(...);
        }
    }
    ```

### 3. Usar Convenciones de Nomenclatura Estandar

* **En el Papel:** Use `snake_case` (`nombre_universidad`) y hubo algunas inconsistencias entre los nombres de las clases en singular y plural a lo largo de nuestras conversaciones.

* **Propuesta de Mejora:** Usar las convenciones estandar de Java desde el principio facilita la escritura del codigo y lo hace mas legible para otros programadores.
    * **`PascalCase` para Nombres de Clases:** `Universidad`, `Profesores`.
    * **`camelCase` para Nombres de Variables:** `nombreUniversidad`, `profesorExamen`.

* **Comparacion con Codigo Final:** Adaptamos el codigo para que usara mis nombres exactos, pero la practica estandar en Java se veria asi, siendo tecnicamente mas convencional.
    ```java
    // Mi version adaptada:
    private String nombre_universidad;
    private Profesores profesor_examen;

    // Version con convencion estandar de Java:
    private String nombreUniversidad;
    private Profesores profesorExamen;
    ```