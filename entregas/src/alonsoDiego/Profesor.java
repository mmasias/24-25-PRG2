public class Profesor {
    private String nombre;
    private String dni;
    private Asignatura asignatura;

    public Profesor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void asignarAsignatura(Asignatura a) {
        this.asignatura = a;
    }

    public Examen crearExamen() {
        if (asignatura == null) {
            System.out.println("El profesor no tiene asignatura y no puede crear examen.");
            return null;
        }
        Examen e = new Examen(asignatura);
        e.agregarPreguntas("Vista pública clases");
        e.agregarPreguntas("Vista pública de objetos");
        e.agregarPreguntas("Vista privada de clases");
        return e;
    }

    public void entregaExamenAl(Examen e, Supervisor s) {
        s.recibir(e, this);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }
}
