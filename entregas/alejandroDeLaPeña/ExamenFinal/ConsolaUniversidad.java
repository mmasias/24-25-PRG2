package entregas.alejandroDeLaPeña.ExamenFinal;

public class ConsolaUniversidad {
    public static void main(String[] args) {

       
        Universidad uni = new Universidad("Universidad Europea Del Atlántico");

        
        Profesor prof1 = new Profesor("Luis", "García", "Pérez", "12345678A");
        Profesor prof2 = new Profesor("Ana", "Martínez", "López", "87654321B");

        
        uni.profesores[0] = prof1;
        uni.profesores[1] = prof2;

       
        Asignatura asig = new Asignatura("POO - Java", prof1, 6);
        uni.asignaturas[0] = asig;

       
        if (asig.imparteProfesor(prof1)) {
           
            String[] preguntas = {
                "¿Qué es la herencia en Java?",
                "¿Qué es la clase pública?",
                "¿Qué es la clase privada?"
            };

            Examen examen = new Examen("Examen Final POO", prof1, preguntas, 10);

            
            if (prof1.entregarExamenA(prof2, uni.asignaturas)) {
                examen.asignarVigilante(prof2);
                System.out.println("\n✅ El examen ha sido entregado a " + prof2.getNombreCompleto() + " para ser vigilado.");
            } else {
                System.out.println("\n❌ ERROR: El profesor " + prof2.getNombreCompleto() + " no puede vigilar exámenes porque imparte alguna asignatura.");
            }

            
            System.out.println("\n📄 EXAMEN CREADO:");
            examen.mostrarExamen();

        } else {
            System.out.println("\n❌ ERROR: El profesor " + prof1.getNombreCompleto() + " no imparte ninguna asignatura, no puede crear el examen.");
        }

        
        System.out.println("\n🏫 UNIVERSIDAD:");
        uni.mostrarContenido();
    }
}


