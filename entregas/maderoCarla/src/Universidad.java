public class Universidad {
    private String nombre;
    private Profesores profesor1;
    private Profesores profesor2;

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public void asignarProfesores(Profesores p1, Profesores p2) {
        this.profesor1 = p1;
        this.profesor2 = p2;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesores getProfesor1() {
        return profesor1;
    }

    public Profesores getProfesor2() {
        return profesor2;
    }
}
