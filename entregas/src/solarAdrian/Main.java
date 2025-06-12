package solarAdrian;


public class Main {
    public static void main(String[] args) {
        Universidad uni = new Universidad("Universidad Europea del Atlántico");

        uni.crearAsignatura("Tecnologías de la Información y Comunicación", "TIC", 6);
        uni.contratarProfesorPrincipal("Lázaro", "12345678A");
        uni.contratarProfesorVigilante("Manuel", "87654321B");

        uni.asignarAsignaturaAlProfesor();
        uni.profesorCreaExamen();
        uni.asignarVigilante();
        uni.mostrarEscenarioCompleto();
    }
}
