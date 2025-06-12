package rubioRicardo;

public class Universidad {
    private String nombre;
    private Asignatura asignatura;
    private Profesor profesorImparte;
    private Profesor profesorVigilante;
    private Examen examen;

    public Universidad(String nombre) {
        this.nombre = nombre;
        organizarExamen();
    }

    private void organizarExamen() {
        
        this.asignatura = new Asignatura("Matemáticas", "MAT", 6);

        
        this.profesorImparte = new Profesor("Ana López", "12345678A", "docente");

        
        asignarAsignatura(asignatura, profesorImparte);

        
        this.examen = profesorImparte.crearExamen(this.profesorImparte, this.asignatura, "Parcial 1");

        
        examen.crearPreguntas();

        
        this.profesorVigilante = new Profesor("Carlos Pérez", "87654321B", "vigilante");

       
        this.profesorVigilante.vigilarExamen(profesorVigilante, examen);

       
        this.profesorImparte.entregarExamen(profesorVigilante, examen);
    }

    public void asignarAsignatura(Asignatura asignatura, Profesor profesor) {
        asignatura.asignarAsignatura(profesor);
    }

    public void imprimir() {
        System.out.println("Universidad: " + nombre);
        System.out.println("Profesor: " + profesorImparte.getNombre() + " / " + profesorImparte.getIdentificacion());
        System.out.println("Asignatura: " + asignatura.getNombre() + "-" + asignatura.getAbreviatura() + "-" + asignatura.getCreditos());
        System.out.println("Examen: " + examen.getNombre());
        System.out.println("Vigilado por: " + profesorVigilante.getNombre() + " / " + profesorVigilante.getIdentificacion());
        int i = 1;
        for (String pregunta : examen.getPreguntas()) {
            System.out.println("Pregunta " + i + ": \"" + pregunta + "\"");
            i++;
        }
    }

    
  public static void iniciar(Universidad universidad) {
    universidad.imprimir();
}
 
}
