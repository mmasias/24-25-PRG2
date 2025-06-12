public class Universidad {
    private String nombre;
    private Profesor[] profesores;
    private Asignatura[] asignaturas;
    private int contadorProfesores;
    private int contadorAsignaturas;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new Profesor[10];
        this.asignaturas = new Asignatura[10];
        this.contadorProfesores = 0;
        this.contadorAsignaturas = 0;
    }

    public Profesor contratarProfesor(String nombre, String dni) {
        Profesor profesor = new Profesor(nombre, dni);
        this.profesores[this.contadorProfesores] = profesor;
        this.contadorProfesores++;
        return profesor;
    }

    public Asignatura crearAsignatura(String nombre, String codigo, int creditos) {
        Asignatura asignatura = new Asignatura(nombre, codigo, creditos);
        this.asignaturas[this.contadorAsignaturas] = asignatura;
        this.contadorAsignaturas++;
        return asignatura;
    }

    public void asignarAsignatura(Profesor profesor, Asignatura asignatura) {
        profesor.impartir(asignatura);
    }

    public String mostrarEscenario() {
        String texto = "Universidad: " + this.nombre + "\n";
        for (int i = 0; i < this.contadorProfesores; i++) {
            texto += this.profesores[i].mostrar() + "\n";
        }
        return texto;
    }
}
