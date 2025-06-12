public class Universidad {
    private String nombre;
    private Profesor profesor1;
    private Profesor profesor2;
    private Asignatura asignatura;

    private Universidad(String nombre) {
        this.nombre = nombre;
    }

    public void contratarProfesor(String nombre, String dni) {
        profesor1 = new Profesor(nombre, dni);
    }

    public void contratarOtroProfesor(String nombre, String dni) {
        profesor2 = new Profesor(nombre, dni);
    }

    public void crearAsignatura(String nombre, String codigo, int creditos) {
        asignatura = new Asignatura(nombre, codigo, creditos);
    }

    public void mostrar() {
        asignatura.asignarAsignatura(profesor1);
        profesor1.crearExamen();
        asignatura.asignarAsignatura(profesor2);
        profesor1.entregarExamen(profesor2);
    }
    public static void main(String[] args) {
        Universidad uni = new Universidad("Universidad europea del Atlantico");
        uni.contratarProfesor("Ibuprofeno del Jesus Fernandez Gomez de la Piedra y Cansado", "244455555X");
        uni.contratarOtroProfesor("Dalsy Piedad de los Remedios Albornoz del Campo", "666456665X");
        uni.crearAsignatura("Programacion 2", "PRG2", 6);
        uni.mostrar();
    }
}
