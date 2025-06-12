public class Universidad {
    private String nombre;

    public Universidad(String nombre) {
        this.nombre = nombre;
        System.out.println("Universidad creada: " + nombre);
    }

    public Profesor ContratarProfesor(String nombre) {
        System.out.println("Contratando al profesor: " + nombre);
        return new Profesor(nombre);
    }

    
