package valdesCarlos;

public class Universidad {
    private String nombre;
    private Asignatura[] asignaturas = new Asignatura[10];
    private int totalAsignaturas = 0;

    private Profesor[] profesores = new Profesor[10];
    private int totalProfesores = 0;

    private ProfesorVigilante[] vigilantes = new ProfesorVigilante[10];
    private int totalVigilantes = 0;

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public Asignatura crearAsignatura(String nombre, int creditos) {
        Asignatura asignatura = new Asignatura(nombre, creditos);
        asignaturas[totalAsignaturas] = asignatura;
        totalAsignaturas++;
        return asignatura;
    }

    public Profesor contratarProfesor(String nombre, String dni) {
        Profesor profesor = new Profesor(nombre, dni);
        profesores[totalProfesores] = profesor;
        totalProfesores++;
        return profesor;
    }

    public void asignarAsignatura(Profesor profesor, Asignatura asignatura) {
        profesor.setAsignatura(asignatura);
    }

    public void iniciarExamen(Profesor profesor, ProfesorVigilante vigilante, Alumno alumno) {
        
        System.out.println("Universidad: " + nombre);
        System.out.println("Profesor: " + profesor.getNombre());
        System.out.println("Asignatura: " + profesor.getAsignatura().getNombre());
    
        
        Examen examen = profesor.crearExamen();
        examen.crearPregunta("¿Qué es una clase en Java?");
        examen.crearPregunta("Explica el concepto de herencia.");
        examen.crearPregunta("¿Qué es la encapsulación?");
    
        profesor.entregarExamen(examen, vigilante);
        vigilante.vigilarExamen(examen);
        alumno.hacerExamen(examen);
    
        Asignatura asignatura = profesor.getAsignatura();
        asignatura.determinarNota(alumno);
    }
    
}
