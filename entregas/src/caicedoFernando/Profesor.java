package caicedoFernando;

public class Profesor extends Universidad {
    private String nombreProfesor;
    private String dni;

    public Profesor(String nombreProfesor, String dni) {
        super("Universidad Europea del Atlántico");
        this.nombreProfesor = nombreProfesor;
        this.dni = dni;
    }

    public Examen crearExamen() {
        return new Examen("Vista pública de clases", "Vista pública de objetos", "Vista privada de la clases", this);
    }

    public String getNombre() {
        return nombreProfesor;
    }

    public String getDni() {
        return dni;
    }
}