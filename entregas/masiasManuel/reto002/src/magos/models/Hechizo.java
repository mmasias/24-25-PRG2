package magos.models;

public class Hechizo {

    private final HechizoTipo tipo;

    public Hechizo(HechizoTipo tipo) {
        this.tipo = tipo;
    }

    public String nombre() {
        return this.tipo.nombre();
    }

    public int danio() {
        return this.tipo.danio();
    }
}
