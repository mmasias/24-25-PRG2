package entregas.larinAlejandro;

public class Profesor {
    private String nombre;
    private String dni;
    private String asignatura;
    private Examen examen;  
    private boolean vigia;


    public Profesor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.asignatura = null;
        this.examen = null;
        this.vigia = true;

    }

    public void crearExamen(String asignatura) {
       if (asignatura != null && !asignatura.isEmpty()) {
            this.asignatura = asignatura;
            this.examen = getExamen(asignatura);
       }else{
            throw new IllegalArgumentException("El profesor debe tener una asignatura asignada para crear un examen.");
       }
    }
    public String getAsignatura() {
        return  this.asignatura ;
    }
    private Examen getExamen(String asignatura) {
        return new Examen(asignatura);
    }

    public void entregarExamen(Profesor profesorVigia) {
        if (profesorVigia.vigia) {
            System.out.println("El examen esta vigilado por: " + profesorVigia.nombre+ "/" + profesorVigia.getDni()) ;
        } else {
            throw new IllegalStateException("El profesor vigía no está disponible para recibir el examen.");
            
        }
        
    }
    public String getDni() {
        return this.dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void asignarASignatura(String asignatura) {
        
        if (asignatura != null && !asignatura.isEmpty()) {
            this.vigia = false;
            this.asignatura = asignatura;
        }
    }

    public void mostrarExamen() {
       examen = getExamen(asignatura);
       examen.mostrarExamen();
    }

}
