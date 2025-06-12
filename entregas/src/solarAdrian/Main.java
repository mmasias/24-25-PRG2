package solarAdrian;


public class Main {
    public static void main(String[] args) {
        Universidad uni = new Universidad("Universidad Europea del Atlántico");

        uni.crearAsignatura("Tecnologías de la Información y Comunicación", "TIC", 6);
        uni.contratarProfesor("Lázaro", "12345678A");
        uni.contratarSupervisor("Manuel", "87654321B");

        uni.asignarAsignaturaAlProfesor();
        uni.profesorCreaExamen();
        uni.entregarExamenAlSupervisor();

        uni.mostrarEscenarioCompleto();
    }
}
