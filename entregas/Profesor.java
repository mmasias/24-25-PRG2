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


