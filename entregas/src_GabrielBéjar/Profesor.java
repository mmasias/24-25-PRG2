package entregas.src_GabrielBéjar;

public class Profesor {
    private String nombreCompleto;
    private String dni;

    public Profesor(String nombreCompleto, String dni) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public String getIdentificacion() {
        return nombreCompleto + " / " + dni;
    }
}
