public class Profesor {
    private String nombre;
    private Asignatura asignatura;
    private boolean vigilando = false;


    public Profesor(String nombre) {
        this.nombre = nombre;
    }


    public void Identificacion() {
        System.out.println("Profesor: " + nombre);
    }


    public void crearAsignatura(String nombreAsignatura) {
        this.asignatura = new Asignatura(nombreAsignatura);
        System.out.println(nombre + " ha creado la asignatura: " + nombreAsignatura);
    }


    public void AsociarAsignatura(Asignatura a) {
        this.asignatura = a;
        System.out.println(nombre + " ha sido asignado a la asignatura: " + a.getNombre());
    }


    public Examen CrearExamen() {
        if (asignatura == null) {
            noCrearAsignatura();
            return null;
        }
        Examen examen = new Examen();
        examen.agregarPregunta("Vista pública clases");
        examen.agregarPregunta("Vista pública de objetos");
        examen.agregarPregunta("Vista privada de clases");
        System.out.println(nombre + " ha creado el examen, con 3 preguntas!");
        return examen;
    }


    public void EntregarExamen(Examen examen, Profesor receptor) {
        if (receptor.puedeVigilar()) {
            System.out.println(nombre + " entrega el examen a " + receptor.nombre);
            receptor.VigilarExamen();
        } else {
            receptor.noVigilarExamen();
        }
    }


    public void VigilarExamen() {
        if (asignatura == null) {
            vigilando = true;
            System.out.println(nombre + " está vigilando el examen.");
        } else {
            noVigilarExamen();
        }
    }


    public void noVigilarExamen() {
        System.out.println(nombre + " no puede vigilar el examen porque imparte una asignatura.");
    }


    public void noCrearAsignatura() {
        System.out.println(nombre + " no puede crear examen porque no tiene asignatura.");
    }


    public boolean puedeVigilar() {
        return asignatura == null;
    }
}
