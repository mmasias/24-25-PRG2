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


    
