package magos.models;

public enum HechizoTipo {

    BOLA_DE_FUEGO("Bola de Fuego", 20),
    RAYO_CONGELANTE("Rayo Congelante", 15),
    TORMENTA_ELECTRICA("Tormenta Eléctrica", 25),
    NUBE_VENENOSA("Nube Venenosa", 18);

    private final String nombre;
    private final int danio;

    HechizoTipo(String nombre, int danio) {
        this.nombre = nombre;
        this.danio = danio;
    }

    public String nombre() {
        return this.nombre;
    }

    public int danio() {
        return this.danio;
    }
}
