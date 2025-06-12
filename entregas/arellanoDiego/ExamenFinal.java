public class ExamenFinal {
    public static void main(String[] args) {
        Universidad uni = crearUniversidad("Universidad Europea del atlantico");

        Profesor profesor1 = crearProfesor(uni, "Ibuprofeno del jesus fernandez gomez de la piedra y cansado", "244455555X");
        Profesor profesor2 = crearProfesor(uni, "Dalsy Piedad de los remedios albornoz del camp", "666456665X");

        Asignatura asignatura = crearAsignatura(uni, "Programación 2", "PRG2", 6);

        asignaturaProfe(uni, profesor1, asignatura);

        Examen examen = crearExamen(profesor1, "Examen Final");
        profesorExamen1(examen, "Vista publica de clases");
        profesorExamen1(examen, "Vista publica de los objetos");
        profesorExamen1(examen, "vista privada de clases");

        entregarExamen(profesor1, profesor2, examen);

        mostrarUni(uni);

    }

    public static Universidad crearUniversidad(String nombre) {
        return new Universidad(nombre);
    }

    public static Profesor crearProfesor(Universidad uni, String nombre, String dni) {
        return uni.contratarProfesor(nombre, dni);
    }

    public static Asignatura crearAsignatura(Universidad uni, String nombre, String codigo, int creditos) {
        return uni.crearAsignatura(nombre, codigo, creditos);
    }

    public static void asignaturaProfe(Universidad uni, Profesor profesor, Asignatura asignatura) {
        uni.asignarAsignatura(profesor, asignatura);
    }

    public static Examen crearExamen(Profesor profesor, String titulo) {
        return profesor.crearExamen(titulo);
    }

    public static void profesorExamen1(Examen examen, String pregunta) {
        examen.agregarPregunta(pregunta);
    }

    public static void entregarExamen(Profesor creador, Profesor vigilante, Examen examen) {
        creador.entregarExamen(vigilante, examen);
    }

    public static void mostrarUni(Universidad uni) {
        System.out.println(uni.mostrarEscenario());
    }

    public static void datosProfesor(Profesor profesor) {
        System.out.println(profesor.mostrar());
    }

    public static void datosAsignatura(Asignatura asignatura) {
        System.out.println(asignatura.mostrar());
    }

    public static void mostrarDatosExamen(Examen examen) {
        System.out.println(examen.mostrar());
    }
}
