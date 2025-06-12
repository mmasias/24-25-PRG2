### Control de estado en la clase Examen ###
Actualmente, el examen solo almacena preguntas, pero no se sabe si ya fue creado, entregado o vigilado.
Podria haber agregado atributos que reflejen el estado del examen, por ejemplo:

·boolean creado
·boolean entregado

Y métodos para verificar el estado, lo que ayudaría a validar que solo se entregue un examen creado, etc.

### El metodo crearExamen () ###

Actualmente, crearExamen(Examen examen) agrega preguntas directamente al examen recibido como parámetro. Si otro profesor también recibe esa misma instancia (por error), ambos podrían modificarla.

### El profesor 2 intenta crear o entregar examen ###

Aunque en el flujo actual se prohíbe con un mensaje, el profesor 2 todavía llama a crearExamen() y entregar().