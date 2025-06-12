# Cambios que debí de haber hecho

## Universidad
- Constructor mal definido
- solucion (   
        this.nombreUniversidad = nombreUniversidad;
        this.nombreAsignatura = nombreAsignatura;

        this.profesorAsignadoAExamen = new Profesores[nombreAsignatura.length];)

## Profesores
- constructor mal definido
- - solucion (    
    profesores = new String[] {"Ibuprofeno del jesus Fernandez Gomez de la Piedra y Cansado", "Dalsy Piedad de los Remedios Albornoz del Campo "};
        identificacionProfesor = new String[] {"244455555x", "66645665x"};
)

## Mostrar Escenarios 

- En lo escrito no puse nada por los nervios 
- solucion (
    public class MostrarEscenario {

    public static void imprimirEscenario(Universidad universidad, String[] vigilantes) {
        System.out.println("Universidad:");

        for (int i = 0; i < universidad.nombreAsignatura.length; i++) {
            Profesores profesor = universidad.profesorAsignadoAExamen[i];
            if (profesor == null) {
                continue; 
            }

            String nombreProfesor = profesor.getNombre();
            String dniProfesor = obtenerDNI(nombreProfesor);

            System.out.println(" Profesor: " + nombreProfesor + " / DNI: " + dniProfesor);
            System.out.println("  Asignatura: " + universidad.nombreAsignatura[i]);

            Examen examen = profesor.crearExamen();

            System.out.println("   Examen:");
            System.out.println("    Vigilado por:");

            for (String vigilante : vigilantes) {
                System.out.println("     " + vigilante);
            }

            
            String[] preguntas = examen.getPreguntas();
            if (preguntas != null) {
                for (int p = 0; p < preguntas.length; p++) {
                    System.out.println("     Pregunta " + (p + 1) + ": " + preguntas[p]);
                }
            }
        }
    }

    private static String obtenerDNI(String nombreProfesor) {
        for (int i = 0; i < Profesores.profesores.length; i++) {
            if (Profesores.profesores[i].equals(nombreProfesor)) {
                return Profesores.identificacionProfesor[i];
            }
        }
        return "DNI no encontrado";
    }
}

)

## Examen 
- Mal definido el constructor