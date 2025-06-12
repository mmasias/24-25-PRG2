public abstract class Persona {

    private final String nombreCompleto;
    private final String dni;

    protected Persona(String nombreCompleto, String dni) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
    }

    public String nombreCompleto() {
        return this.nombreCompleto;
    }

    public String dni() {
        return this.dni;
    }
}