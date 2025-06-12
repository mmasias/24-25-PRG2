# Errores Parte 1 y Parte 2:

## Asignar nombres más claros y tipos a todos los atributos.
Ejemplo: La declaracion del profesor vigilante (especifica cual de los dos es).

         String nombre;
         int numero_pregutas;
         String[] ExamenProgra;
         Profesor vigilante;
## Declarar y definir el tamaño de los arrays.
Ejemplo: la declararcion de la cantidad de preguntas en el examen de programación.

            ExamenProgra = new String[numero_pregutas];

## Añadir  constructores.
Ejemplo: Asigar el constructor de Universidad.

         public Universidad(String nombreUnversidad) {
            this.nombreUnversidad = nombreUnversidad;
            this.examenes = new Examen[1]; 
         }
## Asignar parámetros a los métodos.
Ejemplo: asignar el parametro profesor y asignatura a siganar pursto para que trabaje con ellos.

         void asignarPuesto(Profesor profesor, Asignatura asignatura) {
            profesor.asignatura = asignatura;
         }
## Añadir validaciones .
Ejemplo: Saber si un profesor imparte una asignatura.

         void comprobarImpartiendo(Profesor profesor) {
            if (profesor.asignatura == null) {
                System.out.println("El profesor no está impartiendo ninguna asignatura.");
            }
        } 
## Asociar bien las clases y establecer el tipo (publicas, privadas,...).
Ejemplo: Declarar void en darDatos().

        void darDatos() {
            ...
        }
## Relacionar todas las clases.

Ejemplo: Asigando un profesor a la universidad.

            universidad.profesor1 = new Profesor("Ibuprofeno del Jesús", "Fernández Gomez de la Piedra y Cansado", "244455555X");
            
    




