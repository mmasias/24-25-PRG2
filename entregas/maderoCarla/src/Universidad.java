public class Universidad {
    private String nombre;
    private Profesor profesor1;
    private Profesor profesor2;

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public void asignarProfesores(Profesor p1, Profesor p2) {
        this.profesor1 = p1;
        this.profesor2 = p2;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor1() {
        return profesor1;
    }

    public Profesor getProfesor2() {
        return profesor2;
    }
}
