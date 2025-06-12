package Evaluacion_Final;

class Asignatura {
    String nombre;
    int creditos;

    public Asignatura(String nombre, int creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public int alumnos() {
        return 40;
    }

    public String temas() {
        return "Herencia, Polimorfismo, Encapsulamiento";
    }
}